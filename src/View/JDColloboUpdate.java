
package View;

import DAO.DaoFactory;
import MODEL.Chanteur;
import MODEL.Album;
import MODEL.Instru;
import MODEL.Musicien;
import DAO.DaoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;
import DAO.MusicienDao;
import DAO.ColloboDao;
import DAO.AlbumDao;
import DAO.ChanteurDao;
import DAO.InstruDao;
import MODEL.Collobo;


public class JDColloboUpdate extends javax.swing.JDialog {
    
    private ColloboDao daoCollobo = DaoFactory.getInstance().getDAOCollobos();
    private MusicienDao daoMusicien = DaoFactory.getInstance().getDAOMusicien();
    private InstruDao instruDao = DaoFactory.getInstance().getDAOInstru();
    private AlbumDao daoalbum = DaoFactory.getInstance().getDAOAlbum();
   
    public JDColloboUpdate(java.awt.Frame parent, String modal,Collobo plan) {
        super(parent, modal,true);
        initComponents();
        fillComponents(plan);
         getRootPane().setDefaultButton(jButtonOk);
        setLocation(parent.getX()+parent.getWidth()/3, parent.getY()+parent.getHeight()/3);
        setVisible(true);
    }
    
    private void fillComponents(Collobo col)
    {
        jTextFieldId.setEnabled(false);
        jTextFieldId.setText(col.getId()+"");
       
        
        
        /* charger toutes les list */
        int Idinstru = col.getId(); 
        ArrayList <Instru> listinstru = instruDao.selectInstru();
        for (int i=0;i<listinstru.size();i++)
        {
            jComboBoxInstru.addItem(listinstru.get(i));
            if (listinstru.get(i).getId().equals(Idinstru))
                jComboBoxInstru.setSelectedIndex(i);
        }
        
        int numPro = col.getId();
        ArrayList <Musicien> musicien = daoMusicien.selectMusicien();
        for (int i=0;i<musicien.size();i++){
            jComboBoxMusicien.addItem(musicien.get(i));
            if (musicien.get(i).getId() == numPro)
                jComboBoxMusicien.setSelectedIndex(i);
            
        }
        
        int numJour = col.getId();
        ArrayList <Album> al = daoalbum.selectAlbum();
        for (int i=0;i<al.size();i++){
            jComboBoxAlbum.addItem(al.get(i));
            if (al.get(i).getId() == numJour)
                jComboBoxAlbum.setSelectedIndex(i);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSlider1 = new javax.swing.JSlider();
        jPanelup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        JLabelIdplan = new javax.swing.JLabel();
        JLabelEmp = new javax.swing.JLabel();
        JLabelPro = new javax.swing.JLabel();
        JLabelIJour = new javax.swing.JLabel();
        jComboBoxMusicien = new javax.swing.JComboBox();
        jComboBoxAlbum = new javax.swing.JComboBox();
        jTextFieldId = new javax.swing.JTextField();
        jComboBoxInstru = new javax.swing.JComboBox();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelup.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("       update Collaboration");

        JLabelIdplan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelIdplan.setText("Id");

        JLabelEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelEmp.setText("Album");

        JLabelPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelPro.setText("Musicien");

        JLabelIJour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelIJour.setText("Instrument");

        jComboBoxMusicien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMusicienActionPerformed(evt);
            }
        });

        jComboBoxAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlbumActionPerformed(evt);
            }
        });

        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jComboBoxInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMenuLayout.createSequentialGroup()
                                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelEmp)
                                    .addComponent(JLabelPro))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                                .addComponent(JLabelIdplan, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxAlbum, 0, 141, Short.MAX_VALUE)
                            .addComponent(jTextFieldId)
                            .addComponent(jComboBoxMusicien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(JLabelIJour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxInstru, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelIdplan)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelEmp)
                    .addComponent(jComboBoxAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelPro)
                    .addComponent(jComboBoxMusicien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelIJour)
                    .addComponent(jComboBoxInstru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButtonOk.setBackground(new java.awt.Color(51, 255, 51));
        jButtonOk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonOk.setText("Update collaboration");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCancel.setText("cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelupLayout = new javax.swing.GroupLayout(jPanelup);
        jPanelup.setLayout(jPanelupLayout);
        jPanelupLayout.setHorizontalGroup(
            jPanelupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelupLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelupLayout.setVerticalGroup(
            jPanelupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelupLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancel))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMusicienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMusicienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMusicienActionPerformed

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jComboBoxInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstruActionPerformed

    private void jComboBoxAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAlbumActionPerformed
    public static boolean isNumeric(String strNum) {
        
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        Collobo col = new Collobo();
        col.setId(Integer.parseInt(jTextFieldId.getText()));;
        col.setAlbum((Album)jComboBoxAlbum.getSelectedItem());
        col.setMusicien((Musicien)jComboBoxMusicien.getSelectedItem());
        col.setInstur((Instru)jComboBoxInstru.getSelectedItem());
        try {
                daoCollobo.updateCollobo(col);
            }catch (DaoException e) {
                JOptionPane.showMessageDialog(null,"Modification impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
            }
         this.dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JDColloboUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JDColloboUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JDColloboUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JDColloboUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JDColloboUpdate dialog = new JDColloboUpdate(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelEmp;
    private javax.swing.JLabel JLabelIJour;
    private javax.swing.JLabel JLabelIdplan;
    private javax.swing.JLabel JLabelPro;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox jComboBoxAlbum;
    private javax.swing.JComboBox jComboBoxInstru;
    private javax.swing.JComboBox jComboBoxMusicien;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
