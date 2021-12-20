
package MODEL;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Album implements Comparable<Album> {
    private int id;
    private String code;
    private String titre ;
    private Date date_sortie;
    private Chanteur chanteur ;
    //private List<Chanteur >listPlanning;

    public Album() {
    }
    

    public Album(int id, String code, String titre, Date date_sortie,Chanteur c) {
        this.id = id;
        this.code = code;
        this.titre = titre;
        this.date_sortie = date_sortie;
        this.chanteur = c;
    }

    public Album(int i, String s) {
        this.id = i;
        this.code = s;
        this.titre = s;
        this.date_sortie = date_sortie;
    }

    public Album(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Album(int aInt, String string, String string0, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public Date getDate() {
        return date_sortie;
    }
    public String getDate_sortie() {
        String tmp;

        if (this.date_sortie == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.date_sortie);
          }
        return tmp;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public Chanteur getChanteur() {
        return chanteur;
    }

    public void setChanteur(Chanteur chanteur) {
        this.chanteur = chanteur;
    }

    public void setDate(Date date) {
        this.date_sortie = date;
    }

    @Override
    public String toString() {
        return  code ;
    }
    public String afiche() {
        return "Album{" + "id=" + id + ", code=" + code + ", titre=" + titre + ", date_sortie=" + date_sortie + ", chanteur=" + chanteur + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.code);
        hash = 43 * hash + Objects.hashCode(this.titre);
        hash = 43 * hash + Objects.hashCode(this.date_sortie);
        hash = 43 * hash + Objects.hashCode(this.chanteur);
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
        final Album other = (Album) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.date_sortie, other.date_sortie)) {
            return false;
        }
        if (!Objects.equals(this.chanteur, other.chanteur)) {
            return false;
        }
        return true;
    }   

    @Override
    public int compareTo(Album o) {
        return this.code.compareToIgnoreCase(o.code) ;
    }
    public boolean compareTo(Album o, Album b) {
        return b.code.compareToIgnoreCase(o.code)==0 && b.titre.compareToIgnoreCase(o.titre)==0 && b.date_sortie.equals(o.date_sortie) && b.chanteur.equals(o.chanteur);
    }
}
