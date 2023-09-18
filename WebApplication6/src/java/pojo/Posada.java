package pojo;
// Generated Aug 25, 2017 8:15:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Posada generated by hbm2java
 */
@Entity
@Table(name="Posada"
    ,catalog="let1"
)
public class Posada  implements java.io.Serializable {


     private Integer id;
     private String p1;
     private String p2;
     private String s1;
     private String s2;
     private String s3;
     private String s4;
     private String s5;
     private String brojLeta;

    public Posada() {
    }

    public Posada(String p1, String p2, String s1, String s2, String s3, String s4, String s5, String brojLeta) {
       this.p1 = p1;
       this.p2 = p2;
       this.s1 = s1;
       this.s2 = s2;
       this.s3 = s3;
       this.s4 = s4;
       this.s5 = s5;
       this.brojLeta = brojLeta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="p1", length=45)
    public String getP1() {
        return this.p1;
    }
    
    public void setP1(String p1) {
        this.p1 = p1;
    }

    
    @Column(name="p2", length=45)
    public String getP2() {
        return this.p2;
    }
    
    public void setP2(String p2) {
        this.p2 = p2;
    }

    
    @Column(name="s1", length=45)
    public String getS1() {
        return this.s1;
    }
    
    public void setS1(String s1) {
        this.s1 = s1;
    }

    
    @Column(name="s2", length=45)
    public String getS2() {
        return this.s2;
    }
    
    public void setS2(String s2) {
        this.s2 = s2;
    }

    
    @Column(name="s3", length=45)
    public String getS3() {
        return this.s3;
    }
    
    public void setS3(String s3) {
        this.s3 = s3;
    }

    
    @Column(name="s4", length=45)
    public String getS4() {
        return this.s4;
    }
    
    public void setS4(String s4) {
        this.s4 = s4;
    }

    
    @Column(name="s5", length=45)
    public String getS5() {
        return this.s5;
    }
    
    public void setS5(String s5) {
        this.s5 = s5;
    }

    
    @Column(name="BrojLeta", length=45)
    public String getBrojLeta() {
        return this.brojLeta;
    }
    
    public void setBrojLeta(String brojLeta) {
        this.brojLeta = brojLeta;
    }




}


