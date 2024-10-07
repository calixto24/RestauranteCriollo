/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.cashier.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.controller.VoucherController;
import utp.restaurant.model.Customer;
import utp.restaurant.model.Order;
import utp.restaurant.utils.ImgTable;

/**
 *
 * @author JHORDAN
 */
public class VoucherView extends javax.swing.JFrame {

    private VoucherController voucherController;
    
    public VoucherView() {
        
        voucherController = new VoucherController(this);
        
        initComponents();
    }
    
    public void setOrder(Order order) {
        
        voucherController.setOrder(order);
        voucherController.setAtributtes();
        
    }
    
    public void renderCBCustomer() {
        voucherController.renderCBCustomer();
    }
    
    public void renderTable() {
        
        DefaultTableModel tableModel = voucherController.getTableModel();
        jTItemOrder.setRowHeight(100);
        jTItemOrder.setModel(tableModel);
        
        jTItemOrder.getColumnModel().getColumn(1).setCellRenderer(new ImgTable());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCBcustomer = new javax.swing.JComboBox<>();
        jCBTypeDocument = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTItemOrder = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLBnumerTable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCBpaymentType = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTFsubTotal = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCBcustomer.setBackground(new java.awt.Color(249, 242, 228));
        jCBcustomer.setForeground(new java.awt.Color(86, 42, 35));
        jCBcustomer.setBorder(null);
        jPanel2.add(jCBcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 370, 30));

        jCBTypeDocument.setBackground(new java.awt.Color(249, 242, 228));
        jCBTypeDocument.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBTypeDocument.setForeground(new java.awt.Color(86, 42, 35));
        jCBTypeDocument.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Boleta" }));
        jCBTypeDocument.setBorder(null);
        jPanel2.add(jCBTypeDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 430, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/btnAnadir.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, 60));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("CLIENTE");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jLabel23.setBackground(new java.awt.Color(86, 42, 35));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(86, 42, 35));
        jLabel23.setText("TIPO DE DOCUMENTO");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 490, 310));

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTItemOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTItemOrder);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, 710, 270));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 42, 35));
        jLabel5.setText("DETALLES");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLBnumerTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLBnumerTable.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jLBnumerTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 100, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(86, 42, 35));
        jLabel7.setText("NUMERO DE MESA:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 720, 310));

        jPanel4.setBackground(new java.awt.Color(249, 242, 228));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCBpaymentType.setBackground(new java.awt.Color(249, 242, 228));
        jCBpaymentType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBpaymentType.setForeground(new java.awt.Color(86, 42, 35));
        jCBpaymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));
        jCBpaymentType.setBorder(null);
        jPanel4.add(jCBpaymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 430, 40));

        jLabel17.setBackground(new java.awt.Color(86, 42, 35));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(86, 42, 35));
        jLabel17.setText("VUELTO:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 20));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("METODO DE PAGO");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel22.setBackground(new java.awt.Color(86, 42, 35));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(86, 42, 35));
        jLabel22.setText("MONTO:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jTextField3.setEditable(false);
        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 70, 30));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 70, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 490, 190));

        jPanel5.setBackground(new java.awt.Color(249, 242, 228));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(86, 42, 35));
        jLabel9.setText("TOTAL:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("SUB TOTAL:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("DESCUENTO (%) :");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(86, 42, 35));
        jLabel14.setText("DESCUENTO:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("IGV:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        jTextField1.setEditable(false);
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 480, 30));

        jTFsubTotal.setEditable(false);
        jTFsubTotal.setEnabled(false);
        jTFsubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFsubTotalActionPerformed(evt);
            }
        });
        jPanel5.add(jTFsubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 480, 30));

        jTextField5.setEditable(false);
        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 480, 30));

        jTextField6.setEditable(false);
        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 480, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 480, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 720, 240));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("CANCELAR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 140, 40));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("FINALIZAR PAGO");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 140, 40));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("ATRAS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 104, 30));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("DETALLE DE VENTA");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, 20));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("DATOS DEL COMPROBANTE");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel24.setBackground(new java.awt.Color(86, 42, 35));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(86, 42, 35));
        jLabel24.setText("PAGO");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTFsubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFsubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFsubTotalActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        CustomerRegisterModalView customerRegisterModalView = new CustomerRegisterModalView(this, true);
        customerRegisterModalView.setRoot(this);
        
        customerRegisterModalView.viewDocument(jCBTypeDocument.getSelectedItem().toString());
        
        customerRegisterModalView.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        voucherController.handleFinishClick();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public JLabel getjLBnumerTable() {
        return jLBnumerTable;
    }

    public JComboBox<Customer> getjCBcustomer() {
        return jCBcustomer;
    }

    public JTextField getjTFsubTotal() {
        return jTFsubTotal;
    }

    public JComboBox<String> getjCBTypeDocument() {
        return jCBTypeDocument;
    }

    public JComboBox<String> getjCBpaymentType() {
        return jCBpaymentType;
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
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoucherView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCBTypeDocument;
    private javax.swing.JComboBox<Customer> jCBcustomer;
    private javax.swing.JComboBox<String> jCBpaymentType;
    private javax.swing.JLabel jLBnumerTable;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFsubTotal;
    private javax.swing.JTable jTItemOrder;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
