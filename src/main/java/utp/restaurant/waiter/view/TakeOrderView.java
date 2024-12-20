/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.waiter.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.model.Category;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;
import utp.restaurant.model.Table;
import utp.restaurant.utils.ImgTable;
import utp.restaurant.waiter.controller.TakeOrderController;

/**
 *
 * @author cristian :D
 */
public class TakeOrderView extends javax.swing.JFrame {

    TakeOrderController takeOrderController;
    int row;
    int rowItemOrder;
    
    public TakeOrderView() {
     
        takeOrderController = new TakeOrderController(this);
        initComponents();
        
        renderItemOrderTable();
        
        renderTable();
        
        jBTNadd.setEnabled(false);
                
    }
    
    public TakeOrderView(Order order) {
     
        initComponents();
        takeOrderController = new TakeOrderController(this);
        
        takeOrderController.setAction("edit");
        takeOrderController.setOrder(order);
        
        renderItemOrderTable();
        renderTable();
        renderCBTable();
        renderCBCategory();
       
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
        jCBtable = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTsaucers = new javax.swing.JTable();
        jBTNeditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTorderList = new javax.swing.JTable();
        jBTNguardar = new javax.swing.JButton();
        jBTNeliminar = new javax.swing.JButton();
        jBTNadd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLBTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCBtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBtableActionPerformed(evt);
            }
        });
        jPanel1.add(jCBtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 230, 30));

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTsaucers.setBackground(new java.awt.Color(249, 242, 228));
        jTsaucers.setForeground(new java.awt.Color(51, 51, 51));
        jTsaucers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTsaucers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTsaucersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTsaucers);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 420));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 590, 440));

        jBTNeditar.setBackground(new java.awt.Color(86, 42, 35));
        jBTNeditar.setForeground(new java.awt.Color(249, 242, 228));
        jBTNeditar.setText("EDITAR");
        jBTNeditar.setBorder(null);
        jBTNeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNeditarActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNeditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 660, 80, 30));

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTorderList.setBackground(new java.awt.Color(249, 242, 228));
        jTorderList.setForeground(new java.awt.Color(51, 51, 51));
        jTorderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTorderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTorderListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTorderList);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 500));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 570, 520));

        jBTNguardar.setBackground(new java.awt.Color(86, 42, 35));
        jBTNguardar.setForeground(new java.awt.Color(249, 242, 228));
        jBTNguardar.setText("GUARDAR");
        jBTNguardar.setBorder(null);
        jBTNguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNguardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 90, 30));

        jBTNeliminar.setBackground(new java.awt.Color(86, 42, 35));
        jBTNeliminar.setForeground(new java.awt.Color(249, 242, 228));
        jBTNeliminar.setText("ELIMINAR");
        jBTNeliminar.setBorder(null);
        jBTNeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNeliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNeliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 660, 100, 30));

        jBTNadd.setBackground(new java.awt.Color(86, 42, 35));
        jBTNadd.setForeground(new java.awt.Color(249, 242, 228));
        jBTNadd.setText("AÑADIR");
        jBTNadd.setBorder(null);
        jBTNadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNaddActionPerformed(evt);
            }
        });
        jPanel1.add(jBTNadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, 80, 30));

        jLabel1.setBackground(new java.awt.Color(86, 42, 35));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(86, 42, 35));
        jLabel1.setText("LISTA DE PEDIDOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, 20));

        jLabel4.setBackground(new java.awt.Color(86, 42, 35));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 42, 35));
        jLabel4.setText("MESA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 20));

        jLabel5.setBackground(new java.awt.Color(86, 42, 35));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 42, 35));
        jLabel5.setText("MENUS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 20));

        jButton3.setBackground(new java.awt.Color(86, 42, 35));
        jButton3.setForeground(new java.awt.Color(249, 242, 228));
        jButton3.setText("ATRAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 40, 70, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Tome una orden!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Completa la información requerida");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 270, 30));

        jLBTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLBTotal.setForeground(new java.awt.Color(86, 42, 35));
        jPanel1.add(jLBTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 670, 100, 20));

        jLabel2.setForeground(new java.awt.Color(86, 42, 35));
        jLabel2.setText("TOTAL:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 650, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(86, 42, 35));
        jLabel3.setText("CATEGORIA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(cbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBTNguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNguardarActionPerformed
        
        takeOrderController.handleSaveClick();
        
    }//GEN-LAST:event_jBTNguardarActionPerformed

    private void jBTNaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNaddActionPerformed
        MenuDetails menu= new MenuDetails(this, true);
        menu.setRoot(this);
        
        menu.setItemMenu_id(Long.parseLong(jTsaucers.getModel().getValueAt(row, 0).toString()));
        menu.setAtributes();
        menu.setVisible(true);
    }//GEN-LAST:event_jBTNaddActionPerformed

    private void jTsaucersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTsaucersMouseClicked
        row = jTsaucers.rowAtPoint(evt.getPoint());
        
        takeOrderController.manageButtonAdd();
        
    }//GEN-LAST:event_jTsaucersMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBTNeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNeditarActionPerformed
        MenuDetails menu= new MenuDetails(this, true);
        menu.setRoot(this);
        menu.setItemOrder(takeOrderController.getItemOrder());
        menu.setAction("edit");
        menu.setAtributes();
        
        menu.setVisible(true);
    }//GEN-LAST:event_jBTNeditarActionPerformed

    
    private void jTorderListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTorderListMouseClicked
        rowItemOrder = jTorderList.rowAtPoint(evt.getPoint());
        
        jBTNeditar.setVisible(true);
        jBTNeliminar.setVisible(true);
    }//GEN-LAST:event_jTorderListMouseClicked

    private void jBTNeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNeliminarActionPerformed
        
        takeOrderController.heandleDeleteClick();
        
        
    }//GEN-LAST:event_jBTNeliminarActionPerformed

    private void jCBtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBtableActionPerformed
        
        takeOrderController.setTable();
        
    }//GEN-LAST:event_jCBtableActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        takeOrderController.handleCategoryChange();
    }//GEN-LAST:event_cbCategoryActionPerformed
    
    public void renderItemOrderTable(){
        DefaultTableModel tableorder = takeOrderController.getTableOrderModel();
        jTorderList.setModel(tableorder);
        jTorderList.setRowHeight(40);
        
        TableColumnModel tcm = jTorderList.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        
        takeOrderController.manageButtonVisibility();
        
        takeOrderController.getTotalPrice();
    }
    
    public void renderTable(String category) {
        
        DefaultTableModel tableModel = takeOrderController.getTableModel(category);
        jTsaucers.setRowHeight(100);
        jTsaucers.setModel(tableModel);
        
        jTsaucers.getColumnModel().getColumn(5).setCellRenderer(new ImgTable());
        
        TableColumnModel tcm = jTsaucers.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        
    }
    
    public void renderTable() {
        renderTable("Todos");
    }
    
    public void setItemOrder(ItemOrder itemOrder) {
        
        takeOrderController.addItemOrder(itemOrder);
        
    }
    
    public void updateOrderItem(ItemOrder itemOrder) {
        
        takeOrderController.updateItemOrder(itemOrder);
        
    }

    public JLabel getjLBTotal() {
        return jLBTotal;
    }

    public void setjLBTotal(JLabel jLBTotal) {
        this.jLBTotal = jLBTotal;
    }

    public JButton getjBTNeditar() {
        return jBTNeditar;
    }

    public JButton getjBTNeliminar() {
        return jBTNeliminar;
    }

    public JButton getjBTNguardar() {
        return jBTNguardar;
    }

    public JButton getjBTNadd() {
        return jBTNadd;
    }
    
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }
    
    public int showConfirmation(String msg) {
        return JOptionPane.showConfirmDialog(rootPane, msg);
    }

    public int getRowItemOrder() {
        return rowItemOrder;
    }

    public JTable getjTorderList() {
        return jTorderList;
    }

    public int getRow() {
        return row;
    }
    
    public void renderCBTable() {
        takeOrderController.renderCBTable();
    }
    
    public void renderCBCategory() {
        takeOrderController.renderCBCategory();
    }
    
    public JComboBox<Table> getjCBtable() {
        return jCBtable;
    }

    public JTable getjTsaucers() {
        return jTsaucers;
    }

    public void setjTsaucers(JTable jTsaucers) {
        this.jTsaucers = jTsaucers;
    }

    public JComboBox<Category> getCbCategory() {
        return cbCategory;
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
            java.util.logging.Logger.getLogger(TakeOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeOrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Category> cbCategory;
    private javax.swing.JButton jBTNadd;
    private javax.swing.JButton jBTNeditar;
    private javax.swing.JButton jBTNeliminar;
    private javax.swing.JButton jBTNguardar;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Table> jCBtable;
    private javax.swing.JLabel jLBTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTorderList;
    private javax.swing.JTable jTsaucers;
    // End of variables declaration//GEN-END:variables
}
