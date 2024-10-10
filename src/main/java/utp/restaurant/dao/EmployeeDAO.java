package utp.restaurant.dao;

import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.Employee;

public class EmployeeDAO implements DAO<Employee> {
    private ArrayList<Employee> employeList;

    //constructor vacio
    public EmployeeDAO() {
        employeList = RestaurantDB.getInstance().getEmployeeList();
    }

    //metodos
    @Override
    public ArrayList<Employee> getAll() {
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
