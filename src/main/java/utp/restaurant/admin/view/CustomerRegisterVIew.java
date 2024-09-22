
package utp.restaurant.admin.view;
        
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.admin.controller.CustomerController;

public class CustomerRegisterView extends javax.swing.JFrame {
    //atributos
    private CustomerController customerController;
    private int row;
    
     //constructor vacio
    public CustomerRegisterView() {
        
        customerController = new CustomerController(this);
        
        initComponents();
        
        renderTable();
        BtnDelete.setVisible(false);
        BtnModificar.setVisible(false);
    }
    
    public void renderTable() {
        
       DefaultTableModel customerModel = customerController.getCustomerModel();
       jTList.setModel(customerModel);
       
       TableColumnModel xd = jTList.getColumnModel();
       xd.removeColumn(xd.getColumn(0));
       xd.removeColumn(xd.getColumn(0));
       xd.removeColumn(xd.getColumn(0));
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFAddress = new javax.swing.JTextField();
        jTFName = new javax.swing.JTextField();
        jTFLast_Name_P = new javax.swing.JTextField();
        jTFLast_Name_M = new javax.swing.JTextField();
        jTFDNI = new javax.swing.JTextField();
        jTFBhirtday = new javax.swing.JTextField();
        jTFRUC = new javax.swing.JTextField();
        jTFTelephone = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DIRECCION");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DNI");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("RUC");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("TELEFONO");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("EMAIL");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        jTFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressActionPerformed(evt);
            }
        });
        jPanel2.add(jTFAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 160, 30));

        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });
        jPanel2.add(jTFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 30));

        jTFLast_Name_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLast_Name_PActionPerformed(evt);
            }
        });
        jPanel2.add(jTFLast_Name_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 160, 30));

        jTFLast_Name_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLast_Name_MActionPerformed(evt);
            }
        });
        jPanel2.add(jTFLast_Name_M, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 160, 30));

        jTFDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDNIActionPerformed(evt);
            }
        });
        jPanel2.add(jTFDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, 30));

        jTFBhirtday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBhirtdayActionPerformed(evt);
            }
        });
        jPanel2.add(jTFBhirtday, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 160, 30));

        jTFRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFRUCActionPerformed(evt);
            }
        });
        jPanel2.add(jTFRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 160, 30));

        jTFTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelephoneActionPerformed(evt);
            }
        });
        jPanel2.add(jTFTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 160, 30));

        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        jPanel2.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 160, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 760, 260));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerMesa.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jTList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTList);

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnDelete.setText("ELIMINAR");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnModificar.setText("MODIFICAR");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete)
                    .addComponent(jButton1)
                    .addComponent(BtnModificar))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 730, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNameActionPerformed

    private void jTFLast_Name_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLast_Name_PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLast_Name_PActionPerformed

    private void jTFLast_Name_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLast_Name_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLast_Name_MActionPerformed

    private void jTFDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDNIActionPerformed

    private void jTFBhirtdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBhirtdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBhirtdayActionPerformed

    private void jTFRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFRUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFRUCActionPerformed

    private void jTFTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTelephoneActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jTFAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAddressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDeleteActionPerformed

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(rootPane, message);
    }
    
    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(rootPane, message);
    }
        
    //Metodos get y set
    
    public JTextField getjTFName() {
        return jTFName;
    }

    public JTextField getjTFLast_Name_M() {
        return jTFLast_Name_M;
    }

    public JTextField getjTFLast_Name_P() {
        return jTFLast_Name_P;
    }

    public JTextField getjTFDNI() {
        return jTFDNI;
    }

    public JTextField getjTFBhirtday() {
        return jTFBhirtday;
    }

    public JTextField getjTFTelephone() {
        return jTFTelephone;
    }

    public JTextField getjTFEmail() {
        return jTFEmail;
    }

    public JTextField getjTFAddress() {
        return jTFAddress;
    }

    public JTextField getjTFRUC() {
        return jTFRUC;
    }

    public JButton getBtnDelete() {
        return BtnDelete;
    }

    public JButton getBtnModificar() {
        return BtnModificar;
    }

    public int getRow() {
        return row;
    }

    public JTable getjTList() {
        return jTList;
    }
    
    public static int getDO_NOTHING_ON_CLOSE() {
        return DO_NOTHING_ON_CLOSE;
    }

    public static int getHIDE_ON_CLOSE() {
        return HIDE_ON_CLOSE;
    }

    public static int getDISPOSE_ON_CLOSE() {
        return DISPOSE_ON_CLOSE;
    }

    public static int getEXIT_ON_CLOSE() {
        return EXIT_ON_CLOSE;
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
            java.util.logging.Logger.getLogger(CustomerRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerRegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerRegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFAddress;
    private javax.swing.JTextField jTFBhirtday;
    private javax.swing.JTextField jTFDNI;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFLast_Name_M;
    private javax.swing.JTextField jTFLast_Name_P;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFRUC;
    private javax.swing.JTextField jTFTelephone;
    private javax.swing.JTable jTList;
    // End of variables declaration//GEN-END:variables
}
