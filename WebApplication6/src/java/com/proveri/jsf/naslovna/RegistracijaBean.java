package com.proveri.jsf.naslovna;

import com.flight.pretraga.AddGoogleMapDAO;
import com.flight.pretraga.AddGoogleMapDAOImpl;
import com.flight.pretraga.FlightDAO;
import com.flight.pretraga.FlightDAOImpl;
import controller.NewAirlineDAO;
import controller.NewAirlineDAOImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import manegedBean.LicencaDAO;
import manegedBean.LicencaDAOImpl;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import pojo.*;
import posada.PosadaDAO;
import posada.PosadaDAOImpl;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "registracijaBean")
@SessionScoped
public class RegistracijaBean {

    private String name;
    private String surname;
    private Date birthDay;
    private String email;

    private String username;
    private String password;
    private String password1;
    private String pol, p1, status;
    private String airline;
    private String airlineRadnik;
    private String licenca;
    //  public static String lic;

    private String tipKorisnika;

    //ovo pogledaj
    private String brojLeta;

    private User user1 = new User();
    private List<Flight> f = new ArrayList<Flight>();
    private List<String> s = new ArrayList<String>();
    private List<Airline> lstAirline = new ArrayList<Airline>();
    private List<Airline> lstPromeniAirline = new ArrayList<Airline>();

    private List<Flight> letoviRadnik = new ArrayList<Flight>();
    private List<Flight> letoviPilot = new ArrayList<Flight>();

    private Flight selectedFlight;
    public Flight selectedFlight1;
    public Flight selectedFlight2;
    private MapModel advancedModel;
    private Marker marker;

    private void konvertuj(List<Flight> f) {
        for (Flight f1 : f) {
            s.add(f1.getBrojLeta());

        }
    }

    public List<Flight> getLetoviRadnik() {
        return letoviRadnik;
    }

    public void setLetoviRadnik(List<Flight> letoviRadnik) {
        this.letoviRadnik = letoviRadnik;
    }

    public List<Flight> getLetoviPilot() {
        return letoviPilot;
    }

    public void setLetoviPilot(List<Flight> letoviPilot) {
        this.letoviPilot = letoviPilot;
    }

    public String postavi() {

        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User user = new User();
        user = user1;
        user.setLicenca(licenca);
        inserir.merge(user);

        //dohvati dva karaktera iz licence i u tabelu Licence stavi
        String pp = licenca.substring(0, 2);
        LicencaDAO dao = new LicencaDAOImpl();
        Licenca ll = new Licenca();
        ll.setEmail(user1.getEmail());
        ll.setLicenca(pp);
        ll.setName(user1.getName());
        ll.setSurname(user1.getSurname());
        ll.setUsername(user1.getUsername());
        dao.merge(ll);

        return "/pilot/linkovi.xhtml?faces-redirect=true";
    }

    public String cadastrar() {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User usuario = new User();
        usuario.setName(name);
        usuario.setSurname(surname);
        usuario.setEmail(email);
        usuario.setBirthDay(new java.sql.Date(birthDay.getTime()));
        usuario.setPassword(password);
        usuario.setUsername(username);
        usuario.setTipKorisnika(tipKorisnika);
        usuario.setPol(pol);
        usuario.setAirline(airline);
        usuario.setPrihvacenZahtev("false");

        inserir.persist(usuario);
        clear();
        return "/naslovna/registrovano.xhtml?faces-redirect=true";

    }

    public String promenaLozinke() {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User usuario = new User();

        usuario = inserir.getWithUsername(username, password);
        if (usuario == null) {
            clear();
            return "/naslovna/lozinkaError.xhtml?faces-redirect=true";
        } else {
            usuario.setPassword(password1);
            inserir.merge(usuario);
            clear();
            return "/naslovna/naslovnaStrana.xhtml?faces-redirect=true";
        }
    }

    public String prijavi() {

        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User usuario = new User();

        usuario = inserir.getWithUsername(username, password);

        if (usuario != null) {
            airlineRadnik = usuario.getAirline(); //potrebno za dohvatanje airline od radnika
        }

        user1 = usuario;
        if (usuario == null) {
            clear();
            return "/prijava/prijavaError.xhtml?faces-redirect=true";
        } else {

            NewAirlineDAO a = new NewAirlineDAOImpl();
            lstAirline = a.findAll();
            lstPromeniAirline = a.findAllAirline(usuario.getAirline());

            String pom = usuario.getTipKorisnika();
            if (pom.equals("stujardesa")) {
                // clear();
                return "/stujardesa/linkovi.xhtml?faces-redirect=true";
            }

            if (pom.equals("admin")) {
                //  clear();
                return "/administrator/linkovi.xhtml?faces-redirect=true";
            }

            if (pom.equals("pilot")) {
                // clear();
                String p = usuario.getLicenca();
                if (p == null) {
                    return "/pilot/lozinka.xhtml?faces-redirect=true";
                } else {
                    return "/pilot/linkovi.xhtml?faces-redirect=true";
                }
            }

            if (pom.equals("radnik")) {
                //  clear();
                return "/radnik/linkovi.xhtml?faces-redirect=true";
            }
            return "/naslovna/naslovnaStrana.xhtml?faces-redirect=true";
        }
    }

