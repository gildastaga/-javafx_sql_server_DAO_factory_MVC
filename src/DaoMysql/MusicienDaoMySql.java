
package DaoMysql;

import DAO.DaoFactory;
import DAO.DaoUtil;
import MODEL.Musicien;
import  DAO.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.MusicienDao;
import MODEL.Chanteur;
import java.sql.Date;


public class MusicienDaoMySql implements MusicienDao{
    
    private final DaoFactory daoFactory;
    private String my_select_all_musicien="SELECT m.id, m.nom, m.prenom, m.sexe, m.ddn FROM musicien m ";
    private static final String Sql_Select_All = "SELECT DISTINCT e.id ,e.nom,e.prenom,e.sexe,e.ddn FROM musicien e";
    
    private String select_musicien="SELECT  m.id,m.nom, m.prenom, m.sexe, m.ddn FROM musicien m where m.id = ?";
  
    public MusicienDaoMySql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void deleteMusicien(String ident) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertMusicien(Musicien pr) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList selectMusicien() throws DaoException {
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList <Musicien> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, Sql_Select_All, false, (Object[])null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                  Musicien a = new Musicien(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getDate(5));
                myList.add(a);
            }
           
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public void updateMusicien(Musicien pro) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Musicien getMusicien(String id) {
         Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        Musicien myList = new Musicien();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, select_musicien, false, id);
            resu = prepStat.executeQuery();
            while (resu.next())
            { 
                //creation de l'objet 
                myList = new Musicien(resu.getInt(1),resu.getString(2),resu.getString(3),resu.getString(4), resu.getDate(5));
             }
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
            
        return myList;
    }
    
    
 
}
