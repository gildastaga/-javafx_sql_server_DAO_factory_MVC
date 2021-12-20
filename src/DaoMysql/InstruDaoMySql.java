
package DaoMysql;

import DAO.DaoFactory;
import DAO.DaoUtil;
import DAO.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.InstruDao;
import MODEL.Instru;


public class InstruDaoMySql implements InstruDao{
    
    private final DaoFactory daoFactory;
    private String my_select_all_instru="SELECT v.id , v.nom FROM instru v";
    private String my_select_instru="SELECT  v.nom FROM instru v where v.id = ?";

    public InstruDaoMySql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void deleteInstru(String idVille) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertInstru(Instru ins) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList selectInstru() throws DaoException {
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList <Instru> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, my_select_all_instru, false, (Object[])null);
            resu = prepStat.executeQuery();
            System.out.println(resu);
            while (resu.next())
            { 
                //creation de l'obje vil
                myList.add(new Instru(resu.getString(1),resu.getString(2)));
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
    public void updateInstru(Instru inst) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Instru getInstru(String id) {
       Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
       Instru myList = new Instru();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, my_select_instru, false,id);
            resu = prepStat.executeQuery();
            while (resu.next())
            { 
                //creation de l'obje 
                myList= new Instru(id,resu.getString(1));
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
