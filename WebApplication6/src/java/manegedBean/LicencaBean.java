package manegedBean;

import com.proveri.jsf.naslovna.*;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

@ManagedBean(name = "LicencaBean")
@SessionScoped
public class LicencaBean {

    private String username;
     private String licenca;
     private String name;
     private String surname;
     private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    

    public String cadastrar() {
        LicencaDAO inserir = new LicencaDAOImpl();
        Licenca usuario = new Licenca();
        usuario.setName(name);
        usuario.setSurname(surname);
        usuario.setEmail(email);
        usuario.setUsername(username);
       

        inserir.persist(usuario);
        clear();
        return "/administrator/addLicenca.xhtml?faces-redirect=true";

    }
    
    public String addLicenca() {
        LicencaDAO inserir = new LicencaDAOImpl();
        Licenca usuario = new Licenca();
        usuario.setName(name);
        usuario.setSurname(surname);
        usuario.setEmail(email);
        usuario.setLicenca(licenca);
        usuario.setUsername(username);
       

        inserir.merge(usuario);
        clear();
        return "/administrator/addLicenca.xhtml?faces-redirect=true";

    }

//    public String promenaLozinke() {
//        LicencaDAO inserir = new LicencaDAOImpl();
//        User usuario = new User();
//
//        usuario = inserir.getWithUsername(username, password);
//        if (usuario == null) {
//            clear();
//            return "/naslovna/lozinkaError.xhtml?faces-redirect=true";
//        } else {
//            usuario.setPassword(password1);
//            inserir.merge(usuario);
//            clear();
//            return "/naslovna/naslovnaStrana.xhtml?faces-redirect=true";
//        }
//    }
//        
//        
//        
//        
//
//    public String prijavi(){
//        LicencaDAO inserir = new LicencaDAOImpl();
//        User usuario = new User();
//
//        usuario = inserir.getWithUsername(username, password);
//        if (usuario == null) {
//            clear();
//            return "/prijava/prijavaError.xhtml?faces-redirect=true";
//        } else {
//
//            String pom = usuario.getTipKorisnika();
//            if (pom.equals("stujardesa") ){
//                clear();
//                return "/stujardesa/linkovi.xhtml?faces-redirect=true";
//            }
//            
//            if (pom.equals("admin") ){
//                clear();
//                return "/administrator/linkovi.xhtml?faces-redirect=true";
//            }
//            
//            if (pom.equals("pilot") ){
//                clear();
//                return "/pilot/linkovi.xhtml?faces-redirect=true";
//            }
//            
//            if (pom.equals("radnik") ){
//                clear();
//                return "/radnik/linkovi.xhtml?faces-redirect=true";
//            }
//            return "/naslovna/naslovnaStrana.xhtml?faces-redirect=true";
//        }
//    }

    

    public String logar() {
        return "/registrovano.xhtml?faces-redirect=true";
    }

    public void clear() {
        name = "";
        email = "";
        username = "";
        surname = "";
        licenca = "";
        
    }

}
