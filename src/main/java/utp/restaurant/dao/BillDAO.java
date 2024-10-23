
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


public class BillDAO implements DAO<Bill>{
    
    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Bill> billList;

    public BillDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<Bill> getAll() {
        
        query = "SELECT * FROM getBill";
        
        billList = new ArrayList<>();
        
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                
                Bill bill = new Bill();
                
                bill.setId_Bill(rs.getInt("id_bill"));
                bill.setDate(rs.getDate("date").toLocalDate());
                bill.setTime(rs.getTime("time").toLocalTime());
                
                JuridicalCustomer jc = new JuridicalCustomer();
                jc.setId_juridicalCustomer(rs.getInt("id_juridicalcustomer"));
                jc.setId_juridicalPerson(rs.getInt("id_juridicalperson"));
                jc.setSocialReason(rs.getString("socialreason"));
                bill.setCustomer(jc);
                
                Employee employee = new Employee();
                employee.setId_employee(rs.getInt("id_employee"));
                employee.setName(rs.getString("name"));
                employee.setLastname_paternal(rs.getString("last_paternal"));
                employee.setLastname_maternal(rs.getString("last_maternal"));
                bill.setCashier(employee);
                
                bill.setTotalPrice(rs.getDouble("totalprice"));
                
                billList.add(bill);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return billList;
        
    }

    @Override
    public Bill get(long id) {
        for (Bill bill : billList) {
            if (id == bill.getId_Bill()) {
                return bill;
            }
        }

        return null;
    }

    @Override
    public void add(Bill table) {
        billList.add(table);
    }

    @Override
    public void update( Bill bill) {
        
    }

    @Override
    public void delete(long id) {
        
    }
    
}
