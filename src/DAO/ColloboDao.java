package DAO;

import MODEL.Instru;
import MODEL.Musicien;
import MODEL.Chanteur;
import MODEL.Album;
import MODEL.Collobo;
import java.util.ArrayList;

public interface ColloboDao {
    
    Collobo getCollobo(String id);
    void deleteCollobo(String ident) throws DAO.DaoException;

    void insertCollobo(Collobo col) throws DAO.DaoException;

    ArrayList selectCollobo() throws DAO.DaoException;

    ArrayList selectColloboParMusicien(Musicien mu) throws DAO.DaoException;

    ArrayList selectColloboParAlbum(Album al) throws DAO.DaoException;

    ArrayList selectColloboParInstru(Instru ins) throws DAO.DaoException;

    void updateCollobo(Collobo collo);

  /*  ArrayList selectDateMax() throws dao.DaoException;

    ArrayList selectDateMin() throws dao.DaoException;*/

    public ArrayList selectDateMax();

    public ArrayList selectDateMin();
}
