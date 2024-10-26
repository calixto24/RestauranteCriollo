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
    private EmployeeDAO employeeDAO;
    private TableDAO tableDAO;
    private ItemMenuDAO itemMenuDAO;
    private ArrayList<Order> orderList;

    public OrderDAO() {
        conn = RestaurantDB.getInstance().getConn();
        employeeDAO = new EmployeeDAO();
        tableDAO = new TableDAO();
        itemMenuDAO = new ItemMenuDAO();
    }

    @Override
    public ArrayList<Order> getAll() {

        query = "SELECT * FROM \"order\"";

        orderList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                Order order = new Order();

                order.setId_Order(rs.getInt("id_order"));
                order.setDate(rs.getDate("date").toLocalDate());
                order.setTime(rs.getTime("time").toLocalTime());
                order.setStatus(rs.getString("status"));
                order.setTotal_Price(rs.getDouble("totalprice"));

                //OBJETO EMPLEADO
                int id_employee = rs.getInt("id_employee");
                Employee employee = employeeDAO.get(id_employee);
                order.setWaiter(employee);

                //OBJETO MESA
                int id_table = rs.getInt("id_table");
                Table table = tableDAO.get((int) id_table);
                order.setTable(table);

                //CONSULTA PARA OBTENER LOS ITEMORDER
                String queryOrder = "SELECT * FROM itemOrder WHERE id_order = ?";
                PreparedStatement pso = conn.prepareStatement(queryOrder);
                pso.setInt(1, (int) order.getId_Order());
                ResultSet rso = pso.executeQuery();

                ArrayList<ItemOrder> itemOrderList = new ArrayList<>();

                while (rso.next()) {

                    //objeto ItemOrder para alamcenar las itemorder
                    ItemOrder itemOrder = new ItemOrder();

                    itemOrder.setId_itemOrder(rso.getInt("id_itemorder"));
                    itemOrder.setAmount(rso.getInt("amount"));
                    itemOrder.setTotal(rso.getDouble("total"));
                    itemOrder.setDescription(rso.getString("description"));

                    //RECUPERAMOS EL ID DE LA BD
                    int id_itemMenu = rso.getInt("id_itemmenu");

                    //MANDAMOS EL ID Y RECUPERAMOS EL OBJETO
                    ItemMenu itemMenu = itemMenuDAO.get(id_itemMenu);

                    //MANDAMOS EL OBJETO ITEMMENU A LA ITEMORDER
                    itemOrder.setItemMenu(itemMenu);

                    itemOrderList.add(itemOrder);

                }

                order.setItemOrderList(itemOrderList);

                //AÑADIMOS LA ORDER A LA LISTA
                orderList.add(order);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    @Override
    public Order get(long id) {

        query = "SELECT * FROM \"order\" WHERE id_order = ?";

        Order order = new Order();

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();

            while (rs.next()) {

                order.setId_Order(rs.getInt("id_order"));
                order.setDate(rs.getDate("date").toLocalDate());
                order.setTime(rs.getTime("time").toLocalTime());
                order.setStatus(rs.getString("status"));
                order.setTotal_Price(rs.getDouble("totalprice"));

                //OBJETO EMPLEADO
                int id_employee = rs.getInt("id_employee");
                Employee employee = employeeDAO.get(id_employee);
                order.setWaiter(employee);

                //OBJETO MESA
                int id_table = rs.getInt("id_table");
                Table table = tableDAO.get((int) id_table);
                order.setTable(table);

                //CONSULTA PARA OBTENER LOS ITEMORDER
                String queryOrder = "SELECT * FROM itemOrder WHERE id_order = ?";
                PreparedStatement pso = conn.prepareStatement(queryOrder);
                pso.setInt(1, (int) order.getId_Order());
                ResultSet rso = pso.executeQuery();

                ArrayList<ItemOrder> itemOrderList = new ArrayList<>();

                while (rso.next()) {

                    //objeto ItemOrder para alamcenar las itemorder
                    ItemOrder itemOrder = new ItemOrder();

                    itemOrder.setId_itemOrder(rso.getInt("id_itemorder"));
                    itemOrder.setAmount(rso.getInt("amount"));
                    itemOrder.setTotal(rso.getDouble("total"));
                    itemOrder.setDescription(rso.getString("description"));

                    //RECUPERAMOS EL ID DE LA BD
                    int id_itemMenu = rso.getInt("id_itemmenu");

                    //MANDAMOS EL ID Y RECUPERAMOS EL OBJETO
                    ItemMenu itemMenu = itemMenuDAO.get(id_itemMenu);

                    //MANDAMOS EL OBJETO ITEMMENU A LA ITEMORDER
                    itemOrder.setItemMenu(itemMenu);

                    itemOrderList.add(itemOrder);

                }

                order.setItemOrderList(itemOrderList);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;

    }

    @Override
    public void add(Order order) {
        String query = "INSERT INTO \"order\"(date, time, status, totalprice, id_employee, id_table) VALUES (?,?,?,?,?,?) RETURNING id_order";

        try {

            ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(order.getDate()));
            ps.setTime(2, java.sql.Time.valueOf(order.getTime()));
            ps.setString(3, order.getStatus());
            ps.setDouble(4, order.getTotal_Price());
            ps.setInt(5, (int) order.getWaiter().getId_employee());
            ps.setInt(6, (int) order.getTable().getId());

            try {

                rs = ps.executeQuery();

                int id_order = -1;
                if (rs.next()) {
                    id_order = rs.getInt("id_order");
                }

                // Añadir los ItemOrders asociados
                String queryItemOrder = "INSERT INTO itemOrder(amount, total, description, id_itemmenu, id_order) VALUES (?,?,?,?,?)";

                try (PreparedStatement psIO = conn.prepareStatement(queryItemOrder)) {
                    for (ItemOrder io : order.getItemOrderList()) {
                        psIO.setInt(1, io.getAmount());
                        psIO.setDouble(2, io.getTotal());
                        psIO.setString(3, io.getDescription());
                        psIO.setInt(4, (int) io.getItemMenu().getId());
                        psIO.setInt(5, id_order);
                        psIO.executeUpdate();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) {

        query = "UPDATE \"order\" SET date = ?, time = ?, status = ?, totalprice = ?, id_employee = ?, id_table = ? WHERE id_order = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(order.getDate()));
            ps.setTime(2, java.sql.Time.valueOf(order.getTime()));
            ps.setString(3, order.getStatus());
            ps.setDouble(4, order.getTotal_Price());
            ps.setInt(5, (int) order.getWaiter().getId_employee());
            ps.setInt(6, (int) order.getTable().getId());
            ps.setInt(7, (int) order.getId_Order());

            String queryIO = "UPDATE itemOrder SET amount = ?, total = ?, description = ?, id_itemmenu = ? WHERE id_itemorder = ?";

            try (PreparedStatement psIO = conn.prepareStatement(queryIO)) {

                for (ItemOrder io : order.getItemOrderList()) {
                    psIO.setInt(1, io.getAmount());
                    psIO.setDouble(2, io.getTotal());
                    psIO.setString(3, io.getDescription());
                    psIO.setInt(4, (int) io.getItemMenu().getId());
                    psIO.setInt(5, (int) io.getId_itemOrder());
                    psIO.executeUpdate();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long id) {

        query = "DELETE FROM \"order\" WHERE id_order = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
