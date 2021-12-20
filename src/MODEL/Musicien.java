
package MODEL;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Musicien {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private Date ddn;
    private List<Collobo > colloboList;
    

    public Musicien(int id, String nom, String prenom, String sexe, Date ddn, List<Collobo> intruList) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.ddn = ddn;
        this.colloboList = intruList;
    }

    public Musicien() {}

    public Musicien(int Id, String nom, String prenom, String sexe, Date date) {
        this.id = Id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;//??????
        this.ddn = date;
        this.colloboList = new ArrayList();
    }

    public Musicien(int i, String nom) {
        this.id = i;
        this.nom = nom;
        this.prenom = " ";
        this.sexe = sexe;
        this.ddn = ddn;
        
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public List<Collobo> getColloboList() {
        return colloboList;
    }

    public void setColloboList(List<Collobo> colloboList) {
        this.colloboList = colloboList;
    }

    @Override
    public String toString() {
        return  nom +" "+ prenom ;
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.nom);
        hash = 41 * hash + Objects.hashCode(this.prenom);
        hash = 41 * hash + Objects.hashCode(this.sexe);
        hash = 41 * hash + Objects.hashCode(this.ddn);
        hash = 41 * hash + Objects.hashCode(this.colloboList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musicien other = (Musicien) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.ddn, other.ddn)) {
            return false;
        }
        if (!Objects.equals(this.colloboList, other.colloboList)) {
            return false;
        }
        return true;
    }

    
    
}
