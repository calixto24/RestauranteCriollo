package utp.restaurant.cashier.controller;

import java.awt.CardLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.view.VoucherView;
import utp.restaurant.dao.CustomerDAO;
import utp.restaurant.dao.JuridicalCustomerDAO;
import utp.restaurant.dao.NaturalCustomerDAO;
import utp.restaurant.model.Bill;
import utp.restaurant.model.Customer;
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
    private Order order;
    private Store store;
    private Voucher voucher;
    private Validate vldt;

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

        juridicalCustomer = null;
        naturalCustomer = null;

    }

    public void setOrder(Order order) {
        this.order = order;
        voucher.setOrder(order);
    }

    public void initAttributes() {
        voucherView.getjLBnumerTable().setText(order.getTable().getNumber_table() + "");
        voucher.calculateIgv();
        voucherView.getjTFsubTotal().setText(String.format("S/. %,.2f", voucher.getOrder().getTotal_Price()));
        voucherView.getTfTaxed().setText(String.format("S/. %,.2f", voucher.calcTaxed()));
        voucherView.getjTFigv().setText(String.format("S/. %,.2f", voucher.getIgv()));
        
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

    public void handleDniClick() {

        //VALIDACION
        String dniStr = voucherView.getjTFdniStr().getText();

        int dni = 0;

        if (!dniStr.trim().isEmpty()) {
            dni = Integer.parseInt(dniStr);
        }

        ArrayList<NaturalCustomer> naturalCustomerList = naturalCustomerDAO.getAll();

        for (NaturalCustomer c : naturalCustomerList) {

            if (dni == c.getDni()) {
                naturalCustomer = c;
            }
        }

        try {

            voucherView.getjTFnombreStr().setText(naturalCustomer.getName());
            voucherView.getjTFapellidoPstr().setText(naturalCustomer.getLastname_paternal());
            voucherView.getjTFapellidoMstr().setText(naturalCustomer.getLastname_maternal());

        } catch (Exception e) {

            voucherView.showMessage("No existe el cliente en la BD");

        }

    }

    public void handleRucClick() {

        String rucstr = voucherView.getjTFruc().getText();

        long ruc = 0;

        if (!rucstr.trim().isEmpty()) {
            ruc = Long.parseLong(rucstr);
        }

        ArrayList<JuridicalCustomer> juridicalCustomerList = juridicalCustomerDAO.getAll();

        for (JuridicalCustomer c : juridicalCustomerList) {

            if (ruc == c.getRuc()) {
                juridicalCustomer = c;
            }
        }

        try {

            voucherView.getjTFsocialReason().setText(juridicalCustomer.getSocialReason());
            voucherView.getjTFdireccion().setText(juridicalCustomer.getAddress());

        } catch (Exception e) {

            voucherView.showMessage("No existe el cliente en la BD");

        }

    }

    public void handleFinishClick() {

        String typeDocument = voucherView.getjCBTypeDocument().getSelectedItem().toString();

        //cliente
        //Customer customer = (Customer) voucherView.getjCBcustomer().getSelectedItem();
        //tipo de pago
        String paymentType = voucherView.getjCBpaymentType().getSelectedItem().toString();

    }

}
