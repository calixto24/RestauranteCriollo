/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.cashier.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.controller.VoucherDetailsController;

/**
 *
 * @author JHORDAN
 */
public class VoucherDetailsView extends javax.swing.JFrame {

    private VoucherDetailsController voucherDetailsController;
    private int row;
    private String typeVoucher;
    
    public VoucherDetailsView() {
        voucherDetailsController = new VoucherDetailsController(this);
        
        initComponents();
        
        renderTable();
    }

    public void renderTable() {
        
        DefaultTableModel tableModel = null;
        
        typeVoucher = jCBTypeDocument.getSelectedItem().toString();
        
        if(typeVoucher.equals("Boleta")) {
            
            tableModel = voucherDetailsController.getTableModelTicket();
            
        } else if (typeVoucher.equals("Factura")) {
            
            tableModel = voucherDetailsController.getTableModelBill();
            
        }
        
        jTTypeVoucher.setRowHeight(40);
        jTTypeVoucher.setModel(tableModel);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCBTypeDocument = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTypeVoucher = new javax.swing.JTable();
        jBTNvoucher = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerCocinero.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Ver Comprobantes!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Visualiza los comprobantes hechos por los clientes, asegurando una atencion eficiente.");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 500, 30));

        jCBTypeDocument.setBackground(new java.awt.Color(249, 242, 228));
        jCBTypeDocument.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBTypeDocument.setForeground(new java.awt.Color(86, 42, 35));
        jCBTypeDocument.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura" }));
        jCBTypeDocument.setBorder(null);
        jCBTypeDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTypeDocumentActionPerformed(evt);
            }
        });
        jPanel1.add(jCBTypeDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 430, 30));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("TIPO DE COMPROBANTE");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 240, 20));

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTTypeVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTTypeVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTypeVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTTypeVoucher);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 440));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 730, 460));

        jBTNvoucher.setBackground(new java.awt.Color(86, 42, 35));
        jBTNvoucher.setForeground(new java.awt.Color(249, 242, 228));
        jBTNvoucher.setText("VER DETALLES");
        jBTNvoucher.setBorder(null);
        jBTNvoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNvoucherActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNvoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, 190, 50));

        jButton3.setBackground(new java.awt.Color(86, 42, 35));
        jButton3.setForeground(new java.awt.Color(249, 242, 228));
        jButton3.setText("ATRAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 23, 70, 30));

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

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }
    
    private void jCBTypeDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTypeDocumentActionPerformed
        renderTable();
    }//GEN-LAST:event_jCBTypeDocumentActionPerformed

    private void jBTNvoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNvoucherActionPerformed
        voucherDetailsController.handleViewDetailsClick(row, typeVoucher);
    }//GEN-LAST:event_jBTNvoucherActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTTypeVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTypeVoucherMouseClicked
        row = jTTypeVoucher.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_jTTypeVoucherMouseClicked

    public JButton getjBTNvoucher() {
        return jBTNvoucher;
    }

    public JComboBox<String> getjCBTypeDocument() {
        return jCBTypeDocument;
    }

    public JTable getjTTypeVoucher() {
        return jTTypeVoucher;
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
            java.util.logging.Logger.getLogger(VoucherDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoucherDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoucherDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoucherDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoucherDetailsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTNvoucher;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBTypeDocument;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTTypeVoucher;
    // End of variables declaration//GEN-END:variables
}
