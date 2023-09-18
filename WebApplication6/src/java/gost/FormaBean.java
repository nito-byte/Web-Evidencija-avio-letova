package gost;

import com.flight.pretraga.FlightDAO;
import com.flight.pretraga.FlightDAOImpl;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.lang.RandomStringUtils;
import org.primefaces.context.RequestContext;
import pojo.Flight;
import pojo.Rezervacija;

@ManagedBean(name = "formaBean")
@SessionScoped
public class FormaBean {

    private String ime, prezime, pasos, idCard;

    private String console;
    private String polaziste;
    private String odrediste;
    private int brOsoba = 1;
    private Date datumPolaska;
    private Date datumDolaska;
    private boolean direktanLet;
    private List<Object[]> o;
    private String p1;
    private Rezervacija r1, r2,r3,r4;

    public Rezervacija getR4() {
        return r4;
    }

    public void setR4(Rezervacija r4) {
        this.r4 = r4;
    }

    public Rezervacija getR3() {
        return r3;
    }

    public void setR3(Rezervacija r3) {
        this.r3 = r3;
    }

    private String text1, text2;
    private String t1, t2, t3, t4;
    private Date sumDate = new Date();
    Calendar c = Calendar.getInstance();

    public void ispisiDatum() throws ParseException {

        if (direktanLet && console.equals("item1")) {
            int i = Integer.parseInt(p1);
            Object[] obj = o.get(i);
            Flight f1 = (Flight) obj[0];
            Flight f2 = (Flight) obj[1];

            Calendar cal = Calendar.getInstance();
            cal.setTime(f1.getTime());
            int hours1 = cal.get(Calendar.HOUR_OF_DAY);
            int minute1 = cal.get(Calendar.MINUTE);

            Calendar cal1 = Calendar.getInstance();
            cal.setTime(f2.getTime());
            int hours2 = cal.get(Calendar.HOUR_OF_DAY);
            int minute2 = cal.get(Calendar.MINUTE);

            hours1 += hours2;
            minute1 += minute2;
            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));

            cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
            c.set(Calendar.HOUR_OF_DAY, hours1);
            c.set(Calendar.MINUTE, minute1);

            java.util.Date sumDate = c.getTime();
            System.out.println(sumDate);

