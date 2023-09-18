package posada;

import java.util.List;
import pojo.Posada;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface PosadaDAO {
    
    public void persist(Posada posada);

    public Posada getById(final int id);

    public List<Posada> findAll();

    public void remove(Posada posada);

    public void merge(Posada posada);
    
    public List<Posada> getWithUsername(String username);
    public List<Posada> getWithUsernamePilot(String username);
    
    
}
