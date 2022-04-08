/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hangmangame;

import java.io.*;  
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
/**
 *
 * @author Csiki Akemi
 */
public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
//Ablak mérteének beállítása
        setSize(925,609); 
        setLocation(50,50);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kulcsos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtjelszo = new javax.swing.JPasswordField();
        txtemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(920, 580));
        getContentPane().setLayout(null);

        kulcsos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmangame/Lakatos_emberke.png"))); // NOI18N
        getContentPane().add(kulcsos);
        kulcsos.setBounds(89, 146, 250, 288);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email cím");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(377, 161, 142, 35);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jelszó");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(377, 251, 142, 32);

        txtjelszo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        getContentPane().add(txtjelszo);
        txtjelszo.setBounds(565, 253, 200, 32);

        txtemail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        getContentPane().add(txtemail);
        txtemail.setBounds(565, 163, 200, 35);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Bejelentkezes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(377, 448, 171, 62);

        jLabel4.setFont(new java.awt.Font("Gabriola", 3, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Akasztófa játék");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(281, 49, 335, 59);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmangame/background2.0.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 910, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Bejelentkezéshez szükséges Statement-ek és Connect-tek
        java.sql.Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
       try{
            //Kapcsolat az adatbázisal(webshopdatabase)
            con = DriverManager.getConnection("jdbc:mysql://localhost/webshopdatabase","root", ""); 
            String query = " SELECT * FROM user WHERE mail=? and jelszo=?"; 
            //Beviteli mezők aktiválása 
            pst = con.prepareStatement(query);
            pst.setString(1,txtemail.getText());
            pst.setString(2,txtjelszo.getText());
            rs = pst.executeQuery();
            
            //Sikeres  adatbázis kapcsolat és lekérdezés
            if(rs.next()){  
                //Változók létrehozás az adatbázis alapján
                String mail =(rs.getString("mail")); 
                String jelszo =(rs.getString("jelszo"));
                //Globális változó a mail-re
                Mail.mail = mail;
                System.out.println(mail);  
                //Jelszo és email cím validáció Sikeres
                if(jelszo.equals(jelszo) && mail.equals(mail)){
                    try{
                    //A user email mezőjéhez kapcsolodó utolsó játék dátumának kiválasztása
                    stmt = con.prepareStatement (" SELECT last_game FROM user WHERE mail=? ");
                    stmt.setString(1, rs.getString("mail"));
                    ResultSet result=stmt.executeQuery();
                    Date myEndDate = null;
                    while(result.next())
                        myEndDate = result.getDate("last_game"); //KIOLVASOM ÉS VÁLTOZÓBA MENTEM A LAST_GAME DÁTUMÁT           
                    //Dátumvizsgálat
                    //https://www.baeldung.com/java-period-duration?fbclid=IwAR2axXo_ObrJXan1fEPB8UXMsQOLAvXcsIwUSHlKmLxT9Kjuy5dXHYZ5xUA#period-class
                    LocalDate startDate = LocalDate.now(); //AKTUÁLIS IDŐ
                    LocalDate endDate = LocalDate.parse(String.valueOf(myEndDate)); // -> LAST_GAME
                    Period period = Period.between(startDate, endDate); //A KETTŐ KÖZTI KÜLÖNBSÉG
                    System.out.println(period.getDays());
                    //Dátum vizgsálat megfelelő eredménnyel (Utolsó játék óta eletelt napok száma: 5 )
                    if(period.getDays() > +4){
                        System.out.println("5 naptól 5-el több. Játszhatsz!");  //DEBUG
                        //Hozzáad egy mai dátumot a LAST_GAME oszlophoz ahol az EMAIL = belépő EMAIL-el
                        stmt = con.prepareStatement (" UPDATE user SET last_game=? WHERE mail=? ");
                        LocalDateTime localDateTime = LocalDateTime.now();
                        java.sql.Date last_game = java.sql.Date.valueOf(localDateTime.toLocalDate());
                        java.sql.Time time = java.sql.Time.valueOf(localDateTime.toLocalTime());
                        stmt.setDate(1, last_game);
                        stmt.setString(2, rs.getString("mail"));
                        stmt.executeUpdate();
                        System.out.println(last_game);
                        new login().setVisible(false);
                        TheGame g=new TheGame();
                        g.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sikeres bejelentkezés");
                    //Dátum vizgsálat megfelelő eredménnyel (Utolsó játék óta eletelt napok száma: 5 )                     
                    }else if(period.getDays() < -4){
                        System.out.println("5 naptól 5-el kevesebb. Játszhatsz!");
                        //Hozzáad egy mai dátumot a LAST_GAME oszlophoz ahol az EMAIL = belépő EMAIL-el
                        stmt = con.prepareStatement (" UPDATE user SET last_game=? WHERE mail=? ");
                        LocalDateTime localDateTime = LocalDateTime.now();
                        java.sql.Date last_game = java.sql.Date.valueOf(localDateTime.toLocalDate());
                        java.sql.Time time = java.sql.Time.valueOf(localDateTime.toLocalTime());
                        stmt.setDate(1, last_game);
                        stmt.setString(2, rs.getString("mail"));
                        stmt.executeUpdate();
                        new login().setVisible(false);
                        TheGame g=new TheGame();
                        g.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sikeres bejelentkezés");
                        //con.close();      
                    //Dátum vizgsálat NEM megfelelő eredménnyel (Utolsó játék óta eletelt napok száma: kevesebb mint 5 nap)   
                    }else{
                        System.out.println("5 naptól 5-el se több se kevesebb. Nem játszhatsz!");
                        //new login().setVisible(false);
                        JOptionPane.showMessageDialog(null, "Kevesebb mint öt napja játszottál!");   
                       TheGame g=new TheGame(); //Azért raktam bele mert nem engedett be és így tudom csinálni a pótszámlálást
                       g.setVisible(true);
                    }

                    }catch (SQLException e) {
                    e.printStackTrace();
                    
                        } 
                } 
            //Jelszo és email cím validáció Sikertelen
            }else{
            JOptionPane.showMessageDialog(null, "Sikertelen bejelentkezés, Próbáld újra!");
            new login().setVisible(true);
            txtemail.setText(" ");
            txtjelszo.setText(" ");
            }
            con.close();    
       }catch (SQLException e) {
         e.printStackTrace();
      }
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel kulcsos;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtjelszo;
    // End of variables declaration//GEN-END:variables

    
}
