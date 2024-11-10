package ru.maxima.app.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maxima.app.model.Account;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final DataBaseHibernate hibernate;
    private Account account;

    @Autowired
    public AccountRepositoryImpl(DataBaseHibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public Account signUp(Account account) {
        try (Session session = hibernate.getSession()) {
            Query query = session.createQuery("from Account a where (a.email = :email and a.password = :password)");
            query.setParameter("email", account.getEmail());
            query.setParameter("password", account.getPassword());
            List l = query.list();
            if (!l.isEmpty()) {
                return (Account) l.get(0);
            } else return account;
        } catch (RuntimeException e) {
            throw new RuntimeException("что то пошло не так", e);
        }
    }

    @Override
    public List<Account> getAll() {
        try (Session session = hibernate.getSession()) {
            Query query;
            query = session.createQuery("select * from Account ");
            return query.getResultList();

        } catch (RuntimeException e) {
            throw new RuntimeException("Не получилось получить список пользователей", e);
        }

    }

    public void register(Account account) {
        try (Session session = hibernate.getSession()) {
            session.beginTransaction();
            session.save(account);
            session.flush();
        } catch (RuntimeException e) {
            throw new RuntimeException("не получилось сохранить", e);
        }
    }

}
