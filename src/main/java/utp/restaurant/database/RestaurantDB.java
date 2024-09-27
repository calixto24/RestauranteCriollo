package utp.restaurant.database;

import java.time.LocalDate;
import java.util.ArrayList;
import utp.restaurant.model.Category;
import utp.restaurant.model.Employee;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.Role;
import utp.restaurant.model.Table;
import utp.restaurant.model.Customer;
import utp.restaurant.model.Order;

public class RestaurantDB {

    private static RestaurantDB instance;
    private ArrayList<Employee> employeeList;
    private ArrayList<Table> tableList;
    private ArrayList<Role> roleList;
    private ArrayList<Category> categoryList;
    private ArrayList<ItemMenu> itemMenuList;
    private ArrayList<Customer> customerList;
    private ArrayList<Order> orderList;
    private RestaurantDB() {
        // lista de roles
        roleList = new ArrayList<>();
        roleList.add(new Role("Administrador"));
        roleList.add(new Role("Mesero"));
        roleList.add(new Role("Cocinero"));
        roleList.add(new Role("Cajero"));

        //lista de empleados
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omar", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(0), "Omar", "Carrion", "Alcocer", 123123478, LocalDate.of(2005, 06, 15), 123456789, "omar@gmail.com", "Mz. 10"));
        employeeList.add(new Employee("Cristian", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), "Cristian", "De La Cruz", "De La Cruz", 75286131, LocalDate.of(2005, 8, 18), 951761921, "cristian@gmail.com", "Mz. 18 calle los berracos"));
        employeeList.add(new Employee("Jhordan", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), "Jhordan", "Calixto", "Laureano", 71597595, LocalDate.of(2005, 6, 24), 934745971, "calix@gmail.com", "Mz. q lt 22"));
        employeeList.add(new Employee("Dalia", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(0), "Dalia", "Alberto", "Joaquin", 60749109, LocalDate.of(2006, 06, 06), 935041343, "dalia6@gmail.com", "Mz. 15 lote"));
        employeeList.add(new Employee("Jean", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(0), "Jean", "Chamorro", "Granados", 74883675, LocalDate.of(2006, 01, 18), 946087675, "jean6@gmail.com", "Mz. 20 lote C"));
        
        // lista de mesas
        tableList = new ArrayList<>();
        tableList.add(new Table(1, 15, "Ocupado", employeeList.get(1)));
        tableList.add(new Table(2, 12, "Disponible", employeeList.get(1)));
        tableList.add(new Table(3, 10, "Disponible", employeeList.get(2)));

        //lista de categorias
        categoryList = new ArrayList<>();
        categoryList.add(new Category("ENTRADAS", "Deliciosos aperitivos que abren el apetito con sabores auténticos de la cocina criolla.", "cardCategoryEntradas.png"));
        categoryList.add(new Category("PLATOS", "Exquisitos platos fuertes que resaltan la riqueza de la gastronomía criolla en cada bocado", "cardCategoryPlatos.png"));
        categoryList.add(new Category("POSTRES", "Dulces tentaciones que cierran la experiencia con los más clásicos postres criollos.", "cardCategoryPostres.png"));
        categoryList.add(new Category("BEBIDAS", "Refrescantes y tradicionales bebidas que acompañan a la perfección nuestros sabores criollos.", "cardCategoryBebidas.png"));

        // lista de item menu 
        itemMenuList = new ArrayList<>();
        itemMenuList.add(new ItemMenu("Olluquito con charqui", 39, "Según receta antigua le añadimos su punto de chalona.", "Disponible", categoryList.get(1), "olluquitoCharqui.png"));
        itemMenuList.add(new ItemMenu("Chanfainita", 39, "La servimos con fideos a la criolla, mote, papa a la huancaína y rocoto bravo.", "Disponible", categoryList.get(1), "chanfainta.png"));
        itemMenuList.add(new ItemMenu("Empanada de Pastel de Choclo", 16, "Rellena de choclitos tiernos y carne guisada a fuego lento.", "Disponible", categoryList.get(0), "empanadaPastelChoclo.png"));
        itemMenuList.add(new ItemMenu("Turrón Doña Pancha 1/2 kg", 46, "Con harto cariño y miel de frutos.", "Disponible", categoryList.get(2), "turronDoñaPancha.png"));
        itemMenuList.add(new ItemMenu("Aji de Gallina", 48, "El plato favorito de los limeños.", "Agotado", categoryList.get(1), "ajiDeGallina.png"));

        //lista de clientes
        customerList = new ArrayList<>();
        customerList.add(new Customer("Manuel", "Dias", "Granados", 74883675, LocalDate.of(2005, 02, 15), 946087675, "jean@gmail.com", "Santa Clara, ate", "12345678912"));
        customerList.add(new Customer("Pepito", "Huarote", "Vieira", 74613649, LocalDate.of(2005, 11, 18), 946087675, "cris@gmail.com", "Santa Clara, ate", "12345678913"));
        
        //lista de ordenes
        orderList = new ArrayList<>(); 
    }
        
    
    //patron singleton
    public static RestaurantDB getInstance() {
        if (instance == null) {
            instance = new RestaurantDB();
        }

        return instance;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
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
