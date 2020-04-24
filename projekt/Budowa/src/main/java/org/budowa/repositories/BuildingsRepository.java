package org.budowa.repositories;

import org.budowa.entities.Building;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;


public class BuildingsRepository {


    @PersistenceContext
    private EntityManager em;


    public BuildingsRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Budowa");
        em = entityManagerFactory.createEntityManager();
    }

    public static BuildingsRepository inject() {
        return new BuildingsRepository();
    }


    /**
     * find Building by User id
     *
     * @param managerId
     * @return User
     */
    public Collection<Building> findByUserid(int managerId) {
        TypedQuery<Building> q = em.createQuery("SELECT b FROM Building b WHERE b.managerId = :managerId", Building.class);
        q.setParameter("managerId", managerId);
        return q.getResultList();
    }

    /**
     * Find Building by ID
     *
     * @param id
     * @return Building
     */
    public Building findById(Integer id) {
        return em.find(Building.class, id);
    }


    /**
     * Find all Building records
     *
     * @return
     */
    public Collection<Building> findAll() {
        Query query = em.createQuery("SELECT e FROM Building e");
        return (Collection<Building>) query.getResultList();
    }

    /**
     * Insert new Building record
     *
     * @param building
     * @return userId
     */
    public int insert(Building building) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        building.setCreatedAt(timestamp);
        em.getTransaction().begin();
        em.persist(building);
        em.getTransaction().commit();
        return building.getId();
    }

    /**
     * Update building record
     *
     * @param building
     */
    public void update(Building building) {
        em.getTransaction().begin();
        em.merge(building);
        em.getTransaction().commit();
    }

    /**
     * Delete user record
     *
     * @param building
     */
    public void delete(Building building) {
        em.getTransaction().begin();
        em.remove(building);
        em.getTransaction().commit();
    }


    public Building[] getWorkerBuildings(int userId) {
        Query query = em.createNativeQuery("select * from buildings right join workers_buildings wb on buildings.id = wb.building_id where wb.user_id =" + userId, Building.class);
        var list = query.getResultList();
        return (Building[]) list.toArray(new Building[0]);
    }
}
