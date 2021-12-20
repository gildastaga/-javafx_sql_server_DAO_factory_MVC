package DaoMysql;

import DAO.DaoFactory;
import DAO.DaoUtil;
import MODEL.Album;
import DAO.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.AlbumDao;
import MODEL.Chanteur;
import java.sql.Date;

public class AlbumDaoMySql implements AlbumDao {

    //private String my_select_Album="SELECT j.id, j.code, j.titre, j.datedesortie, c.id, c.nom, c.prenom, c.sexe, c.ddn FROM album j, chanteurs c where j.idchanteur = c.id ";
    // private String select_Album="SELECT  j.code, j.titre, j.datedesortie, c.id, c.nom, c.prenom, c.sexe, c.ddn FROM album j, chanteurs c where j.idchanteur = c.id where j.id = ?";
    private String select_Albu = "SELECT  j.id,j.code, j.titre, j.datedesortie, j.idchanteur  FROM album j where j.id = ?";
    private String select_check = "SELECT * FROM album  where  code =? and titre =? and datedesortie =? and  idchanteur =?";
    private String my_select_Albums = "SELECT j.id, j.code, j.titre, j.datedesortie, j.idchanteur FROM album j";
    private static final String SQL_UPDATE = "Update album set code = ?, titre = ? , datedesortie = ?,  idchanteur = ? where id = ?";
    private static final String SQL_DELETE = "delete from album where Id = ?";
    private static final String SQL_INSERT = "Insert into album  (id, code, titre, datedesortie, idchanteur) values (?,?, ?, ?, ?)";
    private static final String SQL_SELECT_recherche ="j.id,j.code, j.titre, j.datedesortie,  e.id ,e.nom,e.prenom,e.sexe,e.ddn  "
            + "from album j, chanteur e where j.idchanteur = e.idand j.TitreA like '%?%'";

    private final DaoFactory daoFactory;

    private final ChanteurDaoMySql chanteurdao;

    public AlbumDaoMySql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
        chanteurdao = new ChanteurDaoMySql(daoFactory);
    }

    @Override
    public void deleteAlbum(String id) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DELETE, false, id);
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public void insertAlbum(Album album) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, select_check, false,  album.getCode(), album.getTitre(), album.getDate(), album.getChanteur().getId());
            resu = prepStat.executeQuery();
            ArrayList<Album> myList = new ArrayList();
            while (resu.next()) {
                myList.add(new Album(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getDate(4), chanteurdao.getChanteur(resu.getString(5))));
                // new Chanteur(resu.getInt(5), resu.getString(6), resu.getString(7),resu.getString(8),resu.getDate(9))));
            }
             
            if (!myList.isEmpty()) {
                System.out.println(myList.get(0)+"  existe deja");
            } else {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false, album.getId(), album.getCode(), album.getTitre(), album.getDate(), album.getChanteur().getId());
                prepStat.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public ArrayList selectAlbum() throws DaoException {

        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Album> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, my_select_Albums, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet Album  
               // if(resu.getInt(1)>15)
                  //      deleteAlbum(resu.getInt(1)+"");
                myList.add(new Album(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getDate(4), chanteurdao.getChanteur(resu.getString(5))));
                // new Chanteur(resu.getInt(5), resu.getString(6), resu.getString(7),resu.getString(8),resu.getDate(9))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return myList;
    }

    @Override
    public void updateAlbum(Album album) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();
            System.out.println(album.getCode() + " " + album.getTitre() + " " + album.getDate() + " " + album.getChanteur().getId() + " " + album.getId());
            /*prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false, album.getCode(), album.getTitre(), album.getDate(), album.getChanteur().getId(), album.getId());
            prepStat.executeUpdate();*/
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false, album.getCode(), album.getTitre(), album.getDate(), album.getChanteur().getId(), album.getId());
            int resu = prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public Album getAlbum(String id) {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        Album album = new Album();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, select_Albu, false, id);
            resu = prepStat.executeQuery();

            while (resu.next()) {
                //creation de l'objet Album 
                album = new Album(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getDate(4), chanteurdao.getChanteur(resu.getString(5)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return album;
    }

    Album getDateMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
