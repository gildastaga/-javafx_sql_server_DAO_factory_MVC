
package MODEL;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Chanteur {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private Date ddn;
    private List<Album >listAlbum;
    
    public Chanteur(){}
    
    public Chanteur(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.prenom=" ";
    }
    

    public Chanteur(int Id, String nom, String prenom, String sexe, Date date) {
        this.id = Id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.ddn = date;
        this.listAlbum = new ArrayList();
    }
    public Chanteur( String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.ddn = ddn;
        this.listAlbum = listAlbum;
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDdn() {
        return ddn;
    }

  

    public List<Album> getListAlbum() {
        return listAlbum != null ? listAlbum : null;
    }

    public void setIdemp(int Id) {
        this.id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDdn(Date date) {
        this.ddn = date;
    }


    public void setListAlbum(List<Album> list) {
        this.listAlbum = list;
    }

    @Override
    public String toString() {
        return   nom+" "+prenom ;
    }
    
}
