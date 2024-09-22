/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.admin.view;

import utp.restaurant.admin.controller.EmployeeController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.model.Role;

/**
 *
 * @author jeanfranco
 */
public class Register extends javax.swing.JFrame {
    
    //atributos
    private EmployeeController employeeController;
    private int row;
    
    //constructor vacio
    public Register() {
        
        employeeController = new EmployeeController(this);
        
        initComponents();
        
        renderTable();
        employeeController.renderCBRole();
        jBDelete.setVisible(false);
        btnUpdatePassword.setVisible(false);
    }
    
    public void renderTable() {
        
       DefaultTableModel employeeModel = employeeController.getEmployeeModel();
       jTUserList.setModel(employeeModel);
       
       TableColumnModel tcm = jTUserList.getColumnModel();
       tcm.removeColumn(tcm.getColumn(0));
       tcm.removeColumn(tcm.getColumn(0));
       tcm.removeColumn(tcm.getColumn(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFAP = new javax.swing.JTextField();
        jTFAM = new javax.swing.JTextField();
        jTFBirthdate = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTFDni = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTFphoneNumber = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jTFaddress = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jTFUser = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jTFPass = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jCBRole = new javax.swing.JComboBox<>();
        jTFName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTUserList = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnUpdatePassword = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(249, 242, 228));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(86, 42, 35));
        jLabel8.setText("¡Registro de Empleados!");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, 120, 30));

        jBDelete.setBackground(new java.awt.Color(86, 42, 35));
        jBDelete.setForeground(new java.awt.Color(249, 242, 228));
        jBDelete.setText("ELIMINAR");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(jBDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 120, 30));

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(86, 42, 35));
        jLabel1.setForeground(new java.awt.Color(86, 42, 35));
        jLabel1.setText("NOMBRE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 21, -1, 20));

        jLabel2.setBackground(new java.awt.Color(86, 42, 35));
        jLabel2.setForeground(new java.awt.Color(86, 42, 35));
        jLabel2.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 140, -1));

        jLabel3.setBackground(new java.awt.Color(86, 42, 35));
        jLabel3.setForeground(new java.awt.Color(86, 42, 35));
        jLabel3.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 20));

        jLabel5.setBackground(new java.awt.Color(86, 42, 35));
        jLabel5.setForeground(new java.awt.Color(86, 42, 35));
        jLabel5.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, -1));

        jTFAP.setBackground(new java.awt.Color(249, 242, 228));
        jTFAP.setForeground(new java.awt.Color(51, 51, 51));
        jTFAP.setBorder(null);
        jPanel2.add(jTFAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 190, -1));

        jTFAM.setBackground(new java.awt.Color(249, 242, 228));
        jTFAM.setForeground(new java.awt.Color(51, 51, 51));
        jTFAM.setBorder(null);
        jPanel2.add(jTFAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 200, -1));

        jTFBirthdate.setBackground(new java.awt.Color(249, 242, 228));
        jTFBirthdate.setForeground(new java.awt.Color(51, 51, 51));
        jTFBirthdate.setBorder(null);
        jPanel2.add(jTFBirthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, -1));

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 12));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 200, 20));

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 200, 12));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 12));

        jLabel4.setBackground(new java.awt.Color(86, 42, 35));
        jLabel4.setForeground(new java.awt.Color(86, 42, 35));
        jLabel4.setText("DNI");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 31, -1));

        jTFDni.setBackground(new java.awt.Color(249, 242, 228));
        jTFDni.setForeground(new java.awt.Color(51, 51, 51));
        jTFDni.setBorder(null);
        jPanel2.add(jTFDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 200, -1));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 200, 12));

        jLabel6.setBackground(new java.awt.Color(86, 42, 35));
        jLabel6.setForeground(new java.awt.Color(86, 42, 35));
        jLabel6.setText("TELEFONO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 90, -1));

        jTFphoneNumber.setBackground(new java.awt.Color(249, 242, 228));
        jTFphoneNumber.setForeground(new java.awt.Color(51, 51, 51));
        jTFphoneNumber.setBorder(null);
        jTFphoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFphoneNumberActionPerformed(evt);
            }
        });
        jPanel2.add(jTFphoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 200, -1));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 200, 12));

        jLabel7.setBackground(new java.awt.Color(86, 42, 35));
        jLabel7.setForeground(new java.awt.Color(86, 42, 35));
        jLabel7.setText("CORREO ELECTRONICO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jTFEmail.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmail.setBorder(null);
        jPanel2.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, -1));

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 200, 12));

        jLabel12.setBackground(new java.awt.Color(86, 42, 35));
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("DIRECCION");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, -1));

        jTFaddress.setBackground(new java.awt.Color(249, 242, 228));
        jTFaddress.setForeground(new java.awt.Color(51, 51, 51));
        jTFaddress.setBorder(null);
        jTFaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFaddressActionPerformed(evt);
            }
        });
        jPanel2.add(jTFaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 200, -1));

        jSeparator9.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator9.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 200, 12));

        jLabel9.setBackground(new java.awt.Color(86, 42, 35));
        jLabel9.setForeground(new java.awt.Color(86, 42, 35));
        jLabel9.setText("USUARIO");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jTFUser.setBackground(new java.awt.Color(249, 242, 228));
        jTFUser.setForeground(new java.awt.Color(51, 51, 51));
        jTFUser.setBorder(null);
        jPanel2.add(jTFUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 200, -1));

        jSeparator10.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator10.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 200, 12));

        jLabel11.setBackground(new java.awt.Color(86, 42, 35));
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("CONTRASEÑA");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, -1));

        jTFPass.setBackground(new java.awt.Color(249, 242, 228));
        jTFPass.setForeground(new java.awt.Color(51, 51, 51));
        jTFPass.setBorder(null);
        jTFPass.setCaretColor(new java.awt.Color(81, 34, 28));
        jTFPass.setDisabledTextColor(new java.awt.Color(81, 34, 28));
        jPanel2.add(jTFPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, -1));

        jSeparator11.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator11.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 12));

        jLabel10.setBackground(new java.awt.Color(86, 42, 35));
        jLabel10.setForeground(new java.awt.Color(86, 42, 35));
        jLabel10.setText("ROL");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 71, -1));

        jCBRole.setBackground(new java.awt.Color(249, 242, 228));
        jCBRole.setForeground(new java.awt.Color(51, 51, 51));
        jCBRole.setBorder(null);
        jPanel2.add(jCBRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 200, -1));

        jTFName.setBackground(new java.awt.Color(249, 242, 228));
        jTFName.setForeground(new java.awt.Color(51, 51, 51));
        jTFName.setBorder(null);
        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });
        jPanel2.add(jTFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 770, 270));

        jPanel4.setBackground(new java.awt.Color(249, 242, 228));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTUserList.setBackground(new java.awt.Color(249, 242, 228));
        jTUserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUserListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTUserList);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 690, 265));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 700, 280));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("LIMPIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, 110, 30));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("ATRAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 30, 70, -1));

        btnUpdatePassword.setBackground(new java.awt.Color(86, 42, 35));
        btnUpdatePassword.setForeground(new java.awt.Color(249, 242, 228));
        btnUpdatePassword.setText("Actualizar Contraseña");
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 660, 180, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/bannerEmpleado.png"))); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Completa la información de los empleados");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        employeeController.handleRegisterClick();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUserListMouseClicked
        row = jTUserList.rowAtPoint(evt.getPoint());
        
        employeeController.heandleViewEditClick();
        
    }//GEN-LAST:event_jTUserListMouseClicked

    public int getRow() {
        return row;
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        employeeController.handleCleanForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        employeeController.heandleDeleteClick();
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTFphoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFphoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFphoneNumberActionPerformed

    private void jTFaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFaddressActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        ResetPassword rp = new ResetPassword(this, true);
        rp.setRoot(this);
        rp.setEmployee_id(Long.parseLong(jTUserList.getModel().getValueAt(row, 0).toString()));
        rp.setVisible(true);
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void jTFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNameActionPerformed

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(rootPane, message);
    }
    
    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(rootPane, message);
    }
    
    public JTextField getjTFaddress() {
        return jTFaddress;
    }

    //metodos getters
    public JTextField getjTFphoneNumber() {    
        return jTFphoneNumber;
    }

    public JButton getjBDelete() {
        return jBDelete;
    }
    
    public JTable getjTUserList() {
        return jTUserList;
    }
    
    public JComboBox<Role> getjCBRole() {
        return jCBRole;
    }

    public JTextField getjTFAM() {
        return jTFAM;
    }

    public JTextField getjTFAP() {
        return jTFAP;
    }

    public JTextField getjTFBirthdate() {
        return jTFBirthdate;
    }

    public JTextField getjTFDni() {
        return jTFDni;
    }

    public JTextField getjTFEmail() {
        return jTFEmail;
    }

    public JTextField getjTFName() {
        return jTFName;
    }

    public JTextField getjTFPass() {
        return jTFPass;
    }

    public JTextField getjTFRuc() {
        return jTFphoneNumber;
    }

    public JTextField getjTFUser() {
        return jTFUser;
    }

    public JButton getBtnUpdatePassword() {
        return btnUpdatePassword;
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<Role> jCBRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JTextField jTFAM;
    private javax.swing.JTextField jTFAP;
    private javax.swing.JTextField jTFBirthdate;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFPass;
    private javax.swing.JTextField jTFUser;
    private javax.swing.JTextField jTFaddress;
    private javax.swing.JTextField jTFphoneNumber;
    private javax.swing.JTable jTUserList;
    // End of variables declaration//GEN-END:variables
}
