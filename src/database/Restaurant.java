
package database;

import java.util.ArrayList;
import model.Employee;
import java.time.LocalDate;

public class Restaurant {
    
    private ArrayList<Employee>employeeList;
    
    public Restaurant(){
        
        //inicializando el objeto
        employeeList = new ArrayList<>();
        
        //lista de empleados
        employeeList.add(new Employee( "Nolan", " nol", "administrador", "john", "mayro", "luna", 60749102, LocalDate.of(2005, 06, 05), 298392839, "kenao@gmail.com"));
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
}
