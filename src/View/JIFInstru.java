
package View;

import DAO.DaoFactory;
import DaoMysql.InstruDaoMySql;
import controle_table_model.TableModelInstru;
import javax.swing.JTable;
import DAO.InstruDao;


public class JIFInstru extends javax.swing.JInternalFrame {
    
    private DaoFactory factory = DaoFactory.getInstance();
    private InstruDao daoVille =new InstruDaoMySql(factory);
    private TableModelInstru MyVilleModel =new TableModelInstru(daoVille.selectInstru());
    
    public JIFInstru() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(MyVilleModel);

        setBorder(javax.swing.BorderFactory.createTitledBorder("Instruments"));
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(jTable1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
