/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appliswap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Teckos
 */
public class AffichageBL extends javax.swing.JFrame {
    Statement stm;
    Statement stm1;
    connexion maConnexion;
    connexion1 maConnexion1;
    ResultSet rs;
    ResultSet rs1;
    String selection="";
    String LOCAL="OUI";
    Integer col=0;
    /**
     * Creates new form AffichageBL
     */
    public AffichageBL() {
        initComponents();
         BDD_local.doClick();
        try {
        if (LOCAL.equals("OUI")) {maConnexion1=new connexion1();
            stm=maConnexion1.get_connexion().createStatement();
            }
            else {maConnexion=new connexion();
            stm=maConnexion.get_connexion().createStatement();}
        }
        catch (SQLException e){
            System.err.println(e);
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e);
        }
        //affichage();
       
        
       
    }
    private void affichage(){
        
        String requete ="SELECT  (A.BL_SPB), \n" +
"count(imei_ori) as '[[Total]]', \n" +
"count(case when A.status='oui' then 1 end) as '[Demandés]', \n" +
"(select count(B.ID) from liste_swap C, réparation B where (B.Etat ='oui') and (C.ID=B.ID) and (C.status='Oui') and (A.BL_SPB =C.BL_SPB)) as Swappés,\n" +
"(select count(B.ID) from liste_swap C, réparation B where (B.Etat ='Réparé') and (C.ID=B.ID) and (C.status='Oui') and (A.BL_SPB =C.BL_SPB)) as Réparés,\n" +
"(select count(B.ID) from liste_swap C, réparation B where (B.Etat ='En attente') and (C.ID=B.ID) and (C.status='Oui') and (A.BL_SPB =C.BL_SPB)) as En_attente,\n" +
"(select count(B.ID) from liste_swap C, réparation B where (B.Etat='Refusé') and (C.ID=B.ID) and (C.status='Oui') and (A.BL_SPB =C.BL_SPB)) as Refusés,\n" +
"count(case when status IN ('Non','Echec') then 1 end) as '[A demander]', \n" +
"count(case when status IN ('LM','HS', 'IMPOSSIBLE','INCORRECT','DEJA_SWAP') then 1 end) as '[Localisé / HS]',\n" +
"(select count(B.ID) from liste_swap C, réparation B where (B.N_BL='0') and (C.ID=B.ID) and (A.BL_SPB =C.BL_SPB))\n"+
" + count(case when status IN ('LM','HS', 'IMPOSSIBLE','INCORRECT','DEJA_SWAP') then 1 end) \n"+
" - (select count(B.ID) from liste_swap C, réparation B where (C.status IN ('LM','HS', 'IMPOSSIBLE','INCORRECT','DEJA_SWAP')) and (C.ID=B.ID) and (A.BL_SPB =C.BL_SPB)) as '[A livrer]'\n" +
"from liste_swap A where BL_SPB != '' group by BL_SPB";
       
        try {
            if (LOCAL.equals("OUI")) {stm=maConnexion1.get_connexion().createStatement();}
            else {stm=maConnexion.get_connexion().createStatement();}
        
        rs=stm.executeQuery(requete); 
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
        }
         catch(Exception e){
           JOptionPane.showMessageDialog(null,e); }
    }
  
    private void affichage2(){
        String requete;
        if (col.equals(9)) { requete ="SELECT A.ID, A.IMEI_ORI as IMEI, A.Des as Désignation, B.N_REP as N_Rep, B.IMEI_NEW, B.etat as Etat\n "
                + "from liste_swap A, réparation B WHERE (A.BL_SPB='"+selection+"') AND (A.ID=B.ID) AND (B.N_BL='0') ";
        /*requete ="SELECT A.ID, A.IMEI_ORI as IMEI, A.Des as Désignation, \n "
                + "(select B.N_REP from réparation B where (A.ID=B.ID)) as N_Rep, \n"
                + "(select B.IMEI_NEW from réparation B where (A.ID=B.ID)) as IMEI_NEW, \n"
                + "(select B.etat from réparation B where (A.ID=B.ID)) as Etat from liste_swap A, réparation B WHERE A.BL_SPB='"+selection+"' AND (B.N_BL='0') AND (A.ID=B.ID)";*/
        }
        
        else { requete ="SELECT A.ID, A.BL_SPB as Lot, A.IMEI_ORI as IMEI, A.Des as Désignation, A.status as Status,\n "
                + "(select B.N_REP from réparation B where (A.ID=B.ID)) as N_Rep, \n"
                + "(select B.etat from réparation B where (A.ID=B.ID)) as Etat from liste_swap A WHERE A.BL_SPB='"+selection+"'";}
       
         try {
           
        rs=stm.executeQuery(requete); 
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    
        }
         catch(Exception e){
           JOptionPane.showMessageDialog(null,e); }
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        BDD_local = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Rafraîchir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        BDD_local.setText("BDD locale");
        BDD_local.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BDD_localMouseClicked(evt);
            }
        });
        BDD_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDD_localActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel13.setText("V. 2.3.1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(BDD_local)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(BDD_local))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        affichage();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int row = jTable1.getSelectedRow();
         col =jTable1.getSelectedColumn();
         selection = (jTable1.getModel().getValueAt(row, 0).toString());
         System.out.println(col);
         affichage2();
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void BDD_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDD_localActionPerformed
       
    }//GEN-LAST:event_BDD_localActionPerformed

    private void BDD_localMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BDD_localMouseClicked
        try {
        if(BDD_local.isSelected()==true)
            {LOCAL="OUI";
            maConnexion1=new connexion1();
            stm=maConnexion1.get_connexion().createStatement();}
        else {LOCAL="NON";
            maConnexion=new connexion();
            stm=maConnexion.get_connexion().createStatement();}
        System.out.println("Local : "+ LOCAL);
        }
        catch (SQLException e){
            System.err.println(e);
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Erreur de connexion à la BDD");
        }
    }//GEN-LAST:event_BDD_localMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AffichageBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AffichageBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AffichageBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AffichageBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffichageBL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BDD_local;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
