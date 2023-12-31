package pojo;
// Generated Sep 11, 2017 3:51:59 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Azuriranje generated by hbm2java
 */
@Entity
@Table(name="Azuriranje"
    ,catalog="let1"
)
public class Azuriranje  implements java.io.Serializable {


     private Integer id;
     private Double duzina;
     private Double brzina;
     private Double preostaloVreme;
     private String brojLeta;
     private String radar;

    public Azuriranje() {
    }

    public Azuriranje(Double duzina, Double brzina, Double preostaloVreme, String brojLeta, String radar) {
       this.duzina = duzina;
       this.brzina = brzina;
       this.preostaloVreme = preostaloVreme;
       this.brojLeta = brojLeta;
       this.radar = radar;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="duzina", precision=22, scale=0)
    public Double getDuzina() {
        return this.duzina;
    }
    
    public void setDuzina(Double duzina) {
        this.duzina = duzina;
    }

    
    @Column(name="brzina", precision=22, scale=0)
    public Double getBrzina() {
        return this.brzina;
    }
    
    public void setBrzina(Double brzina) {
        this.brzina = brzina;
    }

    
    @Column(name="preostaloVreme", precision=22, scale=0)
    public Double getPreostaloVreme() {
        return this.preostaloVreme;
    }
    
    public void setPreostaloVreme(Double preostaloVreme) {
        this.preostaloVreme = preostaloVreme;
    }

    
    @Column(name="brojLeta", length=45)
    public String getBrojLeta() {
        return this.brojLeta;
    }
    
    public void setBrojLeta(String brojLeta) {
        this.brojLeta = brojLeta;
    }

    
    @Column(name="Radar", length=45)
    public String getRadar() {
        return this.radar;
    }
    
    public void setRadar(String radar) {
        this.radar = radar;
    }




}


