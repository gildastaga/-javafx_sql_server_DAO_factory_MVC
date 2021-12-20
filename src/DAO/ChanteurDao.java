package DAO;

import MODEL.Album;
import MODEL.Chanteur;
import java.util.ArrayList;


public interface ChanteurDao {

    void deleteChanteur(int ident) throws DAO.DaoException;

    void insertChanteur(Chanteur p) throws DAO.DaoException;

    ArrayList selectChanteur() throws DAO.DaoException;

    ArrayList selectChanteurparAlbum(Album al) throws DAO.DaoException;

    void updateChanteur(Chanteur p) throws DAO.DaoException;
    Chanteur getChanteur(String id);
}
