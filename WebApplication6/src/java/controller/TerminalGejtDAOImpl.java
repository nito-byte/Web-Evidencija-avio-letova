package controller;



//package br.com.controleFinanceiro.controller;
import controller.TerminalGejtDAO;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.TerminalGejt;

public class TerminalGejtDAOImpl implements TerminalGejtDAO{

    
    protected EntityManager entityManager;

    public TerminalGejtDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(TerminalGejt terminalGejt) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(terminalGejt);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public TerminalGejt getById(final int id) {
        return entityManager.find(pojo.TerminalGejt.class, id);
    }

    public List<TerminalGejt> findAll() {
       // return entityManager.createQuery("FROM " + TerminalGejt.class.getName()).getResultList();
        return entityManager.createQuery("FROM TerminalGejt").getResultList();

    }

    public void remove(TerminalGejt terminalGejt) {
        try {
            entityManager.getTransaction().begin();
            terminalGejt = entityManager.find(pojo.TerminalGejt.class, terminalGejt.getId());
            entityManager.remove(terminalGejt);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(TerminalGejt terminalGejt) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(terminalGejt);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
   


}
