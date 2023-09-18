package controller;



//package br.com.controleFinanceiro.controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.Tip;

public class TipDAOImpl implements TipDAO{

    
    protected EntityManager entityManager;

    public TipDAOImpl() {
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
    public void persist(Tip tip) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tip);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Tip getById(final int id) {
        return entityManager.find(pojo.Tip.class, id);
    }

    @Override
    public List<Tip> findAll() {
       // return entityManager.createQuery("FROM " + Tip.class.getName()).getResultList();
        return entityManager.createQuery("FROM Tip").getResultList();

    }

    @Override
    public void remove(Tip tip) {
        try {
            entityManager.getTransaction().begin();
            tip = entityManager.find(pojo.Tip.class, tip.getId());
            entityManager.remove(tip);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Tip tip) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tip);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
   


}
