
package utp.restaurant.chef.controller;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.chef.view.OrderChefDetails;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;

public class OrderChefDetailsController {
    
    private OrderChefDetails orderChefDetails;

    public OrderChefDetailsController(OrderChefDetails orderChefDetails) {
        this.orderChefDetails = orderChefDetails;
    }
    
    public DefaultTableModel getTableModel(Order order) {

        String columns[] = {
            "Nombre",
            "Imagen",
            "Descripcion",
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
                itemOrder.getDescription(),
                itemOrder.getItemMenu().getPrice(),
                itemOrder.getAmount(),
                itemOrder.getTotal()
            };

            tableModel.addRow(row);

        }

        return tableModel;

    }
    
}
