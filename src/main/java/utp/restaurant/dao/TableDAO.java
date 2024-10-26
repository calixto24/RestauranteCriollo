package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.*;
import java.util.ArrayList;

public class TableDAO implements DAO<Table> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Table> tableList;
    private EmployeeDAO employeeDAO;

    public TableDAO() {
        conn = RestaurantDB.getInstance().getConn();
        employeeDAO = new EmployeeDAO();
    }

    @Override
    public ArrayList<Table> getAll() {

        query = "SELECT * FROM \"table\"";

        tableList = new ArrayList<>();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                Table table = new Table();

                table.setId(rs.getInt("id_table"));
                table.setNumber_table(rs.getInt("number_table"));
                table.setCapacity(rs.getInt("capacity"));
                table.setStatus(rs.getString("status"));

                int id_employee = rs.getInt("id_employee");
                
                Employee employee = employeeDAO.get((long)id_employee);
                table.setEmployee(employee);

                tableList.add(table);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableList;
    }

    @Override
    public Table get(long id) {
        
        query = "SELECT * FROM \"table\" WHERE id_table = ?";
        
        Table table = new Table();
        
        try {
            
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                
                table.setId(rs.getInt("id_table"));
                table.setNumber_table(rs.getInt("number_table"));
                table.setCapacity(rs.getInt("capacity"));
                table.setStatus(rs.getString("status"));

                int id_employee = rs.getInt("id_employee");
                
                Employee employee = employeeDAO.get((long)id_employee);
                table.setEmployee(employee);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return table;
        
    }

    @Override
    public void add(Table table) {
        
        query = "INSERT INTO \"table\"(number_table, capacity, status, id_employee) VALUES (?,?,?,?)";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, table.getNumber_table());
            ps.setInt(2, table.getCapacity());
            ps.setString(3, table.getStatus());
            ps.setInt(4, (int) table.getEmployee().getId_employee());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(Table table) {
        
        query = "UPDATE \"table\" SET number_table = ?, capacity = ?, status = ?, id_employee = ? WHERE id_table = ?";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, table.getNumber_table());
            ps.setInt(2, table.getCapacity());
            ps.setString(3, table.getStatus());
            ps.setInt(4, (int) table.getEmployee().getId_employee());
            ps.setInt(5, (int) table.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(long id) {
        
        query = "DELETE FROM \"table\" WHERE id_table = ?";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
