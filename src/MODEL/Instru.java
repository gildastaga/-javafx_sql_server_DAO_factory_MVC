package MODEL;


public class Instru  {

    private String identI;
    private String nomI;
    

    public Instru() {
    }
   

    public Instru(String id, String nom) {
        this(nom);
        this.identI = id;
    }

    public Instru( String nom) {
        this.nomI = nom;
        
    }
   
    public String getId() {
        return identI;
    }

    public String getNom() {
        return nomI;
    }   

    public void setId(String Id) {
        this.identI = Id;
    }

    public void setNom(String s) {
        this.nomI = s;
    }

    @Override
    public String toString() {
        return  nomI ;
    }
    
    
}
