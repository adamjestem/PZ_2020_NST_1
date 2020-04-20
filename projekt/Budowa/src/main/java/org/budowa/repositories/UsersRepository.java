package org.budowa.repositories;

import org.budowa.database.DbConnector;
import org.budowa.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UsersRepository {

    private static SessionFactory factory;


    public UsersRepository() {
        DbConnector db = DbConnector.getInstance();
        this.factory = db.getSessionFactory();
    }


    public Integer insert(User user){

        Session session = this.factory.openSession();
        Transaction tx = null;

        Integer userID = null;
        try {
            tx = session.beginTransaction();
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 1;
    }

}
