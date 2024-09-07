
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
        employeeList.add(new Employee( "Nolan", "nol", "Administrador", "john", "mayro", "luna", 60749102, LocalDate.of(2005, 06, 05), "298392839", "kenao@gmail.com"));
        employeeList.add(new Employee( "Calix", "1234", "Mesero", "Jhordan", "Calixto", "Laureano", 71597595, LocalDate.of(2005, 06, 24), "11111211111", "calix@gmail.com"));
        employeeList.add(new Employee( "admin", "admin", "Cajero", "Manuel", "Parra", "Flores", 71597592, LocalDate.of(2005, 06, 24), "11111111111", "manu@gmail.com"));

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
