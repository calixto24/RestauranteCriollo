package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;

public class RoleDAO implements DAO<Role> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Role> roleList;

    //constructor vacio
    public RoleDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<Role> getAll() {

        query = "SELECT * FROM role";

        roleList = new ArrayList<>();

        try {

            Role role = new Role();

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                role.setId(rs.getInt("id_role"));
                role.setName(rs.getString("name_role"));
                roleList.add(role);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return roleList;
    }

    @Override
    public Role get(long id) {

        query = "SELECT * FROM role WHERE id_role = ?";

        Role role = new Role();

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);

            rs = ps.executeQuery();

            while (rs.next()) {

                role.setId(rs.getInt("id_role"));
                role.setName(rs.getString("name_role"));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return role;
    }

    @Override
    public void add(Role role) {

        query = "INSERT INTO role(name_role) VALUES (?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, "name_role");
            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void update(Role role) {

        query = "UPDATE role SET name_role = ? WHERE id_role = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, role.getName());
            ps.setInt(2, (int) role.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void delete(long id) {

        query = "DELETE FROM role WHERE id_role = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
