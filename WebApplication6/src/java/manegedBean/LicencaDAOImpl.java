package manegedBean;

import com.proveri.jsf.naslovna.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.*;

/**
 *
 * @author tijana
 */
public class LicencaDAOImpl implements LicencaDAO {

    protected EntityManager entityManager;

    public LicencaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(Licenca licenca) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(licenca);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Licenca getById(final int id) {
        return entityManager.find(pojo.Licenca.class, id);
    }

    public Licenca getWithUsername(String usern, String pass) {
//        try {
//            entityManager.getTransaction().begin();
//            TypedQuery<User> query = entityManager.createQuery("SELECT c FROM Licenca c WHERE c.username = ?1 and c.password=?2 and c.prihvacenZahtev=:da", User.class);
//            query.setParameter(1, usern);
//            query.setParameter(2, pass);
//            query.setParameter("da", "true");
//            
//            entityManager.getTransaction().commit();
//            return query.getSingleResult();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            entityManager.getTransaction().rollback();return null;
//        }

            return null;
    }

    
      public Licenca postoji(String usern, String lic) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Licenca> query = entityManager.createQuery("SELECT c FROM Licenca c WHERE c.username = ?1 and c.licenca=?2", Licenca.class);
            query.setParameter(1, usern);
            query.setParameter(2, lic);
            
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            //entityManager.getTransaction().rollback();
            return null;
        }

            
    }
    
    
    
    
    
    public List<Licenca> findAll() {
        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
        return entityManager.createQuery("FROM Licenca").getResultList();

    }

    public List<User> findByPrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "true");
        return query.getResultList();
    }

    public void remove(Licenca licenca) {
        try {
            entityManager.getTransaction().begin();
            licenca = entityManager.find(pojo.Licenca.class, licenca.getId());
            entityManager.remove(licenca);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Licenca licenca) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(licenca);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
