package utp.restaurant.cashier.controller;

import java.awt.CardLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.view.VoucherView;
import utp.restaurant.dao.BillDAO;
import utp.restaurant.dao.JuridicalCustomerDAO;
import utp.restaurant.dao.NaturalCustomerDAO;
import utp.restaurant.dao.TicketDAO;
import utp.restaurant.model.Bill;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.JuridicalCustomer;
import utp.restaurant.model.NaturalCustomer;
import utp.restaurant.model.Order;
import utp.restaurant.model.Ticket;
import utp.restaurant.model.Voucher;
import utp.restaurant.store.Store;
import utp.restaurant.utils.Validate;

public class VoucherController {

    private VoucherView voucherView;
    private JuridicalCustomerDAO juridicalCustomerDAO;
    private NaturalCustomerDAO naturalCustomerDAO;
    private BillDAO billDAO;
    private TicketDAO ticketDAO;

    private Order order;
    private Store store;
    private Voucher voucher;
    private Validate vldt;

    private boolean discountApplied;
    private boolean birthdayDiscountApplied;

    //objetos vacios
    private JuridicalCustomer juridicalCustomer;
    private NaturalCustomer naturalCustomer;

    public VoucherController(VoucherView voucherView) {
        this.voucherView = voucherView;
        vldt = new Validate();
        store = Store.getInstance();

        voucher = new Bill();

        juridicalCustomerDAO = new JuridicalCustomerDAO();
        naturalCustomerDAO = new NaturalCustomerDAO();
        billDAO = new BillDAO();
        ticketDAO = new TicketDAO();

        juridicalCustomer = null;
        naturalCustomer = null;
        discountApplied = false;
        birthdayDiscountApplied = false;

    }

    public void setOrder(Order order) {
        this.order = order;
        voucher.setOrder(order);
    }

    public void initAttributes() {
        voucherView.getjLBnumerTable().setText(order.getTable().getNumber_table() + "");

        //inicializando metodos
        voucher.calculateIgv();
        voucher.calculateTotalPrice();

        //pintando
        voucherView.getjTFsubTotal().setText(String.format("S/. %,.2f", voucher.getOrder().getTotal_Price()));
        voucherView.getTfTaxed().setText(String.format("S/. %,.2f", voucher.calcTaxed()));
        voucherView.getjTFigv().setText(String.format("S/. %,.2f", voucher.getIgv()));
        voucherView.getjTFtotal().setText(String.format("S/. %,.2f", voucher.getTotalPrice()));

    }

