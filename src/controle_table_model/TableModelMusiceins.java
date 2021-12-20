package controle_table_model;

import MODEL.Musicien;
import java.util.ArrayList;

public class TableModelMusiceins extends javax.swing.table.AbstractTableModel {

    private String[] columnNames = {" Id", " Nom", "prenom", " sexe ", "date_de naissance"};
    private ArrayList<Musicien> musicienList;

    public TableModelMusiceins(ArrayList<Musicien> List) {
        this.musicienList = List;
        System.out.println(List+" table musiciens");
    }

    @Override
    public int getRowCount() {
        return musicienList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Musicien musicien = musicienList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return musicien.getId();
            case 1:
                return musicien.getNom();
            case 2:
                return musicien.getPrenom();
            case 3:
                return musicien.getSexe();
            case 4:
                return musicien.getDdn();
        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int c) {
        switch (c) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
        }
        return null;
    }
     public ArrayList <Musicien> getMyList ()
    {
        return musicienList;
    }
    public Musicien getMyList (int index)
    {
        return musicienList.get(index);
    }

    public void SetList(ArrayList Mylist) {
        musicienList = Mylist;
        this.fireTableDataChanged();
    }   

}
