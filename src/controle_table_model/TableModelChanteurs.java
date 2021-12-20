package controle_table_model;

import MODEL.Chanteur;
import java.util.ArrayList;

public class TableModelChanteurs extends javax.swing.table.AbstractTableModel{
    
    private String[] columnNames={" Id"," Nom", "PreNom", "sexe " ," date_de_naissance" };
    private ArrayList <Chanteur> chanteurLst;

    public TableModelChanteurs(ArrayList<Chanteur> List) {
        this.chanteurLst = List;
        System.out.println(List);
    }
    
    @Override
    public int getRowCount() {
        return chanteurLst.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Chanteur MyPlan = chanteurLst.get(rowIndex);
        switch(columnIndex){
            case 0:return MyPlan.getId();
            case 1:return MyPlan.getNom();
            case 2:return MyPlan.getPrenom();
            case 3:return MyPlan.getSexe();
            case 4:return MyPlan.getDdn();
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
        this.chanteurLst = myList;
        this.fireTableDataChanged();
    }
    
    public ArrayList <Chanteur> getMyList ()
    {
        return chanteurLst;
    }
    
    public Chanteur getMyList (int index)
    {
        return chanteurLst.get(index);
    }
}
