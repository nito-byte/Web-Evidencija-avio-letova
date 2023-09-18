/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.avion;
import controller.AirportDAO;
import controller.AirportDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "AirportListBean")
@SessionScoped
public class AirportListBean {
    
    	Airport airline = new Airport();
	private List<Airport> lst = new ArrayList<Airport>();

	public Airport getAirport() {
		return airline;
	}

	public void setAirport(Airport airline) {
		this.airline = airline;
	}
	
	public List<Airport> getLst() {
		AirportDAO dao = new AirportDAOImpl();
		lst = dao.findAll();
		return lst;
	}

	public void setLst(List<Airport> lst) {
		this.lst = lst;
	}
        
//        // edit method
//	public String edit(Airport airline) {
//		this.airline = airline;
//		return "/airline/editAirport.xhtml?faces-redirect=true";
//	}
        
//        public String update() {
//            AirportDAO dao = new  AirportDAOImpl();
//		dao.merge(airline);
//		return "/airline/listAirport?faces-redirect=true";
//	}
        
        
    
}
