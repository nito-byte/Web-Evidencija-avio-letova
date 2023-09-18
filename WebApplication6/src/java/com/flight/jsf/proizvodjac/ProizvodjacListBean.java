/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.proizvodjac;
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
@ManagedBean(name = "ProizvodjacListBean")
@SessionScoped
public class ProizvodjacListBean implements Serializable{
    
    	Proizvodjac proizvodjac = new Proizvodjac();
	private List<Proizvodjac> lst = new ArrayList<Proizvodjac>();

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	public List<Proizvodjac> getLst() {
		ProizvodjacDAO dao = new ProizvodjacDAOImpl();
		lst = dao.findAll();
		return lst;
	}

	public void setLst(List<Proizvodjac> lst) {
		this.lst = lst;
	}
        
        
        
        public String update() {
            ProizvodjacDAO dao = new  ProizvodjacDAOImpl();
		dao.merge(proizvodjac);
		return "/proizvodjac/listProizvodjac?faces-redirect=true";
	}
        
        
    
}
