package com.flight.pretraga;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.RadarCentar;

public class AddGoogleMapDAOImpl implements AddGoogleMapDAO {

    protected EntityManager entityManager;

    public AddGoogleMapDAOImpl() {
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
    public void persist(RadarCentar radarCentar) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(radarCentar);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   
    
    

    @Override
    public List<RadarCentar> findAll() {
        // return entityManager.createQuery("FROM " + Airplane.class.getName()).getResultList();
        return entityManager.createQuery("FROM RadarCentar").getResultList();

    }

    @Override
    public void remove(RadarCentar radarCentar) {
        try {
            entityManager.getTransaction().begin();
            radarCentar = entityManager.find(pojo.RadarCentar.class, radarCentar.getId());
            entityManager.remove(radarCentar);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(RadarCentar radarCentar) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(radarCentar);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public List<RadarCentar> getBrojLeta(String brojLeta){
         try{
        
        
        String sql = "FROM RadarCentar "
                + "Where let=:brojLeta ";
        
        Query query = entityManager.createQuery(sql);
        query.setParameter("brojLeta", brojLeta);
        return query.getResultList();
        
        }catch(Exception e){
            e.printStackTrace();
            return null;
            
        }
    }
    

 


}
