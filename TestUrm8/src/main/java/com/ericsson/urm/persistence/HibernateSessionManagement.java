package com.ericsson.urm.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface HibernateSessionManagement {


    public SessionFactory buildSessionFactory();

    public Session getSession();

    public void shutdown();
}
