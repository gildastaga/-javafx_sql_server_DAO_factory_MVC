package DaoMysql;

import DAO.DaoFactory;
import DAO.DaoUtil;
import MODEL.Chanteur;
import MODEL.Album;
import DAO.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ChanteurDao;

public class ChanteurDaoMySql implements ChanteurDao {

    private final DaoFactory daoFactory;
    private DaoFactory factory = DaoFactory.getInstance();
   // private final AlbumDaoMySql albumdao=new AlbumDaoMySql(factory);
    private static final String Sql_Select_All = "SELECT DISTINCT e.id ,e.nom,e.prenom,e.sexe,e.ddn FROM chanteurs e";
     private static final String Sql_Select_chanteur = "SELECT DISTINCT e.nom,e.prenom,e.sexe,e.ddn FROM chanteurs e where e.id = ?";
//            "SELECT DISTINCT e.ID ,e.NomEmp,e.Prenom,e.Adress,e.Email ,v.CP, v.Commune \n"
//            + "FROM employer e  , ville v where e.ID=v.Id";
    private static final String SQL_INSERT = "Insert into chanteurs (Id, NomEmp, Prenom, Adress, Email, IdVille) values (?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "Update chanteurs set nom = ?, prenom = ? ,"
            + "sexe = ?, ddn = ?, IdVille = ? where id = ?";
    private static final String SQL_DELETE = "delete from chanteurs where id = ?";

    public ChanteurDaoMySql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void deleteChanteur(int ident) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DELETE, false, ident);
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public ArrayList selectChanteur() throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        ArrayList<Chanteur> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, Sql_Select_All, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                myList.add(new Chanteur(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getDate(5)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return myList;
    }

    @Override
    public ArrayList selectChanteurparAlbum(Album a) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertChanteur(Chanteur chanteur) throws DaoException {

        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false,
                    chanteur.getId(), chanteur.getNom(), chanteur.getPrenom(), chanteur.getSexe(), chanteur.getDdn());
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public void updateChanteur(Chanteur c) throws DaoException {

        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false,
                    c.getNom(), c.getPrenom(), c.getSexe(), c.getDdn(), c.getId());
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public  Chanteur getChanteur(String id) {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        Chanteur myList = new Chanteur();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, Sql_Select_chanteur, false, id);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                //System.out.println(resu.getString(1)+" "+ resu.getString(2)+" "+ resu.getString(3)+" "+ resu.getString(4)+" pooo");
                myList = new Chanteur(Integer.parseInt(id), resu.getString(1), resu.getString(2), resu.getString(3), resu.getDate(4));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return myList;
    }
   

}