            System.out.println(sumDate);
            //   String newString = new SimpleDateFormat("dd H:mm").format(sumDate);
            String newString = new SimpleDateFormat(" H:mm").format(sumDate);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", newString));
            sumDate = null;

        } else {

            int i = Integer.parseInt(p1);
            Object[] obj = o.get(i);
            Flight f1 = (Flight) obj[0];
            Flight f2 = (Flight) obj[1];

            Calendar cal = Calendar.getInstance();
            cal.setTime(f1.getTime());
            int hours1 = cal.get(Calendar.HOUR_OF_DAY);
            int minute1 = cal.get(Calendar.MINUTE);

            Calendar cal1 = Calendar.getInstance();
            cal.setTime(f2.getTime());
            int hours2 = cal.get(Calendar.HOUR_OF_DAY);
            int minute2 = cal.get(Calendar.MINUTE);

            hours1 += hours2;
            minute1 += minute2;
            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));

            cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
            c.set(Calendar.HOUR_OF_DAY, hours1);
            c.set(Calendar.MINUTE, minute1);

            java.util.Date sumDate = c.getTime();
            System.out.println(sumDate);

            System.out.println(sumDate);
            //   String newString = new SimpleDateFormat("dd H:mm").format(sumDate);
            String newString = new SimpleDateFormat(" H:mm").format(sumDate);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", newString));
            sumDate = null;
        }

    }

    // ovde dohvatam element liste i onda radim rezervaciju
    public String rezervisi() {
        
        if (direktanLet && console.equals("item1")) {

            int i = Integer.parseInt(p1);
            Object[] obj = o.get(i);
            Flight f1 = (Flight) obj[0];
            Flight f2 = (Flight) obj[1];

            r1 = new Rezervacija();
            r2 = new Rezervacija();

            r1.setBrojLeta(f1.getBrojLeta());
            r1.setOdakle(f1.getAirportFrom());
            r1.setDokle(f1.getAirportTo());

            r2.setBrojLeta(f2.getBrojLeta());
            r2.setOdakle(f2.getAirportFrom());
            r2.setDokle(f2.getAirportTo());

            return "/gost/rezervisi.hxtml";

        } if (!direktanLet && console.equals("item1")) {

            int i = Integer.parseInt(p1);
            Object[] obj = o.get(i);
            Flight f1 = (Flight) obj[0];
            Flight f2 = (Flight) obj[1];
            Flight f3=(Flight) obj[2];
            Flight f4=(Flight) obj[3];

            r1 = new Rezervacija();
            r2 = new Rezervacija();
            r3 = new Rezervacija();
            r4 = new Rezervacija();

            r1.setBrojLeta(f1.getBrojLeta());
            r1.setOdakle(f1.getAirportFrom());
            r1.setDokle(f1.getAirportTo());

            r2.setBrojLeta(f2.getBrojLeta());
            r2.setOdakle(f2.getAirportFrom());
            r2.setDokle(f2.getAirportTo());
            
            r3.setBrojLeta(f2.getBrojLeta());
            r3.setOdakle(f2.getAirportFrom());
            r3.setDokle(f2.getAirportTo());
            
            r4.setBrojLeta(f2.getBrojLeta());
            r4.setOdakle(f2.getAirportFrom());
            r4.setDokle(f2.getAirportTo());

            return "/gost/rezervisi.hxtml";
        }
        
        
        
        
        
        
        
        if (direktanLet) {

            int i = Integer.parseInt(p1);
            Flight f1 = (Flight) lst1.get(i);

            r1 = new Rezervacija();
            r2 = new Rezervacija();

            r1.setBrojLeta(f1.getBrojLeta());
            r1.setOdakle(f1.getAirportFrom());
            r1.setDokle(f1.getAirportTo());
            return "/gost/rezervisi.hxtml";

        } else {

            int i = Integer.parseInt(p1);
            Object[] obj = o.get(i);
            Flight f1 = (Flight) obj[0];
            Flight f2 = (Flight) obj[1];

            r1 = new Rezervacija();
            r2 = new Rezervacija();

            r1.setBrojLeta(f1.getBrojLeta());
            r1.setOdakle(f1.getAirportFrom());
            r1.setDokle(f1.getAirportTo());

            r2.setBrojLeta(f2.getBrojLeta());
            r2.setOdakle(f2.getAirportFrom());
            r2.setDokle(f2.getAirportTo());

            return "/gost/rezervisi.hxtml";
        }
        
        
        

    }

    public String dodajInfo() {
        if (direktanLet) {
            RezervacijaDAO rr = new RezervacijaDAOImpl();
            r1.setIme(t1);
            r1.setPrezime(t2);
            r1.setPasos(t3);
            r1.setIdCard(t4);
            rr.persist(r1);

            text1 = RandomStringUtils.randomAlphanumeric(8);
            return "/gost/rezervisano.hxtml";

        } else {
            RezervacijaDAO rr = new RezervacijaDAOImpl();
            r1.setIme(t1);
            r1.setPrezime(t2);
            r1.setPasos(t3);
            r1.setIdCard(t4);
            rr.persist(r1);

            RezervacijaDAO rr1 = new RezervacijaDAOImpl();
            r2.setIme(t1);
            r2.setPrezime(t2);
            r2.setPasos(t3);
            r2.setIdCard(t4);
            rr1.persist(r2);

            text1 = RandomStringUtils.randomAlphanumeric(8);
            return "/gost/rezervisano.hxtml";
        }
    }

    public String proveri() {
        if (text1.equals(text2)) {
            return "/gost/porukaUspesno?faces-redirect=true.hxtml";
        }
        return "/gost/forma.xhtml?faces-redirect=true";
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public Flight getF() {
        return f;
    }

    public void setF(Flight f) {
        this.f = f;
    }

    public List<Object[]> getO() {
        return o;
    }

    private Flight f = new Flight();

    public void setO(List<Object[]> o) {
        this.o = o;
    }

    Flight flight = new Flight();
    private List<Flight> lst = new ArrayList<Flight>();
    private List<Flight> lst1 = new ArrayList<Flight>();
    private List<Object> lst2 = new ArrayList<Object>();

    public List<Object> getLst2() {
        return lst2;
    }

    public void setLst2(List<Object> lst2) {
        this.lst2 = lst2;
    }

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
//        if (direktanLet) {
//            FlightDAO dao = new FlightDAOImpl();
//            lst1 = dao.findFlightsJedanSmer(polaziste, odrediste, datumPolaska);
//            return lst1;
//        }else{
//            FlightDAO dao = new FlightDAOImpl();
//            lst1 = dao.findFlightsPresedanje(polaziste, odrediste, datumPolaska);
//            return lst1;
//        }
        // direktanLet==false

//        if(console.equals("item2")){
//        FlightDAO dao = new FlightDAOImpl();
//        lst1 = dao.findFlightsDvaSmera(polaziste, odrediste, datumPolaska);
//        return lst1;
//        }
        return lst1;
    }

    public void setLst1(List<Flight> lst1) {
        this.lst1 = lst1;
    }

    public String redirect() {
        return "/gost/lista.xhtml?faces-redirect=true";
    }

    public String cadastrar() {
//        if (direktanLet) {
//            FlightDAO dao = new FlightDAOImpl();
//            lst1 = dao.findFlightsJedanSmer(polaziste, odrediste, datumPolaska);
//            
//        }

        if (console.equals("item2")) {

            if (direktanLet) {
                FlightDAO dao = new FlightDAOImpl();
                lst1 = dao.findFlightsJedanSmer(polaziste, odrediste, datumPolaska);
                return "/gost/lista2.xhtml?faces-redirect=true";

            } else {
                FlightDAO dao = new FlightDAOImpl();
                o = dao.findFlightsPresedanje(polaziste, odrediste, datumPolaska);
                return "/gost/lista1.xhtml?faces-redirect=true";
            }
        } else {
            if (direktanLet) {
                FlightDAO dao = new FlightDAOImpl();
                o = dao.findFlightsDvaSmera(polaziste, odrediste, datumPolaska,datumDolaska);
                return "/gost/lista1.xhtml?faces-redirect=true";

            } else {
                FlightDAO dao = new FlightDAOImpl();
                o = dao.findFlightsDvaSmeraNijeDir(polaziste, odrediste, datumPolaska,datumDolaska);
                return "/gost/lista1.xhtml?faces-redirect=true";
            }
        }

        }

    

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public Rezervacija getR1() {
        return r1;
    }

    public void setR1(Rezervacija r1) {
        this.r1 = r1;
    }

    public Rezervacija getR2() {
        return r2;
    }

    public void setR2(Rezervacija r2) {
        this.r2 = r2;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPolaziste() {
        return polaziste;
    }

    public void setPolaziste(String polaziste) {
        this.polaziste = polaziste;
    }

    public String getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(String odrediste) {
        this.odrediste = odrediste;
    }

    public int getBrOsoba() {
        return brOsoba;
    }

    public void setBrOsoba(int brOsoba) {
        this.brOsoba = brOsoba;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public boolean isDirektanLet() {
        return direktanLet;
    }

    public void setDirektanLet(boolean direktanLet) {
        this.direktanLet = direktanLet;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public Date getSumDate() {
        return sumDate;
    }

    public void setSumDate(Date sumDate) {
        this.sumDate = sumDate;
    }

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }

}
