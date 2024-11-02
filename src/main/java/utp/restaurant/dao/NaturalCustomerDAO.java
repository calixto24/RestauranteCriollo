package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                naturalCustomer.setId_naturalPerson(rs.getInt("id_naturalperson"));
                naturalCustomer.setId_naturalCustomer(rs.getInt("id_naturalcustomer"));
                naturalCustomer.setDni(rs.getInt("dni"));
                naturalCustomer.setName(rs.getString("name"));
                naturalCustomer.setLastname_paternal(rs.getString("last_paternal"));
                naturalCustomer.setLastname_maternal(rs.getString("last_maternal"));
                naturalCustomer.setAddress(rs.getString("address"));
                naturalCustomer.setPhoneNumber(rs.getInt("phone_number"));
                naturalCustomer.setEmail(rs.getString("email"));
                naturalCustomer.setRegister(rs.getDate("register").toLocalDate());
                
                Date birthdate = rs.getDate("birthdate");
                naturalCustomer.setBirthdate(birthdate != null ? birthdate.toLocalDate() : null);

                naturalCustomerList.add(naturalCustomer);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return naturalCustomerList;
    }

    @Override
    public NaturalCustomer get(long id) {

        query = "SELECT * FROM getNaturalCustomer WHERE id_naturalcustomer = ?";

        NaturalCustomer naturalCustomer = new NaturalCustomer();

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            
            rs = ps.executeQuery();

            while (rs.next()) {

                naturalCustomer.setId_person(rs.getInt("id_person"));
                naturalCustomer.setId_naturalPerson(rs.getInt("id_naturalperson"));
                naturalCustomer.setId_naturalCustomer(rs.getInt("id_naturalcustomer"));
                naturalCustomer.setDni(rs.getInt("dni"));
                naturalCustomer.setName(rs.getString("name"));
                naturalCustomer.setLastname_paternal(rs.getString("last_paternal"));
                naturalCustomer.setLastname_maternal(rs.getString("last_maternal"));
                naturalCustomer.setAddress(rs.getString("address"));
                naturalCustomer.setPhoneNumber(rs.getInt("phone_number"));
                naturalCustomer.setEmail(rs.getString("email"));
                naturalCustomer.setRegister(rs.getDate("register").toLocalDate());
                
                Date birthdate = rs.getDate("birthdate");
                naturalCustomer.setBirthdate(birthdate != null ? birthdate.toLocalDate() : null);
                
            }

        } catch (SQLException e) {

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
            
            if(naturalCustomer.getBirthdate() == null) {
                ps.setNull(5, java.sql.Types.DATE);
            } else {
                ps.setDate(5, java.sql.Date.valueOf(naturalCustomer.getBirthdate()));
            }
            
            ps.setString(6, naturalCustomer.getAddress());
            ps.setInt(7, naturalCustomer.getPhoneNumber());
            ps.setString(8, naturalCustomer.getEmail());

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public int getLastID() {
        
        query = "SELECT id_naturalCustomer FROM naturalCustomer ORDER BY id_naturalCustomer DESC LIMIT 1";
        
        int id_naturalCustomer = -1;
        
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            if (rs.next()) {
                
                id_naturalCustomer = rs.getInt("id_naturalcustomer");
                
            }
            
        } catch (SQLException e) {

            e.printStackTrace();

        }
        
        return id_naturalCustomer;
        
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
            ps.setDate(5, java.sql.Date.valueOf(naturalCustomer.getBirthdate()));
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

        query = "DELETE FROM naturalCustomer WHERE id_naturalcustomer = ?";

        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
