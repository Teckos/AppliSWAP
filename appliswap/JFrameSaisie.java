/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appliswap;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Teckos
 */
public class JFrameSaisie extends javax.swing.JFrame {
   Statement stm;
    connexion maConnexion=new connexion();
    ResultSet rs;
    /**
     * Creates new form JFrameBonLivraison
     */
    
    
     private void Compteur(){
         
          try{
              
              String sql="select count(IMEI_NEW) as cpt from réparation where N_BL!='0'";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               rs.first();
                
              String  n=rs.getString("cpt");
           
              System.out.println(n);
              my.setText(n);
                  
                  
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
             }
    }
    private void Compteur_Insertion(){
         
          try{
              
              String sql="select count(IMEI_NEW) as cpt from réparation where N_BL!='0'";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               rs.first();
                
              int  n=rs.getInt("cpt");
              String m=my.getText();
                      
              int j, r;
              
              j=Integer.parseInt(m);
              r=n-j;
                      
              String c=String.valueOf(r);
               
              System.out.println(c);
             cp.setText(c);
                  
                  
               }
           catch(Exception e){
               
	
            
           JOptionPane.showMessageDialog(null,e); 
             }
    }
    
    public JFrameSaisie() {
        initComponents();
      //  Remplir_ComboOper();
        imei.setDocument(new JTextFieldLimit(17));
        Compteur();
        my.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        my = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        imei = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        code_retour = new javax.swing.JTextField();
        imei_retour = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        n_rep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        operateur = new javax.swing.JTextField();
        cp = new javax.swing.JTextField();

        my.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SAISIE DES APPAREILS A LIVRER");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Saisie par IMEI swappé"));

        imei.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imeiActionPerformed(evt);
            }
        });
        imei.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imeiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imei, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Saisie des appareils non swappés"));

        code_retour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        code_retour.setToolTipText("Code refus");
        code_retour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                code_retourFocusGained(evt);
            }
        });
        code_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                code_retourActionPerformed(evt);
            }
        });
        code_retour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                code_retourKeyPressed(evt);
            }
        });

        imei_retour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imei_retour.setToolTipText("IMEI");
        imei_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imei_retourActionPerformed(evt);
            }
        });
        imei_retour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imei_retourKeyPressed(evt);
            }
        });

        jLabel3.setText("Code refus      :");

        jLabel4.setText("IMEI    :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(code_retour)
                    .addComponent(imei_retour))
                .addGap(84, 84, 84))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(code_retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(imei_retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Saisie par N° de réparation APPLE"));

        n_rep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        n_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_repActionPerformed(evt);
            }
        });
        n_rep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n_repKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(n_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(n_rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        jLabel2.setText("Opérateur/Numéro de Lot      :");

        operateur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        operateur.setToolTipText("A renseigner obligatoirement !");
        operateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operateurActionPerformed(evt);
            }
        });
        operateur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                operateurKeyPressed(evt);
            }
        });

        cp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(operateur))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(456, 396));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void operateurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_operateurKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
             imei.requestFocusInWindow();
        }
    }//GEN-LAST:event_operateurKeyPressed

    private void imeiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imeiKeyPressed
        // TODO add your handling code here:
        /*if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
             imei.requestFocusInWindow();
        }*/
        
    }//GEN-LAST:event_imeiKeyPressed

    private void operateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operateurActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_operateurActionPerformed

    private void imeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imeiActionPerformed
        // TODO add your handling code here:
        //String CODE = code.getText();
       
        String IMEI = imei.getText();
        Integer id_=0;
        String bl="";
        String OPERATEUR ="";
        
       
        
        if((IMEI.length() != 15 ) && (IMEI.length() != 12 )&& (IMEI.length() != 17 )){
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Le champs N° de Série/IMEI doit avoir 12 ou 15 caractères");
            //java.awt.Toolkit.getDefaultToolkit().beep();
            //N_Rep.setText("");
            //code.setText("");
            imei.setText(""); 
            imei.requestFocusInWindow();
        }
        else {
            //la requête
             if ((IMEI.length() == 17)&(IMEI.startsWith("A"))&(IMEI.endsWith("B")))
                          {
                              IMEI=IMEI.substring(1, 16);
                              imei.setText(IMEI);
                          }
            String requete0="select * from réparation where IMEI_NEW='"+IMEI+"'";
            //JOptionPane.showMessageDialog(null, requete0);
            try {
                stm=maConnexion.get_connexion().createStatement();
                rs=stm.executeQuery(requete0);
                while(rs.next()){
                    id_=rs.getInt("ID");
                    bl=rs.getString("N_BL");
                    OPERATEUR=rs.getString("Opérateur");
                    if ((OPERATEUR.equals("SFR"))|(OPERATEUR.equals("ORANGE"))|(OPERATEUR.equals("BOUYGUES"))|(OPERATEUR.equals("UNLOCKED"))){}
                    else OPERATEUR=operateur.getText();
                    //JOptionPane.showMessageDialog(null, bl);
                }
                //JOptionPane.showMessageDialog(null, id_);
            }
            catch(SQLException e){
                    System.err.println(e);
                                        
                }
            if (id_==0) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Cet IMEI n'est pas enregistré");
                
                imei.setText(""); 
                imei.requestFocusInWindow();
                                
                              
            }
            else if (bl.equals("0"))
            {   
                 String requete="UPDATE réparation SET Opérateur ='"+OPERATEUR+"',N_BL='1' where ID='"+id_+"'";

                                //Exécuter la requête
                                try{
                                    stm=maConnexion.get_connexion().createStatement();
                                    // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
                                    stm.executeUpdate(requete); 
                                    //JOptionPane.showMessageDialog(null,"le nouveau Enregistrement est ajouté");
                                    //code.setText("");
                                    imei.setText(""); 
                                    imei.requestFocusInWindow();
                                    //operateur.setText("");
                                }
                                catch(SQLException e){
                                    System.err.println(e);
                                }
                
            }
            else {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Cet IMEI a déjà été scanné");
                imei.setText(""); 
                imei.requestFocusInWindow();
            }
        }
        Compteur_Insertion();
        //  cp.setText(""); 
        my.setEnabled(false);
       
    }//GEN-LAST:event_imeiActionPerformed

    private void cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpActionPerformed

    private void n_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_repActionPerformed
        // TODO add your handling code here:
        //String CODE = code.getText();

        String Nrep = n_rep.getText();
        Integer id_=0;
        String bl="";
        String OPERATEUR = "";
        String etat="";

        if (Nrep.length() != 10 ) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Le champs N° de réparation doit avoir 10 caractères");
            //java.awt.Toolkit.getDefaultToolkit().beep();
            //N_Rep.setText("");
            //code.setText("");
            n_rep.setText("");
            n_rep.requestFocusInWindow();
        }
        else {
            //la requête
            String requete0="select * from réparation where N_Rep='"+Nrep+"'";
            //JOptionPane.showMessageDialog(null, requete0);
            try {
                stm=maConnexion.get_connexion().createStatement();
                rs=stm.executeQuery(requete0);
                while(rs.next()){
                    id_=rs.getInt("ID");
                    bl=rs.getString("N_BL");
                    etat=rs.getString("etat");
                    OPERATEUR=rs.getString("Opérateur");
                    if ((OPERATEUR.equals("SFR"))|(OPERATEUR.equals("ORANGE"))|(OPERATEUR.equals("BOUYGUES"))|(OPERATEUR.equals("UNLOCKED"))){}
                    else OPERATEUR=operateur.getText();
                    if (etat.equals("oui")){}
                    else {rs=stm.executeQuery("Select BL_SPB from liste_swap where ID='"+id_+"'");
                            while (rs.next()){
                                OPERATEUR=rs.getString("BL_SPB");}
                    }
                    //JOptionPane.showMessageDialog(null, bl);
                }
                //JOptionPane.showMessageDialog(null, id_);
            }
            catch(SQLException e){
                System.err.println(e);

            }
            if (id_==0) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Ce numéro de réparation n'est pas enregistré");

                n_rep.setText("");
                n_rep.requestFocusInWindow();

            }
            else if (bl.equals("0"))
            {
                String requete="UPDATE réparation SET Opérateur ='"+OPERATEUR+"',N_BL='1' where ID='"+id_+"'";
                String requete1="UPDATE réparation A, liste_swap B SET A.IMEI_NEW=B.IMEI_ORI where (A.ID='"+id_+"') AND (A.ID=B.ID)";

                //Exécuter la requête
                try{
                    stm=maConnexion.get_connexion().createStatement();
                    // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
                    stm.executeUpdate(requete);
                    stm.executeUpdate(requete1);
                    //JOptionPane.showMessageDialog(null,"le nouveau Enregistrement est ajouté");
                    //code.setText("");
                    n_rep.setText("");
                    n_rep.requestFocusInWindow();
                    //operateur.setText("");
                }
                catch(SQLException e){
                    System.err.println(e);
                }

            }
            else {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Cet appareil a déjà été scanné");
                n_rep.setText("");
                n_rep.requestFocusInWindow();
            }
        }
        Compteur_Insertion();
        //  cp.setText("");
        my.setEnabled(false);

    }//GEN-LAST:event_n_repActionPerformed

    private void n_repKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_repKeyPressed
        // TODO add your handling code here:
        /*if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            imei.requestFocusInWindow();
        }*/

    }//GEN-LAST:event_n_repKeyPressed

    private void code_retourFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_code_retourFocusGained
        code_retour.setText("");
    }//GEN-LAST:event_code_retourFocusGained

    private void code_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_code_retourActionPerformed
        imei_retour.setText("");
        imei_retour.requestFocusInWindow();
    }//GEN-LAST:event_code_retourActionPerformed

    private void code_retourKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code_retourKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_code_retourKeyPressed

    private void imei_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imei_retourActionPerformed
        // TODO add your handling code here:
        //String CODE = code.getText();

        String IMEI = imei_retour.getText();
        Integer id_=0;
        String bl="";
        String imei_ori="";
        String status="";
        String code="";

        if((IMEI.length() != 15 ) && (IMEI.length() != 12 )){
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Le champs N° de Série/IMEI doit avoir 12 ou 15 caractères");
            //java.awt.Toolkit.getDefaultToolkit().beep();
            //N_Rep.setText("");
            //code.setText("");
            imei_retour.setText("");
            imei_retour.requestFocusInWindow();
        }
        else {
            //la requête
            String requete0="select * from liste_swap where IMEI_ORI='"+IMEI+"'";
            //JOptionPane.showMessageDialog(null, requete0);
            try {
                stm=maConnexion.get_connexion().createStatement();
                rs=stm.executeQuery(requete0);
                while(rs.next()){
                    id_=rs.getInt("ID");
                    bl=rs.getString("BL_SPB");
                    imei_ori=rs.getString("IMEI_ORI");
                    status=rs.getString("status");
                    //JOptionPane.showMessageDialog(null, bl);
                }
                //JOptionPane.showMessageDialog(null, id_);
            }
            catch(SQLException e){
                System.err.println(e);

            }
            if (id_==0) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Cet IMEI n'est pas enregistré");

                imei_retour.setText("");
                imei_retour.requestFocusInWindow();

            }
            else  if (bl !="")
            {
                String Etat="";
                /*String code=imei1.getText();
                if (code.equals("REP-IMPOSSIBLE")){
                    Etat="Impossible";
                }
                else if (code.equals("REP-LM")){
                    Etat="Localisé";
                }*/

                if (status.equals("LM")){
                    code="REP-LOCA";
                    Etat="Refusé";
                }
                else if (status.equals("IMPOSSIBLE")){
                    code="REP-IMPOSSIBLE";
                    Etat="Refusé";
                }
                else if (status.equals("DEJA_SWAP")){
                    code="REP-IMPOSSIBLE";
                    Etat="Refusé";
                }
                else if (status.equals("INCORRECT")){
                    code="REP-IMPOSSIBLE";
                    Etat="Refusé";
                }
                else if (status.equals("HS")){
                    code="REP-IMPOSSIBLE";
                    Etat="Refusé";
                }

                String requete="INSERT into réparation (N_REP, ID, IMEI_NEW, Etat, Prix, CodeAPPLE, Opérateur, N_BL)"
                + " VALUES ('"+id_+"','"+id_+"','"+imei_ori+"','"+Etat+"','0','"+code+"','"+bl+"','1')";
                //Eter la requête
                try{
                    stm=maConnexion.get_connexion().createStatement();
                    // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
                    stm.executeUpdate(requete);
                    //JOptionPane.showMessageDialog(null,"le nouveau Enregistrement est ajouté");
                    //code.setText("");
                    imei_retour.setText("");
                    imei_retour.requestFocusInWindow();
                    //operateur.setText("");
                }
                catch(SQLException e){
                    System.err.println(e);
                }

            }
            else {
                java.awt.Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Cet IMEI a déjà été scanné");
                imei_retour.setText("");
                imei_retour.requestFocusInWindow();
            }
        }
        Compteur_Insertion();
        //  cp.setText("");
        my.setEnabled(false);

    }//GEN-LAST:event_imei_retourActionPerformed

    private void imei_retourKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imei_retourKeyPressed
        // TODO add your handling code here:
        /*if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            imei.requestFocusInWindow();
        }*/

    }//GEN-LAST:event_imei_retourKeyPressed

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
            java.util.logging.Logger.getLogger(JFrameSaisie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameSaisie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameSaisie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameSaisie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameSaisie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField code_retour;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField imei;
    private javax.swing.JTextField imei_retour;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField my;
    private javax.swing.JTextField n_rep;
    private javax.swing.JTextField operateur;
    // End of variables declaration//GEN-END:variables
}