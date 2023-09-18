package com.proveri.jsf.naslovna;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.User;

/**
 *
 * @author tijana
 */
public class PrijavaDAOImpl implements PrijavaDAO {

    protected EntityManager entityManager;

    public PrijavaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public User getById(final int id) {
        return entityManager.find(pojo.User.class, id);
    }
    
    
    public List<User> getStujardesa(String kompanija) {
        String sql = " from User u where u.tipKorisnika=:tip"
                +" and u.prihvacenZahtev=:zahtev"
                +" and u.airline=:kompanija ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("tip", "stujardesa");
        query.setParameter("zahtev", "true");
        query.setParameter("kompanija", kompanija);
        return query.getResultList();
    }
    
    public List<User> getPilot(String kompanija) {
        String sql = " from User u where u.tipKorisnika=:tip"
                     +" and u.prihvacenZahtev=:zahtev"
                     +" and u.airline=:kompanija ";
        
        Query query = entityManager.createQuery(sql);
        query.setParameter("tip", "pilot");
        query.setParameter("zahtev", "true");
        query.setParameter("kompanija", kompanija);
        return query.getResultList();
    }

    public User getWithUsername(String usern, String pass) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = ?1 and c.password=?2 and c.prihvacenZahtev=:da", User.class);
            query.setParameter(1, usern);
            query.setParameter(2, pass);
            query.setParameter("da", "true");
            
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();return null;
        }

    }

    public List<User> findAll() {
        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
        return entityManager.createQuery("FROM User").getResultList();

    }

    public List<User> findByNijePrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "false");
        return query.getResultList();
    }
    
    
     public List<User> findByPrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name  and u.tipKorisnika=:tip";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "true");
        query.setParameter("tip", "pilot");
        return query.getResultList();
    }

    public void remove(User user) {
        try {
            entityManager.getTransaction().begin();
            user = entityManager.find(pojo.User.class, user.getId());
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   

}
