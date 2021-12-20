package DAO;

import dao.DaoConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

    private static final String FICHIER_PROPERTIES = "dao/config.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";
    private static final String PROPERTY_Album_Dao = "albumdao";
    private static final String PROPERTY_Chanteur_DAO  = "chanteurdao";
    private static final String PROPERTY_Instru_DAO="instrudao";
    private static final String PROPERTY_Musicien_DAO="musiciendao";
    private static final String PROPERTY_Collobo_DAO="collobodao";
    
 
    
    private String url;
    private String driver;
    private String username;
    private String password;
    private String albumdao;
    private String chanteurdao;
    private String instrudao;
    private String musiciendao;
    private String collobodao;

    /* Pattern Singleton */
    private static DaoFactory uniqueInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return uniqueInstance;
    }

    private DaoFactory() throws DaoConfigurationException {
        Properties properties = new Properties();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

        if (fichierProperties == null) {
            throw new DaoConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");
        }

        try {
            properties.load(fichierProperties);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            username = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
            password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
            this.collobodao = properties.getProperty(PROPERTY_Collobo_DAO);
            this.chanteurdao = properties.getProperty( PROPERTY_Chanteur_DAO );
            this.instrudao=properties.getProperty(PROPERTY_Instru_DAO);
            this.musiciendao=properties.getProperty(PROPERTY_Musicien_DAO);
            this.albumdao=properties.getProperty(PROPERTY_Album_Dao);
            
        } catch (IOException e) {
            throw new DaoConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DaoConfigurationException("Le driver est introuvable", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ColloboDao getDAOCollobos() {
        try {
            Class ColloboDaoClass = Class.forName(collobodao);
            Constructor[] constr = ColloboDaoClass.getConstructors();
            return (ColloboDao) constr[0].newInstance(this);

        } catch (Exception e) {
            throw new DaoConfigurationException("Probleme d'injection avec la classe collobo ", e);
        }
    }

    public ChanteurDao getDAOChanteur() {
        try {
          //  String ChanteurDao;
            Class ChanteurDaoClass = Class.forName(chanteurdao);
            System.out.println(ChanteurDaoClass);//TEST DE RESOLUTION DU PB
            Constructor[] constr = ChanteurDaoClass.getConstructors();  
            return (ChanteurDao) constr[0].newInstance(this);

        } catch (Exception e) {
            throw new DaoConfigurationException("Probleme d'injection avec la classe Chanteur", e);
        }
    }

    public InstruDao getDAOInstru() {
        try {
            Class InstruDaoClass = Class.forName(instrudao);
            Constructor[] constr = InstruDaoClass.getConstructors();
            return (InstruDao) constr[0].newInstance(this);

        } catch (Exception e) {
            throw new DaoConfigurationException("Probleme d'injection avec la classe Instru", e);
        }
    }
    
    public AlbumDao getDAOAlbum() {
        try {
            Class AlbumDaoClass = Class.forName(albumdao);
            Constructor[] constr = AlbumDaoClass.getConstructors();
            return (AlbumDao) constr[0].newInstance(this);

        } catch (Exception e) {
            throw new DaoConfigurationException("Probleme d'injection avec la classe Album", e);
        }
    }
    
    public MusicienDao getDAOMusicien() {
        try {
            Class MusicienDaoClass = Class.forName(musiciendao);
            Constructor[] constr = MusicienDaoClass.getConstructors();
            return (MusicienDao) constr[0].newInstance(this);

        } catch (Exception e) {
            throw new DaoConfigurationException("Probleme d'injection avec la classe Musicien", e);
        }
    }

}
