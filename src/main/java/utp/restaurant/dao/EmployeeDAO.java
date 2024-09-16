package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.Employee;
import utp.restaurant.model.Role;

public class EmployeeDAO implements DAO<Employee> {
    //objeto
    private Connection conn;
    private String query;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    //constructor vacio
    public EmployeeDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    //metodos
    @Override
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        
        query = "SELECT r.name AS role_name, p.name as person_name, e.id as employee_id, * FROM employee e INNER JOIN person p ON p.id = e.person_id INNER JOIN role r ON e.role_id = r.id";
        
        try {
           st = conn.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next()) {
               Employee employee = new Employee();
               Role role = new Role();
               
               role.setId(rs.getInt("role_id"));
               role.setName(rs.getString("role_name"));
               
               employee.setId(rs.getInt("employee_id"));
               employee.setName(rs.getString("person_name"));
               employee.setLastname_paternal(rs.getString("lastname_paternal"));
               employee.setLastname_maternal(rs.getString("lastname_maternal"));
               employee.setDni(Integer.parseInt(rs.getString("dni")));
               employee.setBirthdate(rs.getDate("birthdate").toLocalDate());
               employee.setPhoneNumber(Integer.parseInt(rs.getString("phoneNumber")));
               employee.setAddress(rs.getString("address"));
               employee.setEmail(rs.getString("email"));
               employee.setUsername(rs.getString("username"));
               employee.setPassword(rs.getString("password"));
               employee.setRole(role);
               employeeList.add(employee);
           }
 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return employeeList;
    }

    @Override
    public Employee get(long id) {
        
        query = "SELECT r.name AS role_name, p.name as person_name, e.id as employee_id, * FROM employee e INNER JOIN person p ON p.id = e.person_id INNER JOIN role r ON e.role_id = r.id WHERE e.id = " + id;
        
        Employee employee = new Employee();
        
        try {
           st = conn.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next()) {
               Role role = new Role();
               
               role.setId(rs.getInt("role_id"));
               role.setName(rs.getString("role_name"));
               
               employee.setId(rs.getInt("employee_id"));
               employee.setName(rs.getString("person_name"));
               employee.setLastname_paternal(rs.getString("lastname_paternal"));
               employee.setLastname_maternal(rs.getString("lastname_maternal"));
               employee.setDni(Integer.parseInt(rs.getString("dni")));
               employee.setBirthdate(rs.getDate("birthdate").toLocalDate());
               employee.setPhoneNumber(Integer.parseInt(rs.getString("phoneNumber")));
               employee.setAddress(rs.getString("address"));
               employee.setEmail(rs.getString("email"));
               employee.setUsername(rs.getString("username"));
               employee.setPassword(rs.getString("password"));
               employee.setRole(role);
           }
 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return employee;
        
    }

    @Override
    public void add(Employee employee) {
        
        /*query = "call add_employee('" +
                employee.getName() + "', '" +
                employee.getLastname_paternal() + "', '" +
                employee.getLastname_maternal() + "', '" +
                employee.getDni() + "', '" +
                employee.getBirthdate() + "', '" +
                employee.getPhoneNumber() + "', '" +
                employee.getAddress() + "', '" +
                employee.getEmail() + "', '" +
                employee.getUsername() + "', '" +
                employee.getPassword() + "', " +
                employee.getRole().getId() 
                ")";*/
        
        query = "call add_employe(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            
            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastname_paternal());
            ps.setString(3, employee.getLastname_maternal());
            ps.setString(4, Integer.toString(employee.getDni()));
            ps.setString(5, employee.getBirthdate().toString());
            ps.setString(6, employee.getPhoneNumber() + "");
            ps.setString(7, employee.getEmail());
            ps.setString(8, employee.getUsername());
            ps.setString(9, employee.getPassword());
            ps.setLong(10, employee.getRole().getId());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
    }

    @Override
    public void update(long id, Employee e) {
        
    }

    @Override
    public void delete(long id) {
        
        query = "delete employee"
       
    }

//    public int getIndex(long id) {
//    
//    }
}
