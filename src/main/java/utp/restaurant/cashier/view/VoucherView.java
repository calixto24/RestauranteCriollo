/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.restaurant.cashier.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.controller.VoucherController;
import utp.restaurant.model.Customer;
import utp.restaurant.model.Order;
import utp.restaurant.utils.ImgTable;

/**
 *
 * @author JHORDAN
 */
public class VoucherView extends javax.swing.JFrame {

    private VoucherController voucherController;

    public VoucherView() {

        voucherController = new VoucherController(this);

        initComponents();
    }
    
    

    public void setOrder(Order order) {
        voucherController.setOrder(order);
        voucherController.initAttributes();
    }

    public void renderTable() {

        DefaultTableModel tableModel = voucherController.getTableModel();
        jTItemOrder.setRowHeight(100);
        jTItemOrder.setModel(tableModel);

        jTItemOrder.getColumnModel().getColumn(1).setCellRenderer(new ImgTable());

    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCBTypeDocument = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPVaucher = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFapellidoPstr = new javax.swing.JTextField();
        jTFdniStr = new javax.swing.JTextField();
        jTFnombreStr = new javax.swing.JTextField();
        jTFapellidoMstr = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTFdireccion = new javax.swing.JTextField();
        jTFruc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTFsocialReason = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTItemOrder = new javax.swing.JTable();
        jLBnumerTable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCBpaymentType = new javax.swing.JComboBox<>();
        jLBvuelto = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTFvuelto = new javax.swing.JTextField();
        jTFamount = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTFtotal = new javax.swing.JTextField();
        jTFsubTotal = new javax.swing.JTextField();
        jTFdiscount = new javax.swing.JTextField();
        jTFigv = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tfTaxed = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jTFsobrecargo = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(jCBTypeDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 430, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/restaurant/images/btnAnadir.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, 60));

