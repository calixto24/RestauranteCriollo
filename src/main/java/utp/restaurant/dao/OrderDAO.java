package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;

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
        
        query = "SELECT * FROM getOrder7";
        
        orderList = new ArrayList<>();
        
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()) {
                
                Order order = new Order();
                
                order.setId_Order(rs.getInt("id_order"));
                order.setDate(rs.getDate("date").toLocalDate());
                order.setTime(rs.getTime("time").toLocalTime());
                order.setStatus(rs.getString("status"));
                order.setTotal_Price(rs.getDouble("totalPrice"));
                
                Employee employee = new Employee();
                employee.setId_employee(rs.getInt("id_employee"));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
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
