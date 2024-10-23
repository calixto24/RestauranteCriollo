package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.Employee;

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
        
        try {
            
        } catch (Exception e) {
        }
        
        
        return employeList;
    }

    @Override
    public Employee get(long id) {
        for(Employee e: employeList) {
            if (e.getId_employee() == id) return e;
        }
        
        return null;
    }

    @Override
    public void add(Employee employee) {
        employeList.add(employee);
    }

    @Override
    public void update(long id, Employee employee) {
        employeList.set(getIndex(id), employee);
    }

    @Override
    public void delete(long id) {
       employeList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return employeList.indexOf(get(id));
    }
}
