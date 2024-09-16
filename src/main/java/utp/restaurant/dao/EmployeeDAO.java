package utp.restaurant.dao;

import java.sql.Connection;
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

    //constructor vacio
    public EmployeeDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    //metodos
    @Override
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        
        query = "SELECT r.name AS roleName, p.name as personName, * FROM employee e INNER JOIN person p ON p.id = e.person_id INNER JOIN role r ON e.role_id = r.id";
        
        try {
           st = conn.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next()) {
               Employee employee = new Employee();
               Role role = new Role();
               
               role.setId(rs.getInt("role_id"));
               role.setName(rs.getString("roleName"));
               
               employee.setId(rs.getInt("id"));
               employee.setName(rs.getString("personName"));
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
        
        
    }

    @Override
    public void add(Employee employee) {
        
    }

    @Override
    public void update(long id, Employee e) {
        
    }

    @Override
    public void delete(long id) {
       
    }

//    public int getIndex(long id) {
//    
//    }
}
