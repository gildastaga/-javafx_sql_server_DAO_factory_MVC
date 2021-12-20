
package controle_table_model;
import MODEL.Chanteur;
import MODEL.Album;
import MODEL.Collobo;
import java.util.*;
import MODEL.Instru;
import MODEL.Musicien;

public class TableModelCollobo extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames={" Id"," Titre Album","code Album", "Musicien", "instrument "  };
    private ArrayList <Collobo> colloboLst;

    public TableModelCollobo(ArrayList<Collobo> colloboLst) {
        this.colloboLst = colloboLst;
    }
    
    

    @Override
    public int getRowCount() {
        return colloboLst.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Collobo Mycollobo = colloboLst.get(rowIndex);
        switch(columnIndex){
            case 0:return Mycollobo.getId();
            case 1:return Mycollobo.getAlbum().getTitre();
             case 2:return Mycollobo.getAlbum().getCode();
            case 3:return Mycollobo.getMusicien().toString();
            case 4:return Mycollobo.getInstur().toString();
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
    public void setMyList (ArrayList myList)
    {
        this.colloboLst = myList;
        this.fireTableDataChanged();
    }
    
    public ArrayList <Collobo> getMyList ()
    {
        return colloboLst;
    }
    
    public Collobo getMyList (int index)
    {
        return colloboLst.get(index);
    }
}