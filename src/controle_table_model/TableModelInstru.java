
package controle_table_model;

import MODEL.Album;
import MODEL.Instru;
import java.util.ArrayList;


public class TableModelInstru extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames={" Id"," nom d'instrument "};
    private ArrayList <Instru > List_Instru;

    public TableModelInstru(ArrayList<Instru> List) {
        this.List_Instru = List;
    }
    
    

    @Override
    public int getRowCount() {
       return List_Instru.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Instru instru = List_Instru.get(rowIndex);
        switch(columnIndex){
            case 0:return instru.getId();
            case 1:return instru.getNom();
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
        }
        return null;
    }
    
    
    
}
