package gost;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.Airplane;
import pojo.Airport;
import pojo.Rezervacija;


public interface RezervacijaDAO {
    

    public void persist(Rezervacija rezervacija); 

    public Rezervacija getById(final int id) ;

    public List<Rezervacija> findAll();

    public void remove(Rezervacija rezervacija);

    public void merge(Rezervacija rezervacija);
    
    
    
    
}
