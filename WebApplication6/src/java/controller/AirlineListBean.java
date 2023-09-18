
package controller;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "AirlineList")
@SessionScoped
public class AirlineListBean {
    
    	Airline airline = new Airline();
	private List<Airline> lst = new ArrayList<Airline>();

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

    public List<Airline> getLst() {
        NewAirlineDAO dao = new NewAirlineDAOImpl();
        lst = dao.findAll();
        return lst;
    }
        
        
	
	public List<String> getLista() {
		NewAirlineDAO dao = new NewAirlineDAOImpl();
		lst = dao.findAll();
                List<String> lista= new ArrayList<String>();
                for(Airline a: lst){
                    lista.add(a.getName());
                  
                }
		return lista;
	}

	public void setLst(List<Airline> lst) {
		this.lst = lst;
	}
        
        // edit method
	public String edit(Airline airline) {
		this.airline = airline;
		return "/airline/editAirline.xhtml?faces-redirect=true";
	}
        
        public String update() {
            NewAirlineDAO dao = new  NewAirlineDAOImpl();
		dao.merge(airline);
		return "/airline/listAirline?faces-redirect=true";
	}
        
        
    
}