    public void autoCompletedDocumentClick() {

        switch (voucherView.getjCBTypeDocument().getSelectedItem().toString()) {

            case "Factura":

                String rucstr = voucherView.getjTFruc().getText();
                vldt.setElement(rucstr)
                        .isRequired("El numero de RUC es obligatorio")
                        .isLong("El numero de DNI debe ser numerico")
                        .equalsLength(11, "El RUC tiene 11 digitos");

                if (!vldt.exec()) {
                    voucherView.showMessage(vldt.getMessage());
                    voucherView.getjTFruc().requestFocus();
                    handleCleanForm();
                    return;
                }

                long ruc = Long.parseLong(rucstr);

                ArrayList<JuridicalCustomer> juridicalCustomerList = juridicalCustomerDAO.getAll();

                for (JuridicalCustomer c : juridicalCustomerList) {

                    if (ruc == c.getRuc()) {
                        juridicalCustomer = c;
                    }
                }

                try {

                    if (juridicalCustomer != null) {

                        //PINTANDO COMPROBANTE
                        voucherView.getjTFsocialReason().setText(juridicalCustomer.getSocialReason());
                        voucherView.getjTFdireccion().setText(juridicalCustomer.getAddress());

                        //PINTANDO DETALLES
                        if (!discountApplied && juridicalCustomer != null) {
                            voucher.calculateDiscount();
                            discountApplied = true;
                        } else if (naturalCustomer == null) {
                            voucher.setDiscount(0);
                        }

                        voucherView.getjTFdiscount().setText(String.format("S/. %,.2f", voucher.getDiscount()));

                    } else {

                        voucherView.showMessage("No existe el cliente en la BD");
                        handleCleanForm();

                    }
                } catch (Exception e) {

                    voucherView.showMessage("Ocurrió un error al procesar el cliente.");
                    handleCleanForm();

                }

                break;

            case "Boleta":

                String dniStr = voucherView.getjTFdniStr().getText();
                vldt.setElement(dniStr)
                        .isRequired("El numero DNI es obligatorio")
                        .isInt("El numero de DNI debe ser numerico")
                        .equalsLength(8, "El numero de DNI tiene 8 digitos");

                if (!vldt.exec()) {
                    voucherView.showMessage(vldt.getMessage());
                    voucherView.getjTFdniStr().requestFocus();
                    handleCleanForm();
                    return;
                }

                int dni = Integer.parseInt(dniStr);

                ArrayList<NaturalCustomer> naturalCustomerList = naturalCustomerDAO.getAll();

                for (NaturalCustomer c : naturalCustomerList) {

                    if (dni == c.getDni()) {
                        naturalCustomer = c;
                    }
                }

                try {

                    if (naturalCustomer != null) {

                        //PINTA DATOS DEL COMPROBANTE
                        voucherView.getjTFnombreStr().setText(naturalCustomer.getName());
                        voucherView.getjTFapellidoPstr().setText(naturalCustomer.getLastname_paternal());
                        voucherView.getjTFapellidoMstr().setText(naturalCustomer.getLastname_maternal());

                        //PINTA DETALLES
                        if (!birthdayDiscountApplied && naturalCustomer != null) {
                            voucher.calculateDiscount(naturalCustomer);
                            birthdayDiscountApplied = true;
                        }

                        if (!discountApplied && naturalCustomer != null) {
                            voucher.calculateDiscount();
                            discountApplied = true;
                        } else if (naturalCustomer == null) {
                            voucher.setDiscount(0);
                        }

                        voucherView.getjTFdiscount().setText(String.format("S/. %,.2f", voucher.getDiscount()));

                    } else {

                        voucherView.showMessage("No existe el cliente en la BD");
                        handleCleanForm();

                    }
                } catch (Exception e) {

                    voucherView.showMessage("Ocurrió un error al procesar el cliente.");
                    handleCleanForm();

                }

                break;
        }

        initAttributes();

    }

    public void handleCleanForm() {
        switch (voucherView.getjCBTypeDocument().getSelectedItem().toString()) {
            case "Factura":
                voucherView.getjTFruc().setText("");
                voucherView.getjTFsocialReason().setText("");
                voucherView.getjTFdireccion().setText("");
                juridicalCustomer = null;
                break;
            case "Boleta":
                voucherView.getjTFdniStr().setText("");
                voucherView.getjTFnombreStr().setText("");
                voucherView.getjTFapellidoPstr().setText("");
                voucherView.getjTFapellidoMstr().setText("");
                naturalCustomer = null;
                break;
        }

        voucher.setDiscount(0);
        voucherView.getjTFdiscount().setText(String.format("S/. %,.2f", voucher.getDiscount()));

        birthdayDiscountApplied = false;
        discountApplied = false;
        initAttributes();
    }

