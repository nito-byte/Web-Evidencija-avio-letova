package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

//import br.com.controleFinanceiro.entidade.User;
@ManagedBean(name = "Airline")
@SessionScoped
public class AirlineBean {
    
    

    private String name;
    private String adresa;
    private String zemlja;
    private String sajt;
    private String email;
    private boolean ok;



    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getZemlja() {
        return zemlja;
    }

    public void setZemlja(String zemlja) {
        this.zemlja = zemlja;
    }

    public String getSajt() {
        return sajt;
    }

    public void setSajt(String sajt) {
        this.sajt = sajt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String cadastrar() {
        NewAirlineDAO inserir = new NewAirlineDAOImpl();
        Airline usuario = new Airline();
        
        if(inserir.getByName(name)==null){
        usuario.setName(name);
        usuario.setAdresa(adresa);
        usuario.setZemlja(zemlja);
        usuario.setEmail(email);
        usuario.setSajt(sajt);

        inserir.persist(usuario);
        clear();
        return "/airline/porukaSuccess.xhtml?faces-redirect=true";}
        else return "/airline/porukaError.xhtml?faces-redirect=true";
    }

    public String logar() {
        return "/principal.xhtml?faces-redirect=true";
    }
    
    public void clear(){
      name="";
      adresa="";
      zemlja="";
      sajt="";
      email="";
    }
            

}
