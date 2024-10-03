package utp.restaurant.chef.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.chef.view.OrderChefView;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.model.Order;
import utp.restaurant.waiter.view.OrderView;

/**
 *
 * @author dalia
 */
public class OrderChefController {

    private OrderChefView orderChefView;
    private OrderDAO orderDAO;

    public OrderChefController(OrderChefView orderChefView) {
        this.orderChefView = orderChefView;
        orderDAO = new OrderDAO();

    }

    public DefaultTableModel getTableModel() {
        String[] columns = {
            "Id",
            "Mesa",
            "Mesero",
            "Fecha",
            "Hora",
            "Estado",
            "Precio Total"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<Order> orderList = orderDAO.getAll();

        for (Order nol : orderList) {

            if (nol.getStatus().equals("Pendiente")) {

                Object[] row = {
                    nol.getId_Order(),
                    nol.getTable().getNumber_table(),
                    nol.getWaiter().fullName(),
                    nol.getDate(),
                    nol.getTime(),
                    nol.getStatus(),
                    nol.getTotal_Price()
                };
                tableModel.addRow(row);

            }
        }
        
        return tableModel;
        
    }
    
    public void manageButtonDetails() {
        
        boolean isEmpty = true;
        
        if(orderChefView.getjTorder().getRowCount() != 0) {
            
            isEmpty = false;
            
        }
        
        orderChefView.getjBTNdetails().setEnabled(!isEmpty);
        
    }

}
