
package View;

import DAO.DaoFactory;
import DaoMysql.MusicienDaoMySql;
import controle_table_model.TableModelMusiceins;
import javax.swing.JTable;
import DAO.MusicienDao;


public class JIFMusicien extends javax.swing.JInternalFrame {

    private DaoFactory factory = DaoFactory.getInstance();
    private MusicienDao daoMusicien =new MusicienDaoMySql(factory);
    private TableModelMusiceins MyMusicienModel =new TableModelMusiceins(daoMusicien.selectMusicien());
    
    public JIFMusicien() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(MyMusicienModel);

        setBorder(javax.swing.BorderFactory.createTitledBorder("Musiciens"));
        setVisible(true);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
