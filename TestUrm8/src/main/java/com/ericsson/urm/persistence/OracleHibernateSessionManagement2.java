package com.ericsson.urm.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.config.ConfigurationException;

public class OracleHibernateSessionManagement2 implements HibernateSessionManagement {

    private SessionFactory sessionFactory;

    public OracleHibernateSessionManagement2(){

        sessionFactory = buildSessionFactory();
    }

    public SessionFactory buildSessionFactory() {

        try {
            Configuration cfg = new Configuration().configure();

            sessionFactory = cfg.buildSessionFactory();

            return sessionFactory;
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public  SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public  void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public Session getSession() throws ConfigurationException {

        Session session = sessionFactory.getCurrentSession();

        return session;

    }
}
