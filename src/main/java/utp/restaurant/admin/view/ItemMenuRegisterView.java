/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.admin.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import utp.restaurant.admin.controller.ItemMenuController;
import utp.restaurant.model.Category;
import utp.restaurant.utils.ImgTable;

/**
 *
 * @author PC
 */
public class ItemMenuRegisterView extends javax.swing.JFrame {

    private ItemMenuController itemMenuController;
    private int row;

    public ItemMenuRegisterView() {
        itemMenuController = new ItemMenuController(this);

        initComponents();
        renderTable();
    }

    public void renderTable() {
        DefaultTableModel tableModel = itemMenuController.getTableModel();
        jTItemMenuList.setRowHeight(100);
        jTItemMenuList.setModel(tableModel);
        
        jTItemMenuList.getColumnModel().getColumn(6).setCellRenderer(new ImgTable());

        TableColumnModel tcm = jTItemMenuList.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));

    }
    
    public void renderCBCategory() {
        itemMenuController.renderCBCate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTFname = new javax.swing.JTextField();
        jTFdescription = new javax.swing.JTextField();
        jTFprice = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jCBstatus1 = new javax.swing.JComboBox<>();
        jcate = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFimage = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLBmostrar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTItemMenuList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFname.setBackground(new java.awt.Color(249, 242, 228));
        jTFname.setForeground(new java.awt.Color(51, 51, 51));
        jTFname.setBorder(null);
        jTFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFnameActionPerformed(evt);
            }
        });
        jPanel2.add(jTFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 30));

        jTFdescription.setBackground(new java.awt.Color(249, 242, 228));
        jTFdescription.setForeground(new java.awt.Color(51, 51, 51));
        jTFdescription.setBorder(null);
        jPanel2.add(jTFdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 420, 30));

        jTFprice.setBackground(new java.awt.Color(249, 242, 228));
        jTFprice.setForeground(new java.awt.Color(51, 51, 51));
        jTFprice.setBorder(null);
        jPanel2.add(jTFprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 200, 30));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 12));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 200, 20));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 420, 12));

        jLabel16.setBackground(new java.awt.Color(86, 42, 35));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("NOMBRE");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("CATEGORIA");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 20));

        jLabel13.setBackground(new java.awt.Color(86, 42, 35));
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("DESCRIPCION");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("PRECIO");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 20));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("ESTADO");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 50, 20));

        jCBstatus1.setBackground(new java.awt.Color(249, 242, 228));
        jCBstatus1.setForeground(new java.awt.Color(51, 51, 51));
        jCBstatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Agotado", " " }));
        jCBstatus1.setBorder(null);
        jPanel2.add(jCBstatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 200, 30));

        jcate.setBackground(new java.awt.Color(249, 242, 228));
        jcate.setForeground(new java.awt.Color(51, 51, 51));
        jcate.setBorder(null);
        jPanel2.add(jcate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 102, 180, 30));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("IMAGEN");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 30));

        jButton5.setBackground(new java.awt.Color(86, 42, 35));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(249, 242, 228));
        jButton5.setText("EXPLORAR");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 290, 30));

        jLabel1.setText("Imagen Seleccionada");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        jTFimage.setEditable(false);
        jTFimage.setBackground(new java.awt.Color(249, 242, 228));
        jTFimage.setForeground(new java.awt.Color(51, 51, 51));
        jTFimage.setBorder(null);
        jPanel2.add(jTFimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 290, 20));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 290, 10));
        jPanel2.add(jLBmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 290, 110));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 760, 220));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTItemMenuList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTItemMenuList.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTItemMenuListAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTItemMenuList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTItemMenuListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTItemMenuList);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 300));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 730, 320));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 670, 104, -1));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 670, 104, 30));

        jButton3.setBackground(new java.awt.Color(86, 42, 35));
        jButton3.setForeground(new java.awt.Color(249, 242, 228));
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 670, 104, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerItemMenu.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Completa la información de los platillos");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 270, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Registro de los platillos!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        itemMenuController.handleRegisterClick();

    }//GEN-LAST:event_jButton1ActionPerformed

    public ItemMenuController getItemMenuController() {
        return itemMenuController;
    }

    public void setItemMenuController(ItemMenuController itemMenuController) {
        this.itemMenuController = itemMenuController;
    }

    public int getRow() {
        return row;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(rootPane, message);
    }

    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(rootPane, message);
    }


    private void jTItemMenuListAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTItemMenuListAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTItemMenuListAncestorAdded

    private void jTFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFnameActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        itemMenuController.handleCleanForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        itemMenuController.heandleDeleteClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTItemMenuListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTItemMenuListMouseClicked
        row = jTItemMenuList.rowAtPoint(evt.getPoint());

        itemMenuController.heandleViewEditClick();        // TODO add your handling code here:
    }//GEN-LAST:event_jTItemMenuListMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        itemMenuController.heandleExplorerClick();
    }//GEN-LAST:event_jButton5ActionPerformed

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjLBmostrar(JLabel jLBmostrar) {
        this.jLBmostrar = jLBmostrar;
    }

    public void setjTFimage(JTextField jTFimage) {
        this.jTFimage = jTFimage;
    }

    public JTextField getjTFimage() {
        return jTFimage;
    }

    public JLabel getjLBmostrar() {
        return jLBmostrar;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JComboBox<String> getjCBstatus1() {
        return jCBstatus1;
    }

    public void setjCBstatus1(JComboBox<String> jCBstatus1) {
        this.jCBstatus1 = jCBstatus1;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JSeparator jSeparator3) {
        this.jSeparator3 = jSeparator3;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public void setjSeparator5(JSeparator jSeparator5) {
        this.jSeparator5 = jSeparator5;
    }

    public JSeparator getjSeparator6() {
        return jSeparator6;
    }

    public void setjSeparator6(JSeparator jSeparator6) {
        this.jSeparator6 = jSeparator6;
    }

    public JTextField getjTFdescription() {
        return jTFdescription;
    }

    public void setjTFdescription(JTextField jTFdescription) {
        this.jTFdescription = jTFdescription;
    }

    public JTextField getjTFname() {
        return jTFname;
    }

    public void setjTFname(JTextField jTFname) {
        this.jTFname = jTFname;
    }

    public JTextField getjTFprice() {
        return jTFprice;
    }

    public void setjTFprice(JTextField jTFprice) {
        this.jTFprice = jTFprice;
    }

    public JTable getjTItemMenuList() {
        return jTItemMenuList;
    }

    public void setjTItemMenuList(JTable jTItemMenuList) {
        this.jTItemMenuList = jTItemMenuList;
    }

    public JComboBox<Category> getJcate() {
        return jcate;
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
            java.util.logging.Logger.getLogger(ItemMenuRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemMenuRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemMenuRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemMenuRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemMenuRegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jCBstatus1;
    private javax.swing.JLabel jLBmostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTFdescription;
    private javax.swing.JTextField jTFimage;
    private javax.swing.JTextField jTFname;
    private javax.swing.JTextField jTFprice;
    private javax.swing.JTable jTItemMenuList;
    private javax.swing.JComboBox<Category> jcate;
    // End of variables declaration//GEN-END:variables

}
