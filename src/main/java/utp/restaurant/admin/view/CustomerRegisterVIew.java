
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
        jTFAddress = new javax.swing.JTextField();
        jTFName = new javax.swing.JTextField();
        jTFLast_Name_P = new javax.swing.JTextField();
        jTFLast_Name_M = new javax.swing.JTextField();
        jTFDNI = new javax.swing.JTextField();
        jTFBhirtday = new javax.swing.JTextField();
        jTFRUC = new javax.swing.JTextField();
        jTFTelephone = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
<<<<<<< HEAD
        BtnDelete = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
=======
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFAddress.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddress.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddress.setBorder(null);
        jPanel2.add(jTFAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 200, 30));

        jTFName.setBackground(new java.awt.Color(249, 242, 228));
        jTFName.setForeground(new java.awt.Color(51, 51, 51));
        jTFName.setBorder(null);
        jPanel2.add(jTFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 30));

        jTFLast_Name_P.setBackground(new java.awt.Color(249, 242, 228));
        jTFLast_Name_P.setForeground(new java.awt.Color(51, 51, 51));
        jTFLast_Name_P.setBorder(null);
        jPanel2.add(jTFLast_Name_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 200, 30));

        jTFLast_Name_M.setBackground(new java.awt.Color(249, 242, 228));
        jTFLast_Name_M.setForeground(new java.awt.Color(51, 51, 51));
        jTFLast_Name_M.setBorder(null);
        jPanel2.add(jTFLast_Name_M, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 200, 30));

        jTFDNI.setBackground(new java.awt.Color(249, 242, 228));
        jTFDNI.setForeground(new java.awt.Color(51, 51, 51));
        jTFDNI.setBorder(null);
        jPanel2.add(jTFDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 30));

        jTFBhirtday.setBackground(new java.awt.Color(249, 242, 228));
        jTFBhirtday.setForeground(new java.awt.Color(51, 51, 51));
        jTFBhirtday.setBorder(null);
        jPanel2.add(jTFBhirtday, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 200, 30));

        jTFRUC.setBackground(new java.awt.Color(249, 242, 228));
        jTFRUC.setForeground(new java.awt.Color(51, 51, 51));
        jTFRUC.setBorder(null);
        jPanel2.add(jTFRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 200, 30));

        jTFTelephone.setBackground(new java.awt.Color(249, 242, 228));
        jTFTelephone.setForeground(new java.awt.Color(51, 51, 51));
        jTFTelephone.setBorder(null);
        jPanel2.add(jTFTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

<<<<<<< HEAD
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
=======
        jTFEmail.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmail.setBorder(null);
        jPanel2.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 200, 30));
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e

        jLabel12.setBackground(new java.awt.Color(86, 42, 35));
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("TELEFONO");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 200, 12));

        jLabel13.setBackground(new java.awt.Color(86, 42, 35));
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 20));

        jLabel15.setBackground(new java.awt.Color(86, 42, 35));
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("DNI");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 12));

        jLabel16.setBackground(new java.awt.Color(86, 42, 35));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("NOMBRE");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 12));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 200, 20));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 200, 12));

        jLabel17.setBackground(new java.awt.Color(86, 42, 35));
        jLabel17.setForeground(new java.awt.Color(86, 42, 35));
        jLabel17.setText("RUC");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, 20));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 200, 20));

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 200, 12));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 20));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("DIRECCION");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, 20));

        jSeparator9.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator9.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 200, 20));

        jSeparator10.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator10.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 200, 12));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, 20));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("EMAIL");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 720, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerCliente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));

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

<<<<<<< HEAD
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

=======
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
<<<<<<< HEAD
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
=======
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
<<<<<<< HEAD
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete)
                    .addComponent(jButton1)
                    .addComponent(BtnModificar))
                .addGap(0, 6, Short.MAX_VALUE))
=======
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 710, 340));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, -1, -1));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("LIMPIAR");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 660, 100, 40));

        jButton3.setBackground(new java.awt.Color(86, 42, 35));
        jButton3.setForeground(new java.awt.Color(249, 242, 228));
        jButton3.setText("ELIMINAR");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 660, 100, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("¡Registro de Clientes!");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Completa la información de los clientes");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 270, 30));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("GUARDAR");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 660, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
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

=======
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

<<<<<<< HEAD
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
    
=======
    /**
     * @param args the command line arguments
     */
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e
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
<<<<<<< HEAD
=======
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
>>>>>>> 8c3e48dbbaae9f56062a8caa365b835ad4ed019e
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
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
