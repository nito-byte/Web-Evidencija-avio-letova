/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.proveri.jsf.naslovna.RegistracijaBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pojo.Azuriranje;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "aktuelniAzurirajBean")
@SessionScoped
public class AktuelniAzurirajBean {
    private String title;
    private String duzina;
    private String brzina;
    private double preostalo;
    
    
    @ManagedProperty(value = "#{registracijaBean}")
    RegistracijaBean firstBean;
    
    private String brojLeta;

    public String getDuzina() {
        return duzina;
    }

    public void setDuzina(String duzina) {
        this.duzina = duzina;
    }

    public String getBrzina() {
        return brzina;
    }

    public void setBrzina(String brzina) {
        this.brzina = brzina;
    }

    public double getPreostalo() {
        return preostalo;
    }

    public void setPreostalo(double preostalo) {
        this.preostalo = preostalo;
    }

    public RegistracijaBean getFirstBean() {
        return firstBean;
    }

    public void setFirstBean(RegistracijaBean firstBean) {
        this.firstBean = firstBean;
    }

    public String getBrojLeta() {
        return brojLeta;
    }

    public void setBrojLeta(String brojLeta) {
        this.brojLeta = brojLeta;
    }
      

  
    
      
    
      
    public String getTitle() {
        return title;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }
  
   
    
    public String getTitle1() {
        return title;
    }
  
    public void setTitle1(String title) {
        this.title = title;
    }
    
    public void addAzuriranje(){
        //treba da ubacim u Tabelu sa nekom metodom cadastrar
        
       
        
        AzuriranjeDAO inserir = new AzuriranjeDAOImpl();
        Azuriranje usuario = new Azuriranje();
        double v1 = Double.parseDouble(brzina);
        double v2 = Double.parseDouble(duzina);
        usuario.setBrzina(v1);
        usuario.setDuzina(v2);
        
        String brL = firstBean.getBrojLeta();
        if (brL == null) {

            //  return "Error.xhtml?faces-redirect=true";
        } else {
        usuario.setBrojLeta(brL);
        }
        
        double pom=v2/v1;
        usuario.setPreostaloVreme(pom);
        
                

        inserir.persist(usuario);
        
       // return "/pilot/aktuelniAzuriraj.xhtml?faces-redirect=true";
        
        //return "/airline/porukaSuccess.xhtml?faces-redirect=true";
    
        
        
        
        //zatim treba da promenim za taj odgovarajuci let koje je ocekivano vreme u tabeli Flight
        //i treba da postavim taj marker da ne moze vise da se klikne na njega
        
    }
}
