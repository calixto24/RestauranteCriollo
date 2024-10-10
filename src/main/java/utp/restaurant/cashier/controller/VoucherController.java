package utp.restaurant.cashier.controller;

import java.awt.CardLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.view.VoucherView;
import utp.restaurant.dao.CustomerDAO;
import utp.restaurant.model.Bill;
import utp.restaurant.model.Customer;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;
import utp.restaurant.model.Ticket;
import utp.restaurant.model.Voucher;
import utp.restaurant.store.Store;

public class VoucherController {

    private VoucherView voucherView;
    private CustomerDAO customerDAO;
    private Order order;
    private Store store;
    private Customer customer = null;
    private Voucher voucher;

    public VoucherController(VoucherView voucherView) {
        this.voucherView = voucherView;
        customerDAO = new CustomerDAO();
        store = Store.getInstance();
        voucher = new Bill();
    }

    public void setOrder(Order order) {
        this.order = order;
        voucher.setOrder(order);
    }

    public void initAttributes() {
        voucherView.getjLBnumerTable().setText(order.getTable().getNumber_table() + "");
        voucher.calculateIgv();
        voucherView.getTfTaxed().setText(String.format("S/. %,.2f", voucher.calcTaxed()));
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
        String dniStr = voucherView.getjTFdniStr().getText();
        
        int dni = 0;
        
        if (!dniStr.trim().isEmpty()) {
            dni = Integer.parseInt(dniStr);
        }

        ArrayList<Customer> customerList = customerDAO.getAll();

        for (Customer c : customerList) {

            if (dni == c.getDni()) {
                customer = c;
            }
        }

        voucherView.getjTFnombreStr().setText(customer.getName());
        voucherView.getjTFapellidoPstr().setText(customer.getLastname_paternal());
        voucherView.getjTFapellidoMstr().setText(customer.getLastname_maternal());

    }
    
    public void handleRucClick(){
        
        String ruc = voucherView.getjTFruc().getText();

        ArrayList<Customer> customerList = customerDAO.getAll();

        for (Customer c : customerList) {

            if (ruc.equals(c.getRuc())) {
                customer = c;
            }
        }

        voucherView.getjTFsocialReason().setText(customer.getSocialReason());
        voucherView.getjTFdireccion().setText(customer.getAddress());
        
    }
    
    public void handleFinishClick() {

        String typeDocument = voucherView.getjCBTypeDocument().getSelectedItem().toString();

        //cliente
        //Customer customer = (Customer) voucherView.getjCBcustomer().getSelectedItem();
        //tipo de pago
        String paymentType = voucherView.getjCBpaymentType().getSelectedItem().toString();

    }

}
