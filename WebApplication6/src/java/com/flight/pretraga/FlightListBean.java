/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.pretraga;

import com.flight.jsf.avion.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "FlightListBean")
@SessionScoped
public class FlightListBean {

    Flight flight = new Flight();
    private List<Flight> lst = new ArrayList<Flight>();
    private List<Flight> lst1 = new ArrayList<Flight>();

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Flight> getLst() {
        FlightDAO dao = new FlightDAOImpl();
        lst = dao.findAll();
        return lst;
    }

    public void setLst(List<Flight> lst) {
        this.lst = lst;
    }

    public List<Flight> getLst1() {
        FlightDAO dao = new FlightDAOImpl();
        lst1 = dao.findByDate();
        return lst1;
    }

    public void setLst1(List<Flight> lst1) {
        this.lst1 = lst1;
    }

//        // edit method
//	public String edit(Flight flight) {
//		this.flight = flight;
//		return "/flight/editFlight.xhtml?faces-redirect=true";
//	}
//        public String update() {
//            FlightDAO dao = new  FlightDAOImpl();
//		dao.merge(flight);
//		return "/flight/listFlight?faces-redirect=true";
//	}
}
