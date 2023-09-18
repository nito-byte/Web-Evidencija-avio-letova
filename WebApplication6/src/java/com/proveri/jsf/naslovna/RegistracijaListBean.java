/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proveri.jsf.naslovna;

import controller.NewAirlineDAO;
import controller.NewAirlineDAOImpl;
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
@ManagedBean(name = "RegistracijaListBean")
@SessionScoped
public class RegistracijaListBean implements Serializable {

    private String licenca;
    private List<User> lst = new ArrayList<User>();
    private List<User> lst1 = new ArrayList<User>();
    private String username;
    private String name;
    private String surname;
    private String email;
    private Licenca ll= new Licenca();
    private String airline;
    private User user1=new User();
   
    

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
    
    

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
    
    

    public Licenca getLl() {
        return ll;
    }

    public void setLl(Licenca ll) {
        this.ll = ll;
    }
    
    

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 

    public List<User> getLst() {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        lst = dao.findByNijePrihvacenZahtev();
        return lst;
    }

    public void setLst(List<User> lst) {
        this.lst = lst;
    }

    public List<User> getLst1() {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        lst1 = dao.findByPrihvacenZahtev();
        return lst1;
    }

    public void setLst1(List<User> lst1) {
        this.lst1 = lst1;
    }

    public String edit(User user1) {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User user = new User();
        user = user1;
        user.setPrihvacenZahtev("true");
        inserir.merge(user);

        return "/administrator/listRegistracija.xhtml?faces-redirect=true";
    }

    
    
    public String editAirline() {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User user = new User();
        user = user1;
        user.setAirline(airline);
        inserir.merge(user);

        return "/stujardesa/linkovi.xhtml?faces-redirect=true";
    }
    
    
    
    
    
    public String edit1(User user1) {
        LicencaDAO inserir = new LicencaDAOImpl();
        Licenca lic = new Licenca();
        
//        String username=user1.getUsername();
//        String name=user1.getName();
//        String surname=user1.getSurname();
//        String email=user1.getEmail();
        
        
        lic.setEmail(user1.getEmail());
        lic.setName(user1.getName());
        lic.setSurname(user1.getSurname());
        lic.setLicenca(licenca);
        lic.setUsername(user1.getUsername());
        
        
        
        ll.setEmail(user1.getEmail());
        ll.setName(user1.getName());
        ll.setSurname(user1.getSurname());
        ll.setLicenca(licenca);
        ll.setUsername(user1.getUsername());
        
        //inserir.persist(lic);
     
        

        return "/administrator/editLicenca.xhtml?faces-redirect=true";
    }
    
    

    // remove method
    public void remove(User user) {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        dao.remove(user);
    }
    
    public String updateLicenca() {
        //treba da proverim da li postoji vec user sa tom licencom
        String username=ll.getUsername();
        String lic=ll.getLicenca();
        LicencaDAO dao = new LicencaDAOImpl();
        Licenca a=dao.postoji(username,lic);
        if(a==null){
        
           // LicencaDAO dao = new  LicencaDAOImpl();
		dao.merge(ll);
		return "/administrator/listLicenca?faces-redirect=true";
	
        }
        return "/administrator/listLicenca?faces-redirect=true";
    }

}
