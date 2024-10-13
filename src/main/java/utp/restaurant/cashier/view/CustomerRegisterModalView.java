package utp.restaurant.cashier.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import utp.restaurant.cashier.controller.CustomerRegisterModalController;

/**
 *
 * @author PC
 */
public class CustomerRegisterModalView extends javax.swing.JDialog {

    private CustomerRegisterModalController customerRegisterModalController;
    private VoucherView root;
    private String typeDocument;

    public CustomerRegisterModalView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        customerRegisterModalController = new CustomerRegisterModalController(this);
        initComponents();

    }

    public void setRoot(VoucherView root) {
        this.root = root;

    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;

    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void execTypeDocument() {

        customerRegisterModalController.handleCustomerTypeClick();

    }

    public void showMessage(String msg) {

        JOptionPane.showMessageDialog(rootPane, msg);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanelTypeCustomer = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTFLastNameP = new javax.swing.JTextField();
        jTFBhirtday = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jTFLastNameM = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jTFTelephone = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTFAddress = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTFEmail = new javax.swing.JTextField();
        jTFName = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jTFdni = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 110, 40));

        jButton2.setText("AGREGAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 100, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("Registro del Cliente");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanelTypeCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTypeCustomer.setLayout(new java.awt.CardLayout());

        jPanel5.setBackground(new java.awt.Color(0, 255, 0));

        jTFLastNameP.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameP.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameP.setBorder(null);
        jTFLastNameP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNamePActionPerformed(evt);
            }
        });

        jTFBhirtday.setBackground(new java.awt.Color(249, 242, 228));
        jTFBhirtday.setForeground(new java.awt.Color(51, 51, 51));
        jTFBhirtday.setBorder(null);
        jTFBhirtday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBhirtdayActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(86, 42, 35));
        jLabel22.setForeground(new java.awt.Color(86, 42, 35));
        jLabel22.setText("DIRECCION");

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));

        jTFLastNameM.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameM.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameM.setBorder(null);
        jTFLastNameM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNameMActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));

        jTFTelephone.setBackground(new java.awt.Color(249, 242, 228));
        jTFTelephone.setForeground(new java.awt.Color(51, 51, 51));
        jTFTelephone.setBorder(null);
        jTFTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelephoneActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(86, 42, 35));
        jLabel17.setForeground(new java.awt.Color(86, 42, 35));
        jLabel17.setText("DNI");

        jLabel15.setBackground(new java.awt.Color(86, 42, 35));
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("APELLIDO PATERNO");

        jTFAddress.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddress.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddress.setBorder(null);
        jTFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressActionPerformed(evt);
            }
        });

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("TELEFONO");

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));

        jTFEmail.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmail.setBorder(null);
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });

        jTFName.setBackground(new java.awt.Color(249, 242, 228));
        jTFName.setForeground(new java.awt.Color(51, 51, 51));
        jTFName.setBorder(null);
        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("EMAIL");

        jTFdni.setBackground(new java.awt.Color(249, 242, 228));
        jTFdni.setForeground(new java.awt.Color(51, 51, 51));
        jTFdni.setBorder(null);
        jTFdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdniActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(86, 42, 35));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("APELLIDO MATERNO");

        jLabel13.setBackground(new java.awt.Color(86, 42, 35));
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("NOMBRE");

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("FECHA DE NACIMIENTO");

        jSeparator9.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator9.setForeground(new java.awt.Color(86, 42, 35));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(198, 198, 198)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(110, 110, 110)
                            .addComponent(jLabel16))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jTFLastNameP, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jTFLastNameM, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jTFdni, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jTFBhirtday, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jTFTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFLastNameP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFLastNameM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel19))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTFdni, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFBhirtday, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel22)
                            .addGap(4, 4, 4)
                            .addComponent(jTFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelTypeCustomer.add(jPanel5, "Boleta\n");

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanelTypeCustomer.add(jPanel4, "Factura\n");

        jPanel1.add(jPanelTypeCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 850, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public CustomerRegisterModalController getCustomerRegisterModalController() {
        return customerRegisterModalController;

    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

   

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanelTypeCustomer() {
        return jPanelTypeCustomer;
    }

   

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public JSeparator getjSeparator4() {
        return jSeparator4;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public JSeparator getjSeparator6() {
        return jSeparator6;
    }

    public JSeparator getjSeparator7() {
        return jSeparator7;
    }

    public JSeparator getjSeparator8() {
        return jSeparator8;
    }

    public JSeparator getjSeparator9() {
        return jSeparator9;
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

    public JTextField getjTFName() {
        return jTFName;
    }

    public JTextField getjTFTelephone() {
        return jTFTelephone;
    }

    public JTextField getjTFdni() {
        return jTFdni;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

  


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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        customerRegisterModalController.handleRegisterClick();


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus         dispose();
look and feel */
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
            java.util.logging.Logger.getLogger(CustomerRegisterModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerRegisterModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerRegisterModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerRegisterModalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerRegisterModalView dialog = new CustomerRegisterModalView(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelTypeCustomer;
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
    // End of variables declaration//GEN-END:variables
}
