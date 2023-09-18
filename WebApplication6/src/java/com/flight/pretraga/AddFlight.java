package com.flight.pretraga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import pojo.Airplane;
import pojo.Flight;
import pojo.RadarCentar;

@ManagedBean(name = "FlightBean")
@SessionScoped
public class AddFlight implements Serializable {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm";
    public static String K;
    public static String M;
    public static int ll;
    public static boolean charter_posada;
    
    

    private String brojLeta;
    private String airportFrom;
    private String airportTo;
    private String model;
    private Date start;
    private Date time;
    private String now;
    private String grad1;
    private String grad2;
    private boolean carter;

    private Date planiranoVreme;

    private Date ocekivanoVreme;

    private String avioKompanija;
    private String avioKompanija1;

    public String getAvioKompanija1() {
        return avioKompanija1;
    }

    public void setAvioKompanija1(String avioKompanija1) {
        this.avioKompanija1 = avioKompanija1;
    }
    
    

    Flight ff = new Flight();
    Airplane airplane = new Airplane();

    //**************** Google Map *******************
    private MapModel emptyModel;
    private String title;
    private double lat;
    private double lng;
    private Marker marker;
    List<Marker> lista = new ArrayList<Marker>();

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    //***********************************************
    public String cadastrar() {

        FlightDAO inserir = new FlightDAOImpl();
        Flight usuario = new Flight();
        usuario.setBrojLeta(brojLeta);
        usuario.setAirportFrom(airportFrom);
        usuario.setAirportTo(airportTo);
        usuario.setAirplane(model);
        usuario.setStart(start);
        usuario.setTime(time);
        usuario.setGrad1(grad1);
        usuario.setGrad2(grad2);

        usuario.setAvioKompanija(avioKompanija);
        K = avioKompanija;
        M = model;

        Calendar pomocna = Calendar.getInstance();
        pomocna.setTime(time);
        int hour = pomocna.get(Calendar.HOUR_OF_DAY);
        int min = pomocna.get(Calendar.MINUTE);

        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.HOUR_OF_DAY, hour);
        cal.add(Calendar.MINUTE, min);
        planiranoVreme = cal.getTime();

        usuario.setPlaniranoVreme(planiranoVreme);
        usuario.setOcekivanoVreme(planiranoVreme);

        ff.setAirportFrom(airportFrom);
        ff.setBrojLeta(brojLeta);
        ff.setAirportTo(airportTo);
        ff.setAirplane(model);
        ff.setStart(start);
        ff.setTime(time);
        ff.setAvioKompanija(avioKompanija);
        ff.setOcekivanoVreme(planiranoVreme);
        ff.setPlaniranoVreme(planiranoVreme);
        ff.setGrad1(grad1);
        ff.setGrad2(grad2);

        if (carter) {
            charter_posada=false;
            ll = 0;
            usuario.setCarter(1);
            usuario.setIznajmljeno(avioKompanija1);
            Boolean bb=inserir.persistP(usuario);
             if (bb== null) {
                    return "linkovi.xhtml?faces-redirect=true";
                }
        } else {
            charter_posada=true;
            usuario.setCarter(0);
            Boolean bbb=inserir.persistP(usuario);
             if (bbb== null) {
                    return "linkovi.xhtml?faces-redirect=true";
                }
            

            Calendar c = Calendar.getInstance();
            c.setTime(start);
            int pom = c.get(Calendar.MONTH);
            int pom1 = pom + 1;
            c.add(Calendar.DAY_OF_MONTH, 7);
            char ch = 'a';
             ll = 0;     //dodajem

            while (pom < pom1) {
                FlightDAO inseriro = new FlightDAOImpl();
                Flight usuarioo = new Flight();
                usuarioo.setBrojLeta(brojLeta+ch);
                usuarioo.setAirportFrom(airportFrom);
                usuarioo.setAirportTo(airportTo);
                usuarioo.setAirplane(model);
                usuarioo.setStart(start);
                usuarioo.setTime(time);
                usuarioo.setGrad1(grad1);
                usuarioo.setGrad2(grad2);
                usuarioo.setCarter(0);
                
                usuarioo.setAvioKompanija(avioKompanija);
                Date st = c.getTime();
                usuarioo.setStart(st);

                Calendar cc = Calendar.getInstance();
                cc.setTime(st);
                cc.add(Calendar.HOUR_OF_DAY, hour);
                cc.add(Calendar.MINUTE, min);
                planiranoVreme = cc.getTime();

                usuarioo.setPlaniranoVreme(planiranoVreme);
                usuarioo.setOcekivanoVreme(planiranoVreme);

                inserir.persist(usuarioo);
             
                c.add(Calendar.DAY_OF_MONTH, 7);
                pom = c.get(Calendar.MONTH);
                ch++;
                ll++;   //dodajem

            }
        }
        clear();

