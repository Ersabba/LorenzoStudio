package com.ericsson.urm.persistence;


import com.ericsson.urm.exceptions.ConfigurationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class OracleHibernateSessionManagement implements HibernateSessionManagement{

    private SessionFactory sessionFactory;

    public OracleHibernateSessionManagement(){

        sessionFactory = buildSessionFactory();
    }

    public SessionFactory buildSessionFactory() {

        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                    .configure("hibernate.cfg.xml").build();

            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
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
