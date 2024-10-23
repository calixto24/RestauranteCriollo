package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.*;

public class EmployeeDAO implements DAO<Employee> {

    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Employee> employeList;

    //constructor vacio
    public EmployeeDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    //metodos
    @Override
    public ArrayList<Employee> getAll() {

        query = "SELECT * FROM getEmployee";
        
        employeList = new ArrayList<>();

        try {
            
            Employee employee = new Employee();

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                
                employee.setId_person(rs.getInt("id_person"));
                employee.setId_naturalPerson(rs.getInt("id_naturalPerson"));
                employee.setId_employee(rs.getInt("id_employee"));
                employee.setDni(rs.getInt("dni"));
                employee.setName(rs.getString("name"));
                employee.setLastname_paternal(rs.getString("last_paternal"));
                employee.setLastname_maternal(rs.getString("last_maternal"));
                employee.setBirthdate(rs.getDate("birthdate").toLocalDate());
                employee.setAddress(rs.getString("address"));
                employee.setPhoneNumber(rs.getInt("phone_number"));
                employee.setEmail(rs.getString("email"));
                employee.setUsername(rs.getString("username"));
                
                Role role = new Role();
                role.setId(rs.getInt("id_role"));
                role.setName(rs.getString("name_role"));
                
                employee.setRole(role);
                
                employeList.add(employee);

            }

        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

        return employeList;
    }

    @Override
    public Employee get(long id) {
        
        query = "SELECT * FROM employee WHERE id_employee = ?";
        
        Employee employee = new Employee();
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                employee.setId_person(rs.getInt("id_person"));
                employee.setId_naturalPerson(rs.getInt("id_naturalPerson"));
                employee.setId_employee(rs.getInt("id_employee"));
                employee.setDni(rs.getInt("dni"));
                employee.setName(rs.getString("name"));
                employee.setLastname_paternal(rs.getString("last_paternal"));
                employee.setLastname_maternal(rs.getString("last_maternal"));
                employee.setBirthdate(rs.getDate("birthdate").toLocalDate());
                employee.setAddress(rs.getString("address"));
                employee.setPhoneNumber(rs.getInt("phone_number"));
                employee.setEmail(rs.getString("email"));
                employee.setUsername(rs.getString("username"));
                
                Role role = new Role();
                role.setId(rs.getInt("id_role"));
                role.setName(rs.getString("name_role"));
                
                employee.setRole(role);

            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
        return employee;
        
    }

    @Override
    public void add(Employee employee) {
        
        query = "CALL add_employee(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getDni());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getLastname_paternal());
            ps.setString(4, employee.getLastname_maternal());
            ps.setString(5, employee.getBirthdate().toString());
            ps.setString(6, employee.getAddress());
            ps.setInt(7, employee.getPhoneNumber());
            ps.setString(8, employee.getEmail());
            ps.setString(9, employee.getUsername());
            ps.setString(10, employee.getPassword());
            ps.setInt(11, (int) employee.getRole().getId());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }

    @Override
    public void update(Employee employee) {
        
        query = "CALL update_employee(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getDni());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getLastname_paternal());
            ps.setString(4, employee.getLastname_maternal());
            ps.setString(5, employee.getBirthdate().toString());
            ps.setString(6, employee.getAddress());
            ps.setInt(7, employee.getPhoneNumber());
            ps.setString(8, employee.getEmail());
            ps.setString(9, employee.getUsername());
            ps.setString(10, employee.getPassword());
            ps.setInt(11, (int) employee.getRole().getId());
            ps.setInt(12, (int) employee.getId_employee());
            ps.setInt(13, (int) employee.getId_naturalPerson());
            ps.setInt(14, (int) employee.getId_person());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }

    @Override
    public void delete(long id) {
        
        query = "DELETE FROM employee WHERE id_employee = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, (int) id);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}
