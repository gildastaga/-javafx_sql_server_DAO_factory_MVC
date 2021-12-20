
package View;

import DAO.AlbumDao;
import DAO.DaoFactory;
import DAO.DaoException;
import MODEL.Album;
import controle_table_model.TableModelAlbum;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class JIFAlbum extends javax.swing.JInternalFrame {
    
    private DaoFactory factory = DaoFactory.getInstance();
    private AlbumDao daoAlbum =DaoFactory.getInstance().getDAOAlbum();
    private TableModelAlbum myAlbumMode =new TableModelAlbum(daoAlbum.selectAlbum());

    
    public JIFAlbum() {
        initComponents();
        fillComponents() ;
    }
private void fillComponents() {
       
        /* charger toutes les employe */
        ArrayList<Album> listalbum = daoAlbum.selectAlbum();
        listalbum.add(0, new Album(-1," * "));
        listalbum.forEach((j) -> {
            jComboBoxAlbum.addItem(j);
        });

        jComboBoxAlbum.setEnabled(false);
        jRadioButtonfilter.setSelected(true);
        jTextFieldfiltrealbum.setEnabled(false);
        myAlbumMode.SetList(daoAlbum.selectAlbum());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAddemp = new javax.swing.JButton();
        jButtonUpdateEmp = new javax.swing.JButton();
        jButtonDeleteEmp = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jRadioButtonfilter = new javax.swing.JRadioButton();
        jLabelfilter = new javax.swing.JLabel();
        jRadioButtonJour = new javax.swing.JRadioButton();
        jComboBoxAlbum = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextFieldfiltrealbum = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jDateChooserMax = new com.toedter.calendar.JDateChooser();
        jDateChooserMin = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(myAlbumMode);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createTitledBorder("Albums"));
        setTitle("album");
        setMinimumSize(new java.awt.Dimension(640, 580));
        setVisible(true);

        jButtonAddemp.setText("Add Album");
        jButtonAddemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddempActionPerformed(evt);
            }
        });

        jButtonUpdateEmp.setText("UpdateAlbum");
        jButtonUpdateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateEmpActionPerformed(evt);
            }
        });

        jButtonDeleteEmp.setText("DeleteAlbum");
        jButtonDeleteEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddemp)
                .addGap(30, 30, 30)
                .addComponent(jButtonUpdateEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteEmp)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddemp)
                    .addComponent(jButtonUpdateEmp)
                    .addComponent(jButtonDeleteEmp))
                .addContainerGap())
        );

        buttonGroup1.add(jRadioButtonfilter);
        jRadioButtonfilter.setText("Aucun");
        jRadioButtonfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonfilterActionPerformed(evt);
            }
        });

        jLabelfilter.setText("filter");

        buttonGroup1.add(jRadioButtonJour);
        jRadioButtonJour.setText(" Code album ");
        jRadioButtonJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonJourActionPerformed(evt);
            }
        });

        jComboBoxAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlbumActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("filtre par titre");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jTextFieldfiltrealbum.setToolTipText("");
        jTextFieldfiltrealbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldfiltrealbumActionPerformed(evt);
            }
        });

        jButton2.setText("Decroissante");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Croissante ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Entre deux intervalles de date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserMax, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserMin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonOk.setText("ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonOk))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelfilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonfilter)
                        .addGap(79, 79, 79)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldfiltrealbum, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jRadioButtonJour, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonfilter)
                            .addComponent(jRadioButton1)
                            .addComponent(jTextFieldfiltrealbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonJour)
                            .addComponent(jComboBoxAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOk))
                .addContainerGap())
        );

        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 753, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddempActionPerformed
        
    // recupere la JFrame parente
        JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
        new JDAlbumInsert(parent, "INSERTION D'Album");
        // après l'insertion : rafraîchir les données en relisant la BD
        myAlbumMode.SetList(daoAlbum.selectAlbum());
        
    }//GEN-LAST:event_jButtonAddempActionPerformed

    private void jButtonUpdateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateEmpActionPerformed
       if (jTable1.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this,"Sélectionnez d'abord une ligne svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            // renvoie l'objet à passer en paramètre
            Album album =myAlbumMode.getMyList(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()));
            
           System.out.println("button update jifemp"+album.getId()+" "+album.getCode()+" "+album.getTitre()+" "+album.getDate_sortie()+" "+album.getChanteur()+"   ic: "+album.getId());
            // récupère la JFrame parente
            JFrame parent = (JFrame)(this.getDesktopPane().getTopLevelAncestor());
             new JDAlbumUpdate(parent, "MODIFICATION D'APPAREIL", album);
            
            // après la modification : rafraîchir les données en relisant la BD
           myAlbumMode.SetList(daoAlbum.selectAlbum()); 
        }
    }//GEN-LAST:event_jButtonUpdateEmpActionPerformed

    private void jButtonDeleteEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteEmpActionPerformed
        if (jTable1.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(null,"Sélectionnez d'abord une ligne svp !","Avertissement",JOptionPane.ERROR_MESSAGE);
        else {
            int rep = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer " +
                    myAlbumMode.getValueAt(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()), 0) + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION)
                try {   
                    Album album =myAlbumMode.getMyList(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()));
                    daoAlbum.deleteAlbum(album.getId()+"");
                }
                catch (DaoException e) {
                    JOptionPane.showMessageDialog(null,"Suppression impossible !","Avertissement",JOptionPane.ERROR_MESSAGE);
                }
        }
        // après la suppression : rafraîchir les données en relisant la BD
       myAlbumMode.SetList(daoAlbum.selectAlbum());
        
    }//GEN-LAST:event_jButtonDeleteEmpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Album> list = daoAlbum.selectAlbum();
        Collections.sort(list);
        myAlbumMode.SetList(list);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Album> list = daoAlbum.selectAlbum();
        Collections.sort(list);
        Collections.sort(list,Collections.reverseOrder());
         myAlbumMode.SetList(list);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldfiltrealbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldfiltrealbumActionPerformed
        ArrayList<Album>  that = new ArrayList<>();
        ArrayList<Album> list = daoAlbum.selectAlbum();
        list.forEach((p) ->{
            String a = p.getTitre();
            String b = jTextFieldfiltrealbum.getText();
            if(a.contains(b)){
                that.add(p);
                myAlbumMode.SetList(that);
            }
        });
         myAlbumMode.SetList(that);
    }//GEN-LAST:event_jTextFieldfiltrealbumActionPerformed

    private void jRadioButtonfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonfilterActionPerformed
        jComboBoxAlbum.setEnabled(false);
        jTextFieldfiltrealbum.setEnabled(false);
         myAlbumMode.SetList(daoAlbum.selectAlbum());
    }//GEN-LAST:event_jRadioButtonfilterActionPerformed

    private void jRadioButtonJourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonJourActionPerformed
        jComboBoxAlbum.setEnabled(true);
        jTextFieldfiltrealbum.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonJourActionPerformed

    private void jComboBoxAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlbumActionPerformed
        Album album = (Album) jComboBoxAlbum.getSelectedItem();
        ArrayList<Album> list = new ArrayList<>();
        list.add(daoAlbum.getAlbum(album.getId()+""));
       myAlbumMode.SetList(list);
    }//GEN-LAST:event_jComboBoxAlbumActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
         ArrayList<Album>  that = new ArrayList<>();
        ArrayList<Album> list = daoAlbum.selectAlbum();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateMax = null;
        Date dateMin = null;
        if(jDateChooserMax.getDate()!= null && jDateChooserMin.getDate() != null){
            try {
                dateMax = new Date( df.parse(df.format(jDateChooserMax.getDate())).getTime());
                dateMin =  new Date( df.parse(df.format(jDateChooserMin.getDate())).getTime());
              for(Album p : list){
                  System.out.println(p.getDate().after(dateMax) +"   "+p.getDate().after(dateMax));
                if(p.getDate().after(dateMax)  && p.getDate().before(dateMin)){
                    that.add(p);
                }
                  System.out.println(that);
            }
            } catch (ParseException ex) { 
                ex.getMessage();//Logger.getLogger(JDAlbumInsert.class.getName()).log(Level.SEVERE, "ajouter une date ", ex);
            }
        }else{
             JOptionPane.showMessageDialog(null,"selectionner deux date Svp!","Avertissement",JOptionPane.ERROR_MESSAGE);
        }System.out.println(that);
        myAlbumMode.SetList(that);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTextFieldfiltrealbum.setEnabled(true);
         jComboBoxAlbum.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddemp;
    private javax.swing.JButton jButtonDeleteEmp;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonUpdateEmp;
    private javax.swing.JComboBox jComboBoxAlbum;
    private com.toedter.calendar.JDateChooser jDateChooserMax;
    private com.toedter.calendar.JDateChooser jDateChooserMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelfilter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButtonJour;
    private javax.swing.JRadioButton jRadioButtonfilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldfiltrealbum;
    // End of variables declaration//GEN-END:variables
}
