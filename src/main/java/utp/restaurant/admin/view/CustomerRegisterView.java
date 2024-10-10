package utp.restaurant.admin.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utp.restaurant.admin.controller.CustomerController;

public class CustomerRegisterView extends javax.swing.JFrame {

    //atributos
    private CustomerController customerController;
    private int juridicalRow;
    private int naturalRow;

    //Constructor vacio
    public CustomerRegisterView() {
        customerController = new CustomerController(this);

        initComponents();

        renderTable();

        BtnDelete.setVisible(false);
    }

    public void renderTable() {

        DefaultTableModel customerModel = customerController.getCustomerModel();

        if (jCBcustomerType.getSelectedItem().toString().equals("JURIDICO")) {

            jTjuridicalList.setRowHeight(40);
            jTjuridicalList.setModel(customerModel);

            TableColumnModel xd = jTjuridicalList.getColumnModel();
            xd.removeColumn(xd.getColumn(0));
            xd.removeColumn(xd.getColumn(0));
            xd.removeColumn(xd.getColumn(0));

        } else if (jCBcustomerType.getSelectedItem().toString().equals("NATURAL")) {
            
            jTnaturalList.setRowHeight(40);
            jTnaturalList.setModel(customerModel);

            TableColumnModel xd = jTnaturalList.getColumnModel();
            xd.removeColumn(xd.getColumn(0));
            xd.removeColumn(xd.getColumn(0));
            xd.removeColumn(xd.getColumn(0));
            
        }
        
        System.out.println(jCBcustomerType.getSelectedItem().toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPCustomerType = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jTFLastNameP = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jTFLastNameM = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jTFdni = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jTFBhirtday = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jTFTelephone = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jTFAddress = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTnaturalList = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTjuridicalList = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jCBcustomerType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel3.setBackground(new java.awt.Color(249, 242, 228));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, 100, 30));

