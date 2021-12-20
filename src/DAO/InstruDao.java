
package DAO;

import MODEL.Instru;
import java.util.ArrayList;


public interface InstruDao {
    void deleteInstru(String id) throws DAO.DaoException;

    void insertInstru(Instru i) throws DAO.DaoException;

    ArrayList selectInstru() throws DAO.DaoException;

    void updateInstru(Instru i) throws DAO.DaoException;
    
    Instru getInstru(String id);
    
}
