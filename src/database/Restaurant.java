
package database;

import java.util.ArrayList;
import model.Employee;
import java.time.LocalDate;

public class Restaurant {
    
    private ArrayList<Employee>employeeList;
    private static Restaurant instance;
    
    private Restaurant(){
        
        //inicializando el objeto
        employeeList = new ArrayList<>();
        
        //lista de empleados
        employeeList.add(new Employee( "Nolan", "nol", "administrador", "john", "mayro", "luna", 60749102, LocalDate.of(2005, 06, 05), 298392839, "kenao@gmail.com"));
        employeeList.add(new Employee( "Calix", "123", "administrador", "Jhordan", "Calixto", "Laureano", 71597595, LocalDate.of(2005, 06, 24), 1245646446, "calix@gmail.com"));

    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    //patron singleton
    public static Restaurant getInstance() {
        
        if(instance == null) {
            
            instance = new Restaurant();
            
        }
        
        return instance;
        
    }
    
}
