package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Category;

public class CategoryDAO implements DAO<Category> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Category> categoryList;

    public CategoryDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<Category> getAll() {

        query = "SELECT * FROM category";

        categoryList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                
                Category category = new Category(
                        rs.getInt("id_category"),
                        rs.getString("name_category"),
                        rs.getString("description")
                );

                categoryList.add(category);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryList;

    }

    @Override
    public Category get(long id) {

        query = "SELECT * FROM category WHERE id_category = ?";

        Category category = null;

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();

            rs.next();

            category = new Category(
                        rs.getInt("id_category"),
                        rs.getString("name_category"),
                        rs.getString("description")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return category;

    }

    @Override
    public void add(Category category) {

        query = "INSERT INTO category(name_category, description) VALUES (?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, category.name());
            ps.setString(2, category.description());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Category category) {

        query = "UPDATE category SET name_category = ?, description = ? WHERE id_category = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, category.name());
            ps.setString(2, category.description());
            ps.setInt(3, (int) category.id());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long id) {

        query = "DELETE FROM category WHERE id_category = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
