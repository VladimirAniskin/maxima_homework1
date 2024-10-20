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
    public void signUp(Account account) {
        this.account = account;
        try (Session session = hibernate.getSession()) {
            session.save(account);

        } catch (RuntimeException e) {
            throw new RuntimeException("Не получилось сохранить", e);
        }

    }

    @Override
    public List<Account> getAll() {
        try (Session session = hibernate.getSession()) {
            Query  query = session.createQuery("select * from Account ");
            return  query.getResultList();

        } catch (RuntimeException e){
            throw new RuntimeException("Не получилось получить список пользователей", e);
        }

    }
}
