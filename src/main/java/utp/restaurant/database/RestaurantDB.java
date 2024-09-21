package utp.restaurant.database;

import java.time.LocalDate;
import java.util.ArrayList;
import utp.restaurant.model.Category;
import utp.restaurant.model.Employee;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.Role;
import utp.restaurant.model.Table;

public class RestaurantDB {

    private static RestaurantDB instance;
    private ArrayList<Employee> employeeList;
    private ArrayList<Table> tableList;
    private ArrayList<Role> roleList;
    private ArrayList<Category> categoryList; 
    private ArrayList<ItemMenu> itemMenuList;


    private RestaurantDB() {
        // lista de roles
        roleList = new ArrayList<>();
        roleList.add(new Role("Administrador"));
        roleList.add(new Role("Mesero"));
        roleList.add(new Role("Cocinero"));
        roleList.add(new Role("Cajero"));

        //lista de empleados
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omar", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(0), "Omar", "Carrion", "Alcocer", 12365478, LocalDate.of(2005, 06, 15), 123456789, "omar@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee("Cristian", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), "Cristian", "asd", "gdfgd", 12365479, LocalDate.of(2000, 01, 20), 123456799, "cristian@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee("Cristian", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), "Manuel", "asd", "gdfgd", 12365479, LocalDate.of(2000, 01, 20), 123456799, "cristian@gmail.com", "Mz. 16 al pincho"));

        // lista de mesas
        tableList = new ArrayList<>();
        tableList.add(new Table(1, 15, "Ocupado", employeeList.get(1)));
        tableList.add(new Table(2, 12, "Disponible", employeeList.get(1)));
        tableList.add(new Table(3, 10, "Disponible", employeeList.get(2)));

        
        //lista de categorias
        categoryList= new ArrayList<>();
        categoryList.add(new Category("postres", "aaaa", ""));
        categoryList.add(new Category("bebidas", "eee", ""));
        categoryList.add(new Category("platos", "eeee", ""));


        // lista de item menu 
        itemMenuList = new ArrayList<>();
        itemMenuList.add(new ItemMenu("image","Lomo Saltado", 20, "Carne de pollo","disponible"));
        itemMenuList.add(new ItemMenu("image","Causa", 16, "Causa de atun","disponible"));
        itemMenuList.add(new ItemMenu("image","Ceviche", 15, "De tilapia", "agotado"));
        
    }

    //patron singleton
    public static RestaurantDB getInstance() {
        if (instance == null) {
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

    public ArrayList<ItemMenu> getItemMenuList() {
        return itemMenuList;
    }

    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }
    
}
