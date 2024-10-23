
package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.JuridicalCustomer;

public class JuridicalCustomerDAO implements DAO<JuridicalCustomer>{
    
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
        
        query = "SELECT * FROM getJuricalCustomer";
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
        } catch (Exception e) {
        }
        
        return juridicalCustomerList;  
    }
    
    @Override
    public JuridicalCustomer get(long id) {
        for(JuridicalCustomer e: juridicalCustomerList) {
            if (e.getId_juridicalCustomer() == id) return e;
        }
        return null;
    }
    
    @Override 
    public void add(JuridicalCustomer juridicalCustomer) {
        
        
        
    }
    
    @Override
    public void update(JuridicalCustomer juridicalCustomer) {
        
        
        
    }

    @Override
    public void delete(long id) {
       
        
        
    }
    
}