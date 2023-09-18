package controller;



//package br.com.controleFinanceiro.controller;
import controller.AirportDAO;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.Airport;

public class AirportDAOImpl implements AirportDAO{

    
    protected EntityManager entityManager;

    public AirportDAOImpl() {
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
    public void persist(Airport airport) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(airport);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Airport getById(final int id) {
        return entityManager.find(pojo.Airport.class, id);
    }

    @Override
    public List<Airport> findAll() {
       // return entityManager.createQuery("FROM " + Airport.class.getName()).getResultList();
        return entityManager.createQuery("FROM Airport").getResultList();

    }

    @Override
    public void remove(Airport airport) {
        try {
            entityManager.getTransaction().begin();
            airport = entityManager.find(pojo.Airport.class, airport.getId());
            entityManager.remove(airport);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Airport airport) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(airport);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
   


}
