package ru.maxima.app.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class DataBaseHibetnateImpl implements DataBaseHibernate {
   private final SessionFactory sessionFactory;

    public DataBaseHibetnateImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
