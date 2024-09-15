package utp.restaurant.dao;

import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.Employee;

public class EmployeeDAO implements DAO<Employee> {
    //objeto
    private ArrayList<Employee> employeeList;

    //constructor vacio
    public EmployeeDAO() {
        employeeList = RestaurantDB.getInstance().getEmployeeList();
    }

    //metodos
    @Override
    public ArrayList<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee get(long id) {
        
        for (Employee employee : employeeList) {
            
            if (id == employee.getId()) {
                return employee;
            }
            
        }

        return null;
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void update(long id, Employee e) {
        int index = getIndex(id);

        employeeList.set(index, e);
    }

    @Override
    public void delete(long id) {
        int index = getIndex(id);

        employeeList.remove(index);
    }

    public int getIndex(long id) {
        Employee employee = get(id);

        return employeeList.indexOf(employee);
    }
}
