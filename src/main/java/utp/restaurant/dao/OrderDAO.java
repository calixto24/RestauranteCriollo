package utp.restaurant.dao;

import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Order;

public class OrderDAO implements DAO<Order> {

    private ArrayList<Order> orderList;

    public OrderDAO() {
        orderList = RestaurantDB.getInstance().getOrderList();
    }

    @Override
    public ArrayList<Order> getAll() {
        return orderList;
    }

    @Override
    public Order get(long id) {
        for (Order e : orderList) {
            if (e.getId_Order()== id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void add(Order order) {
        orderList.add(order);
    }

    @Override
    public void update(long id, Order order) {
        orderList.set(getIndex(id), order);
    }

    @Override
    public void delete(long id) {
        orderList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return orderList.indexOf(get(id));
    }

}
