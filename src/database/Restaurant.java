
package database;

import java.util.ArrayList;
import model.Employee;
import java.time.LocalDate;
import model.Table;

public class Restaurant {
    
    private ArrayList<Employee>employeeList;
    private static Restaurant instance;
    private ArrayList<Table>tableList;
    
    private Restaurant(){
        
        //inicializando el objeto
        employeeList = new ArrayList<>();
        
        //lista de empleados
        employeeList.add(new Employee( "Omar", "12345678", "Administrador", "Omar", "Carrion", "Alcocer", 60749102, LocalDate.of(2005, 06, 15), 123456789, "omar@gmail.com", "Mz. 16 al pincho"));
        
        
        tableList = new ArrayList<>(); 
        tableList.add(new Table(1, 15, "Disponible"));
        tableList.add(new Table(2, 12, "Disponible"));
        tableList.add(new Table(3, 10, "Disponible"));
    }

    public ArrayList<Table> getTableList() {
        return tableList;
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
