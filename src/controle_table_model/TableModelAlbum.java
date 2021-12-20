
package controle_table_model;

import MODEL.Album;
import java.util.ArrayList;


public class TableModelAlbum extends javax.swing.table.AbstractTableModel {
    
    
    private String[] columnNames={" Id","code de l’album "," Titre","date de sortie","nom du chanteur"};
    private ArrayList <Album> albumList;

    public TableModelAlbum(ArrayList<Album> List) {
        this.albumList = List;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return albumList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Album album = albumList.get(rowIndex);
        switch(columnIndex){
            case 0:return album.getId();
            case 1:return album.getCode();
            case 2:return album.getTitre();
            case 3:return album.getDate_sortie();
            case 4:return album.getChanteur().toString();
        }
        return null;
    }
    
     @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Class getColumnClass(int c){
        switch(c){
            case 0 : return String.class;
            case 1 : return String.class;
            case 2 : return String.class;
            case 3 : return String.class;
            case 4 : return String.class;
        }
        return null;
    }
    public ArrayList <Album> getMyList ()
    {
        return albumList;
    }
    public Album getMyList (int index)
    {
        return albumList.get(index);
    }

    public void SetList(ArrayList selectAlbum) {
        albumList = selectAlbum;
        this.fireTableDataChanged();
    }    
}
