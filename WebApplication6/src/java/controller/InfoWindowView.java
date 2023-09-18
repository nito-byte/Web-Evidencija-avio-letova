package controller;

import com.flight.pretraga.AddGoogleMapDAO;
import com.flight.pretraga.AddGoogleMapDAOImpl;
import com.proveri.jsf.naslovna.RegistracijaBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;
import pojo.RadarCentar;


@ManagedBean(name = "infoWindowView")
@ViewScoped
public class InfoWindowView implements Serializable {

    private List<Marker> mm = new ArrayList<Marker>();

    //private MapModel advancedModel;
    private List<MapModel> advancedModel;
    private MapModel selectedMapModel;

    public List<MapModel> getAdvancedModel() {
        return advancedModel;
    }

    public void setAdvancedModel(List<MapModel> advancedModel) {
        this.advancedModel = advancedModel;
    }

    public MapModel getSelectedMapModel() {

        init();
        return selectedMapModel;
    }

    public void setSelectedMapModel(MapModel selectedMapModel) {
        this.selectedMapModel = selectedMapModel;
    }

//    public List<Flight> getLetoviRadnik() {
//        return letoviRadnik;
//    }
//    public void setLetoviRadnik(List<Flight> letoviRadnik) {
//        this.letoviRadnik = letoviRadnik;
//    }
    private Marker marker;

//    @ManagedProperty(value = "#{registracijaBean}")
//    List<Flight> letoviRadnik ;
    @ManagedProperty(value = "#{registracijaBean}")
    RegistracijaBean firstBean;

    public RegistracijaBean getFirstBean() {
        return firstBean;
    }

    public void setFirstBean(RegistracijaBean firstBean) {
        this.firstBean = firstBean;
    }

    @PostConstruct
    public void init() {

        //advancedModel = new DefaultMapModel();
        advancedModel = new LinkedList<MapModel>();

       // int i=letoviRadnik.size();
        // for(int j=0; j<i;j++){
        AddGoogleMapDAO inserir = new AddGoogleMapDAOImpl();
        List<RadarCentar> usuario = new ArrayList<RadarCentar>();

        // String pom= new String();
        if(firstBean.selectedFlight1!=null)
        usuario = inserir.getBrojLeta(firstBean.selectedFlight1.getBrojLeta());
        else{usuario=inserir.getBrojLeta(firstBean.getBrojLeta());}
        if (usuario == null) {

            //  return "Error.xhtml?faces-redirect=true";
        } else {
            //znaci postoji taj clan u posadi
            //treba da dohvatim 
            List<Marker> f1 = new ArrayList<Marker>();
            Polyline polyline = new Polyline();
            
            int x=0;
            for (RadarCentar p : usuario) {
                //idem do tabele Flights i trazim let sa istim brojem leta 
                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
                //odgovarajuci

                double a = p.getLat();
                double b = p.getLng();
                String c = p.getNaziv();
                
                

                LatLng l = new LatLng(a, b);
                polyline.getPaths().add(l);
                if(x==0){
                    Marker m = new Marker(l, c,"http://maps.google.com/mapfiles/marker_grey.png");
                    m.setClickable(false);
                  //  m.setIcon("http://maps.google.com/mapfiles/ms/icons/green-dot.png");
                }if(x==usuario.size()){
                    Marker m = new Marker(l, c);
                   m.setIcon("http://maps.google.com/mapfiles/ms/icons/green-dot.png");
                }else{
                Marker m = new Marker(l, c);
                if (m != null) {
                    f1.add(m);
                }}x++;

            }
            //sad bi u mm trebala da mi se nalazi lista svih Markera.
            mm = f1;

      //  }
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);
          
        

        MapModel pom = new DefaultMapModel();
        // advancedModel = new DefaultMapModel();
        for (Marker p : mm) {
            pom.addOverlay(p);
            pom.addOverlay(polyline);
        }
        selectedMapModel = pom;
        advancedModel.add(pom);

          }
    }

    
    
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    
//    public MapModel getAdvancedModel() {
//        //return advancedModel;
//    }
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        //LatLng m=marker.getLatlng();
       // if(m.length() >2) marker.setClickable(false);
       
    }

    public Marker getMarker() {
        return marker;
    }

    public List<Marker> getMm() {
        return mm;
    }

    public void setMm(List<Marker> mm) {
        this.mm = mm;
    }
}
//
//
//  public void init() {
//        
//        //advancedModel = new DefaultMapModel();
//        advancedModel=new LinkedList<MapModel>();
//        
//        int i=letoviRadnik.size();
//        for(int j=0; j<i;j++){
//
//        AddGoogleMapDAO inserir = new AddGoogleMapDAOImpl();
//        List<RadarCentar> usuario = new ArrayList<RadarCentar>();
//
//        // String pom= new String();
//        usuario = inserir.getBrojLeta(firstBean.selectedFlight1.getBrojLeta());
//        if (usuario == null) {
//
//            //  return "Error.xhtml?faces-redirect=true";
//        } else {
//            //znaci postoji taj clan u posadi
//            //treba da dohvatim 
//            List<Marker> f1 = new ArrayList<Marker>();
//
//            for (RadarCentar p : usuario) {
//                //idem do tabele Flights i trazim let sa istim brojem leta 
//                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
//                //odgovarajuci
//
//                double a = p.getLat();
//                double b = p.getLng();
//                String c = p.getNaziv();
//
//                LatLng l = new LatLng(a, b);
//                Marker m = new Marker(l, c);
//                if (m != null) {
//                    f1.add(m);
//                }
//
//            }
//            //sad bi u mm trebala da mi se nalazi lista svih Markera.
//            mm = f1;
//
//        }
//        MapModel pom=new DefaultMapModel();
//       // advancedModel = new DefaultMapModel();
//            for (Marker p : mm) {
//                pom.addOverlay(p);
//            }
//            selectedMapModel=pom;
//            advancedModel.add(pom);
//
//    }
