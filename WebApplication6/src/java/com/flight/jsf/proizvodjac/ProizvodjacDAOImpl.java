package com.flight.jsf.proizvodjac;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pojo.Proizvodjac;

public class ProizvodjacDAOImpl implements ProizvodjacDAO {

    protected EntityManager entityManager;

    public ProizvodjacDAOImpl() {
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
    public void persist(Proizvodjac proizvodjac) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(proizvodjac);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Proizvodjac getById(final int id) {
        return entityManager.find(pojo.Proizvodjac.class, id);
    }

    public List<Proizvodjac> findAll() {
        // return entityManager.createQuery("FROM " + Proizvodjac.class.getName()).getResultList();
        return entityManager.createQuery("FROM Proizvodjac").getResultList();

    }

    @Override
    public void remove(Proizvodjac proizvodjac) {
        try {
            entityManager.getTransaction().begin();
            proizvodjac = entityManager.find(pojo.Proizvodjac.class, proizvodjac.getId());
            entityManager.remove(proizvodjac);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Proizvodjac proizvodjac) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(proizvodjac);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
