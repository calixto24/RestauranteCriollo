
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
        employeeList.add(new Employee( "Omar", "12345678", "Administrador", "JoOmarhn", "Carrion", "Alcocer", 60749102, LocalDate.of(2005, 06, 15), "11111111111", "omar@gmail.com"));
        employeeList.add(new Employee( "Cristian", "12345678", "Administrador", "Cristian", "De la Cruz", "De la Cruz", 40749102, LocalDate.of(2004, 02, 05), "21111111111", "cristian@gmail.com"));
        employeeList.add(new Employee( "Dalia", "12345678", "Administrador", "Dalia", "Alberto", "Joaquin", 60249102, LocalDate.of(2005, 03, 12), "31111111111", "dalia@gmail.com"));
        employeeList.add(new Employee( "Leonardo", "12345678", "Mesero", "Leonardo", "Murillo", "Alejandro", 70129102, LocalDate.of(2005, 01, 12), "41111111111", "leonardo@gmail.com"));
        employeeList.add(new Employee( "Jhordan", "12345678", "Administrador", "Jhordan", "Calixto", "Laureano", 91597595, LocalDate.of(2004, 06, 24), "51111111111", "calix@gmail.com"));
        employeeList.add(new Employee( "Jean", "12345678", "Cajero", "Jean", "Chamorro", "Granados", 71597592, LocalDate.of(2005, 06, 24), "61111111111", "jean@gmail.com"));
        
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
