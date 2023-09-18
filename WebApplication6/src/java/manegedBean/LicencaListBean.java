/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manegedBean;
import com.proveri.jsf.naslovna.*;
import manegedBean.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "LicencaListBean")
@SessionScoped
public class LicencaListBean implements Serializable{
    
    	User user = new User();
	private List<User> lst = new ArrayList<User>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getLst() {
		LicencaDAO dao = new LicencaDAOImpl();
		lst = dao.findByPrihvacenZahtev();
		return lst;
	}
        
        
        

	public void setLst(List<User> lst) {
		this.lst = lst;
	}
}
        
        
//        
//          public String edit(User user1) {
////                LicencaDAO inserir = new LicencaDAOImpl();
////                User user= new User();
//		user = user1;
//                user.setPrihvacenZahtev("true");
//                inserir.merge(user);
//                
//		return "/administrator/listRegistracija.xhtml?faces-redirect=true";
//	}
//        
//        // remove method
//	public void remove(User user) {
//		LicencaDAO dao = new LicencaDAOImpl();
//		dao.remove(user);
//	}
        
        
          