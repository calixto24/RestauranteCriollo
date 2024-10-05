
package utp.restaurant.cashier.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.view.OrderView;
import utp.restaurant.cashier.view.VoucherView;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.model.Order;

public class OrderController {
    
    private OrderView orderView;
    private OrderDAO orderDAO;
    private ArrayList<Order> orderList;

    public OrderController(OrderView orderView) {
        this.orderView = orderView;
        orderDAO = new OrderDAO();
    }
    
    public DefaultTableModel getTableModel() {
        
        String columns[] = {
            "id",
            "Mesa",
            "Mesero",
            "Total"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        
        orderList = orderDAO.getAll();
        
        for(Order o : orderList) {
            
            if(o.getStatus().equals("Preparado")) {
                
                Object row[] = {
                    o.getId_Order(),
                    o.getTable().getNumber_table(),
                    o.getWaiter().fullName(),
                    o.getTotal_Price()
                };
                
                tableModel.addRow(row);
                
            }
            
        }
        
        return tableModel;        
        
    }
    
    public void handleClick() {
        VoucherView voucherView = new VoucherView();
        voucherView.setOrder(orderList.get(orderView.getRow()));
        
        voucherView.renderTable();
        voucherView.renderCBCustomer();
        voucherView.setVisible(true);
        orderView.dispose();
        
    }
    
}
