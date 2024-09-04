
package database;

import java.util.ArrayList;
import java.util.Date;
import model.Employee;

public class Restaurant {
    private ArrayList<Employee>employeeList;
    public Restaurant(){
        employeeList = new ArrayList<>();
        employeeList.add(new Employee( "Nolan", " nol", "administrador", "john", "mayro", "luna", 60749102, Date.from("12/12/2001"), 123456, "keanu@gmail.com"));
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
}
