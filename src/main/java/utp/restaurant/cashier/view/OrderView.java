/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.cashier.view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.cashier.controller.OrderController;

/**
 *
 * @author JHORDAN
 */
public class OrderView extends javax.swing.JFrame {

    private OrderController orderController;
    private int row;
    
    public OrderView() {
        
        orderController = new OrderController(this);
        initComponents();
        
        renderTable();
        
        jBTNvoucher.setEnabled(false);
    }
    
    public void renderTable() {
        
        DefaultTableModel tableModel = orderController.getTableModel();
        jTorder.setRowHeight(40);
        jTorder.setModel(tableModel);
        
        TableColumnModel tcm = jTorder.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        
    }

    public JButton getjBTNvoucher() {
        return jBTNvoucher;
    }

    public JTable getjTorder() {
        return jTorder;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTorder = new javax.swing.JTable();
        jBTNvoucher = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 480));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 710, 510));

        jBTNvoucher.setBackground(new java.awt.Color(86, 42, 35));
        jBTNvoucher.setForeground(new java.awt.Color(249, 242, 228));
        jBTNvoucher.setText("CREAR COMPROBANTE");
        jBTNvoucher.setBorder(null);
        jBTNvoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNvoucherActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNvoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, 190, 50));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("ATRAS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, 104, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerVerPedido.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 720));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Ver Pedidos!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Gestiona los pedidos hechos por los clientes, asegurando una atencion eficiente.");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 500, 30));

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

    private void jBTNvoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNvoucherActionPerformed
        orderController.handleClick();
    }//GEN-LAST:event_jBTNvoucherActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTorderMouseClicked
        row = jTorder.rowAtPoint(evt.getPoint());
        
        orderController.manageButtonVoucher();
    }//GEN-LAST:event_jTorderMouseClicked

    public int getRow() {
        return row;
    }
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
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTNvoucher;
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
