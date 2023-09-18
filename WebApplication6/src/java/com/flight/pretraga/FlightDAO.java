package com.flight.pretraga;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.Airplane;
import pojo.Airport;
import pojo.Flight;


public interface FlightDAO {
    

    public void persist(Flight flight); 

    public Flight getById(final int id) ;

    public List<Flight> findAll();

    public void remove(Flight flight);

    public void merge(Flight flight);
    
    public List<Flight> findFlightsJedanSmer(String polaziste, String  odrediste, Date when) ;
    public List<Object[]> findFlightsDvaSmera(String polaziste, String  odrediste, Date when1, Date when2) ;
    public List<Object[]> findFlightsPresedanje(String polaziste, String  odrediste, Date when) ; 
    
     public List<Object[]> findFlightsDvaSmeraNijeDir(String polaziste, String  odrediste, Date when1, Date when2) ;
   
    
    public Flight findArchiveS(String brojLeta);
    public Flight findBuduciS(String brojLeta);
    public Flight findLet(String brojLeta);
    
    public Flight findById(int id);
    
    
    public Flight findByCode(String code);
    
    
   // public List<Flight> findByDate(Date from, Date to);
    
    public List<Flight> findByDate();
    
    
    public void addFlight(Flight flight);
    
    
    public boolean updateFlight(Flight flight);
    
    
    public boolean deleteFlight(Flight flight);
    
    
    public List<Flight> findRadnikAktuelni(String airline); 
    public Flight findPilotAktuelni(String brojLeta); 
    

    public List findCountFlightsByDate(int days);
    

    public List<Flight> findByDate(Date date);

    public Boolean persistP(Flight usuario);
    
}
