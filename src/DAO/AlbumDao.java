/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Album;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public interface AlbumDao {
    void deleteAlbum(String id) throws DAO.DaoException;

    void insertAlbum(Album al) throws DAO.DaoException;

    ArrayList selectAlbum() throws DAO.DaoException;

    void updateAlbum(Album al) throws DAO.DaoException;
    Album getAlbum(String id);
}