    public String logar() {
        return "/registrovano.xhtml?faces-redirect=true";
    }

    public void clear() {
        name = "";
        email = "";
        username = "";
        password = "";
        password1 = "";
        pol = "";
        airline = "";
        tipKorisnika = "";
        birthDay = null;
    }

    public String editAirline() {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User user = new User();
        user = user1;
        user.setAirline(airline);
        inserir.merge(user);

        NewAirlineDAO a = new NewAirlineDAOImpl();
        lstPromeniAirline = a.findAllAirline(user.getAirline());

        return "/stujardesa/linkovi.xhtml?faces-redirect=true";
    }

    public String editAirline1() {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User user = new User();
        user = user1;
        user.setAirline(airline);
        inserir.merge(user);

        NewAirlineDAO a = new NewAirlineDAOImpl();
        lstPromeniAirline = a.findAllAirline(user.getAirline());

        return "/pilot/linkovi.xhtml?faces-redirect=true";
    }

    //******* pilot: azuriraj status leta *********
    public String promeniStatus() {

        int i = Integer.parseInt(p1);
        FlightDAO inserir = new FlightDAOImpl();
        Flight f1 = (Flight) f.get(i);
        
        
        if (status.equals("prinudno")) {
            brojLeta = f1.getBrojLeta();

            letoviPilot.clear();
            return aktuelniP();
        }
        
        if (status.equals("sleteo")) {
            brojLeta = f1.getBrojLeta();

            letoviPilot.clear();
            return aktuelniV();
        }
        

        if (status.equals("izmene")) {
            brojLeta = f1.getBrojLeta();

            letoviPilot.clear();
            return aktuelniA();
        }

        //dodaj ocde da postavis na bas trazeni status
        //samo napraviti jedno novo polje izmena i  staviti ga na true
        //i zapamtiti u tabrli Flight
        // i postavi ovo tamo u trazenjima da nije izmenau Flight
        f1.setStatus(status);
        inserir.merge(f1);

        //onda treba da postavim i vreme stetanja u Flightu na sadasnje
        if (status.equals("sleteo")) {
            Date d = new Date();
            f1.setVremeSletanja(d);
            inserir.merge(f1);
        }

        //f1.setIzmena(true);
        //inserir.persist(f1);
        return "/pilot/azurirajLet.xhtml";

    }

    private String prinudno;

    public String getPrinudno() {
        return prinudno;
    }

    public void setPrinudno(String prinudno) {
        this.prinudno = prinudno;
    }
    
    
    public String promeniNajbliziAerodrom() {

        int i = Integer.parseInt(p1);
        FlightDAO inserir = new FlightDAOImpl();
        Flight f1 = (Flight) f.get(i);
        
        
        
        

       

        //dodaj ocde da postavis na bas trazeni status
        //samo napraviti jedno novo polje izmena i  staviti ga na true
        //i zapamtiti u tabrli Flight
        // i postavi ovo tamo u trazenjima da nije izmenau Flight
        //f1.setIzmena(name);
        f1.setStatus(status);
        f1.setNajblizi(prinudno);
        inserir.merge(f1);

       

       
        return "/pilot/azurirajLet.xhtml";

    }
    
    public String azurirajLet() {
        PosadaDAO inserir = new PosadaDAOImpl();
        FlightDAO fl = new FlightDAOImpl();
        List<Posada> usuario = new ArrayList<Posada>();

        String pom = new String();

        usuario = inserir.getWithUsernamePilot(username);
        if (usuario == null) {
            clear();
            return "Error.xhtml?faces-redirect=true";
        } else {
            //znaci postoji taj clan u posadi
            //treba da dohvatim 
            List<Flight> f1 = new ArrayList<Flight>();
            for (Posada p : usuario) {
                //idem do tabele Flights i trazim let sa istim brojem leta 
                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
                //odgovarajuci

                pom = p.getBrojLeta();
                Flight q = new Flight();
                if (pom != null) {
                    q = fl.findLet(pom);
                    if (q != null) {
                        f1.add(q);
                    }

                }

            }
            konvertuj(f1);
            f = f1;
            return "/pilot/azurirajLet.xhtml?faces-redirect=true";

        }
        
    }
    
    
    public String aktuelniV() {

    //    FlightDAO dao = new FlightDAOImpl();
     //   letoviPilot.add(dao.findPilotAktuelni(brojLeta));

        return "/pilot/sleteo.xhtml?faces-redirect=true";
    }
    

