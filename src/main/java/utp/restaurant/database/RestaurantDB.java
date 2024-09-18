package utp.restaurant.database;

import java.time.LocalDate;
import java.util.ArrayList;
import utp.restaurant.model.Employee;
import utp.restaurant.model.Role;
import utp.restaurant.model.Table;

public class RestaurantDB {
    private static RestaurantDB instance;
    private ArrayList<Employee> employeeList;
    private ArrayList<Table> tableList;
    private ArrayList<Role> roleList;

    
    private RestaurantDB(){
        // lista de roles
        roleList = new ArrayList<>();
        roleList.add(new Role("Administrador"));
        roleList.add(new Role("Mesero"));
        roleList.add(new Role("Cocinero"));
        roleList.add(new Role("Cajero"));
                
        //lista de empleados
        employeeList = new ArrayList<>();
        employeeList.add(new Employee( "Omar", "12345678", roleList.get(0), "Omar", "Carrion", "Alcocer", 12365478, LocalDate.of(2005, 06, 15), 123456789, "omar@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee( "Cristian", "12345678", roleList.get(1), "Cristian", "asd", "gdfgd", 12365479, LocalDate.of(2000, 01, 20), 123456799, "cristian@gmail.com", "Mz. 16 al pincho"));
        
        // lista de mesas
        tableList = new ArrayList<>(); 
        tableList.add(new Table(1, 15, "Disponible", employeeList.get(1)));
        tableList.add(new Table(2, 12, "Disponible", employeeList.get(1)));
        tableList.add(new Table(3, 10, "Disponible", employeeList.get(1)));
    }
    
    //patron singleton
    public static RestaurantDB getInstance() {
        if(instance == null) {         
            instance = new RestaurantDB();
        }
        
        return instance;  
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<Table> getTableList() {
        return tableList;
    }

    public ArrayList<Role> getRoleList() {
        return roleList;
    }
}
