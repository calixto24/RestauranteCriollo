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

            Category category = new Category();

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                category.setId(rs.getInt("id_category"));
                category.setName(rs.getString("name_category "));
                category.setDescription(rs.getString("description"));

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

        Category category = new Category();

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();

            while (rs.next()) {

                category.setId(rs.getInt("id_category"));
                category.setName(rs.getString("name_category "));
                category.setDescription(rs.getString("description"));

            }

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
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());

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
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setInt(3, (int) category.getId());
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
