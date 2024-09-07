
package dao;

import database.Restaurant;
import java.util.ArrayList;
import model.Employee;

public class EmployeeDao {
    
    //objeto
    private ArrayList<Employee> employeeList;

    //constructor vacio
    public EmployeeDao() {
        
        employeeList = Restaurant.getInstance().getEmployeeList();
        
    }
    
    //metodos
    public ArrayList<Employee> getAll() {
        
        return employeeList;
        
    }
    
    public void add(Employee employee) {
        
        employeeList.add(employee);
        
    }
    
    public void update(int dni) {
        
        get(dni);
        
    }
    
    public Employee get(int dni) {
        
        for(Employee employee : employeeList) {
            
            if (dni == employee.getDni()) {
                
                return employee;
                
            }
            
        }
        
        return null;
        
    }
    
}
