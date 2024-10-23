package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.JuridicalCustomer;

public class JuridicalCustomerDAO implements DAO<JuridicalCustomer> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<JuridicalCustomer> juridicalCustomerList;

    //constructor vacio
    public JuridicalCustomerDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<JuridicalCustomer> getAll() {
        // para obtener todas las filas

        query = "SELECT * FROM getJuricalCustomer";
        juridicalCustomerList = new ArrayList<>();
        try {
            JuridicalCustomer juridicalCustomer = new JuridicalCustomer();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                juridicalCustomer.setId_person(rs.getInt("id_person"));
                juridicalCustomer.setId_juridicalPerson(rs.getInt("id_juridicalPerson"));
                juridicalCustomer.setId_juridicalCustomer(rs.getInt("id_juridcalCustomer"));
                juridicalCustomer.setRuc(Long.parseLong(rs.getString("ruc")));
                juridicalCustomer.setSocialReason(rs.getString("socialReason"));
                juridicalCustomer.setType(rs.getString("type"));
                juridicalCustomer.setEconomicActivity(rs.getString("economicActivity"));
                juridicalCustomer.setTypeBilling(rs.getString("typeBilling"));
                juridicalCustomer.setAddress(rs.getString("address"));
                juridicalCustomer.setPhoneNumber(rs.getInt("phone_number"));
                juridicalCustomer.setEmail(rs.getString("email"));
                juridicalCustomer.setRegister(rs.getDate("register").toLocalDate());

                juridicalCustomerList.add(juridicalCustomer);
            }

        } catch (Exception e) {
            e.printStackTrace(); // para que salga el error
        }

        return juridicalCustomerList;
    }

    @Override
    public JuridicalCustomer get(long id) {

        query = "SELECT * FROM getJuricalCustomer WHERE id_juridicalCustomer= ?";

        JuridicalCustomer juridicalCustomer = new JuridicalCustomer();

        try {

            ps = conn.prepareStatement(query);

            ps.setInt(1, (int) id);

            rs = ps.executeQuery();

            while (rs.next()) {

                juridicalCustomer.setId_person(rs.getInt("id_person"));
                juridicalCustomer.setId_juridicalPerson(rs.getInt("id_juridicalPerson"));
                juridicalCustomer.setId_juridicalCustomer(rs.getInt("id_juridcalCustomer"));
                juridicalCustomer.setRuc(Long.parseLong(rs.getString("ruc")));
                juridicalCustomer.setSocialReason(rs.getString("socialReason"));
                juridicalCustomer.setType(rs.getString("type"));
                juridicalCustomer.setEconomicActivity(rs.getString("economicActivity"));
                juridicalCustomer.setTypeBilling(rs.getString("typeBilling"));
                juridicalCustomer.setAddress(rs.getString("address"));
                juridicalCustomer.setPhoneNumber(rs.getInt("phone_number"));
                juridicalCustomer.setEmail(rs.getString("email"));
                juridicalCustomer.setRegister(rs.getDate("register").toLocalDate());

            }

        } catch (Exception e) {
            e.printStackTrace(); // para que salga el error

        }

        return juridicalCustomer;

    }

    @Override
    public void add(JuridicalCustomer juridicalCustomer) {

        query = "CALL add_juridicalCustomer (?,?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);

            ps.setString(1, juridicalCustomer.getRuc() + "");
            ps.setString(2, juridicalCustomer.getSocialReason());
            ps.setString(3, juridicalCustomer.getType());
            ps.setString(4, juridicalCustomer.getEconomicActivity());
            ps.setString(5, juridicalCustomer.getTypeBilling());
            ps.setString(6, juridicalCustomer.getAddress());
            ps.setInt(7, juridicalCustomer.getPhoneNumber());
            ps.setString(8, juridicalCustomer.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(); // para que salga el error

        }

    }

    @Override
    public void update(JuridicalCustomer juridicalCustomer) {

        query = "CALL update_juridicalCustomer(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, juridicalCustomer.getRuc() + "");
            ps.setString(2, juridicalCustomer.getSocialReason());
            ps.setString(3, juridicalCustomer.getType());
            ps.setString(4, juridicalCustomer.getEconomicActivity());
            ps.setString(5, juridicalCustomer.getTypeBilling());
            ps.setString(6, juridicalCustomer.getAddress());
            ps.setInt(7, juridicalCustomer.getPhoneNumber());
            ps.setString(8, juridicalCustomer.getEmail());
            ps.setInt(9, (int) juridicalCustomer.getId_person());
            ps.setInt(10, (int) juridicalCustomer.getId_juridicalPerson());
            ps.setInt(11, (int) juridicalCustomer.getId_juridicalCustomer());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace(); // para que salga el error

        }

    }

    @Override
    public void delete(long id) {
        
        
        
        query = "DELET FROM juridicalCustomer WHERE id_juridicalCustomer=? ";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
        
        

    }

}
