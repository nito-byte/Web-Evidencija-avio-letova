package com.flight.pretraga;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.lang.time.DateFormatUtils;
import org.hibernate.HibernateException;
import pojo.Flight;

public class FlightDAOImpl implements FlightDAO {

    protected EntityManager entityManager;

    public FlightDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(Flight flight) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(flight);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public Boolean persistP(Flight flight) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(flight);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();return null;
        }
    }

    public Flight getById(final int id) {
        return entityManager.find(pojo.Flight.class, id);
    }
    
    

    public List<Flight> findAll() {
        // return entityManager.createQuery("FROM " + Airplane.class.getName()).getResultList();
        return entityManager.createQuery("FROM Flight").getResultList();

    }

    public void remove(Flight flight) {
        try {
            entityManager.getTransaction().begin();
            flight = entityManager.find(pojo.Flight.class, flight.getId());
            entityManager.remove(flight);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Flight flight) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(flight);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Flight findById(int id) {
        try {
            return (Flight) this.entityManager.find(Flight.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Flight findByCode(String code) {
        try {
            Query query = this.entityManager.createQuery("FROM Flight  WhERE code = :code ");
            query.setParameter("code", code);
            return (Flight) query.getSingleResult();
        } catch (HibernateException e) {
            return null;
            
        }
    }
    
    
    // dodajem za pilote: pregled i azuriranje
     @Override
    public Flight findPilotAktuelni(String brojLeta) {
        try {
            String sql= "FROM Flight "
                    + "WHERE brojLeta=:brojLeta ";
//            String sql = "FROM Flight f,Posada p "
//                    + "Where f.avioKompanija=:avioKompanija  "
//                    + "AND p.p1=:username OR p.p2=:username  "
//                    + "AND p.BrojLeta=f.BrojLeta "
//                    + "AND  f.start = current_date() "
//                    + "OR f.vremeSletanja=current_date() "
//                    + "ORDER BY f.start,f.vremeSletanja ";

                    
            Query query = entityManager.createQuery(sql);
            Date d=new Date();
            
          //  query.setParameter("avioKompanija", avioKompanija);
          //  query.setParameter("username", username);
            query.setParameter("brojLeta", brojLeta);

            
            return  (Flight) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
    
    
    
    
    
    
     @Override
    public List<Flight> findRadnikAktuelni(String avioKompanija) {
        try {
            String sql = "FROM Flight "
                    + "Where avioKompanija=:avioKompanija  "
                    + "AND  start >= current_date() "
                    + "OR vremeSletanja=current_date() "
                    + "ORDER BY start,vremeSletanja ";

                    
            Query query = entityManager.createQuery(sql);
            Date d=new Date();
            
            query.setParameter("avioKompanija", avioKompanija);

            
            return  query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
    
    @Override
    public Flight findBuduciS(String brojLeta) {
        try {
            String sql = "FROM Flight "
                    + "Where brojLeta=:brojLeta "
                    + "AND start > current_date() ";

                    
            Query query = entityManager.createQuery(sql);

            Date d=new Date();
            
            query.setParameter("brojLeta", brojLeta);
           // query.setParameter("danas", DateFormatUtils.format(d, "yyyy-MM-dd HH:mm:SS"));

            
            return (Flight) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
    @Override
    public Flight findLet(String brojLeta) {
        try {
            String sql = "FROM Flight "
                    + "Where brojLeta=:brojLeta ";

            Query query = entityManager.createQuery(sql);
            query.setParameter("brojLeta", brojLeta);
            return  (Flight) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public Flight findArchiveS(String brojLeta) {
        try {
            String sql = "FROM Flight "
                    + "Where brojLeta=:brojLeta "
                    + "AND vremeSletanja < current_date() ";

                    
            Query query = entityManager.createQuery(sql);

            Date d=new Date();
            
            query.setParameter("brojLeta", brojLeta);
           // query.setParameter("danas", DateFormatUtils.format(d, "yyyy-MM-dd HH:mm:SS"));

            
            return (Flight) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

//  ja: ovo su svi letovi izmedju dva datuma    
//    @Override
//    public List<Flight> findByDate(Date from, Date to) {
//        try {
//            Query query = this.entityManager.createQuery("SELECT f "
//                    + "FROM Flight f "
//                    + "WHERE f.start > :from AND f.start < :to "
//                    + "ORDER BY f.start DESC"
//            );
//
//            query.setParameter("from", from);
//            query.setParameter("to", to);
//            return query.getResultList();
//        } catch (HibernateException e) {
//            return new ArrayList();
//        }
//    }
//    
    @Override
    public List<Flight> findByDate() {
        try {
            Query query = this.entityManager.createQuery(
                    "FROM Flight f "
                    + "WHERE day(f.start) = :day AND month(f.start) = :month AND year(f.start) = :year  OR "
                    + " day(f.ocekivanoVreme) = :day AND month(f.ocekivanoVreme) = :month AND year(f.ocekivanoVreme) = :year "
                    + "ORDER BY f.start DESC"
            );

            Calendar cal = Calendar.getInstance();
            // cal.setTime(date);
            query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
            query.setParameter("month", cal.get(Calendar.MONTH) + 1);
            query.setParameter("year", cal.get(Calendar.YEAR));
            return query.getResultList();
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }
    
    

    @Override
    public void addFlight(Flight flight) {
        this.entityManager.persist(flight);
    }

    @Override
    public boolean updateFlight(Flight flight) {
        try {
            this.entityManager.merge(flight);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteFlight(Flight flight) {
        try {
            this.entityManager.remove(flight);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Object[]> findFlightsPresedanje(String polaziste, String odrediste, Date when) {
        try {

            String sql = "FROM Flight f1, Flight f2 "
                    + "WHERE  (f2.airportFrom=f1.airportTo and f2.start>f1.ocekivanoVreme) "
                    + "AND day(f1.ocekivanoVreme)=:day "
                    + "AND month(f1.ocekivanoVreme)=:month "
                    + "AND year(f1.ocekivanoVreme)=:year "
                    + "AND day(f2.start)=:day  "
                    + "AND month(f2.start)=:month "
                    + "AND year(f2.start)=:year "
                    + "AND  ( f1.airportFrom=:polaziste or f1.grad1=:polaziste) "
                    + "AND  (f2.grad2=:odrediste OR f2.airportTo=:odrediste) "
                    + "order by f1,f2 ";
            Query query = entityManager.createQuery(sql);

//            Query query = this.entityManager.createQuery("Select f1,f2 "
//                     +
//            );
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(when);
//            query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
//            query.setParameter("month", cal.get(Calendar.MONTH) + 1);
//            query.setParameter("year", cal.get(Calendar.YEAR));
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(when);
            
            int p  = cal.get(Calendar.DAY_OF_MONTH);
            int p1=cal.get(Calendar.MONTH) + 1;
            int p2=cal.get(Calendar.YEAR);
            
            query.setParameter("day", p);
            query.setParameter("month",p1 );
            query.setParameter("year", p2);
            
            
            
            query.setParameter("polaziste", polaziste);
            query.setParameter("odrediste", odrediste);
            return query.getResultList();
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }

    @Override
    public List<Flight> findFlightsJedanSmer(String polaziste, String odrediste, Date when) {
        try {
            
            String sql ="FROM Flight  "
                    + "WHERE (airportFrom=:polaziste OR grad1=:polaziste) "
                    + "AND (grad2=:odrediste OR airportTo=:odrediste) "
                    + "AND day(start) =:day AND month(start) =:month AND year(start) =:year "
                    + "ORDER BY start DESC ";
            Query query = entityManager.createQuery(sql);
//            Query query = this.entityManager.createQuery("SELECT f "
//                    + "FROM Flight f "
//                    + "WHERE day(f.start) =:day AND month(f.start) =:month AND year(f.start) =:year "
//                    + "AND  ( f.airportFrom=:polaziste or f.grad1=:polaziste) "
//                    + "AND  (f.grad2 =:odrediste OR f.airportTo=:odrediste) "
//                    + "ORDER BY f.start DESC"
//            );

            Calendar cal = Calendar.getInstance();
            cal.setTime(when);
            
            int p  = cal.get(Calendar.DAY_OF_MONTH);
            int p1=cal.get(Calendar.MONTH) + 1;
            int p2=cal.get(Calendar.YEAR);
            
            query.setParameter("day", p);
            query.setParameter("month",p1 );
            query.setParameter("year", p2);
            
            
            
//            query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
//            query.setParameter("month", cal.get(Calendar.MONTH) + 1);
//            //query.setParameter("month", cal.DAY_OF_MONTH);
//            query.setParameter("year", cal.get(Calendar.YEAR));
////            query.setParameter("year", cal.MONTH);
////            query.setParameter("year", cal.);
            
            
            query.setParameter("polaziste", polaziste);
            query.setParameter("odrediste", odrediste);
            return query.getResultList();
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }
    @Override
     public List<Object[]> findFlightsDvaSmeraNijeDir(String polaziste, String odrediste, Date when1, Date when2) {
        try{
         String sql = "FROM Flight f1, Flight f2 , Flight f3, Flight f4 "
                    + "WHERE  f2.airportFrom=f1.airportTo "
                    + "and f2.start>f1.ocekivanoVreme "
                    + "AND day(f1.start)=:day1 "
                    + "AND month(f1.start)=:month1 "
                   + "AND year(f1.start)=:year1 "
                    + "AND day(f2.start)=:day1  "
                    + "AND month(f2.start)=:month1 "
                    + "AND year(f2.start)=:year1 "
                    + "AND   f1.airportFrom=:polaziste "
                    + "or f1.grad1=:polaziste "
                    + "AND  f2.grad2=:odrediste "
                    + "OR f2.airportTo=:odrediste "
                 
                    + "AND  f3.airportTo=f4.airportFrom "
                    + "and f4.start>f3.ocekivanoVreme "
                    + "AND day(f3.ocekivanoVreme)=:day2 "
                    + "AND month(f3.ocekivanoVreme)=:month2 "
                    + "AND year(f3.ocekivanoVreme)=:year2 "
                    + "AND day(f4.start)=:day2  "
                    + "AND month(f4.start)=:month2 "
                    + "AND year(f4.start)=:year2 "
                    + "AND   f3.airportFrom=:odrediste "
                 + "or f3.grad1=:odrediste "
                    + "AND  f4.grad2=:polaziste "
                 + "OR f4.airportTo=:polaziste "
                    + "order by f1,f2,f3,f4 ";
         
              
            Query query = entityManager.createQuery(sql);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(when1);
            
            int p  = cal.get(Calendar.DAY_OF_MONTH);
            int p1=cal.get(Calendar.MONTH) + 1;
            int p2=cal.get(Calendar.YEAR);
            
            query.setParameter("day1", p);
            query.setParameter("month1",p1 );
            query.setParameter("year1", p2);
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(when2);
            
            int a  = cal1.get(Calendar.DAY_OF_MONTH);
            int a1=cal1.get(Calendar.MONTH) + 1;
            int a2=cal1.get(Calendar.YEAR);
            
            query.setParameter("day2", a);
            query.setParameter("month2",a1 );
            query.setParameter("year2", a2);
            
            query.setParameter("polaziste", polaziste);
            query.setParameter("odrediste", odrediste);
            return query.getResultList();
            
        } catch (HibernateException e) {
            return new ArrayList();
        }
     }
     
     
     
     

    @Override
    public List<Object[]> findFlightsDvaSmera(String polaziste, String odrediste, Date when1, Date when2) {
       
//            Query query = this.entityManager.createQuery("SELECT f "
//                    + "FROM Flight f "
//                    + "WHERE day(f.start) = :day AND month(f.start) = :month AND year(f.start) = :year "
//                    + "AND  ( f.airportFrom=: polaziste) "
//                    + "OR  (f.grad2 = :odrediste OR f.airportTo=: odrediste) "
//                    + "ORDER BY f.start DESC"
//            );
//
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(when);
//            query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
//            query.setParameter("month", cal.get(Calendar.MONTH) + 1);
//            query.setParameter("year", cal.get(Calendar.YEAR));
//            query.setParameter("from", polaziste);
//            query.setParameter("to", odrediste);
//            return query.getResultList(); 
            
            
            
            
           try {

            String sql = "FROM Flight f1, Flight f2 "
                    + "WHERE  (f1.airportFrom=:polaziste or f1.grad1=:polaziste) "
                    + "and (f1.airportTo=:odrediste or f1.grad2=:odrediste)  "
                    + "AND (f2.airportFrom=:odrediste or f2.grad1=:odrediste)"
                    + " and (f2.airportTo=:polaziste or f2.grad2=:polaziste) "
                    + "AND day(f1.start)=:day1 "
                    + "AND month(f1.start)=:month1 "
                    + "AND year(f1.start)=:year1 "
                    + "AND day(f2.start)=:day2  "
                    + "AND month(f2.start)=:month2 "
                    + "AND year(f2.start)=:year2 "
                    + "order by f1,f2 ";
            Query query = entityManager.createQuery(sql);
//            Query query = this.entityManager.createQuery("SELECT f "
//                    + "FROM Flight f "
//                    + "WHERE day(f.start) =:day AND month(f.start) =:month AND year(f.start) =:year "
//                    + "AND  ( f.airportFrom=:polaziste or f.grad1=:polaziste) "
//                    + "AND  (f.grad2 =:odrediste OR f.airportTo=:odrediste) "
//                    + "ORDER BY f.start DESC"
//            );

            Calendar cal = Calendar.getInstance();
            cal.setTime(when1);
            
            int p  = cal.get(Calendar.DAY_OF_MONTH);
            int p1=cal.get(Calendar.MONTH) + 1;
            int p2=cal.get(Calendar.YEAR);
            
            query.setParameter("day1", p);
            query.setParameter("month1",p1 );
            query.setParameter("year1", p2);
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(when2);
            
            int a  = cal1.get(Calendar.DAY_OF_MONTH);
            int a1=cal1.get(Calendar.MONTH) + 1;
            int a2=cal1.get(Calendar.YEAR);
            
            query.setParameter("day2", a);
            query.setParameter("month2",a1 );
            query.setParameter("year2", a2);
            
            
            
//            query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
//            query.setParameter("month", cal.get(Calendar.MONTH) + 1);
//            //query.setParameter("month", cal.DAY_OF_MONTH);
//            query.setParameter("year", cal.get(Calendar.YEAR));
////            query.setParameter("year", cal.MONTH);
////            query.setParameter("year", cal.);
            
            
            query.setParameter("polaziste", polaziste);
            query.setParameter("odrediste", odrediste);
            return query.getResultList();
        } catch (HibernateException e) {
            return new ArrayList();
        }
    }
        

    @Override
    public List findCountFlightsByDate(int days) {
        try {
            Query query = this.entityManager.createQuery("SELECT count(f.id), f.start "
                    + "FROM Flight f "
                    + "WHERE f.start > current_date() "
                    + "GROUP BY day(f.start), month(f.start), year(f.start)"
                    + "ORDER BY f.start DESC"
            );
            List result = query.getResultList();
            if (result.size() >= days) {
                return result.subList(0, days);
            } else {
                return result.subList(0, result.size());
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

//    @Override
//    public boolean setSeatsToFlight(Flight flight, Set<Seat> seats, Book book) {
//        try {
//            for (Seat seat: seats) {
//                if (this.setSeatToFlight(flight, seat, book) == false) {
//                    return false;
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//
//    
//    @Override
//    public boolean setSeatToFlight(Flight flight, Seat seat, Book book) {
//        try {
//            seat.setFlight(flight);
//            //this.entityManager.persist(seat);
////            seat.setBook(book);
////            if (flight.isOffer() == false) {
////                seat.setType(ClassEntity.TOURIST);
////            }
////            flight.addSeat(seat);
//            this.entityManager.merge(flight);
//            return true;
//        } catch(Exception e) {
//            System.out.println("fsdafdsadsfadsfas" + e.getMessage());
//            return false;
//        }
//    }
//    
//   
//    @Override
//    public List<Seat> getSeatsByFlightClass(Flight flight, int type) {
//        try {
//            Query query = this.entityManager.createQuery("SELECT f "
//                    + "FROM Seat s "
//                    + "INNER JOIN s.flight f "
//                    + "WHERE s.flight = :flight AND s.type = :type "
//            );
//            query.setParameter("flight", flight);
//            query.setParameter("type", type);
//            return query.getResultList();
//                    
//        } catch(Exception e) {
//            return new ArrayList();
//        }
//    }
    @Override
    public List<Flight> findByDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
