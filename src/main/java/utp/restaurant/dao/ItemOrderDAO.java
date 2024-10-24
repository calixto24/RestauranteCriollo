package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;

public class ItemOrderDAO implements DAO<ItemOrder> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<ItemOrder> itemOrderList;

    public ItemOrderDAO() {

        conn = RestaurantDB.getInstance().getConn();

    }

    @Override
    public ArrayList<ItemOrder> getAll() {

        query = "SELECT * FROM getItemOrder";

        itemOrderList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                ItemOrder itemOrder = new ItemOrder();

                itemOrder.setId_itemOrder(rs.getInt("id_itemorder"));
                itemOrder.setAmount(rs.getInt("amount"));
                itemOrder.setTotal(rs.getDouble("total"));
                itemOrder.setDescription(rs.getString("description_itemorder"));

                ItemMenu itemMenu = new ItemMenu();
                itemMenu.setId(rs.getInt("id_itemmenu"));
                itemMenu.setName(rs.getString("name_itemmenu"));
                itemMenu.setPrice(rs.getDouble("preciounit"));
                itemMenu.setDescription(rs.getString("description_itemmenu"));
                itemOrder.setItemMenu(itemMenu);

                Order order = new Order();
                order.setId_Order(rs.getInt("id_order"));
                itemOrder.setOrder(order);
                itemOrderList.add(itemOrder);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemOrderList;
    }

    @Override
    public ItemOrder get(long id) {

        query = "SELECT * FROM getItemOrder WHERE id_itemorder = ?";

        ItemOrder itemOrder = new ItemOrder();

        try {

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                itemOrder.setId_itemOrder(rs.getInt("id_itemorder"));
                itemOrder.setAmount(rs.getInt("amount"));
                itemOrder.setTotal(rs.getDouble("total"));
                itemOrder.setDescription(rs.getString("description_itemorder"));

                ItemMenu itemMenu = new ItemMenu();
                itemMenu.setId(rs.getInt("id_itemmenu"));
                itemMenu.setName(rs.getString("name_itemmenu"));
                itemMenu.setPrice(rs.getDouble("preciounit"));
                itemMenu.setDescription(rs.getString("description_itemmenu"));
                itemOrder.setItemMenu(itemMenu);

                Order order = new Order();
                order.setId_Order(rs.getInt("id_order"));
                itemOrder.setOrder(order);
                itemOrderList.add(itemOrder);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemOrder;

    }

    @Override
    public void add(ItemOrder itemOrder) {

        query = "INSERT INTO itemOrder (amount, total, description, id_itemMenu, id_order) VALUES (?, ?, ?, ?, ?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, itemOrder.getAmount());
            ps.setDouble(2, itemOrder.getTotal());
            ps.setString(3, itemOrder.getDescription());
            ps.setInt(4, (int) itemOrder.getItemMenu().getId());
            ps.setInt(5, (int) itemOrder.getOrder().getId_Order());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(ItemOrder itemOrder) {

        query = "UPDATE itemOrder SET amount = ?, total = ?, description = ?, id_itemMenu = ?, id_order = ? WHERE id_itemOrder = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, itemOrder.getAmount());
            ps.setDouble(2, itemOrder.getTotal());
            ps.setString(3, itemOrder.getDescription());
            ps.setInt(4, (int) itemOrder.getItemMenu().getId());
            ps.setInt(5, (int) itemOrder.getOrder().getId_Order());
            ps.setInt(6, (int) itemOrder.getId_itemOrder());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long id) {

        query = "SELETE FROM itemOrder WHERE id_itemOrder = ?";

        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
