package utp.restaurant.cashier.controller;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.view.VoucherView;
import utp.restaurant.dao.CustomerDAO;
import utp.restaurant.model.Customer;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;

public class VoucherController {

    private VoucherView voucherView;
    private CustomerDAO customerDAO;
    private Order order;

    public VoucherController(VoucherView voucherView) {
        this.voucherView = voucherView;
        customerDAO = new CustomerDAO();
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void setAtributtes() {
        
        voucherView.getjLBnumerTable().setText(order.getTable().getNumber_table() + "");
        voucherView.getjTFsubTotal().setText(order.getTotal_Price() + "");
        
    }
    
    public void renderCBCustomer() {
        
        ArrayList<Customer> customerList = customerDAO.getAll();
        
        voucherView.getjCBcustomer().removeAllItems();
        
        for (Customer c : customerList) {
            voucherView.getjCBcustomer().addItem(c);
        }
        
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

}
