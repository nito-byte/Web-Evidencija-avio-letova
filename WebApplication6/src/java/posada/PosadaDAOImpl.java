package posada;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.Posada;
import pojo.RadarCentar;

/**
 *
 * @author tijana
 */
public class PosadaDAOImpl implements PosadaDAO {

    protected EntityManager entityManager;

    public PosadaDAOImpl() {
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
    public void persist(Posada posada) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(posada);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Posada getById(final int id) {
        return entityManager.find(pojo.Posada.class, id);
    }
    
   
    @Override
    public List<Posada> findAll() {
        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
        return entityManager.createQuery("FROM Posada").getResultList();

    }
    
    
    @Override
    public List<Posada> getWithUsername(String username) {
        try{
        
        
        String sql = "FROM Posada "
                + "Where s1=:username "
                + "or s2=:username "
                + "or s3=:username " 
                + "or s4=:username "
                + "or s5=:username ";
        
        Query query = entityManager.createQuery(sql);
        query.setParameter("username", username);
        return query.getResultList();
        
        }catch(Exception e){
            e.printStackTrace();
            return null;
            
        }
    }
    
    
     @Override
    public List<Posada> getWithUsernamePilot(String username) {
        try{
        
        
        String sql = "FROM Posada "
                + "Where p1=:username "
                + "or p2=:username ";
        
        Query query = entityManager.createQuery(sql);
        query.setParameter("username", username);
        return query.getResultList();
        
        }catch(Exception e){
            e.printStackTrace();
            return null;
            
        }
    }
    
    
    

    

    
    @Override
    public void remove(Posada posada) {
        try {
            entityManager.getTransaction().begin();
            posada = entityManager.find(pojo.Posada.class, posada.getId());
            entityManager.remove(posada);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(Posada posada) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(posada);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   

}
