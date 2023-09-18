/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.avion;
import com.flight.jsf.proizvodjac.ProizvodjacDAOImpl;
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
@ManagedBean(name = "AvionListBean")
@SessionScoped
public class AirplaneListBean implements Serializable{
    
    	Airplane airplane = new Airplane();
	private List<Airplane> lst = new ArrayList<Airplane>();

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
	public List<Airplane> getLst() {
		AirplaneDAO dao = new AirplaneDAOImpl();
		lst = dao.findAll();
		return lst;
	}

	public void setLst(List<Airplane> lst) {
		this.lst = lst;
	}
        
        
        
        public String update() {
                AirplaneDAO dao = new  AirplaneDAOImpl();
		dao.merge(airplane);
		return "/airplane/listAirplane?faces-redirect=true";
	}
        
        
    
}
