package manegedBean;

import com.proveri.jsf.naslovna.*;
import java.util.List;
import pojo.*;

/**
 *
 * @author tijana
 */
public interface LicencaDAO {
    
    public void persist(Licenca licenca);

    public Licenca getById(final int id);
    public Licenca getWithUsername(String username,String pass);

    public List<Licenca> findAll();
    public List<User> findByPrihvacenZahtev();

    public void remove(Licenca licenca);

    public void merge(Licenca licenca);

    
    public Licenca postoji(String username, String lic);
    
    
}
