package DaoMysql;

import DAO.DaoFactory;
import DAO.DaoUtil;
import MODEL.Instru;
import MODEL.Musicien;
import MODEL.Chanteur;
import MODEL.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ColloboDao;
import DAO.DaoException;
import MODEL.Collobo;

public class ColloboDaoMySql implements ColloboDao {

    private final DaoFactory daoFactory;
   
    private final AlbumDaoMySql albumdao;
    private final ChanteurDaoMySql chanteurdao;
    private final InstruDaoMySql instrudao;
    private final MusicienDaoMySql musiciendao;
    
    private static final String SQL_SELECT_TOUS ="SELECT c.id ,c.ida, c.idm, c.idi FROM collabo c";
     private static final String SQL_SELECT_Colla_by_id ="SELECT c.id , c.idm, c.idi FROM collabo c where c.ida = ?";
    private static final String SQL_DELETE = "delete from collabo where id =?";

    private static final String SQL_UPDATE = "Update collabo set  ida = ? ,idm = ?, idi = ? where id = ?";
     private String select_check = "SELECT * FROM collabo  where   ida =? and idm =? and  idi =?";
    private static final String SQL_INSERT = "Insert into collabo  (id, ida, idm, idi) values ( ?, ?, ?, ?)";

    private static final String SQL_SELECT_by_Album = " SELECT c.id, c.idm, c.idi FROM collabo c where c.ida = ?";

    private static final String SQL_SELECT_by_Instru =" SELECT c.id , c.ida, c.idm FROM collabo c where c.idi = ?";
    
    private static final String SQL_SELECT_by_Musicien =" SELECT c.id , c.ida,  c.idi FROM collabo c where c.idm = ?";
    
    private static final String SQL_SELECT_DATEMAX = "select  p.Id ,p.NBHeure,e.NomEmp,e.Prenom,j.date,pr.NomPro "
            + "                                             from planning p, jour j, employer e, projet pr"
            + "                                                 where p.IdEmploye = e.ID and p.idProjet= pr.Id  and p.IdJour=j.Id group by p.Id order by Date DESC";

    private static final String SQL_SELECT_DATEMIN = "select  p.Id ,p.NBHeure,e.NomEmp,e.Prenom,j.date,pr.NomPro "
            + "                                             from planning p, jour j, employer e, projet pr"
            + "                                                 where p.IdEmploye = e.ID and p.idProjet= pr.Id  and p.IdJour=j.Id group by p.Id order by date ASC";

    public ColloboDaoMySql(DaoFactory daoFactory) {
         this.daoFactory = daoFactory;
        this.albumdao = new AlbumDaoMySql(daoFactory);
        this.chanteurdao = new ChanteurDaoMySql(daoFactory);
        this.instrudao = new InstruDaoMySql(daoFactory);
        this.musiciendao = new MusicienDaoMySql(daoFactory);
       
    }

    @Override
    public void deleteCollobo(String ident) throws DaoException {
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
    public void insertCollobo(Collobo collobo) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection(); prepStat = DaoUtil.initialisationRequetePreparee(conn, select_check, false,  collobo.getAlbum().getId(), collobo.getMusicien().getId() ,Integer.parseInt(collobo.getInstur().getId()));
            resu = prepStat.executeQuery();
            ArrayList<Collobo> myList = new ArrayList();
            while (resu.next()) {
                    myList.add(new Collobo(resu.getInt(1),this.albumdao.getAlbum(resu.getString(2)),musiciendao.getMusicien(resu.getString(3)),this.instrudao.getInstru(resu.getString(4))));
                    // new Chanteur(resu.getInt(5), resu.getString(6), resu.getString(7),resu.getString(8),resu.getDate(9))));
            }
             
            if (!myList.isEmpty()) {
                System.out.println(myList.get(0)+"  existe deja");
            } else {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false, collobo.getId(), collobo.getAlbum().getId(), collobo.getMusicien().getId() ,Integer.parseInt(collobo.getInstur().getId()));
                prepStat.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public ArrayList selectCollobo() throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Collobo> myList = new ArrayList();
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet 
                myList.add(new Collobo(resu.getInt(1),this.albumdao.getAlbum(resu.getString(2)),musiciendao.getMusicien(resu.getString(3)),this.instrudao.getInstru(resu.getString(4))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return myList;
    }

    @Override
    public void updateCollobo(Collobo col) {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false,
                    col.getAlbum().getId(), col.getInstur().getId(), col.getMusicien().getId(), col.getId());
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public ArrayList selectDateMax() throws DaoException {
         ArrayList<Collobo> myList = new ArrayList();
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        try {
            conn = daoFactory.getConnection();
            Album al = albumdao.getDateMax();
            
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_Colla_by_id, false, al.getId());
            resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet Instru
                myList.add(new Collobo(resu.getInt(1),this.albumdao.getAlbum(resu.getString(2)),musiciendao.getMusicien(resu.getString(3)),this.instrudao.getInstru(resu.getString(4))));
               
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return myList;
    }

   @Override
    public ArrayList selectDateMin() throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Instru> myList = new ArrayList();

      /*  try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_DATEMIN, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet Instru
                myList.add(new Instru(resu.getString(1), resu.getString(2),
                        new Chanteur(resu.getString(3), resu.getString(4)),
                        new Album(resu.getDate(5)),
                        new Musicien(resu.getString(6))));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }*/

        return myList;
    }

    @Override
    public Collobo getCollobo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList selectColloboParMusicien(Musicien mu) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        ArrayList<Collobo> myList = new ArrayList();
        try {
            conn = daoFactory.getConnection();
            if (mu.getId() == -1) {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            } else {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_by_Musicien, false, mu.getId());
            }
            resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet Instru
                 myList.add(new Collobo(resu.getInt(1),this.albumdao.getAlbum(resu.getString(2)),musiciendao.getMusicien(mu.getId()+""),this.instrudao.getInstru(resu.getString(3))));
             }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public ArrayList selectColloboParAlbum(Album al) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            if (al.getId() == -1) {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            } else {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_by_Album, false, al.getId());
            }

            resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet Instru
                myList.add(new Collobo(resu.getInt(1),this.albumdao.getAlbum(al.getId()+""),musiciendao.getMusicien(resu.getString(2)),this.instrudao.getInstru(resu.getString(3))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

        return myList;
    }

    @Override
    public ArrayList selectColloboParInstru(Instru ins) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;
        ArrayList<Collobo> myList = new ArrayList();
        try {
            conn = daoFactory.getConnection();
            if (ins.getId().compareTo("-1")==0) {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            } else {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_by_Instru, false, ins.getId());
            }
             resu = prepStat.executeQuery();
            while (resu.next()) {
                //creation de l'objet Instru
                myList.add(new Collobo(resu.getInt(1),this.albumdao.getAlbum(resu.getString(2)),musiciendao.getMusicien(resu.getString(3)),this.instrudao.getInstru(ins.getId())));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }
}
