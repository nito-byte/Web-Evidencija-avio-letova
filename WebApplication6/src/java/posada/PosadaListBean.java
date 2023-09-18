package posada;

import com.flight.pretraga.AddFlight;
import com.flight.pretraga.AddGoogleMapDAO;
import com.flight.pretraga.AddGoogleMapDAOImpl;
import com.proveri.jsf.naslovna.RegistracijaDAO;
import com.proveri.jsf.naslovna.RegistracijaDAOImpl;
import manegedBean.*;
import java.io.Serializable;
import java.util.ArrayList;
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
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "PosadaListBean")
@SessionScoped
public class PosadaListBean implements Serializable {

    private List<User> lst = new ArrayList<User>();
    private List<User> lst1 = new ArrayList<User>();

    private List<String> piloti = new ArrayList<String>();
    private List<String> stujardese = new ArrayList<String>();

    private String brojLeta;
    private String kompanija;

    public List<String> getPiloti() {
        return piloti;
    }

    public void setPiloti(List<String> piloti) {
        this.piloti = piloti;
    }

    public List<String> getStujardese() {
        return stujardese;
    }

    public void setStujardese(List<String> stujardese) {
        this.stujardese = stujardese;
    }

    public String getBrojLeta() {
        return brojLeta;
    }

    public void setBrojLeta(String brojLeta) {
        this.brojLeta = brojLeta;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public void clear() {
        lst = null;
        lst1 = null;
        piloti = null;
        stujardese = null;
    }

    public List<User> getLst() {

        RegistracijaDAO dao = new RegistracijaDAOImpl();
        lst = (List<User>) dao.getStujardesa(AddFlight.K);
        return lst;
    }

    public void setLst(List<User> lst) {
        this.lst = lst;
    }

    public List<User> getLst1() {
        kompanija = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("hidd1");
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        lst = (List<User>) dao.getPilot(AddFlight.K, AddFlight.M);
        return lst;
    }

    public void setLst1(List<User> lst) {
        this.lst = lst;
    }

    public void action() {
        PosadaDAO inserir = new PosadaDAOImpl();
        Posada usuario = new Posada();

        brojLeta = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("hidden1");

        kompanija = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("hidden2");

        usuario.setP1(piloti.get(0));
        usuario.setP2(piloti.get(1));
        usuario.setS1(stujardese.get(0));
        usuario.setS2(stujardese.get(1));
        usuario.setBrojLeta(brojLeta);

        usuario.setS3(stujardese.get(2));

        if ((stujardese.size()) >= 4) {
            usuario.setS4(stujardese.get(3));
        }

        if ((stujardese.size()) == 5) {
            usuario.setS5(stujardese.get(4));
        }

        inserir.persist(usuario);

        //ako nije charter let onda treba da dodam istu posadu 
        if (AddFlight.charter_posada) {
            char ch = 'a';
            for (int i = 0; i < AddFlight.ll; i++) {
                
                PosadaDAO inserir1 = new PosadaDAOImpl();
                Posada usuario1 = new Posada();
                usuario1.setP1(piloti.get(0));
                usuario1.setP2(piloti.get(1));
                usuario1.setS1(stujardese.get(0));
                usuario1.setS2(stujardese.get(1));
                usuario1.setBrojLeta(brojLeta);
                usuario1.setBrojLeta(brojLeta + ch);

                usuario1.setS3(stujardese.get(2));

                if ((stujardese.size()) >= 4) {
                    usuario1.setS4(stujardese.get(3));
                }

                if ((stujardese.size()) == 5) {
                    usuario1.setS5(stujardese.get(4));
                }

                inserir1.persist(usuario1);
                ch++;

            }
            AddFlight.charter_posada = false;
            AddFlight.ll = 0;
        }

        clear();

    }

}
