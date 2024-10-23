package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;

public class NaturalCustomerDAO implements DAO<NaturalCustomer> {

    private Connection conn;
    private String query;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<NaturalCustomer> naturalCustomerList;

    //constructor vacio
    public NaturalCustomerDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<NaturalCustomer> getAll() {

        naturalCustomerList = new ArrayList<>();

        query = "SELECT * FROM getNaturalCustomer";

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                NaturalCustomer naturalCustomer = new NaturalCustomer();

                naturalCustomer.setId_person(rs.getInt("id_person"));
                naturalCustomer.setId_naturalPerson(rs.getInt("id_naturalPerson"));
                naturalCustomer.setId_naturalCustomer(rs.getInt("id_naturalCustomer"));
                naturalCustomer.setDni(rs.getInt("dni"));
                naturalCustomer.setName(rs.getString("name"));
                naturalCustomer.setLastname_paternal(rs.getString("last_paternal"));
                naturalCustomer.setLastname_maternal(rs.getString("last_maternal"));
                naturalCustomer.setBirthdate(rs.getDate("birthdate").toLocalDate());
                naturalCustomer.setAddress(rs.getString("address"));
                naturalCustomer.setPhoneNumber(rs.getInt("phone_number"));
                naturalCustomer.setEmail(rs.getString("email"));
                naturalCustomer.setRegister(rs.getDate("register").toLocalDate());

                naturalCustomerList.add(naturalCustomer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return naturalCustomerList;
    }

    @Override
    public NaturalCustomer get(long id) {

        query = "SELECT * FROM getNaturalCustomer WHERE id_naturalCustomer = ?";

        NaturalCustomer naturalCustomer = new NaturalCustomer();

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            
            rs = ps.executeQuery();

            while (rs.next()) {

                naturalCustomer.setId_person(rs.getInt("id_person"));
                naturalCustomer.setId_naturalPerson(rs.getInt("id_naturalPerson"));
                naturalCustomer.setId_naturalCustomer(rs.getInt("id_naturalCustomer"));
                naturalCustomer.setDni(rs.getInt("dni"));
                naturalCustomer.setName(rs.getString("name"));
                naturalCustomer.setLastname_paternal(rs.getString("last_paternal"));
                naturalCustomer.setLastname_maternal(rs.getString("last_maternal"));
                naturalCustomer.setBirthdate(rs.getDate("birthdate").toLocalDate());
                naturalCustomer.setAddress(rs.getString("address"));
                naturalCustomer.setPhoneNumber(rs.getInt("phone_number"));
                naturalCustomer.setEmail(rs.getString("email"));
                naturalCustomer.setRegister(rs.getDate("register").toLocalDate());
                
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return naturalCustomer;
    }

    @Override
    public void add(NaturalCustomer naturalCustomer) {

        query = "CALL add_naturalCustomer(?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, naturalCustomer.getDni());
            ps.setString(2, naturalCustomer.getName());
            ps.setString(3, naturalCustomer.getLastname_paternal());
            ps.setString(4, naturalCustomer.getLastname_maternal());
            ps.setString(5, naturalCustomer.getBirthdate().toString());
            ps.setString(6, naturalCustomer.getAddress());
            ps.setInt(7, naturalCustomer.getPhoneNumber());
            ps.setString(8, naturalCustomer.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void update(NaturalCustomer naturalCustomer) {

        query = "CALL update_naturalCustomer(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, naturalCustomer.getDni());
            ps.setString(2, naturalCustomer.getName());
            ps.setString(3, naturalCustomer.getLastname_paternal());
            ps.setString(4, naturalCustomer.getLastname_maternal());
            ps.setString(5, naturalCustomer.getBirthdate().toString());
            ps.setString(6, naturalCustomer.getAddress());
            ps.setInt(7, naturalCustomer.getPhoneNumber());
            ps.setString(8, naturalCustomer.getEmail());
            ps.setInt(9,(int) naturalCustomer.getId_person());
            ps.setInt(10,(int) naturalCustomer.getId_naturalPerson());
            ps.setInt(11,(int) naturalCustomer.getId_naturalCustomer());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void delete(long id) {

        query = "DELETE FROM naturalCustomer WHERE id_naturalCustomer = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