    public void handlePaymentTypeClick() {

        switch (voucherView.getjCBpaymentType().getSelectedItem().toString()) {

            case "Efectivo":

                voucherView.getjTFvuelto().setVisible(true);
                voucherView.getjLBvuelto().setVisible(true);
                voucherView.getjTFamount().setEditable(true);

                voucher.setAdditionalPayments(0);

                break;

            case "Tarjeta":

                voucherView.getjTFvuelto().setVisible(false);
                voucherView.getjLBvuelto().setVisible(false);

                voucherView.getjTFamount().setEditable(false);
                
                voucher.calcAddPayment();
                voucher.calculateTotalPrice();
                
                voucherView.getjTFamount().setText(voucher.getTotalPrice() + "");

                break;

        }

        voucherView.getjTFsobrecargo().setText(String.format("S/. %,.2f", voucher.getAdditionalPayments()));
        initAttributes();

    }

    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Nombre",
            "Imagen",
            "Cantidad",
            "Precio Unitario",
            "Total"
        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);

        ArrayList<ItemOrder> itemOrderList = order.getItemOrderList();

        for (ItemOrder i : itemOrderList) {

            //obtengo y cargo la imagen a traves de su direcciom
            ImageIcon img = new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + i.getItemMenu().getImage()));

            //le agrego dimensiones
            Image scaledImage = img.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

            Object row[] = {
                i.getItemMenu().getName(),
                new ImageIcon(scaledImage),
                i.getAmount(),
                i.getItemMenu().getPrice(),
                i.getTotal()
            };

            tableModel.addRow(row);
        }

        return tableModel;
    }

    public void handleVoucherTypeClick() {

        CardLayout cl = (CardLayout) voucherView.getjPVaucher().getLayout();

        switch (voucherView.getjCBTypeDocument().getSelectedItem().toString()) {

            case "Factura":
                voucher = new Bill();
                cl.show(voucherView.getjPVaucher(), "factura");
                break;
            case "Boleta":
                voucher = new Ticket();
                cl.show(voucherView.getjPVaucher(), "boleta");
                break;
        }

        voucher.setOrder(order);
    }

    public void handleAmountClick() {

        String amountstr = voucherView.getjTFamount().getText();
        double amount = 0;

        switch (voucherView.getjCBpaymentType().getSelectedItem().toString()) {

            case "Efectivo":

                vldt.setElement(amountstr)
                        .isRequired("El monto es obligatorio")
                        .isDouble("El monto debe ser numerico")
                        .greaterThanDouble(voucher.getTotalPrice(), "El monto no puede ser menor que el total");

                if (!vldt.exec()) {
                    voucherView.showMessage(vldt.getMessage());
                    voucherView.getjTFamount().requestFocus();
                    return;
                }

                amount = Double.parseDouble(amountstr);

                voucher.calcTurned(amount);
                voucherView.getjTFvuelto().setText(String.format("S/. %,.2f", voucher.getTurned()));

                break;

        }

    }

    public void handleFinishClick() {

        String selectedDocument = voucherView.getjCBTypeDocument().getSelectedItem().toString();

        switch (selectedDocument) {

            case "Factura":
                if (juridicalCustomer == null) {
                    voucherView.showMessage("Debe seleccionar un cliente jurídico antes de finalizar la factura");
                    return; 
                }

                Bill newBill = new Bill(juridicalCustomer, order, store.getEmploye());

                try {
                    //añade una factura
                    billDAO.add(newBill);
                    
                    //cambia estado el pedido
                    newBill.getOrder().setStatus("Finalizado");
                    newBill.getOrder().getTable().setStatus("Disponible");
                    
                    voucherView.showMessage("Factura finalizada correctamente");
                    voucherView.dispose();

                } catch (Exception e) {
                    voucherView.showMessage("Error al finalizar la factura");
                }

                break;

            case "Boleta":
                if (naturalCustomer == null) {
                    voucherView.showMessage("Debe seleccionar un cliente natural antes de finalizar la boleta");
                    return; 
                }

                Ticket newTicket = new Ticket(naturalCustomer, order, store.getEmploye());

                try {
                    ticketDAO.add(newTicket);
                    
                    //cambia estado el pedido
                    newTicket.getOrder().setStatus("Finalizado");
                    newTicket.getOrder().getTable().setStatus("Disponible");
                    
                    voucherView.showMessage("Boleta finalizada correctamente");
                    voucherView.dispose();

                } catch (Exception e) {
                    voucherView.showMessage("Error al finalizar la boleta");
                }

                break;
        }
        
        voucher = null;
    }
    

}