        jLabel23.setBackground(new java.awt.Color(86, 42, 35));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(86, 42, 35));
        jLabel23.setText("TIPO DE DOCUMENTO");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        jPVaucher.setLayout(new java.awt.CardLayout());

        jPanel7.setBackground(new java.awt.Color(249, 242, 228));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(86, 42, 35));
        jLabel4.setText("APELLIDO MATERNO: ");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 33));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(86, 42, 35));
        jLabel6.setText("DNI: ");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 86, 33));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(86, 42, 35));
        jLabel8.setText("NOMBRES: ");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 86, 33));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(86, 42, 35));
        jLabel10.setText("APELLIDO PATERNO: ");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 33));

        jTFapellidoPstr.setEditable(false);
        jTFapellidoPstr.setBackground(new java.awt.Color(249, 242, 228));
        jTFapellidoPstr.setBorder(null);
        jPanel7.add(jTFapellidoPstr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 260, 30));

        jTFdniStr.setBackground(new java.awt.Color(249, 242, 228));
        jTFdniStr.setForeground(new java.awt.Color(51, 51, 51));
        jTFdniStr.setBorder(null);
        jTFdniStr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFdniStrMouseClicked(evt);
            }
        });
        jTFdniStr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdniStrActionPerformed(evt);
            }
        });
        jPanel7.add(jTFdniStr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 30));

        jTFnombreStr.setEditable(false);
        jTFnombreStr.setBackground(new java.awt.Color(249, 242, 228));
        jTFnombreStr.setBorder(null);
        jPanel7.add(jTFnombreStr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 260, 30));

        jTFapellidoMstr.setEditable(false);
        jTFapellidoMstr.setBackground(new java.awt.Color(249, 242, 228));
        jTFapellidoMstr.setBorder(null);
        jPanel7.add(jTFapellidoMstr, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 260, 30));

        jSeparator1.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator1.setForeground(new java.awt.Color(86, 42, 35));
        jPanel7.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 260, 12));

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 260, 12));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel7.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 260, 12));

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));
        jPanel7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 260, 12));

        jPVaucher.add(jPanel7, "boleta");

        jPanel8.setBackground(new java.awt.Color(249, 242, 228));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setForeground(new java.awt.Color(86, 42, 35));
        jLabel11.setText("DIRECCION: ");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 33));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("RUC: ");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 86, 33));

        jTFdireccion.setEditable(false);
        jTFdireccion.setBackground(new java.awt.Color(249, 242, 228));
        jTFdireccion.setBorder(null);
        jPanel8.add(jTFdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 250, 30));

        jTFruc.setBackground(new java.awt.Color(249, 242, 228));
        jTFruc.setBorder(null);
        jTFruc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFrucMouseClicked(evt);
            }
        });
        jTFruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrucActionPerformed(evt);
            }
        });
        jPanel8.add(jTFruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 250, 30));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("RAZON SOCIAL: ");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 33));

        jTFsocialReason.setEditable(false);
        jTFsocialReason.setBackground(new java.awt.Color(249, 242, 228));
        jTFsocialReason.setBorder(null);
        jPanel8.add(jTFsocialReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 250, 30));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel8.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, 12));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel8.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, 12));

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));
        jPanel8.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 250, 12));

        jPVaucher.add(jPanel8, "factura");

        jPanel2.add(jPVaucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 430, 180));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 490, 310));

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTItemOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTItemOrder);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, 710, 270));

        jLBnumerTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLBnumerTable.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jLBnumerTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 100, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(86, 42, 35));
        jLabel7.setText("NUMERO DE MESA:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 720, 310));

        jPanel4.setBackground(new java.awt.Color(249, 242, 228));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCBpaymentType.setBackground(new java.awt.Color(249, 242, 228));
        jCBpaymentType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBpaymentType.setForeground(new java.awt.Color(86, 42, 35));
        jCBpaymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));
        jCBpaymentType.setBorder(null);
        jCBpaymentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBpaymentTypeActionPerformed(evt);
            }
        });
        jPanel4.add(jCBpaymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 430, 40));

        jLBvuelto.setBackground(new java.awt.Color(86, 42, 35));
        jLBvuelto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLBvuelto.setForeground(new java.awt.Color(86, 42, 35));
        jLBvuelto.setText("VUELTO:");
        jPanel4.add(jLBvuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 20));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("METODO DE PAGO");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel22.setBackground(new java.awt.Color(86, 42, 35));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(86, 42, 35));
        jLabel22.setText("MONTO:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jTFvuelto.setEditable(false);
        jTFvuelto.setBackground(new java.awt.Color(249, 242, 228));
        jTFvuelto.setBorder(null);
        jTFvuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFvueltoActionPerformed(evt);
            }
        });
        jPanel4.add(jTFvuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 70, 30));

        jTFamount.setBackground(new java.awt.Color(249, 242, 228));
        jTFamount.setBorder(null);
        jTFamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFamountActionPerformed(evt);
            }
        });
        jPanel4.add(jTFamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 70, 30));

        jSeparator15.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator15.setForeground(new java.awt.Color(86, 42, 35));
        jPanel4.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 12));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 490, 210));

        jPanel5.setBackground(new java.awt.Color(249, 242, 228));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(86, 42, 35)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(86, 42, 35));
        jLabel9.setText("CARGO ADICIONAL:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("GRAVADO:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(86, 42, 35));
        jLabel14.setText("DESCUENTO:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("IGV:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        jTFtotal.setEditable(false);
        jTFtotal.setBackground(new java.awt.Color(249, 242, 228));
        jTFtotal.setForeground(new java.awt.Color(51, 51, 51));
        jTFtotal.setBorder(null);
        jTFtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtotalActionPerformed(evt);
            }
        });
        jPanel5.add(jTFtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 480, 30));

        jTFsubTotal.setEditable(false);
        jTFsubTotal.setBackground(new java.awt.Color(249, 242, 228));
        jTFsubTotal.setForeground(new java.awt.Color(51, 51, 51));
        jTFsubTotal.setBorder(null);
        jTFsubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFsubTotalActionPerformed(evt);
            }
        });
        jPanel5.add(jTFsubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 480, 30));

        jTFdiscount.setEditable(false);
        jTFdiscount.setBackground(new java.awt.Color(249, 242, 228));
        jTFdiscount.setForeground(new java.awt.Color(51, 51, 51));
        jTFdiscount.setText("S/. 0,00");
        jTFdiscount.setBorder(null);
        jTFdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdiscountActionPerformed(evt);
            }
        });
        jPanel5.add(jTFdiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 480, 30));

        jTFigv.setEditable(false);
        jTFigv.setBackground(new java.awt.Color(249, 242, 228));
        jTFigv.setForeground(new java.awt.Color(51, 51, 51));
        jTFigv.setBorder(null);
        jTFigv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFigvActionPerformed(evt);
            }
        });
        jPanel5.add(jTFigv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 480, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(86, 42, 35));
        jLabel25.setText("SUB TOTAL:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        tfTaxed.setEditable(false);
        tfTaxed.setBackground(new java.awt.Color(249, 242, 228));
        tfTaxed.setForeground(new java.awt.Color(51, 51, 51));
        tfTaxed.setBorder(null);
        tfTaxed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaxedActionPerformed(evt);
            }
        });
        jPanel5.add(tfTaxed, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 480, 30));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 480, 12));

        jSeparator10.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator10.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 480, 12));

        jSeparator12.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator12.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 480, 12));

        jSeparator13.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator13.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 480, 12));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(86, 42, 35));
        jLabel26.setText("TOTAL:");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, -1));

        jTFsobrecargo.setEditable(false);
        jTFsobrecargo.setBackground(new java.awt.Color(249, 242, 228));
        jTFsobrecargo.setForeground(new java.awt.Color(51, 51, 51));
        jTFsobrecargo.setText("S/. 0,00");
        jTFsobrecargo.setBorder(null);
        jPanel5.add(jTFsobrecargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 480, 30));

        jSeparator14.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator14.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 480, 12));

        jSeparator11.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator11.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 480, 12));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 720, 290));

        jButton1.setBackground(new java.awt.Color(86, 42, 35));
        jButton1.setForeground(new java.awt.Color(249, 242, 228));
        jButton1.setText("CANCELAR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 660, 140, 50));

        jButton2.setBackground(new java.awt.Color(86, 42, 35));
        jButton2.setForeground(new java.awt.Color(249, 242, 228));
        jButton2.setText("FINALIZAR PAGO");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 140, 50));

        jButton4.setBackground(new java.awt.Color(86, 42, 35));
        jButton4.setForeground(new java.awt.Color(249, 242, 228));
        jButton4.setText("ATRAS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 104, 30));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("DETALLE DE VENTA");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, 30));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("DATOS DEL COMPROBANTE");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel24.setBackground(new java.awt.Color(86, 42, 35));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(86, 42, 35));
        jLabel24.setText("PAGO");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 42, 35));
        jLabel5.setText("DETALLES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFtotalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTFvueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFvueltoActionPerformed

    }//GEN-LAST:event_jTFvueltoActionPerformed

    private void jTFsubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFsubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFsubTotalActionPerformed

    private void jTFdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFdiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFdiscountActionPerformed

    private void jTFigvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFigvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFigvActionPerformed

    private void jTFamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFamountActionPerformed
        voucherController.handleAmountClick();
    }//GEN-LAST:event_jTFamountActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        CustomerRegisterModalView customerRegisterModalView = new CustomerRegisterModalView(this, true);
        customerRegisterModalView.setRoot(this);
        
        customerRegisterModalView.setTypeDocument(jCBTypeDocument.getSelectedItem().toString());
        
        customerRegisterModalView.execTypeDocument();

        customerRegisterModalView.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        voucherController.handleFinishClick();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCBTypeDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTypeDocumentActionPerformed
        voucherController.handleVoucherTypeClick();

    }//GEN-LAST:event_jCBTypeDocumentActionPerformed

    private void jTFdniStrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFdniStrActionPerformed
        voucherController.autoCompletedDocumentClick();
    }//GEN-LAST:event_jTFdniStrActionPerformed

    private void jTFrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFrucActionPerformed
        voucherController.autoCompletedDocumentClick();
    }//GEN-LAST:event_jTFrucActionPerformed

    private void tfTaxedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaxedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTaxedActionPerformed

    private void jTFrucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFrucMouseClicked

    }//GEN-LAST:event_jTFrucMouseClicked

    private void jTFdniStrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFdniStrMouseClicked

    }//GEN-LAST:event_jTFdniStrMouseClicked

    private void jCBpaymentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBpaymentTypeActionPerformed
        voucherController.handlePaymentTypeClick();
    }//GEN-LAST:event_jCBpaymentTypeActionPerformed

    public JTextField getjTFdniStr() {
        return jTFdniStr;
    }

    public JTextField getjTFsobrecargo() {
        return jTFsobrecargo;
    }

    public JTextField getjTFamount() {
        return jTFamount;
    }

    public JTextField getjTFtotal() {
        return jTFtotal;
    }

    public JTextField getjTFdiscount() {
        return jTFdiscount;
    }

    public JTextField getjTFapellidoPstr() {
        return jTFapellidoPstr;
    }

    public JTextField getjTFdireccion() {
        return jTFdireccion;
    }

    public JTextField getjTFruc() {
        return jTFruc;
    }

    public JTextField getjTFsocialReason() {
        return jTFsocialReason;
    }

    public JTextField getjTFapellidoMstr() {
        return jTFapellidoMstr;
    }

    public JTextField getjTFnombreStr() {
        return jTFnombreStr;
    }

    public JPanel getjPVaucher() {
        return jPVaucher;
    }

    public JLabel getjLBnumerTable() {
        return jLBnumerTable;
    }

    public JComboBox<String> getjCBTypeDocument() {
        return jCBTypeDocument;
    }

    public JComboBox<String> getjCBpaymentType() {
        return jCBpaymentType;
    }

    public JTextField getjTFsubTotal() {
        return jTFsubTotal;
    }

    public JTextField getTfTaxed() {
        return tfTaxed;
    }

    public JLabel getjLBvuelto() {
        return jLBvuelto;
    }

    public JTextField getjTFvuelto() {
        return jTFvuelto;
    }

    public JTextField getjTFigv() {
        return jTFigv;
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
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoucherView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCBTypeDocument;
    private javax.swing.JComboBox<String> jCBpaymentType;
    private javax.swing.JLabel jLBnumerTable;
    private javax.swing.JLabel jLBvuelto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPVaucher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTFamount;
    private javax.swing.JTextField jTFapellidoMstr;
    private javax.swing.JTextField jTFapellidoPstr;
    private javax.swing.JTextField jTFdireccion;
    private javax.swing.JTextField jTFdiscount;
    private javax.swing.JTextField jTFdniStr;
    private javax.swing.JTextField jTFigv;
    private javax.swing.JTextField jTFnombreStr;
    private javax.swing.JTextField jTFruc;
    private javax.swing.JTextField jTFsobrecargo;
    private javax.swing.JTextField jTFsocialReason;
    private javax.swing.JTextField jTFsubTotal;
    private javax.swing.JTextField jTFtotal;
    private javax.swing.JTextField jTFvuelto;
    private javax.swing.JTable jTItemOrder;
    private javax.swing.JTextField tfTaxed;
    // End of variables declaration//GEN-END:variables
}
