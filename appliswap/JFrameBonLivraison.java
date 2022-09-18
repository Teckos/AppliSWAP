/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appliswap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Teckos
 */
public class JFrameBonLivraison extends javax.swing.JFrame {
    
    Statement stm;
    connexion maConnexion=new connexion();
    ResultSet rs;
    String BL;
    String Adresse;
    String type;
    String Date;
    String ExBL;
    
    
    /**
     * Creates new form JFrameBonLivraison
     */
   
    public void date_courante2(){
        
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

        int annee = cal.get(Calendar.YEAR);
        int mois=cal.get(Calendar.MONTH); 
        int jour=cal.get(Calendar.DAY_OF_MONTH);
        date_bl.setText(date_format.format(cal.getTime()));
    
    }
    
    /*public String  bon_livraison(){
        
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
        int annee = cal.get(Calendar.YEAR);
        int mois=cal.get(Calendar.MONTH); 
        int jour=cal.get(Calendar.DAY_OF_MONTH);
        return (new String("B"+ date_format.format(cal.getTime())+"R"));
    }
    
    public String date_courante(){
        
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

        int annee = cal.get(Calendar.YEAR);
        int mois=cal.get(Calendar.MONTH); 
        int jour=cal.get(Calendar.DAY_OF_MONTH);
        return (new String(date_format.format(cal.getTime())));
     
    }*/
    
    public JFrameBonLivraison() {
        initComponents();
        date_courante2();
        Remplir_ComboBL();

        //ex.setText("R");
    }
    void Remplir_ComboBL(){
        ComboBL.removeAllItems();
        try{
                            String sql="select distinct(N_BL) from bonlivraison where N_BL NOT IN ('0','1') ";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("N_BL");
                  ComboBL.addItem(name);
                }
            }
           catch(Exception e){
                JOptionPane.showMessageDialog(null,e); 
            }
    }
    public void chercherBL(){
        
        
        //requête 
        String requete="UPDATE réparation set N_BL='1' where N_BL = '"+ComboBL.getSelectedItem()+"'" ;
        String requete_suppression="DELETE FROM bonlivraison where N_BL = '"+ComboBL.getSelectedItem()+"'" ;
        
        //Exécuter la requête
       try{
            stm=maConnexion.get_connexion().createStatement();
            
            stm.executeUpdate(requete); 
            stm.executeUpdate(requete_suppression);
            
            JOptionPane.showMessageDialog(null,"La suppression est effectuée ! ");
                       
  
       }
        catch(SQLException e){
           //System.err.println(e);
           java.awt.Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null, e);
        }
       
    }
    public void maj(){
        
        Adresse = addr_bl.getText();
        String RAPPORT="";
         try{
             
                String requeteType = "SELECT distinct Type from réparation R, appareil A WHERE R.CodeAPPLE = A.CodeAPPLE AND N_BL='1' order by Type";
                String reqnb = "select count(distinct type) from réparation R, appareil A WHERE R.CodeAPPLE = A.CodeAPPLE AND N_BL='1'";
                stm=maConnexion.get_connexion().createStatement();
                
                rs=stm.executeQuery(reqnb);
                rs.next();
                String nb = rs.getString("count(distinct type)");
                int cpt = Integer.parseInt(nb); 
                String [] Type = new String [cpt];
                // Création du rapport 
                if (jComboBox1.getSelectedItem().equals("Swaps")){
                     RAPPORT = "C:\\appliSWAP2\\src\\appliswap\\Saisie_swap.jrxml";
                     
                }
                else if (jComboBox1.getSelectedItem().equals("Retour SPB")){
                     RAPPORT = "C:\\appliSWAP2\\src\\appliswap\\Saisie_swap_1.jrxml";
                     
                }
              JasperReport jr = JasperCompileManager.compileReport(RAPPORT);
                
                Map param = new HashMap();           
                  
                for(int i=0; i<cpt;i++){
                
                rs=stm.executeQuery(requeteType);

                  rs.next();
                    type = rs.getString("Type");
                    
                    //remplissage du tableau 
                    for(int j=0;j<cpt;j++){
                        
                       Type[j]=type;
                    }

                    if(type.equals(Type[i])){
                        ExBL=ex.getText();
                        //BL = new String (bon_livraison());
                        Date = date_bl.getText();
                        String rep = Date.replace("-","");
                        BL = "B"+rep+ExBL;
                        int t = i+1;
                        String tmp=BL+t;
                        String requeteBL="INSERT INTO bonlivraison(N_BL,Date_BL)\n"+
                        "VALUES ('"+tmp+"','"+Date+"') " ;
                        
                        String requete1= "UPDATE réparation SET N_BL= '"+tmp+"' WHERE N_BL='1'\n" +
        "AND CodeAPPLE IN (select CodeAPPLE from appareil where Type='"+type+"') ";
                        stm.executeUpdate(requeteBL);
                        stm.executeUpdate(requete1); 
                        
                        param.put("type", type);
                        param.put("numBL", tmp);
                        param.put("addrDes", new String (Adresse));
                        JasperPrint jp = JasperFillManager.fillReport(jr,param, maConnexion.get_connexion());
                        JasperExportManager.exportReportToPdfFile(jp, "C:\\appliSWAP2\\"+tmp+".pdf");
                        JasperViewer.viewReport(jp,false);

                    }
                }
                    
                
        }
        catch(Exception e){
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        ex = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        date_bl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addr_bl = new javax.swing.JTextArea();
        verifier = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ComboBL = new javax.swing.JComboBox();
        supprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTION BONS DE LIVRAISON");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Création de BL"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Swaps", "Retour SPB" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        ex.setText("R");
        ex.setToolTipText("Extension de BL (R, RR, autres)");

        jLabel3.setText("Date de BL   :");

        jLabel5.setText("Adresse de BL : ");

        addr_bl.setColumns(20);
        addr_bl.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        addr_bl.setRows(5);
        addr_bl.setText("SPB SERVICES\n124 RUE SALVADOR ALLENDE\n95870 BEZONS");
        jScrollPane1.setViewportView(addr_bl);

        verifier.setText("Valider");
        verifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verifier)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(date_bl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ex, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_bl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verifier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Suppression de BL"));

        jLabel2.setText("Numéro de BL :");

        ComboBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBLActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(ComboBL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(supprimer)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(supprimer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(360, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void verifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifierActionPerformed
       maj();
       Remplir_ComboBL();
    }//GEN-LAST:event_verifierActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
        chercherBL();
        Remplir_ComboBL();
    }//GEN-LAST:event_supprimerActionPerformed

    private void ComboBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBLActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameBonLivraison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameBonLivraison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameBonLivraison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameBonLivraison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameBonLivraison().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBL;
    private javax.swing.JTextArea addr_bl;
    private javax.swing.JTextField date_bl;
    private javax.swing.JTextField ex;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton supprimer;
    private javax.swing.JButton verifier;
    // End of variables declaration//GEN-END:variables
}
