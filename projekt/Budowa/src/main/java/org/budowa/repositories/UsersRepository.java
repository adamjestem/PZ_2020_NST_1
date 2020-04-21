package org.budowa.repositories;
import org.budowa.entities.User;
import javax.persistence.*;
import java.util.Collection;


public class UsersRepository {


    @PersistenceContext
    private EntityManager em;


    public UsersRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Budowa");
        em = entityManagerFactory.createEntityManager();
    }


    /**
     * find User by Username
     * @param username
     * @return User
     */
    public User findByUsername(String username) {
        TypedQuery<User> q = em.createQuery("SELECT b FROM User b WHERE b.username = :username", User.class);
        q.setParameter("username", username);
        return q.getSingleResult();
    }

    /**
     * Find User by ID
     * @param id
     * @return User
     */
    public User findById(Integer id) {
        return em.find(User.class, id);
    }


    /**
     * Find all User records
     * @return
     */
    public Collection<User> findAll() {
        Query query = em.createQuery("SELECT e FROM User e");
        return (Collection<User>) query.getResultList();
    }

    /**
     * Insert new user record
     * @param user
     * @return userId
     */
    public int insert(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user.getId();
    }

    /**
     * Update user record
     * @param user
     */
    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    /**
     * Delete user record
     * @param user
     */
    public void delete(User user){
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }


}
