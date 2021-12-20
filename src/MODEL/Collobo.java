
package MODEL;

import java.util.Objects;

public class Collobo implements Comparable<Collobo>{
     private int id;
    private Album album;
    private Musicien musicien;
    private Instru instur;

   

    public Collobo() {
    }

    public Collobo(int id ,Album album, Musicien musicien, Instru instru) {
        this.id = id;
        this.album = album;
        this.musicien = musicien;
        this.instur = instru;
    }

    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }

    public Musicien getMusicien() {
        return musicien;
    }

    public void setMusicien(Musicien musicien) {
        this.musicien = musicien;
    }

    public Instru getInstur() {
        return instur;
    }

    public void setInstur(Instru instur) {
        this.instur = instur;
    }

    public int getId() {
       return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Collobo o) {
       return this.album.getDate().compareTo(o.album.getDate());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.album);
        hash = 83 * hash + Objects.hashCode(this.musicien);
        hash = 83 * hash + Objects.hashCode(this.instur);
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
        final Collobo other = (Collobo) obj;
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.musicien, other.musicien)) {
            return false;
        }
        if (!Objects.equals(this.instur, other.instur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Collobo{" + "id=" + id + ", album=" + album + ", musicien=" + musicien + ", instur=" + instur + '}';
    }
    
    
}
