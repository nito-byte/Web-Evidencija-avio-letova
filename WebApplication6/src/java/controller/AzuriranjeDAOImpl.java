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
import pojo.Azuriranje;

/**
 *
 * @author tijana
 */
public class AzuriranjeDAOImpl implements AzuriranjeDAO {
    protected EntityManager entityManager;

    public AzuriranjeDAOImpl() {
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
    public void persist(Azuriranje azuriranje) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(azuriranje);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Azuriranje getById(final int id) {
        return entityManager.find(pojo.Azuriranje.class, id);
    }

    @Override
    public List<Azuriranje> findAll() {
       // return entityManager.createQuery("FROM " + Azuriranje.class.getName()).getResultList();
        return entityManager.createQuery("FROM Azuriranje").getResultList();

    }

    @Override
    public void remove(Azuriranje azuriranje) {
        try {
            entityManager.getTransaction().begin();
            azuriranje = entityManager.find(pojo.Azuriranje.class, azuriranje.getId());
            entityManager.remove(azuriranje);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Azuriranje azuriranje) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(azuriranje);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
