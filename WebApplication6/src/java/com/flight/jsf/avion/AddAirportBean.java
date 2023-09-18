package com.flight.jsf.avion;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

@ManagedBean
@SessionScoped
public class AddAirportBean implements Serializable {

    public AddAirportBean() {
    }

    private String name;
    private String country;
    private String city;
   
    private String code;
    
    private Integer brojPisti;

    private Airport aa = new Airport();

    public Airport getAa() {
        return aa;
    }

    public void setAa(Airport aa) {
        this.aa = aa;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getBrojPisti() {
        return brojPisti;
    }

    public void setBrojPisti(Integer brojPisti) {
        this.brojPisti = brojPisti;
    }

    public String cadastrar() {
        controller.AirportDAO inserir = new controller.AirportDAOImpl();
        Airport usuario = new Airport();
        usuario.setName(name);
        usuario.setBrojPisti(brojPisti);
        usuario.setCity(city);
        usuario.setCode(code);
        usuario.setCountry(country);
        
        aa.setBrojPisti(brojPisti);
        aa.setCity(city);
        aa.setCode(code);
        aa.setCountry(country);
        aa.setName(name);

        inserir.persist(usuario);
        clear();

        return "/administrator/addTerminalGejt.xhtml?faces-redirect=true";
    }

    public String logar() {
        return "/principal.xhtml?faces-redirect=true";
    }

    public void clear() {
        name = "";
        brojPisti = null;
        city = "";
        code = "";
        country = "";
    }

}
