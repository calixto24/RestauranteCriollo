/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package utp.restaurant.chef.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.model.ItemMenu;

/**
 *
 * @author JHORDAN
 */
public class SourcesDetails extends javax.swing.JDialog {

    SourcersView root;
    ItemMenu itemMenu;
    ItemMenuDAO itemMenuDAO;
    
    public SourcesDetails(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        itemMenuDAO = new ItemMenuDAO();
        
        initComponents();
    }

    public void setRoot(SourcersView root) {
        this.root = root;
    }
    
    public void setId(long id) {
        
        itemMenu = itemMenuDAO.get(id);
        
    }
    
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }
    
    public void setAtributtes() {
        
        jLBnameMenu.setText(itemMenu.getName());
        jLBimageMenu.setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + itemMenu.getImage())));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLBimageMenu = new javax.swing.JLabel();
        jLBnameMenu = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCBstatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLBimageMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 350));

        jLBnameMenu.setBackground(new java.awt.Color(86, 42, 35));
        jLBnameMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLBnameMenu.setForeground(new java.awt.Color(86, 42, 35));
        jPanel1.add(jLBnameMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jLabel10.setBackground(new java.awt.Color(86, 42, 35));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(86, 42, 35));
        jLabel10.setText("ESTADO DEL PLATILLO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, 20));

        jCBstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Agotado" }));
        jPanel1.add(jCBstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 350, 40));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("ACTUALIZAR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 100, 40));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("CANCELAR");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String estado = jCBstatus.getSelectedItem().toString();
        
        try {
            
            itemMenu.setStatus(estado);
            itemMenuDAO.update(itemMenu);
            
            showMessage("Estado actualizado correctamente");
            
            root.getjBTNStatus().setEnabled(false);
            dispose();
            
        } catch (Exception e) {
            
            showMessage("Estado no actualizado");
            
        }
        
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SourcesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SourcesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SourcesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SourcesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SourcesDetails dialog = new SourcesDetails(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBstatus;
    private javax.swing.JLabel jLBimageMenu;
    private javax.swing.JLabel jLBnameMenu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
