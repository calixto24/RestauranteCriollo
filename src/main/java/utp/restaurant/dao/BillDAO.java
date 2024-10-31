package utp.restaurant.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;

public class BillDAO implements DAO<Bill> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private EmployeeDAO employeeDAO;
    private OrderDAO orderDAO;
    private JuridicalCustomerDAO jcdao;
    private ArrayList<Bill> billList;

    public BillDAO() {
        conn = RestaurantDB.getInstance().getConn();
        employeeDAO = new EmployeeDAO();
        orderDAO = new OrderDAO();
        jcdao = new JuridicalCustomerDAO();
    }

    @Override
    public ArrayList<Bill> getAll() {

        query = "SELECT * FROM getBill";

        billList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                Bill bill = new Bill();

                bill.setId_Bill(rs.getInt("id_bill"));
                bill.setId_Voucher(rs.getInt("id_voucher"));
                bill.setDate(rs.getDate("date").toLocalDate());
                bill.setTime(rs.getTime("time").toLocalTime());
                bill.setStatus(rs.getString("status"));
                bill.setTotalPrice(rs.getDouble("totalprice"));
                bill.setDiscount(rs.getDouble("discount"));
                bill.setAdditionalPayments(rs.getDouble("additionalpayments"));
                bill.setIgv(rs.getDouble("igv"));
                bill.setPaymentType(rs.getString("paymenttype"));
                bill.setTurned(rs.getDouble("turned"));

                //OBJETO EMPLEADO
                int id_employee = rs.getInt("id_employee");
                Employee employee = employeeDAO.get(id_employee);
                bill.setCashier(employee);

                //OBJETO ORDER
                int id_order = rs.getInt("id_order");
                Order order = orderDAO.get(id_order);
                bill.setOrder(order);

                //OBJETO CLIENTE JURIDICO
                int id_juridicalCustomer = rs.getInt("id_juridicalcustomer");
                JuridicalCustomer juridicalCustomer = jcdao.get(id_juridicalCustomer);
                bill.setCustomer(juridicalCustomer);

                billList.add(bill);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billList;

    }

    @Override
    public Bill get(long id) {

        query = "SELECT * FROM getBill";

        Bill bill = new Bill();

        try {

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                bill.setId_Voucher(rs.getInt("id_voucher"));
                bill.setDate(rs.getDate("date").toLocalDate());
                bill.setTime(rs.getTime("time").toLocalTime());
                bill.setStatus(rs.getString("status"));
                bill.setTotalPrice(rs.getDouble("totalprice"));
                bill.setDiscount(rs.getDouble("discount"));
                bill.setAdditionalPayments(rs.getDouble("additionalpayments"));
                bill.setIgv(rs.getDouble("igv"));
                bill.setPaymentType(rs.getString("paymenttype"));
                bill.setTurned(rs.getDouble("turned"));

                //OBJETO EMPLEADO
                int id_employee = rs.getInt("id_employee");
                Employee employee = employeeDAO.get(id_employee);
                bill.setCashier(employee);

                //OBJETO ORDER
                int id_order = rs.getInt("id_order");
                Order order = orderDAO.get(id_order);
                bill.setOrder(order);

                //OBJETO CLIENTE JURIDICO
                int id_juridicalCustomer = rs.getInt("id_juridicalcustomer");
                JuridicalCustomer juridicalCustomer = jcdao.get(id_juridicalCustomer);
                bill.setCustomer(juridicalCustomer);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bill;
    }

    @Override
    public void add(Bill bill) {

        query = "CALL add_bill(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(bill.getDate()));         
            ps.setTime(2, java.sql.Time.valueOf(bill.getTime()));       
            ps.setString(3, bill.getStatus());                            
            ps.setBigDecimal(4, BigDecimal.valueOf(bill.getTotalPrice())); 
            ps.setBigDecimal(5, BigDecimal.valueOf(bill.getDiscount()));
            ps.setBigDecimal(6, BigDecimal.valueOf(bill.getAdditionalPayments()));
            ps.setBigDecimal(7, BigDecimal.valueOf(bill.getIgv()));
            ps.setString(8, bill.getPaymentType());
            ps.setBigDecimal(9, BigDecimal.valueOf(bill.getTurned()));
            ps.setInt(10, (int) bill.getCashier().getId_employee());
            ps.setInt(11, (int) bill.getOrder().getId_Order());
            ps.setInt(12, (int) bill.getCustomer().getId_juridicalCustomer());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public int getLastID() {

        query = "select id_bill from bill order by id_bill desc limit 1";
        
        int id_bill = -1;

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                
                id_bill = rs.getInt("id_bill");

            }

        } catch (SQLException e) {
            e.printStackTrace(); // para que salga el error

        }
        
        return id_bill;

    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete(long id) {

    }

}
