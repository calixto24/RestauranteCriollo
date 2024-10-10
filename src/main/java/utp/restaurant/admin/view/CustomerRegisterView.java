
package utp.restaurant.admin.view;

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
    
    //Constructor vacio
    public CustomerRegisterView() {
        customerController = new CustomerController(this);
        
        initComponents();
        
        renderTable();
        BtnDelete.setVisible(false);
    }
    
    public void renderTable() {
        
       DefaultTableModel customerModel = customerController.getCustomerModel();
       jTList.setRowHeight(40);
       jTList.setModel(customerModel);
       
       TableColumnModel xd = jTList.getColumnModel();
       xd.removeColumn(xd.getColumn(0));
       xd.removeColumn(xd.getColumn(0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTFName = new javax.swing.JTextField();
        jTFLastNameP = new javax.swing.JTextField();
        jTFLastNameM = new javax.swing.JTextField();
        jTFdni = new javax.swing.JTextField();
        jTFBhirtday = new javax.swing.JTextField();
        jTFTelephone = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFAddress = new javax.swing.JTextField();
        jTFruc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jTFrazonSocial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFName.setBackground(new java.awt.Color(249, 242, 228));
        jTFName.setForeground(new java.awt.Color(51, 51, 51));
        jTFName.setBorder(null);
        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });
        jPanel2.add(jTFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 20));

        jTFLastNameP.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameP.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameP.setBorder(null);
        jTFLastNameP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNamePActionPerformed(evt);
            }
        });
        jPanel2.add(jTFLastNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 210, 20));

        jTFLastNameM.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameM.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameM.setBorder(null);
        jTFLastNameM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNameMActionPerformed(evt);
            }
        });
        jPanel2.add(jTFLastNameM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 220, 20));

        jTFdni.setBackground(new java.awt.Color(249, 242, 228));
        jTFdni.setForeground(new java.awt.Color(51, 51, 51));
        jTFdni.setBorder(null);
        jTFdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdniActionPerformed(evt);
            }
        });
        jPanel2.add(jTFdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, 20));

        jTFBhirtday.setBackground(new java.awt.Color(249, 242, 228));
        jTFBhirtday.setForeground(new java.awt.Color(51, 51, 51));
        jTFBhirtday.setBorder(null);
        jTFBhirtday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBhirtdayActionPerformed(evt);
            }
        });
        jPanel2.add(jTFBhirtday, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 210, 20));

        jTFTelephone.setBackground(new java.awt.Color(249, 242, 228));
        jTFTelephone.setForeground(new java.awt.Color(51, 51, 51));
        jTFTelephone.setBorder(null);
        jTFTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelephoneActionPerformed(evt);
            }
        });
        jPanel2.add(jTFTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 220, 20));

        jTFEmail.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmail.setBorder(null);
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        jPanel2.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, 200, -1));

        jTFAddress.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddress.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddress.setBorder(null);
        jTFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressActionPerformed(evt);
            }
        });
        jPanel2.add(jTFAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 210, 20));

        jTFruc.setBackground(new java.awt.Color(249, 242, 228));
        jTFruc.setForeground(new java.awt.Color(51, 51, 51));
        jTFruc.setBorder(null);
        jTFruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrucActionPerformed(evt);
            }
        });
        jPanel2.add(jTFruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 138, 220, 20));

        jLabel13.setBackground(new java.awt.Color(86, 42, 35));
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("NOMBRE");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jLabel15.setBackground(new java.awt.Color(86, 42, 35));
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 140, -1));

        jLabel16.setBackground(new java.awt.Color(86, 42, 35));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 20));

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 12));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 210, 10));

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 220, 12));

        jLabel17.setBackground(new java.awt.Color(86, 42, 35));
        jLabel17.setForeground(new java.awt.Color(86, 42, 35));
        jLabel17.setText("DNI");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, 12));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 210, 10));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 220, 12));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("TELEFONO");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, 20));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 140, -1));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("EMAIL");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 12));

        jSeparator9.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator9.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 210, 10));

        jSeparator10.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator10.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 220, 12));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("RUC");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, 20));

        jLabel22.setBackground(new java.awt.Color(86, 42, 35));
        jLabel22.setForeground(new java.awt.Color(86, 42, 35));
        jLabel22.setText("DIRECCION");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 140, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 740, 180));

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTList.setBackground(new java.awt.Color(255, 255, 255));
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
        jTList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 320));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 740, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerCliente.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 660, 100, 30));

        BtnLimpiar.setBackground(new java.awt.Color(86, 42, 35));
        BtnLimpiar.setForeground(new java.awt.Color(249, 242, 228));
        BtnLimpiar.setText("LIMPIAR");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(BtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 660, 90, 30));

        BtnDelete.setBackground(new java.awt.Color(86, 42, 35));
        BtnDelete.setForeground(new java.awt.Color(249, 242, 228));
        BtnDelete.setText("ELIMINAR");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(BtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 660, 100, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("¡Registro de Clientes!");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Completa la información de los clientes");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 270, -1));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("ATRAS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, 90, 30));

        jLabel23.setBackground(new java.awt.Color(86, 42, 35));
        jLabel23.setForeground(new java.awt.Color(86, 42, 35));
        jLabel23.setText("RAZON SOCIAL");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, -1, 20));

        jSeparator11.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator11.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 220, 12));

        jTFrazonSocial.setBackground(new java.awt.Color(249, 242, 228));
        jTFrazonSocial.setBorder(null);
        jTFrazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrazonSocialActionPerformed(evt);
            }
        });
        jPanel3.add(jTFrazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 220, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNameActionPerformed

    private void jTFLastNamePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLastNamePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLastNamePActionPerformed

    private void jTFLastNameMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLastNameMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLastNameMActionPerformed

    private void jTFdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFdniActionPerformed

    private void jTFBhirtdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBhirtdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBhirtdayActionPerformed

    private void jTFTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTelephoneActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jTFAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAddressActionPerformed

    private void jTFrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFrucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFrucActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        customerController.handleRegisterClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        customerController.heandleDeleteClick();
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        customerController.handleCleanForm();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void jTListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListMouseClicked
        row = jTList.rowAtPoint(evt.getPoint());
        
        customerController.heandleViewEditClick();
    }//GEN-LAST:event_jTListMouseClicked

    private void jTFrazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFrazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFrazonSocialActionPerformed

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(rootPane, message);
    }
    
    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(rootPane, message);
    }
    
    //Metodos Getters

    public JTextField getjTFrazonSocial() {
        return jTFrazonSocial;
    }
    
    public JTextField getjTFName() {
        return jTFName;
    }

    public JTextField getjTFAddress() {
        return jTFAddress;
    }

    public JTextField getjTFBhirtday() {
        return jTFBhirtday;
    }

    public JTextField getjTFEmail() {
        return jTFEmail;
    }

    public JTextField getjTFLastNameM() {
        return jTFLastNameM;
    }

    public JTextField getjTFLastNameP() {
        return jTFLastNameP;
    }

    public JTextField getjTFTelephone() {
        return jTFTelephone;
    }

    public JTextField getjTFdni() {
        return jTFdni;
    }

    public JTextField getjTFruc() {
        return jTFruc;
    }

    public int getRow() {
        return row;
    }

    public JTable getjTList() {
        return jTList;
    }

    public JButton getBtnDelete() {
        return BtnDelete;
    }

    public JButton getBtnLimpiar() {
        return BtnLimpiar;
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerRegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTFAddress;
    private javax.swing.JTextField jTFBhirtday;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFLastNameM;
    private javax.swing.JTextField jTFLastNameP;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFTelephone;
    private javax.swing.JTextField jTFdni;
    private javax.swing.JTextField jTFrazonSocial;
    private javax.swing.JTextField jTFruc;
    private javax.swing.JTable jTList;
    // End of variables declaration//GEN-END:variables
}
