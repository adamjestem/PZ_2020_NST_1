package org.budowa.database;

import org.budowa.entities.Building;
import org.budowa. entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DbConnector {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;
    private static DbConnector instance = null;

    private DbConnector() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Building.class);
        configuration.configure();

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static DbConnector inject(){
        if(instance == null){
            instance  = new DbConnector();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