    public String aktuelniP() {

    //    FlightDAO dao = new FlightDAOImpl();
     //   letoviPilot.add(dao.findPilotAktuelni(brojLeta));

        return "/pilot/najbliziAerodrom.xhtml?faces-redirect=true";
    }
    
    public String aktuelniA() {

        FlightDAO dao = new FlightDAOImpl();
        letoviPilot.add(dao.findPilotAktuelni(brojLeta));

        return "/pilot/aktuelniAzuriraj.xhtml?faces-redirect=true";
    }

    //******* radnik: googleMap markeri *********
    public String aktuelniR() {

        //prvo cu da dohvatim listu Flightova iz te tabele koji su 
        //buduci i koji su za moju aviokompaniju
        FlightDAO dao = new FlightDAOImpl();
        letoviRadnik = dao.findRadnikAktuelni(airlineRadnik);

//        if(letoviRadnik!=null){
//            markeriLista();
//        }
        return "/radnik/pregledAktuelni.xhtml?faces-redirect=true";
    }

    //******* stujardesa: arhiva i buduci letovi *********
    public String arhivaS() {
        // prvo pretrazi tabelu posada
        PosadaDAO inserir = new PosadaDAOImpl();
        FlightDAO fl = new FlightDAOImpl();
        List<Posada> usuario = new ArrayList<Posada>();

        String pom = new String();

        usuario = inserir.getWithUsername(username);
        if (usuario == null) {
            clear();
            return "Error.xhtml?faces-redirect=true";
        } else {
            //znaci postoji taj clan u posadi
            //treba da dohvatim 
            List<Flight> f1 = new ArrayList<Flight>();
            for (Posada p : usuario) {
                //idem do tabele Flights i trazim let sa istim brojem leta 
                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
                //odgovarajuci

                pom = p.getBrojLeta();
                Flight q = new Flight();
                q = fl.findArchiveS(pom);
                if (q != null) {
                    f1.add(q);
                }

            }
            konvertuj(f1);
            f = f1;
            return "/stujardesa/arhivaLetova.xhtml?faces-redirect=true";

        }
    }

    public String buduciS() {
        // prvo pretrazi tabelu posada
        PosadaDAO inserir = new PosadaDAOImpl();
        FlightDAO fl = new FlightDAOImpl();
        List<Posada> usuario = new ArrayList<Posada>();

        String pom = new String();

        usuario = inserir.getWithUsername(username);
        if (usuario == null) {
            clear();
            return "Error.xhtml?faces-redirect=true";
        } else {
            //znaci postoji taj clan u posadi
            //treba da dohvatim 
            List<Flight> f1 = new ArrayList<Flight>();
            for (Posada p : usuario) {
                //idem do tabele Flights i trazim let sa istim brojem leta 
                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
                //odgovarajuci

                pom = p.getBrojLeta();
                Flight q = new Flight();
                q = fl.findBuduciS(pom);
                if (q != null) {
                    f1.add(q);
                }

            }
            konvertuj(f1);
            f = f1;
            return "/stujardesa/buduciLetovi.xhtml?faces-redirect=true";

        }
    }

    // ******* getteri i setteri *******
    public List<String> getS() {
        return s;
    }

    public void setS(List<String> s) {
        this.s = s;
    }

    public List<Flight> getF() {
        return f;
    }

    public void setF(List<Flight> f) {
        this.f = f;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public List<Airline> getLstAirline() {
        return lstAirline;

    }

    public void setLstAirline(List<Airline> lstAirline) {
        this.lstAirline = lstAirline;
    }

    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getBrojLeta() {
        return brojLeta;
    }

    public void setBrojLeta(String brojLeta) {
        this.brojLeta = brojLeta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public Flight getSelectedFlight1() {

        return selectedFlight1;
    }

    public void setSelectedFlight1(Flight selectedFlight1) {
        this.selectedFlight1 = selectedFlight1;
    }

    public Flight getSelectedFlight2() {

        return selectedFlight2;
    }

    public void setSelectedFlight2(Flight selectedFlight2) {
        this.selectedFlight2 = selectedFlight2;
    }

    public String getAirlineRadnik() {
        return airlineRadnik;
    }

    public void setAirlineRadnik(String airlineRadnik) {
        this.airlineRadnik = airlineRadnik;
    }

    public MapModel getAdvancedModel() {
        return advancedModel;
    }

    public void setAdvancedModel(MapModel advancedModel) {
        this.advancedModel = advancedModel;
    }

    public Marker getMarker() {
        return marker;
    }

    public List<Airline> getLstPromeniAirline() {
        return lstPromeniAirline;
    }

    public void setLstPromeniAirline(List<Airline> lstPromeniAirline) {
        this.lstPromeniAirline = lstPromeniAirline;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

}
