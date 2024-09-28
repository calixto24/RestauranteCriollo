package utp.restaurant.waiter.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.waiter.view.OrderView;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.model.Order;
import utp.restaurant.store.Store;

public class OrderController {

    private OrderView view;
    private OrderDAO orderDao;
    private Store store;
    private long selectedIdOrder;

    public OrderController(OrderView view) {
        this.view = view;
        orderDao = new OrderDAO();
        store = Store.getInstance();
        
        selectedIdOrder = 0;
    }

    public DefaultTableModel getDefaultTableModel() {
        
        String columns[] = {
            "Id",
            "Mesa",
            "Fecha",
            "Hora",
            "Estado",
            "Precio Total"
        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<Order> orderList = orderDao.getAll();
        for (Order order : orderList) {

            if (store.getEmploye().getId_employee() == order.getWaiter().getId_employee()) {
                Object row[] = {
                    order.getId_Order(),
                    order.getTable().getNumber_table(),
                    order.getDate(),
                    order.getTime(),
                    order.getStatus(),
                    order.getTotal_Price()
                };
                tableModel.addRow(row);
            }

        }
        return tableModel;

    }

}
