/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.chef.view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.chef.controller.OrderChefController;

/**
 *
 * @author dalia
 */
public class OrderChefView extends javax.swing.JFrame {

    public OrderChefController orderChefController;
    int row;
    
    public OrderChefView() {
        initComponents();
        orderChefController  = new OrderChefController(this);
        renderTable();
        
        jBTNdetails.setEnabled(false);
    }
    public void renderTable(){
        DefaultTableModel tableModel = orderChefController.getTableModel();
        jTorder.setRowHeight(40);
        jTorder.setModel(tableModel);
        
        TableColumnModel tcm = jTorder.getColumnModel();
       tcm.removeColumn(tcm.getColumn(0));
        
    }
    
    public void callManageButton() {
        orderChefController.manageButtonDetails();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTorder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jBTNdetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTorderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTorder);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 470));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 123, 740, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerVerPedido2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Ver Pedidos!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Actualiza el estado del pedido.");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 310, 30));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("ATRAS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, 104, 30));

        jBTNdetails.setBackground(new java.awt.Color(86, 42, 35));
        jBTNdetails.setForeground(new java.awt.Color(249, 242, 228));
        jBTNdetails.setText("VER DETALLES");
        jBTNdetails.setBorder(null);
        jBTNdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNdetailsActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jBTNdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNdetailsActionPerformed
        
        OrderChefDetails orderChefDetails = new OrderChefDetails(this, true);
        orderChefDetails.setRoot(this);
        orderChefDetails.setId(Long.parseLong(jTorder.getModel().getValueAt(row, 0).toString()));
        
        orderChefDetails.setAtributtes();
        orderChefDetails.renderTable();
        
        orderChefDetails.setVisible(true);
        
    }//GEN-LAST:event_jBTNdetailsActionPerformed

    private void jTorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTorderMouseClicked
        row = jTorder.rowAtPoint(evt.getPoint());
        
        orderChefController.manageButtonDetails();
    }//GEN-LAST:event_jTorderMouseClicked

    public JButton getjBTNdetails() {
        return jBTNdetails;
    }

    public JTable getjTorder() {
        return jTorder;
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
            java.util.logging.Logger.getLogger(OrderChefView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderChefView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderChefView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderChefView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderChefView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTNdetails;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTorder;
    // End of variables declaration//GEN-END:variables
}