        BtnLimpiar.setBackground(new java.awt.Color(86, 42, 35));
        BtnLimpiar.setForeground(new java.awt.Color(249, 242, 228));
        BtnLimpiar.setText("LIMPIAR");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(BtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 660, 90, 30));

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

        jPCustomerType.setBackground(new java.awt.Color(255, 255, 255));
        jPCustomerType.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(249, 242, 228));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(86, 42, 35));
        jLabel13.setForeground(new java.awt.Color(86, 42, 35));
        jLabel13.setText("NOMBRE");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jTFName.setBackground(new java.awt.Color(249, 242, 228));
        jTFName.setForeground(new java.awt.Color(51, 51, 51));
        jTFName.setBorder(null);
        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });
        jPanel6.add(jTFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 20));

        jSeparator2.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator2.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 12));

        jLabel24.setBackground(new java.awt.Color(86, 42, 35));
        jLabel24.setForeground(new java.awt.Color(86, 42, 35));
        jLabel24.setText("APELLIDO PATERNO");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 140, -1));

        jTFLastNameP.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameP.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameP.setBorder(null);
        jTFLastNameP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNamePActionPerformed(evt);
            }
        });
        jPanel6.add(jTFLastNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 210, 20));

        jSeparator3.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator3.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 210, 10));

        jLabel16.setBackground(new java.awt.Color(86, 42, 35));
        jLabel16.setForeground(new java.awt.Color(86, 42, 35));
        jLabel16.setText("APELLIDO MATERNO");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 20));

        jTFLastNameM.setBackground(new java.awt.Color(249, 242, 228));
        jTFLastNameM.setForeground(new java.awt.Color(51, 51, 51));
        jTFLastNameM.setBorder(null);
        jTFLastNameM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLastNameMActionPerformed(evt);
            }
        });
        jPanel6.add(jTFLastNameM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 220, 20));

        jSeparator4.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator4.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 220, 12));

        jLabel17.setBackground(new java.awt.Color(86, 42, 35));
        jLabel17.setForeground(new java.awt.Color(86, 42, 35));
        jLabel17.setText("DNI");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jTFdni.setBackground(new java.awt.Color(249, 242, 228));
        jTFdni.setForeground(new java.awt.Color(51, 51, 51));
        jTFdni.setBorder(null);
        jTFdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdniActionPerformed(evt);
            }
        });
        jPanel6.add(jTFdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 20));

        jSeparator5.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator5.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 12));

        jLabel19.setBackground(new java.awt.Color(86, 42, 35));
        jLabel19.setForeground(new java.awt.Color(86, 42, 35));
        jLabel19.setText("FECHA DE NACIMIENTO");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 140, -1));

        jTFBhirtday.setBackground(new java.awt.Color(249, 242, 228));
        jTFBhirtday.setForeground(new java.awt.Color(51, 51, 51));
        jTFBhirtday.setBorder(null);
        jTFBhirtday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBhirtdayActionPerformed(evt);
            }
        });
        jPanel6.add(jTFBhirtday, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 210, 20));

        jSeparator6.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator6.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 210, 10));

        jLabel18.setBackground(new java.awt.Color(86, 42, 35));
        jLabel18.setForeground(new java.awt.Color(86, 42, 35));
        jLabel18.setText("TELEFONO");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, 20));

        jTFTelephone.setBackground(new java.awt.Color(249, 242, 228));
        jTFTelephone.setForeground(new java.awt.Color(51, 51, 51));
        jTFTelephone.setBorder(null);
        jTFTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTelephoneActionPerformed(evt);
            }
        });
        jPanel6.add(jTFTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 220, 20));

        jSeparator7.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator7.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 220, 12));

        jLabel20.setBackground(new java.awt.Color(86, 42, 35));
        jLabel20.setForeground(new java.awt.Color(86, 42, 35));
        jLabel20.setText("EMAIL");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jTFEmail.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmail.setBorder(null);
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        jPanel6.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 20));

        jSeparator8.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator8.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, 12));

        jLabel22.setBackground(new java.awt.Color(86, 42, 35));
        jLabel22.setForeground(new java.awt.Color(86, 42, 35));
        jLabel22.setText("DIRECCION");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 140, -1));

        jTFAddress.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddress.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddress.setBorder(null);
        jTFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressActionPerformed(evt);
            }
        });
        jPanel6.add(jTFAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 210, 20));

        jSeparator9.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator9.setForeground(new java.awt.Color(86, 42, 35));
        jPanel6.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 210, 10));

        jTnaturalList.setBackground(new java.awt.Color(255, 255, 255));
        jTnaturalList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTnaturalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTnaturalListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTnaturalList);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 730, 290));

        jPCustomerType.add(jPanel6, "naturalCustomer");

        jPanel5.setBackground(new java.awt.Color(249, 242, 228));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(86, 42, 35));
        jLabel23.setForeground(new java.awt.Color(86, 42, 35));
        jLabel23.setText("RAZON SOCIAL");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jTFrazonSocial.setBackground(new java.awt.Color(249, 242, 228));
        jTFrazonSocial.setBorder(null);
        jTFrazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrazonSocialActionPerformed(evt);
            }
        });
        jPanel5.add(jTFrazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 20));

        jSeparator11.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator11.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 12));

        jLabel21.setBackground(new java.awt.Color(86, 42, 35));
        jLabel21.setForeground(new java.awt.Color(86, 42, 35));
        jLabel21.setText("RUC");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 20));

        jTFruc.setBackground(new java.awt.Color(249, 242, 228));
        jTFruc.setForeground(new java.awt.Color(51, 51, 51));
        jTFruc.setBorder(null);
        jTFruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrucActionPerformed(evt);
            }
        });
        jPanel5.add(jTFruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 220, 20));

        jSeparator10.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator10.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 220, 12));

        jLabel25.setBackground(new java.awt.Color(86, 42, 35));
        jLabel25.setForeground(new java.awt.Color(86, 42, 35));
        jLabel25.setText("TIPO");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 20));

        jTFtype.setBackground(new java.awt.Color(249, 242, 228));
        jTFtype.setForeground(new java.awt.Color(51, 51, 51));
        jTFtype.setBorder(null);
        jTFtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtypeActionPerformed(evt);
            }
        });
        jPanel5.add(jTFtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 220, 20));

        jSeparator12.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator12.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 12));

        jLabel26.setBackground(new java.awt.Color(86, 42, 35));
        jLabel26.setForeground(new java.awt.Color(86, 42, 35));
        jLabel26.setText("ACTIVIDAD ECONOMICA");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jTFactivityEconomic.setBackground(new java.awt.Color(249, 242, 228));
        jTFactivityEconomic.setForeground(new java.awt.Color(51, 51, 51));
        jTFactivityEconomic.setBorder(null);
        jTFactivityEconomic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFactivityEconomicActionPerformed(evt);
            }
        });
        jPanel5.add(jTFactivityEconomic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 220, 20));

        jSeparator13.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator13.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 12));

        jLabel27.setBackground(new java.awt.Color(86, 42, 35));
        jLabel27.setForeground(new java.awt.Color(86, 42, 35));
        jLabel27.setText("TIPO DE FACTURACION");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, 20));

        jTFtypeBilling.setBackground(new java.awt.Color(249, 242, 228));
        jTFtypeBilling.setForeground(new java.awt.Color(51, 51, 51));
        jTFtypeBilling.setBorder(null);
        jTFtypeBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtypeBillingActionPerformed(evt);
            }
        });
        jPanel5.add(jTFtypeBilling, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 220, 20));

        jSeparator14.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator14.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 220, 12));

        jLabel28.setBackground(new java.awt.Color(86, 42, 35));
        jLabel28.setForeground(new java.awt.Color(86, 42, 35));
        jLabel28.setText("TELEFONO");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, 20));

        jTFThelephoneJuridical.setBackground(new java.awt.Color(249, 242, 228));
        jTFThelephoneJuridical.setForeground(new java.awt.Color(51, 51, 51));
        jTFThelephoneJuridical.setBorder(null);
        jTFThelephoneJuridical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFThelephoneJuridicalActionPerformed(evt);
            }
        });
        jPanel5.add(jTFThelephoneJuridical, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 220, 20));

        jSeparator15.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator15.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 220, 12));

        jLabel29.setBackground(new java.awt.Color(86, 42, 35));
        jLabel29.setForeground(new java.awt.Color(86, 42, 35));
        jLabel29.setText("EMAIL");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jTFEmailJuridical.setBackground(new java.awt.Color(249, 242, 228));
        jTFEmailJuridical.setForeground(new java.awt.Color(51, 51, 51));
        jTFEmailJuridical.setBorder(null);
        jTFEmailJuridical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailJuridicalActionPerformed(evt);
            }
        });
        jPanel5.add(jTFEmailJuridical, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 220, 20));

        jSeparator16.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator16.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, 12));

        jLabel30.setBackground(new java.awt.Color(86, 42, 35));
        jLabel30.setForeground(new java.awt.Color(86, 42, 35));
        jLabel30.setText("DIRECCION");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, 20));

        jTFAddressJuridical.setBackground(new java.awt.Color(249, 242, 228));
        jTFAddressJuridical.setForeground(new java.awt.Color(51, 51, 51));
        jTFAddressJuridical.setBorder(null);
        jTFAddressJuridical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAddressJuridicalActionPerformed(evt);
            }
        });
        jPanel5.add(jTFAddressJuridical, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 220, 20));

        jSeparator17.setBackground(new java.awt.Color(86, 42, 35));
        jSeparator17.setForeground(new java.awt.Color(86, 42, 35));
        jPanel5.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 220, 12));

        jTjuridicalList.setBackground(new java.awt.Color(255, 255, 255));
        jTjuridicalList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTjuridicalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTjuridicalListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTjuridicalList);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 730, 290));

        jPCustomerType.add(jPanel5, "juridicalCustomer");

        jPanel3.add(jPCustomerType, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 750, 480));

        jLabel15.setBackground(new java.awt.Color(86, 42, 35));
        jLabel15.setForeground(new java.awt.Color(86, 42, 35));
        jLabel15.setText("TIPO DE CLIENTE");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 140, -1));

        jCBcustomerType.setBackground(new java.awt.Color(249, 242, 228));
        jCBcustomerType.setForeground(new java.awt.Color(102, 102, 102));
        jCBcustomerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NATURAL", "JURIDICO" }));
        jCBcustomerType.setBorder(null);
        jCBcustomerType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBcustomerTypeActionPerformed(evt);
            }
        });
        jPanel3.add(jCBcustomerType, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jTjuridicalListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTjuridicalListMouseClicked
        juridicalRow = jTjuridicalList.rowAtPoint(evt.getPoint());

        customerController.heandleViewEditClick();
    }//GEN-LAST:event_jTjuridicalListMouseClicked

    private void jTFrazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFrazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFrazonSocialActionPerformed

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

    private void jTnaturalListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTnaturalListMouseClicked
        naturalRow = jTnaturalList.rowAtPoint(evt.getPoint());

        customerController.heandleViewEditClick();
    }//GEN-LAST:event_jTnaturalListMouseClicked

    private void jCBcustomerTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBcustomerTypeActionPerformed

        customerController.handleCustomerTypeClick();

    }//GEN-LAST:event_jCBcustomerTypeActionPerformed

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(rootPane, message);
    }

    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(rootPane, message);
    }

    //Metodos Getters
    public JPanel getjPCustomerType() {
        return jPCustomerType;
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

    public JTextField getjTFtype() {
        return jTFtype;
    }

    public JTextField getjTFtypeBilling() {
        return jTFtypeBilling;
    }

    public JComboBox<String> getjCBcustomerType() {
        return jCBcustomerType;
    }

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

    public int getJuridicalRow() {
        return juridicalRow;
    }

    public int getNaturalRow() {
        return naturalRow;
    }

    public JTable getjTjuridicalList() {
        return jTjuridicalList;
    }

    public JTable getjTnaturalList() {
        return jTnaturalList;
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
    private javax.swing.JComboBox<String> jCBcustomerType;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPCustomerType;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable jTjuridicalList;
    private javax.swing.JTable jTnaturalList;
    // End of variables declaration//GEN-END:variables
}
