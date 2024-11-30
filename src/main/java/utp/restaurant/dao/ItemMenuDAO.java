package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;

public class ItemMenuDAO implements DAO<ItemMenu> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private CategoryDAO categoryDAO;
    private ArrayList<ItemMenu> itemMenuList;

    // constructor 
    public ItemMenuDAO() {
        conn = RestaurantDB.getInstance().getConn();
        categoryDAO = new CategoryDAO();
    }

    @Override
    public ArrayList<ItemMenu> getAll() {

        query = "SELECT * FROM itemMenu";

        itemMenuList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                ItemMenu itemMenu = new ItemMenu();

                itemMenu.setId(rs.getInt("id_itemmenu"));
                itemMenu.setName(rs.getString("name_itemmenu"));
                itemMenu.setPrice(rs.getDouble("priceunit"));
                itemMenu.setDescription(rs.getString("description"));
                itemMenu.setStatus(rs.getString("status"));
                itemMenu.setImage(rs.getString("image"));

                int id_category = rs.getInt("id_category");
                
                Category category = categoryDAO.get((long) id_category);
                itemMenu.setCategory(category);

                itemMenuList.add(itemMenu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemMenuList;
    }

    @Override
    public ItemMenu get(long id) {

        query = "SELECT * FROM itemMenu WHERE id_itemMenu = ?";

        ItemMenu itemMenu = new ItemMenu();

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();

            while (rs.next()) {

                itemMenu.setId(rs.getInt("id_itemmenu"));
                itemMenu.setName(rs.getString("name_itemmenu"));
                itemMenu.setPrice(rs.getDouble("priceunit"));
                itemMenu.setDescription(rs.getString("description"));
                itemMenu.setStatus(rs.getString("status"));
                itemMenu.setImage(rs.getString("image"));

                int id_category = rs.getInt("id_category");
                
                Category category = categoryDAO.get((long) id_category);
                itemMenu.setCategory(category);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemMenu;

    }

    @Override
    public void add(ItemMenu item_Menu) {

        query = "INSERT INTO itemMenu(name_itemMenu, priceUnit, description, status, image, id_category) VALUES (?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, item_Menu.getName());
            ps.setDouble(2, item_Menu.getPrice());
            ps.setString(3, item_Menu.getDescription());
            ps.setString(4, item_Menu.getStatus());
            ps.setString(5, item_Menu.getImage());
            ps.setInt(6, (int) item_Menu.getCategory().id());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(ItemMenu item_Menu) {

        query = "UPDATE itemMenu SET name_itemMenu = ?, priceUnit = ?, description = ?, status = ?, image = ?, id_category = ? WHERE id_itemMenu = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, item_Menu.getName());
            ps.setDouble(2, item_Menu.getPrice());
            ps.setString(3, item_Menu.getDescription());
            ps.setString(4, item_Menu.getStatus());
            ps.setString(5, item_Menu.getImage());
            ps.setInt(6, (int) item_Menu.getCategory().id());
            ps.setInt(7, (int) item_Menu.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long id) {

        query = "DELETE FROM itemMenu WHERE id_itemMenu = ?";

        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
