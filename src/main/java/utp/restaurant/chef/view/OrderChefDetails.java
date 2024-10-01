/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package utp.restaurant.chef.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.chef.controller.OrderChefDetailsController;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.model.Order;
import utp.restaurant.utils.ImgTable;

/**
 *
 * @author JHORDAN
 */
public class OrderChefDetails extends javax.swing.JDialog {

    OrderChefView root;
    Order order;
    OrderDAO orderDAO;
    OrderChefDetailsController orderChefDetailsController;

    public OrderChefDetails(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        orderDAO = new OrderDAO();
        orderChefDetailsController = new OrderChefDetailsController(this);

        initComponents();
    }

    public void setRoot(OrderChefView root) {
        this.root = root;
    }

    public void setId(long id) {

        order = orderDAO.get(id);

    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    public int showConfirmDialog(String msg) {

        return JOptionPane.showConfirmDialog(rootPane, msg);

    }

    public void setAtributtes() {

        jLBnumberTable.setText(order.getTable().getNumber_table() + "");
        jLBwaiter.setText(order.getWaiter().toString());

    }

    public void renderTable() {

        DefaultTableModel tableModel = orderChefDetailsController.getTableModel(order);
        jTplatillos.setRowHeight(100);
        jTplatillos.setModel(tableModel);

        jTplatillos.getColumnModel().getColumn(1).setCellRenderer(new ImgTable());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLBwaiter = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLBnumberTable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTplatillos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("Detalles");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel4.setBackground(new java.awt.Color(86, 42, 35));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 42, 35));
        jLabel4.setText("PLATILLOS SELECCIONADOS:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 20));

        jLabel5.setBackground(new java.awt.Color(86, 42, 35));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 42, 35));
        jLabel5.setText("MESERO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, 20));

        jLBwaiter.setBackground(new java.awt.Color(86, 42, 35));
        jLBwaiter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLBwaiter.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jLBwaiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 260, 40));

        jLabel7.setBackground(new java.awt.Color(86, 42, 35));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(86, 42, 35));
        jLabel7.setText("NUMERO DE MESA:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 20));

        jLBnumberTable.setBackground(new java.awt.Color(86, 42, 35));
        jLBnumberTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLBnumberTable.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jLBnumberTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 130, 40));

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTplatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTplatillos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 320));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 700, 340));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("FINALIZAR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 110, 40));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("CANCELAR");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int op = showConfirmDialog("¿Desea Finalizar el pedido?");

        if (op != 0) {

            return;

        } else {

            try {

                order.setStatus("Finalizado");
                showMessage("Pedido finalizado correctamente");
                root.renderTable();

                dispose();

            } catch (Exception e) {

                showMessage("Pedido no finalizado");

            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    public JLabel getjLBnumberTable() {
        return jLBnumberTable;
    }

    public JLabel getjLBwaiter() {
        return jLBwaiter;
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
            java.util.logging.Logger.getLogger(OrderChefDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderChefDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderChefDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderChefDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrderChefDetails dialog = new OrderChefDetails(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLBnumberTable;
    private javax.swing.JLabel jLBwaiter;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTplatillos;
    // End of variables declaration//GEN-END:variables
}
