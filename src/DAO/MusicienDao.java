
package DAO;

import MODEL.Musicien;
import java.util.ArrayList;


public interface MusicienDao {
    void deleteMusicien(String ident) throws DAO.DaoException;

    void insertMusicien(Musicien mu) throws DAO.DaoException;

    ArrayList selectMusicien() throws DAO.DaoException;

    void updateMusicien(Musicien mu) throws DAO.DaoException;
    Musicien getMusicien(String id);
}
