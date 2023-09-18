package com.proveri.jsf.naslovna;

import java.util.List;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface RegistracijaDAO {
    
    public void persist(User user);

    public User getById(final int id);
    public User getWithUsername(String username,String pass);
    public List<User> getStujardesa(String kompanija);
    public List<User> getPilot(String kompanija,String model);

    public List<User> findAll();
    public List<User> findByNijePrihvacenZahtev();
    public List<User> findByPrihvacenZahtev();
    

    public void remove(User user);

    public void merge(User user);
    
    
}
