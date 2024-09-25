/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.admin.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import utp.restaurant.admin.controller.PreviewAdminViewController;
import utp.restaurant.login.view.LoginView;

/**
 *
 * @author PC
 */
public class PreviewAdminView extends javax.swing.JFrame {

    private Register register;
    private TableRegisterView tableRegisterView;
    private RoleRegisterView roleRegisterView;
    private ItemMenuRegisterView itemMenuRegisterView;
    private CategoryRegisterView categoryRegisterView;
    private CustomerRegisterView customerRegisterView;
    private PreviewAdminViewController previewAdminViewController;
    
    public PreviewAdminView() {
        
        register = new Register();
        tableRegisterView = new TableRegisterView();
        roleRegisterView = new RoleRegisterView();
        itemMenuRegisterView = new ItemMenuRegisterView();
        categoryRegisterView = new CategoryRegisterView();
        customerRegisterView = new CustomerRegisterView();
        
        previewAdminViewController = new PreviewAdminViewController(this);
        
        initComponents();
        
        previewAdminViewController.getUser();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLBuser = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLBplatillo = new javax.swing.JLabel();
        jLBemployee = new javax.swing.JLabel();
        jLBrol = new javax.swing.JLabel();
        jLBcliente = new javax.swing.JLabel();
        jLBmesa = new javax.swing.JLabel();
        jLBcategoria = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLBuser.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLBuser.setForeground(new java.awt.Color(86, 42, 35));
        jPanel1.add(jLBuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLBplatillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cardPlatillo.png"))); // NOI18N
        jLBplatillo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBplatillo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBplatilloMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBplatilloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBplatilloMouseExited(evt);
            }
        });
        jPanel2.add(jLBplatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 180, 210));

        jLBemployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cardEmpleado.png"))); // NOI18N
        jLBemployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBemployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBemployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBemployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBemployeeMouseExited(evt);
            }
        });
        jPanel2.add(jLBemployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 180, 210));

        jLBrol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cardRol.png"))); // NOI18N
        jLBrol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBrol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBrolMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBrolMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBrolMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLBrolMousePressed(evt);
            }
        });
        jPanel2.add(jLBrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 180, 210));

        jLBcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cardCliente.png"))); // NOI18N
        jLBcliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBclienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBclienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBclienteMouseExited(evt);
            }
        });
        jPanel2.add(jLBcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 180, 210));

        jLBmesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cardMesa.png"))); // NOI18N
        jLBmesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBmesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBmesaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBmesaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBmesaMouseExited(evt);
            }
        });
        jPanel2.add(jLBmesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 180, 210));

        jLBcategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/cardCategoria.png"))); // NOI18N
        jLBcategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLBcategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBcategoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBcategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBcategoriaMouseExited(evt);
            }
        });
        jPanel2.add(jLBcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 180, 210));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1280, 460));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerPreview.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText(" Explora las opciones a continuación para realizar tareas, optimizar procesos y asegurar el éxito en cada área de gestión.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 740, 30));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("CERRAR SESION");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 190, -1, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 42, 35));
        jLabel4.setText("Bienvenid@ ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLBplatilloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBplatilloMouseClicked
        itemMenuRegisterView.renderCBCategory();
        itemMenuRegisterView.setVisible(true);
    }//GEN-LAST:event_jLBplatilloMouseClicked

    private void jLBemployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBemployeeMouseClicked
        register.renderCBRole();
        register.setVisible(true);
    }//GEN-LAST:event_jLBemployeeMouseClicked

    private void jLBrolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBrolMouseClicked
        roleRegisterView.setVisible(true);
    }//GEN-LAST:event_jLBrolMouseClicked

    private void jLBclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBclienteMouseClicked
        customerRegisterView.setVisible(true);
    }//GEN-LAST:event_jLBclienteMouseClicked

    private void jLBmesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBmesaMouseClicked
        tableRegisterView.renderCBWaiter();
        tableRegisterView.setVisible(true);
    }//GEN-LAST:event_jLBmesaMouseClicked

    private void jLBcategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBcategoriaMouseClicked
        categoryRegisterView.setVisible(true);
    }//GEN-LAST:event_jLBcategoriaMouseClicked

    private void jLBrolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBrolMousePressed
        
    }//GEN-LAST:event_jLBrolMousePressed

    private void jLBrolMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBrolMouseEntered
        jLBrol.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "carRolSombra.png")));
    }//GEN-LAST:event_jLBrolMouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LoginView loginView = new LoginView();
        
        loginView.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLBrolMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBrolMouseExited
        jLBrol.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardRol.png")));
    }//GEN-LAST:event_jLBrolMouseExited

    private void jLBemployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBemployeeMouseEntered
        jLBemployee.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardEmpleadoSombra.png")));
    }//GEN-LAST:event_jLBemployeeMouseEntered

    private void jLBemployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBemployeeMouseExited
        jLBemployee.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardEmpleado.png")));
    }//GEN-LAST:event_jLBemployeeMouseExited

    private void jLBclienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBclienteMouseEntered
        jLBcliente.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardClienteSombra.png")));
    }//GEN-LAST:event_jLBclienteMouseEntered

    private void jLBclienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBclienteMouseExited
        jLBcliente.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardCliente.png")));
    }//GEN-LAST:event_jLBclienteMouseExited

    private void jLBmesaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBmesaMouseEntered
        jLBmesa.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardMesaSombra.png")));
    }//GEN-LAST:event_jLBmesaMouseEntered

    private void jLBmesaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBmesaMouseExited
        jLBmesa.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardMesa.png")));
    }//GEN-LAST:event_jLBmesaMouseExited

    private void jLBcategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBcategoriaMouseEntered
        jLBcategoria.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardCategorySombra.png")));
    }//GEN-LAST:event_jLBcategoriaMouseEntered

    private void jLBcategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBcategoriaMouseExited
        jLBcategoria.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardCategoria.png")));
    }//GEN-LAST:event_jLBcategoriaMouseExited

    private void jLBplatilloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBplatilloMouseEntered
        jLBplatillo.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardPlatilloSombra.png")));
    }//GEN-LAST:event_jLBplatilloMouseEntered

    private void jLBplatilloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBplatilloMouseExited
        jLBplatillo.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/" + "cardPlatillo.png")));
    }//GEN-LAST:event_jLBplatilloMouseExited

    public JLabel getjLBuser() {
        return jLBuser;
    }

    public void setjLBuser(JLabel jLBuser) {
        this.jLBuser = jLBuser;
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
            java.util.logging.Logger.getLogger(PreviewAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreviewAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreviewAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreviewAdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreviewAdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLBcategoria;
    private javax.swing.JLabel jLBcliente;
    private javax.swing.JLabel jLBemployee;
    private javax.swing.JLabel jLBmesa;
    private javax.swing.JLabel jLBplatillo;
    private javax.swing.JLabel jLBrol;
    private javax.swing.JLabel jLBuser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
