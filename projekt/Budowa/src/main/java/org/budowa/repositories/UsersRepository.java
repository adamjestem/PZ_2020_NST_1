package org.budowa.repositories;

import org.budowa.entities.User;
import org.budowa.entities.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


public class UsersRepository {


    @PersistenceContext
    private EntityManager em;

    private static UsersRepository usersRepository;

    public UsersRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Budowa");
        em = entityManagerFactory.createEntityManager();
    }

    public static UsersRepository inject() {
        if (UsersRepository.usersRepository == null) {
            UsersRepository.usersRepository = new UsersRepository();
        }
        return UsersRepository.usersRepository;
    }

    /**
     * find User by Username
     *
     * @param username
     * @param password
     * @return User
     */
    public User findByUsernameAndPassword(String username, String password) {
        TypedQuery<User> q = em.createQuery(
                "SELECT b FROM User b WHERE b.username = :username and b.password = :password",
                User.class
        );
        q.setParameter("username", username);
        q.setParameter("password", password);
        return q.getSingleResult();
    }

    /**
     * Find User by ID
     *
     * @param id
     * @return User
     */
    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    public ArrayList<User> findByRole(UserRole role) {
        TypedQuery<User> q = em.createQuery(
                "SELECT b FROM User b WHERE b.userRole = :role",
                User.class
        );
        q.setParameter("role", role);
        return (ArrayList<User>) q.getResultList();
    }

    /**
     * Find all User records
     *
     * @return
     */
    public Collection<User> findAll() {
        Query query = em.createQuery("SELECT e FROM User e");
        return (Collection<User>) query.getResultList();
    }

    /**
     * Insert new user record
     *
     * @param user
     * @return userId
     */
    public int insert(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user.getId();
    }

    /**
     * Update user record
     *
     * @param user
     */
    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    /**
     * Delete user record
     *
     * @param user
     */
    public void delete(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public User findByUsername(String username) {
        TypedQuery<User> query = em.createQuery("select user from User user where user.username = :username", User.class);
        query.setParameter("username", username);
        var result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
}
