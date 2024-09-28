
package utp.restaurant.waiter.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.model.Order;
import utp.restaurant.waiter.view.OrderDetails;

public class OrderDetailsController {
    
    private OrderDetails orderDetails;
    private OrderDAO orderDAO;

    public OrderDetailsController(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    /*public DefaultTableModel getTableModel() {
        
        String columns[] = {
            "Id",
            "Nombre",
            "Imagen",
            "Precio Unitario",
            "Cantidad",
            "Precio Total"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        
        ArrayList<Order> orderList  = new ArrayList<>();
        
    }*/
    
}
