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
    private ArrayList<Order> filterOrderList;

    public OrderController(OrderView orderView) {
        this.orderView = orderView;
        orderDAO = new OrderDAO();
        this.filterOrderList = new ArrayList<>();
    }

    public DefaultTableModel getTableModel() {

        String columns[] = {
            "id",
            "Mesa",
            "Mesero",
            "Total"
        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);

        ArrayList<Order> orderList = orderDAO.getAll();

        for (Order o : orderList) {

            if (o.getStatus().equals("Preparado")) {
                filterOrderList.add(o);

                Object row[] = {
                    o.getId_Order(),
                    o.getTable().getNumber_table(),
                    o.getWaiter().fullData(),
                    o.getTotal_Price()
                };

                tableModel.addRow(row);

            }

        }

        return tableModel;

    }

    public void handleClick() {
        VoucherView voucherView = new VoucherView();
        voucherView.setOrder(filterOrderList.get(orderView.getRow()));

        voucherView.renderTable();

        voucherView.setVisible(true);
        orderView.dispose();

    }

    public void manageButtonVoucher() {

        boolean isEmpty = true;

        if (orderView.getjTorder().getRowCount() != 0) {

            isEmpty = false;

        }

        orderView.getjBTNvoucher().setEnabled(!isEmpty);

    }

}
