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

public class TicketDAO implements DAO<Ticket> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private EmployeeDAO employeeDAO;
    private OrderDAO orderDAO;
    private NaturalCustomerDAO naturalCustomerDAO;

    private ArrayList<Ticket> ticketList;

    public TicketDAO() {
        conn = RestaurantDB.getInstance().getConn();
        employeeDAO = new EmployeeDAO();
        orderDAO = new OrderDAO();
        naturalCustomerDAO = new NaturalCustomerDAO();
    }

    @Override
    public ArrayList<Ticket> getAll() {

        query = "SELECT * FROM getTicket";

        ticketList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setId_Voucher(rs.getInt("id_voucher"));
                ticket.setDate(rs.getDate("date").toLocalDate());
                ticket.setTime(rs.getTime("time").toLocalTime());
                ticket.setStatus(rs.getString("status"));
                ticket.setTotalPrice(rs.getDouble("totalprice"));
                ticket.setDiscount(rs.getDouble("discount"));
                ticket.setAdditionalPayments(rs.getDouble("additionalpayments"));
                ticket.setIgv(rs.getDouble("igv"));
                ticket.setPaymentType(rs.getString("paymenttype"));
                ticket.setTurned(rs.getDouble("turned"));

                //OBJETO EMPLEADO
                int id_employee = rs.getInt("id_employee");
                Employee employee = employeeDAO.get(id_employee);
                ticket.setCashier(employee);

                //OBJETO ORDER
                int id_order = rs.getInt("id_order");
                Order order = orderDAO.get(id_order);
                ticket.setOrder(order);

                //OBJETO CLIENTE JURIDICO
                int id_naturalCustomer = rs.getInt("id_naturalcustomer");
                NaturalCustomer naturalCustomer = naturalCustomerDAO.get(id_naturalCustomer);
                ticket.setNaturalPerson(naturalCustomer);

                ticketList.add(ticket);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketList;
    }

    @Override
    public Ticket get(long id) {
        
        query = "SELECT * FROM getTicket";

        Ticket ticket = new Ticket();

        try {

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                ticket.setId_Voucher(rs.getInt("id_voucher"));
                ticket.setDate(rs.getDate("date").toLocalDate());
                ticket.setTime(rs.getTime("time").toLocalTime());
                ticket.setStatus(rs.getString("status"));
                ticket.setTotalPrice(rs.getDouble("totalprice"));
                ticket.setDiscount(rs.getDouble("discount"));
                ticket.setAdditionalPayments(rs.getDouble("additionalpayments"));
                ticket.setIgv(rs.getDouble("igv"));
                ticket.setPaymentType(rs.getString("paymenttype"));
                ticket.setTurned(rs.getDouble("turned"));

                //OBJETO EMPLEADO
                int id_employee = rs.getInt("id_employee");
                Employee employee = employeeDAO.get(id_employee);
                ticket.setCashier(employee);

                //OBJETO ORDER
                int id_order = rs.getInt("id_order");
                Order order = orderDAO.get(id_order);
                ticket.setOrder(order);

                //OBJETO CLIENTE JURIDICO
                int id_naturalCustomer = rs.getInt("id_naturalcustomer");
                NaturalCustomer naturalCustomer = naturalCustomerDAO.get(id_naturalCustomer);
                ticket.setNaturalPerson(naturalCustomer);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    @Override
    public void add(Ticket ticket) {
            
        query = "CALL add_ticket(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(ticket.getDate()));         
            ps.setTime(2, java.sql.Time.valueOf(ticket.getTime()));       
            ps.setString(3, ticket.getStatus());                            
            ps.setBigDecimal(4, BigDecimal.valueOf(ticket.getTotalPrice())); 
            ps.setBigDecimal(5, BigDecimal.valueOf(ticket.getDiscount()));
            ps.setBigDecimal(6, BigDecimal.valueOf(ticket.getAdditionalPayments()));
            ps.setBigDecimal(7, BigDecimal.valueOf(ticket.getIgv()));
            ps.setString(8, ticket.getPaymentType());
            ps.setBigDecimal(9, BigDecimal.valueOf(ticket.getTurned()));
            ps.setInt(10, (int) ticket.getCashier().getId_employee());
            ps.setInt(11, (int) ticket.getOrder().getId_Order());
            ps.setInt(12, (int) ticket.getNaturalPerson().getId_naturalCustomer());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ticket ticket) {

    }

    @Override
    public void delete(long id) {

    }

}
