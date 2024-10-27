package utp.restaurant.waiter.controller;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.dao.TableDAO;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;
import utp.restaurant.waiter.view.OrderDetails;
import utp.restaurant.waiter.view.TakeOrderView;

public class OrderDetailsController {

    private OrderDetails orderDetails;
    private OrderDAO orderDAO;

    public OrderDetailsController(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        
        orderDAO = new OrderDAO();
    }

    public DefaultTableModel getTableModel(Order order) {

        String columns[] = {
            "Nombre",
            "Imagen",
            "Precio Unitario",
            "Cantidad",
            "Precio Total"
        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);

        for (ItemOrder itemOrder : order.getItemOrderList()) {

            //obtengo y cargo la imagen a traves de su direcciom
            ImageIcon img = new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + itemOrder.getItemMenu().getImage()));

            //le agrego dimensiones
            Image scaledImage = img.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

            Object row[] = {
                itemOrder.getItemMenu().getName(),
                new ImageIcon(scaledImage),
                itemOrder.getItemMenu().getPrice(),
                itemOrder.getAmount(),
                itemOrder.getTotal()
            };

            tableModel.addRow(row);

        }

        return tableModel;

    }
    
    public void handleEditClick(Order order) {
        
        TakeOrderView takeOrderView = new TakeOrderView(order);
        
        takeOrderView.setVisible(true);
        
    }
    
    public void handleDeleteClick(Order order) {
        
        int op = orderDetails.showConfirmDialog("¿Desea eliminar esa orden?");
        
        if(op != 0) {
            
            return;
            
        } else {
            TableDAO tableDAO = new TableDAO();
            
            order.getTable().setStatus("Disponible");
            tableDAO.update(order.getTable());
            
            orderDAO.delete(order.getId_Order());
            orderDetails.showMessage("Orden eliminada correctamente");
            
            orderDetails.dispose();
            
        }
        
    }

}