        return "/posada/addPosada.xhtml?faces-redirect=true";

    }

    public void clear() {
        airportFrom = "";
        airportTo = "";
        model = "";
        start = null;
        time = null;
    }

//    public String calculatePlaniranoVreme() {
//
//        Calendar pomocna = Calendar.getInstance();
//        pomocna.setTime(time);
//        int hour = pomocna.get(Calendar.HOUR_OF_DAY);
//        int min = pomocna.get(Calendar.MINUTE);
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(start);
//        cal.add(Calendar.HOUR_OF_DAY, hour);
//        cal.add(Calendar.MINUTE, min);
//        planiranoVreme = cal.getTime();
//        
//    
//        
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
//        return sdf.format(planiranoVreme);
//    }
    // ******************* Google Map ******************* 
    public List<Marker> getLista() {
        return lista;
    }

    public void setLista(List<Marker> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void addMarker() {
        marker = new Marker(new LatLng(lat, lng), title);
        //  emptyModel.addOverlay(marker);

        getMarkerList();
        cadastrarMarker();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }

    public void getMarkerList() {
        lista = emptyModel.getMarkers();
    }

    public void cadastrarMarker() {
        AddGoogleMapDAO inserir = new AddGoogleMapDAOImpl();
        RadarCentar usuario = new RadarCentar();

        Marker p = marker;
        usuario.setLat(p.getLatlng().getLat());
        usuario.setLng(p.getLatlng().getLng());
        usuario.setNaziv(p.getTitle());
        usuario.setLet(brojLeta);
        inserir.persist(usuario);
        
        
        
        int q=AddFlight.ll;
        char a='a';
        for(int i=0;i<q;i++){
            RadarCentar usuarioo = new RadarCentar();
        usuarioo.setLat(p.getLatlng().getLat());
        usuarioo.setLng(p.getLatlng().getLng());
        usuarioo.setNaziv(p.getTitle());
        usuarioo.setLet(brojLeta+a);
        inserir.persist(usuarioo);
        a++;
        }

    }

    //******************** getteri i setteri
    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getAvioKompanija() {
        return avioKompanija;
    }

    public void setAvioKompanija(String avioKompanija) {
        this.avioKompanija = avioKompanija;
    }

    public Date getOcekivanoVreme() {
        return ocekivanoVreme;
    }

    public void setOcekivanoVreme(Date ocekivanoVreme) {
        this.ocekivanoVreme = ocekivanoVreme;
    }

    public String getBrojLeta() {
        return brojLeta;
    }

    public void setBrojLeta(String brojLeta) {
        this.brojLeta = brojLeta;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Flight getFf() {
        return ff;
    }

    public void setFf(Flight ff) {
        this.ff = ff;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getGrad1() {
        return grad1;
    }

    public void setGrad1(String grad1) {
        this.grad1 = grad1;
    }

    public String getGrad2() {
        return grad2;
    }

    public void setGrad2(String grad2) {
        this.grad2 = grad2;
    }

    public boolean isCarter() {
        return carter;
    }

    public void setCarter(boolean carter) {
        this.carter = carter;
    }

    public Date getPlaniranoVreme() {
        return planiranoVreme;
    }

    public void setPlaniranoVreme(Date planiranoVreme) {
        this.planiranoVreme = planiranoVreme;
    }

}
