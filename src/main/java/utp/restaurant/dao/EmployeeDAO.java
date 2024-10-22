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

        query = "SELECT * from get_employees";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Employee employee = new Employee();
                Role role = new Role();

                role.setId(rs.getInt("role_id"));
                role.setName(rs.getString("role_name"));

                employee.setId_employee(rs.getInt("employee_id"));
                employee.setId_person(rs.getInt("person_id"));
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee get(long id) {

        query = "SELECT * from get_employees WHERE employee_id = " + id;

        Employee employee = new Employee();

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Role role = new Role();

                role.setId(rs.getInt("role_id"));
                role.setName(rs.getString("role_name"));

                employee.setId_employee(rs.getInt("employee_id"));
                employee.setId_person(rs.getInt("person_id"));
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;

    }

    @Override
    public void add(Employee employee) {

        query = "call add_employe(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastname_paternal());
            ps.setString(3, employee.getLastname_maternal());
            ps.setString(4, Integer.toString(employee.getDni()));
            ps.setString(5, employee.getBirthdate().toString());
            ps.setString(6, employee.getPhoneNumber() + "");
            ps.setString(7, employee.getAddress());
            ps.setString(8, employee.getEmail());
            ps.setString(9, employee.getUsername());
            ps.setString(10, employee.getPassword());
            ps.setLong(11, employee.getRole().getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void update(Employee employee) {

        query = "call update_employee(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastname_paternal());
            ps.setString(3, employee.getLastname_maternal());
            ps.setString(4, Integer.toString(employee.getDni()));
            ps.setString(5, employee.getBirthdate().toString());
            ps.setString(6, employee.getPhoneNumber() + "");
            ps.setString(7, employee.getAddress());
            ps.setString(8, employee.getEmail());
            ps.setString(9, employee.getUsername());
            ps.setLong(10, employee.getRole().getId());
            ps.setLong(11, employee.getId_person());
            ps.setLong(12, employee.getId_employee());

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void delete(long id) {

        query = "delete from person WHERE id = " + id;

        try {

            st = conn.createStatement();
            st.executeQuery(query);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

//    public int getIndex(long id) {
//    
//    }
}
