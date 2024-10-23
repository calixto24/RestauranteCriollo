package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Order;

public class OrderDAO implements DAO<Order> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Order> orderList;

    public OrderDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<Order> getAll() {
        return orderList;
    }

    @Override
    public Order get(long id) {
        return null;
    }

    @Override
    public void add(Order order) {
        
    }

    @Override
    public void update(Order order) {
        
    }

    @Override
    public void delete(long id) {
        
    }

}
