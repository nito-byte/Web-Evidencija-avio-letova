/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.Airline;

/**
 *
 * @author tijana
 */
public class NewAirlineDAOImpl implements NewAirlineDAO {

    protected EntityManager entityManager;

    public NewAirlineDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    @Override
    public void persist(Airline airline) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(airline);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Airline getById(final int id) {
        return entityManager.find(pojo.Airline.class, id);
    }
    
    @Override
    public Airline getByName(String name) {
        try{
        
        
        String sql = "FROM Airline "
                + "Where name=:name ";
        
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", name);
        return (Airline) query.getSingleResult();
        
        }catch(Exception e){
            e.printStackTrace();
            return null;
            
        }
    }

    @Override
    public List<Airline> findAll() {
        // return entityManager.createQuery("FROM " + Airline.class.getName()).getResultList();
        return entityManager.createQuery("FROM Airline").getResultList();

    }

    @Override
    public List<Airline> findAllAirline(String airline) {

        String sql = " from Airline "
                + "where name<>:airline ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("airline", airline);
        return query.getResultList();

    }

    @Override
    public void remove(Airline airline) {
        try {
            entityManager.getTransaction().begin();
            airline = entityManager.find(pojo.Airline.class, airline.getId());
            entityManager.remove(airline);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Airline airline) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(airline);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
