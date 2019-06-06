package com.ericsson.urm.persistence;

import com.ericsson.urm.exceptions.ConfigurationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RadiusHibernateSessionManagement implements HibernateSessionManagement {

    SessionFactory sessionFactory = buildSessionFactory();

    public SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure("radius.hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public Session getSession() throws ConfigurationException {

        Session session = sessionFactory.getCurrentSession();

        return session;

    }
}
