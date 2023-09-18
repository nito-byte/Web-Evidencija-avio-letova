package com.flight.jsf.avion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.Airplane;

public class AirplaneDAOImpl implements com.flight.jsf.avion.AirplaneDAO {

    protected EntityManager entityManager;

    public AirplaneDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

   
    public void persist(Airplane airplane) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(airplane);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   
    public Airplane getById(final int id) {
        return entityManager.find(pojo.Airplane.class, id);
    }

  
    public List<Airplane> findAll() {
        // return entityManager.createQuery("FROM " + Airplane.class.getName()).getResultList();
        return entityManager.createQuery("FROM Airplane").getResultList();

    }

  
    public void remove(Airplane airplane) {
        try {
            entityManager.getTransaction().begin();
            airplane = entityManager.find(pojo.Airplane.class, airplane.getId());
            entityManager.remove(airplane);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

  
    public void merge(Airplane airplane) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(airplane);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
