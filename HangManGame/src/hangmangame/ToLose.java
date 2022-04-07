/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

/**
 *
 * @author Akemi
 */
public class ToLose extends javax.swing.JFrame {

    public ToLose() {
        initComponents();      
        initComponents();
        setSize(705,478); //Jobb oldalt és alul
        setLocation(50,50);
        
        TheGame g=new TheGame();
                g.setVisible(false);
                g.dispose();
                g.setDefaultCloseOperation(TheGame.EXIT_ON_CLOSE);
                
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Szöveg = new javax.swing.JLabel();
        Címsor = new javax.swing.JLabel();
        Háttérkép = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Kilépés");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 360, 140, 50);

        Szöveg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmangame/szöveg2.jpg"))); // NOI18N
        Szöveg.setText("jLabel2");
        Szöveg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(Szöveg);
        Szöveg.setBounds(140, 140, 400, 170);

        Címsor.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Címsor.setForeground(new java.awt.Color(255, 255, 255));
        Címsor.setText("Vesztettél!");
        getContentPane().add(Címsor);
        Címsor.setBounds(250, 10, 200, 94);

        Háttérkép.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangmangame/background2.0.jpg"))); // NOI18N
        Háttérkép.setText("Kedves játékos! \nKöszönjük a részvételt , öt nap múlva újra tud játszani egy újabb  esélyel,\nhogy megnyerhese az ingenyes házhoz szállítást megvásárolni kívánttermékeihez.  \n\nHardWareshop");
        Háttérkép.setToolTipText("");
        Háttérkép.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        getContentPane().add(Háttérkép);
        Háttérkép.setBounds(0, 0, 690, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*ToLose tl=new ToLose();
                tl.setVisible(false);
                tl.dispose();
                tl.setDefaultCloseOperation(ToLose.EXIT_ON_CLOSE);*/
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ToLose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToLose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToLose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToLose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToLose().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Címsor;
    private javax.swing.JLabel Háttérkép;
    private javax.swing.JLabel Szöveg;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
