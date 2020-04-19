package org.budowa.database;

import org.budowa.entities.Attachment;
import org.budowa.entities.Building;
import org.budowa.entities.Role;
import org.budowa. entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DbConnector {
    private SessionFactory sessionFactory;

    public void setSessionFactory() throws Exception {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Role.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Attachment.class);
        configuration.addAnnotatedClass(Building.class);
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}