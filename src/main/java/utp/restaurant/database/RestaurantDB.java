package utp.restaurant.database;

import java.time.LocalDate;
import java.util.ArrayList;
import utp.restaurant.model.Category;
import utp.restaurant.model.Employee;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.Role;
import utp.restaurant.model.Table;
import utp.restaurant.model.Customer;


public class RestaurantDB {

    private static RestaurantDB instance;
    private ArrayList<Employee> employeeList;
    private ArrayList<Table> tableList;
    private ArrayList<Role> roleList;
    private ArrayList<Category> categoryList; 
    private ArrayList<ItemMenu> itemMenuList;
    private ArrayList<Customer> customerList; 

    private RestaurantDB() {
        // lista de roles
        roleList = new ArrayList<>();
        roleList.add(new Role("Administrador"));
        roleList.add(new Role("Mesero"));
        roleList.add(new Role("Cocinero"));
        roleList.add(new Role("Cajero"));

        //lista de empleados
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omar", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(0), "Omar", "Carrion", "Alcocer", 123123478, LocalDate.of(2005, 06, 15), 123456789, "omar@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee("Cristian", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), "Cristian", "asd", "gdfgd", 12365479, LocalDate.of(2000, 01, 20), 123456799, "cristian@gmail.com", "Mz. 16 al pincho"));
        employeeList.add(new Employee("Cristian", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), "Manuel", "asd", "gdfgd", 12365479, LocalDate.of(2000, 01, 20), 123456799, "cristian@gmail.com", "Mz. 16 al pincho"));

        // lista de mesas
        tableList = new ArrayList<>();
        tableList.add(new Table(1, 15, "Ocupado", employeeList.get(1)));
        tableList.add(new Table(2, 12, "Disponible", employeeList.get(1)));
        tableList.add(new Table(3, 10, "Disponible", employeeList.get(2)));

        
        //lista de categorias
        categoryList= new ArrayList<>();
        categoryList.add(new Category("ENTRADAS", "Deliciosos aperitivos que abren el apetito con sabores auténticos de la cocina criolla.", "cardCategoryEntradas.png"));
        categoryList.add(new Category("PLATOS", "Exquisitos platos fuertes que resaltan la riqueza de la gastronomía criolla en cada bocado", "cardCategoryPlatos.png"));
        categoryList.add(new Category("POSTRES", "Dulces tentaciones que cierran la experiencia con los más clásicos postres criollos.", "cardCategoryPostres.png"));
        categoryList.add(new Category("BEBIDAS", "Refrescantes y tradicionales bebidas que acompañan a la perfección nuestros sabores criollos.", "cardCategoryBebidas.png"));


        // lista de item menu 
        itemMenuList = new ArrayList<>();
        itemMenuList.add(new ItemMenu("Lomo Saltado", 20.23, "Carne de pollo","disponible",categoryList.get(1),"cardCategoryEntradas.png"));
        itemMenuList.add(new ItemMenu("Causa", 16, "Causa de atun","disponible",categoryList.get(2),""));
        itemMenuList.add(new ItemMenu("Ceviche", 15, "De tilapia", "agotado",categoryList.get(1),""));
        
        //lista de clientes
        customerList = new ArrayList<>();
        customerList.add( new Customer("Jean", "Chamorro", "Granados",74883675,LocalDate.of(2005, 02, 15), 946087675, "jean@gmail.com","Santa Clara, ate", "12345678912"));
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

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    
}
