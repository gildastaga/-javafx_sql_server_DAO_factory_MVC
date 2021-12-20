
package View;

import DAO.DaoFactory;
import javax.swing.JTable;
import DAO.ChanteurDao;
import DaoMysql.ChanteurDaoMySql;
import controle_table_model.TableModelChanteurs;


public class JIFChanteur extends javax.swing.JInternalFrame {
    
    private DaoFactory factory = DaoFactory.getInstance();
    private ChanteurDao daochanteur = new ChanteurDaoMySql(factory);
    private TableModelChanteurs MyDayModel =new TableModelChanteurs(daochanteur.selectChanteur());
    
    public JIFChanteur() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(MyDayModel);

        setBorder(javax.swing.BorderFactory.createTitledBorder("Chanteurs"));
        setVisible(true);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
