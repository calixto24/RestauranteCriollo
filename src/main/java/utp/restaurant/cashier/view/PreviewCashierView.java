/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.cashier.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import utp.restaurant.cashier.controller.PreviewCashierController;
import utp.restaurant.login.view.LoginView;

/**
 *
 * @author JHORDAN
 */
public class PreviewCashierView extends javax.swing.JFrame {

    private PreviewCashierController previewCashierController;
    
    public PreviewCashierView() {
        
        previewCashierController = new PreviewCashierController(this);
        
        initComponents();
        
        previewCashierController.getUser();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLBuser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLBVerPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("CERRAR SESION");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 16, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerCashier.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jLBuser.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLBuser.setForeground(new java.awt.Color(86, 42, 35));
        jPanel1.add(jLBuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 690, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 42, 35));
        jLabel4.setText("Bienvenid@ ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 290, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Explora las opciones para finalizar los pedidos, asegurando una atención eficiente.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 660, 30));

        jLBVerPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cards/cardVerPedidos.png"))); // NOI18N
        jLBVerPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBVerPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBVerPedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBVerPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBVerPedidosMouseExited(evt);
            }
        });
        jPanel1.add(jLBVerPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, -1, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LoginView loginView = new LoginView();

        loginView.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLBVerPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBVerPedidosMouseClicked

        OrderView orderView = new OrderView();
        
        orderView.setVisible(true);

    }//GEN-LAST:event_jLBVerPedidosMouseClicked

    private void jLBVerPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBVerPedidosMouseEntered
        jLBVerPedidos.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/cards/" + "cardVerPedidosSombra.png")));
    }//GEN-LAST:event_jLBVerPedidosMouseEntered

    private void jLBVerPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBVerPedidosMouseExited
        jLBVerPedidos.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/cards/" + "cardVerPedidos.png")));
    }//GEN-LAST:event_jLBVerPedidosMouseExited

    public JLabel getjLBuser() {
        return jLBuser;
    }
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
            java.util.logging.Logger.getLogger(PreviewCashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreviewCashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreviewCashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreviewCashierView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreviewCashierView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLBVerPedidos;
    private javax.swing.JLabel jLBuser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
