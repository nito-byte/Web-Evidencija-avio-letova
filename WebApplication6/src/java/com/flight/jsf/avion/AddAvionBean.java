package com.flight.jsf.avion;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Airplane;

@ManagedBean(name = "addAvionBean")
@SessionScoped
public class AddAvionBean implements Serializable {

    private String model;
    private String proizvodjac;
    private String tip;
    
    private Airplane aa= new Airplane();

    public Airplane getAa() {
        return aa;
    }

    public void setAa(Airplane aa) {
        this.aa = aa;
    }
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

     public String cadastrar() {
        AirplaneDAO inserir = new AirplaneDAOImpl();
        Airplane usuario = new Airplane();
        usuario.setModel(model);
        usuario.setProizvodjac(proizvodjac);
        usuario.setTip(tip);
        
        aa.setModel(model);
        aa.setProizvodjac(proizvodjac);
        aa.setTip(tip);

        inserir.persist(usuario);
        clear();
        return "/avion/addSlika.xhtml?faces-redirect=true";
    }

    public String logar() {
        return "/principal.xhtml?faces-redirect=true";
    }
    
    public void clear(){
      model="";
      proizvodjac="";
      tip="";
      
    }
            
}
