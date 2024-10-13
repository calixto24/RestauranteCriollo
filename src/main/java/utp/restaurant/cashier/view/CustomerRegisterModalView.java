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
        jPtypeCustomer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTFrazonSocial = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jTFruc = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jTFtype = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jTFactivityEconomic = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jTFtypeBilling = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jTFThelephoneJuridical = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jTFEmailJuridical = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jTFAddressJuridical = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 242, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 110, 40));

        jButton2.setText("AGREGAR ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(86, 42, 35));
        jLabel12.setText("Registro del Cliente");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPtypeCustomer.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(86, 42, 35));
        jLabel23.setForeground(new java.awt.Color(86, 42, 35));
        jLabel23.setText("RAZON SOCIAL");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jTFrazonSocial.setBackground(new java.awt.Color(249, 242, 228));
        jTFrazonSocial.setBorder(null);
        jTFrazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrazonSocialActionPerformed(evt);
            }
        });
        jPanel3.add(jTFrazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 20));

        jSeparator11.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator11.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 12));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("RUC");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 20));

        jTFruc.setBackground(new java.awt.Color(249, 242, 228));
        jTFruc.setForeground(new java.awt.Color(51, 51, 51));
        jTFruc.setBorder(null);
        jTFruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrucActionPerformed(evt);
            }
        });
        jPanel3.add(jTFruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 220, 20));

        jSeparator10.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator10.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 220, 12));

        jLabel25.setBackground(new java.awt.Color(86, 42, 35));
        jLabel25.setForeground(new java.awt.Color(86, 42, 35));
        jLabel25.setText("TIPO");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 20));

        jTFtype.setBackground(new java.awt.Color(249, 242, 228));
        jTFtype.setForeground(new java.awt.Color(51, 51, 51));
        jTFtype.setBorder(null);
        jTFtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtypeActionPerformed(evt);
            }
        });
        jPanel3.add(jTFtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 220, 20));

        jSeparator12.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator12.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 12));

        jLabel26.setBackground(new java.awt.Color(86, 42, 35));
        jLabel26.setForeground(new java.awt.Color(86, 42, 35));
        jLabel26.setText("ACTIVIDAD ECONOMICA");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jTFactivityEconomic.setBackground(new java.awt.Color(249, 242, 228));
        jTFactivityEconomic.setForeground(new java.awt.Color(51, 51, 51));
        jTFactivityEconomic.setBorder(null);
        jTFactivityEconomic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFactivityEconomicActionPerformed(evt);
            }
        });
        jPanel3.add(jTFactivityEconomic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 220, 20));

        jSeparator13.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator13.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 12));

        jLabel27.setBackground(new java.awt.Color(86, 42, 35));
        jLabel27.setForeground(new java.awt.Color(86, 42, 35));
        jLabel27.setText("TIPO DE FACTURACION");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, 20));

        jTFtypeBilling.setBackground(new java.awt.Color(249, 242, 228));
        jTFtypeBilling.setForeground(new java.awt.Color(51, 51, 51));
        jTFtypeBilling.setBorder(null);
        jTFtypeBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtypeBillingActionPerformed(evt);
            }
        });
        jPanel3.add(jTFtypeBilling, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 220, 20));

        jSeparator14.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator14.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 220, 12));

        jLabel28.setBackground(new java.awt.Color(86, 42, 35));
        jLabel28.setForeground(new java.awt.Color(86, 42, 35));
        jLabel28.setText("TELEFONO");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, 20));

        jTFThelephoneJuridical.setBackground(new java.awt.Color(249, 242, 228));
        jTFThelephoneJuridical.setForeground(new java.awt.Color(51, 51, 51));
        jTFThelephoneJuridical.setBorder(null);
        jTFThelephoneJuridical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFThelephoneJuridicalActionPerformed(evt);
            }
        });
        jPanel3.add(jTFThelephoneJuridical, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 220, 20));

        jSeparator15.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator15.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 220, 12));

        jLabel29.setBackground(new java.awt.Color(86, 42, 35));
        jLabel29.setForeground(new java.awt.Color(86, 42, 35));
        jLabel29.setText("EMAIL");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jTFEmailJuridical.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmailJuridical.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmailJuridical.setBorder(null);
        jTFEmailJuridical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailJuridicalActionPerformed(evt);
            }
        });
        jPanel3.add(jTFEmailJuridical, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 220, 20));

        jSeparator16.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator16.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, 12));

        jLabel30.setBackground(new java.awt.Color(86, 42, 35));
        jLabel30.setForeground(new java.awt.Color(86, 42, 35));
        jLabel30.setText("DIRECCION");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, 20));

        jTFAddressJuridical.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddressJuridical.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddressJuridical.setBorder(null);
        jTFAddressJuridical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressJuridicalActionPerformed(evt);
            }
        });
        jPanel3.add(jTFAddressJuridical, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 220, 20));

        jSeparator17.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator17.setForeground(new java.awt.Color(86, 42, 35));
        jPanel3.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 220, 12));

        jPtypeCustomer.add(jPanel3, "Factura");

        jPanel2.setBackground(new java.awt.Color(249, 242, 228));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFLastNameP.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameP.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameP.setBorder(null);
        jTFLastNameP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNamePActionPerformed(evt);
            }
        });
        jPanel2.add(jTFLastNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 210, 20));

        jTFBhirtday.setBackground(new java.awt.Color(249, 242, 228));
        jTFBhirtday.setForeground(new java.awt.Color(51, 51, 51));
        jTFBhirtday.setBorder(null);
        jTFBhirtday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBhirtdayActionPerformed(evt);
            }
        });
        jPanel2.add(jTFBhirtday, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 210, 20));

        jLabel22.setBackground(new java.awt.Color(86, 42, 35));
        jLabel22.setForeground(new java.awt.Color(86, 42, 35));
        jLabel22.setText("DIRECCION");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 140, -1));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 12));

        jTFLastNameM.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameM.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameM.setBorder(null);
        jTFLastNameM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNameMActionPerformed(evt);
            }
        });
        jPanel2.add(jTFLastNameM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 220, 20));

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 220, 12));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 210, 10));

        jTFTelephone.setBackground(new java.awt.Color(249, 242, 228));
        jTFTelephone.setForeground(new java.awt.Color(51, 51, 51));
        jTFTelephone.setBorder(null);
        jTFTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelephoneActionPerformed(evt);
            }
        });
        jPanel2.add(jTFTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 220, 20));

        jLabel17.setBackground(new java.awt.Color(86, 42, 35));
        jLabel17.setForeground(new java.awt.Color(86, 42, 35));
        jLabel17.setText("DNI");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jLabel15.setBackground(new java.awt.Color(86, 42, 35));
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 140, -1));

        jTFAddress.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddress.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddress.setBorder(null);
        jTFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressActionPerformed(evt);
            }
        });
        jPanel2.add(jTFAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 210, 20));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 220, 12));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("TELEFONO");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, 20));

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 12));

        jTFEmail.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmail.setBorder(null);
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        jPanel2.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        jTFName.setBackground(new java.awt.Color(249, 242, 228));
        jTFName.setForeground(new java.awt.Color(51, 51, 51));
        jTFName.setBorder(null);
        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });
        jPanel2.add(jTFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 20));

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, 12));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("EMAIL");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jTFdni.setBackground(new java.awt.Color(249, 242, 228));
        jTFdni.setForeground(new java.awt.Color(51, 51, 51));
        jTFdni.setBorder(null);
        jTFdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdniActionPerformed(evt);
            }
        });
        jPanel2.add(jTFdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 20));

        jLabel16.setBackground(new java.awt.Color(86, 42, 35));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 20));

        jLabel13.setBackground(new java.awt.Color(86, 42, 35));
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("NOMBRE");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 140, -1));

        jSeparator9.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator9.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 210, 10));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 210, 10));

        jPtypeCustomer.add(jPanel2, "Boleta");

        jPanel1.add(jPtypeCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public CustomerRegisterModalController getCustomerRegisterModalController() {
        return customerRegisterModalController;

    }

    public JPanel getjPtypeCustomer() {
        return jPtypeCustomer;
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

    public JTextField getjTFAddressJuridical() {
        return jTFAddressJuridical;
    }

    public JTextField getjTFEmailJuridical() {
        return jTFEmailJuridical;
    }

    public JTextField getjTFThelephoneJuridical() {
        return jTFThelephoneJuridical;
    }

    public JTextField getjTFactivityEconomic() {
        return jTFactivityEconomic;
    }

    public JTextField getjTFrazonSocial() {
        return jTFrazonSocial;
    }

    public JTextField getjTFruc() {
        return jTFruc;
    }

    public JTextField getjTFtype() {
        return jTFtype;
    }

    public JTextField getjTFtypeBilling() {
        return jTFtypeBilling;
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

    private void jTFrazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFrazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFrazonSocialActionPerformed

    private void jTFrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFrucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFrucActionPerformed

    private void jTFtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFtypeActionPerformed

    private void jTFactivityEconomicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFactivityEconomicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFactivityEconomicActionPerformed

    private void jTFtypeBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFtypeBillingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFtypeBillingActionPerformed

    private void jTFThelephoneJuridicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFThelephoneJuridicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFThelephoneJuridicalActionPerformed

    private void jTFEmailJuridicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailJuridicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailJuridicalActionPerformed

    private void jTFAddressJuridicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAddressJuridicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAddressJuridicalActionPerformed

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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPtypeCustomer;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTFAddress;
    private javax.swing.JTextField jTFAddressJuridical;
    private javax.swing.JTextField jTFBhirtday;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFEmailJuridical;
    private javax.swing.JTextField jTFLastNameM;
    private javax.swing.JTextField jTFLastNameP;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFTelephone;
    private javax.swing.JTextField jTFThelephoneJuridical;
    private javax.swing.JTextField jTFactivityEconomic;
    private javax.swing.JTextField jTFdni;
    private javax.swing.JTextField jTFrazonSocial;
    private javax.swing.JTextField jTFruc;
    private javax.swing.JTextField jTFtype;
    private javax.swing.JTextField jTFtypeBilling;
    // End of variables declaration//GEN-END:variables
}
