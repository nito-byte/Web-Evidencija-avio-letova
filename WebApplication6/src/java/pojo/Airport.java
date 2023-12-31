package pojo;
// Generated Aug 20, 2017 11:14:07 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Airport generated by hbm2java
 */
@Entity
@Table(name="Airport"
    ,catalog="let1"
)
public class Airport  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String code;
     private String city;
     private String country;
     private Integer brojPisti;

    public Airport() {
    }

    public Airport(String name, String code, String city, String country, Integer brojPisti) {
       this.name = name;
       this.code = code;
       this.city = city;
       this.country = country;
       this.brojPisti = brojPisti;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Name", length=150)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="Code", length=3)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="City", length=35)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="Country", length=35)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="BrojPisti")
    public Integer getBrojPisti() {
        return this.brojPisti;
    }
    
    public void setBrojPisti(Integer brojPisti) {
        this.brojPisti = brojPisti;
    }




}


