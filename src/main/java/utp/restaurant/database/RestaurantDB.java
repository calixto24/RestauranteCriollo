package utp.restaurant.database;

import java.util.ArrayList;
import java.time.LocalDate;

import utp.restaurant.model.Employee;
import utp.restaurant.model.Table;

public class RestaurantDB {
    
    private ArrayList<Employee>employeeList;
    private static RestaurantDB instance;
    private ArrayList<Table>tableList;
    
    private RestaurantDB(){
        
        //inicializando el objeto
        employeeList = new ArrayList<>();
        
        //lista de empleados
        employeeList.add(new Employee( "Omar", "12345678", "Mesero", "Omar", "Carrion", "Alcocer", 12365478, LocalDate.of(2005, 06, 15), 123456789, "omar@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee( "Pepe", "12345687", "Administrador", "Pepe", "Torres", "Alcocer", 45678932, LocalDate.of(2005, 06, 15), 123456489, "omaras@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee( "Carlos", "32165498", "Mesero", "Carlos", "Mamani", "Alcocer", 12345678, LocalDate.of(2005, 06, 15), 121456789, "omarasd@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee( "Tom", "123456456345", "Mesero", "Tom", "Quispe", "Alcocer", 65432185, LocalDate.of(2005, 06, 15), 123456589, "omarasd@gmail.com", "Mz. 16 al pincho"));
        
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
    public static RestaurantDB getInstance() {
        if(instance == null) {         
            instance = new RestaurantDB();
        }
        
        return instance;  
    }
    
}
