package pojo;
// Generated Aug 20, 2017 3:14:27 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Proizvodjac generated by hbm2java
 */
@Entity
@Table(name="Proizvodjac"
    ,catalog="let1"
)
public class Proizvodjac  implements java.io.Serializable {


     private Integer id;
     private String ime;
     private String grad;
     private String zemlja;

    public Proizvodjac() {
    }

    public Proizvodjac(String ime, String grad, String zemlja) {
       this.ime = ime;
       this.grad = grad;
       this.zemlja = zemlja;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Ime", length=45)
    public String getIme() {
        return this.ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }

    
    @Column(name="Grad", length=45)
    public String getGrad() {
        return this.grad;
    }
    
    public void setGrad(String grad) {
        this.grad = grad;
    }

    
    @Column(name="Zemlja", length=45)
    public String getZemlja() {
        return this.zemlja;
    }
    
    public void setZemlja(String zemlja) {
        this.zemlja = zemlja;
    }




}

