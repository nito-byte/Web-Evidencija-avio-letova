package gost;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import pojo.Rezervacija;


public class RezervacijaDAOImpl implements RezervacijaDAO {
    
    
    protected EntityManager entityManager;

    public RezervacijaDAOImpl() {
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
    public void persist(Rezervacija rezervacija) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rezervacija);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Rezervacija getById(final int id) {
        return entityManager.find(pojo.Rezervacija.class, id);
    }

    @Override
    public List<Rezervacija> findAll() {
        // return entityManager.createQuery("FROM " + Airplane.class.getName()).getResultList();
        return entityManager.createQuery("FROM Rezervacija").getResultList();

    }

    @Override
    public void remove(Rezervacija rezervacija) {
        try {
            entityManager.getTransaction().begin();
            rezervacija = entityManager.find(pojo.Rezervacija.class, rezervacija.getId());
            entityManager.remove(rezervacija);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Rezervacija rezervacija) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(rezervacija);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    

 

}
