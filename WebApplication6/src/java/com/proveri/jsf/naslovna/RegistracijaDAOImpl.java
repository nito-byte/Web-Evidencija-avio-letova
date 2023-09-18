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
public class RegistracijaDAOImpl implements RegistracijaDAO {

    protected EntityManager entityManager;

    public RegistracijaDAOImpl() {
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

    @Override
    public User getById(final int id) {
        return entityManager.find(pojo.User.class, id);
    }

    @Override
    public List<User> getStujardesa(String kompanija) {
        String sql = " from User u where u.tipKorisnika=:tip"
                + " and u.prihvacenZahtev=:zahtev"
                + " and u.airline=:kompanija ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("tip", "stujardesa");
        query.setParameter("zahtev", "true");
        query.setParameter("kompanija", kompanija);
        return query.getResultList();
    }

//     @Override
//    public List<User> getPilot(String kompanija) {
//        String sql = " from User u where u.tipKorisnika=:tip"
//                     +" and u.prihvacenZahtev=:zahtev"
//                     +" and u.airline=:kompanija ";
//        
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("tip", "pilot");
//        query.setParameter("zahtev", "true");
//        query.setParameter("kompanija", kompanija);
//        return query.getResultList();
//    }
    @Override
    public List<User> getPilot(String kompanija, String m) {
        try {
        //String sql = " FROM User u, Licenca l, Tip t, Airplane a "
            //           + "where (l.licenca=t.licenca) "
            //           + "and (l.username=u.username) ";
            //  + "where (a.tip=t.naziv) ";
            //  + "and l.licenca=t.licenca "
            //  + "and l.username=u.username  "

                 //    + "and u.tipKorisnika=:tip "
            //  +" and u.prihvacenZahtev=:zahtev ";
            // +" and u.airline=?1 ";
            // + "and a.model=?2";
      //  Query query = entityManager.createQuery(sql);
            //  query.
            //query.setParameter("tip", "pilot");
            // query.setParameter("zahtev", "true");
            // query.setParameter(1, kompanija);
            //query.setParameter(2, m);
            // return (List<User>)query.getResultList();
            List<User> users = entityManager.createQuery(
                    "select distinct u "
                    + "from User u, Licenca l, Tip t, Airplane a "
                    + "where l.licenca = t.licenca and l.username=u.username and a.tip=t.naziv and u.tipKorisnika=:tip "
                            + "and u.prihvacenZahtev=:zahtev and u.airline=?1 and a.model=?2 ", User.class)
                    .setParameter("tip", "pilot")
                    .setParameter("zahtev", "true")
                    .setParameter(1, kompanija)
                    .setParameter(2, m)
                    .getResultList();
            return users;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }

    @Override
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
            return null;

        }

    }

    @Override
    public List<User> findAll() {
        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
        return entityManager.createQuery("FROM User").getResultList();

    }

    @Override
    public List<User> findByNijePrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "false");
        return query.getResultList();
    }

    @Override
    public List<User> findByPrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name  and u.tipKorisnika=:tip";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "true");
        query.setParameter("tip", "pilot");
        return query.getResultList();
    }

    @Override
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

    @Override
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
