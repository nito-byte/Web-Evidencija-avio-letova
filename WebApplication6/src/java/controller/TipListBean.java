/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.avion;
import controller.TipDAO;
import controller.TipDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "TipListBean")
@SessionScoped
public class TipListBean {
    
    	Tip tip = new Tip();
	private List<Tip> lst = new ArrayList<Tip>();
      //  private List<String> lst_licence = new ArrayList<String>();

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
	public List<Tip> getLst() {
		TipDAO dao = new TipDAOImpl();
		lst = dao.findAll();
                
                
//                for(Tip t:lst){
//                    lst_licence.add(t.getLicenca());
//                }
		return lst;
	}

	public void setLst(List<Tip> lst) {
		this.lst = lst;
	}
        
    
        
    
}
