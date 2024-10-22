/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.chef.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.chef.controller.SourcesController;
import utp.restaurant.utils.ImgTable;

public class SourcersView extends javax.swing.JFrame {

    SourcesController sourcesController;
    int row;

    public SourcersView() {
        sourcesController = new SourcesController(this);
        initComponents();
        Rendertable();
        
        jBTNStatus.setEnabled(false);

    }

    public void Rendertable() {
        DefaultTableModel tableModel = sourcesController.defaultTableModel();

        JTSources.setRowHeight(100);
        JTSources.setModel(tableModel);
        JTSources.getColumnModel().getColumn(5).setCellRenderer(new ImgTable());

        TableColumnModel tcm = JTSources.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTSources = new javax.swing.JTable();
        jBTNStatus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTSources.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTSources.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTSources.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTSourcesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTSources);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 710, 470));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 730, 490));

        jBTNStatus.setBackground(new java.awt.Color(86, 42, 35));
        jBTNStatus.setForeground(new java.awt.Color(249, 242, 228));
        jBTNStatus.setText("VER ESTADO");
        jBTNStatus.setBorder(null);
        jBTNStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, 140, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerVerPlatillos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Platillos!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Completa la información del estado del platillo.");
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

    private void jBTNStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNStatusActionPerformed

        SourcesDetails sourcesDetails = new SourcesDetails(this, true);
        sourcesDetails.setRoot(this);

        sourcesDetails.setId(Long.parseLong(JTSources.getModel().getValueAt(row, 0).toString()));
        sourcesDetails.setAtributtes();

        sourcesDetails.setVisible(true);
        
        Rendertable();

    }//GEN-LAST:event_jBTNStatusActionPerformed

    private void JTSourcesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTSourcesMouseClicked

        row = JTSources.rowAtPoint(evt.getPoint());
        
        jBTNStatus.setEnabled(true);

    }//GEN-LAST:event_JTSourcesMouseClicked

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
            java.util.logging.Logger.getLogger(SourcersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SourcersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SourcersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SourcersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SourcersView().setVisible(true);
            }
        });
    }

    public int getRow() {
        return row;
    }

    public JTable getJTSources() {
        return JTSources;
    }

    public JButton getjBTNStatus() {
        return jBTNStatus;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTSources;
    private javax.swing.JButton jBTNStatus;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
