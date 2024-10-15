package utp.restaurant.database;

import java.time.LocalDate;
import java.util.ArrayList;
import utp.restaurant.model.Bill;
import utp.restaurant.model.Category;
import utp.restaurant.model.Employee;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.Role;
import utp.restaurant.model.Table;
import utp.restaurant.model.Customer;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.JuridicalCustomer;
import utp.restaurant.model.NaturalCustomer;
import utp.restaurant.model.Order;
import utp.restaurant.model.Ticket;

public class RestaurantDB {
    
    private static RestaurantDB instance;
    private ArrayList<Employee> employeeList;
    private ArrayList<Table> tableList;
    private ArrayList<Role> roleList;
    private ArrayList<Category> categoryList;
    private ArrayList<ItemMenu> itemMenuList;
    private ArrayList<NaturalCustomer> naturalCustomerList;
    private ArrayList<JuridicalCustomer> juridicalCustomerList;
    private ArrayList<Order> orderList;
    private ArrayList<Bill> billList;
    private ArrayList<Ticket> ticketList;
    
    private RestaurantDB() {
        // lista de roles
        roleList = new ArrayList<>();
        roleList.add(new Role("Administrador"));
        roleList.add(new Role("Mesero"));
        roleList.add(new Role("Cocinero"));
        roleList.add(new Role("Cajero"));

        //lista de empleados
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Omar", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(0), 74266131, "Omar", "Carrion", "Alcocer", LocalDate.of(2005, 06, 15), 923123478, "omar@gmail.com", "Mz. 10"));
        employeeList.add(new Employee("Cristian", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), 75286131, "Cristian", "De La Cruz", "De La Cruz", LocalDate.of(2005, 8, 18), 951761921, "cristian@gmail.com", "Mz. 18 calle los berracos"));
        employeeList.add(new Employee("Jhordan", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), 71597595, "Jhordan", "Calixto", "Laureano", LocalDate.of(2005, 6, 24), 934745971, "calix@gmail.com", "Mz. q lt 22"));
        employeeList.add(new Employee("Dalia", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(3), 60749109, "Dalia", "Alberto", "Joaquin", LocalDate.of(2006, 06, 06), 935041343, "dalia6@gmail.com", "Mz. 15"));
        employeeList.add(new Employee("Jean", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(2), 74883675, "Jean", "Chamorro", "Granados", LocalDate.of(2006, 01, 18), 946087675, "jean6@gmail.com", "Mz. 20 lote C"));
        employeeList.add(new Employee("Leonardo", "$2a$12$xB0S0mPQGM6p96Qiz6tHUuIdsiOMNi4jkziajkY4Aghsb4wx0M9j.", roleList.get(1), 76454651, "Leonardo", "Murillo", "Alejandro", LocalDate.of(2006, 01, 19), 946087675, "leonardoelpisado@gmail.com", "Mz. 20 lote C"));

        // lista de mesas
        tableList = new ArrayList<>();
        tableList.add(new Table(1, 15, "Ocupado", employeeList.get(1)));
        tableList.add(new Table(2, 12, "Disponible", employeeList.get(1)));
        tableList.add(new Table(3, 12, "Disponible", employeeList.get(1)));
        tableList.add(new Table(4, 10, "Disponible", employeeList.get(2)));
        tableList.add(new Table(5, 2, "Disponible", employeeList.get(5)));
        
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
        itemMenuList.add(new ItemMenu("Papa a la Huancaina", 29, "Con su huevo y aceituna.", "Disponible", categoryList.get(0), "papaHuancaina.png"));
        itemMenuList.add(new ItemMenu("Papa Rellena", 29, "Una papa rellena acompañada de crema de rocoto y sarza criolla.", "Disponible", categoryList.get(0), "papaRellena.png"));
        itemMenuList.add(new ItemMenu("Tamalito Verde", 19, "Con jugo de seco y sarza criolla.", "Disponible", categoryList.get(0), "tamalVerde.png"));
        itemMenuList.add(new ItemMenu("San Luis", 7.5, "Con harto gas.", "Disponible", categoryList.get(3), "sanLuis.png"));
        itemMenuList.add(new ItemMenu("Arroz con leche", 23, "Tradicional postre con arroz, leche y canela.", "Disponible", categoryList.get(2), "arrozConLeche.png"));
        itemMenuList.add(new ItemMenu("Mazamorra morada", 23, "Típico en nuestra repostería limeña con piña, durazno y guindones.", "Disponible", categoryList.get(3), "mazamorraMorada.png"));
        
        //Lista de clientes naturales
        naturalCustomerList = new ArrayList<>();
        naturalCustomerList.add(new NaturalCustomer(74883475, "Manuel", "Dias", "Granados", LocalDate.of(2005, 10, 12), 946087675, "jean@gmail.com", "Santa Clara, ate"));
        naturalCustomerList.add(new NaturalCustomer(74613649, "Pepito", "Huarote", "Vieira", LocalDate.of(2005, 11, 18), 946087675, "cris@gmail.com", "Santa Clara, ate"));
        
        //lista de clientes Juridicos
        juridicalCustomerList = new ArrayList<>();
        juridicalCustomerList.add(new JuridicalCustomer(Long.parseLong("12345678912"), "Company Name", "Sociedad Comercial", "Venta al por mayor de equipos electronicos", "Manuel / mecanizado", 946082375, "pass@gmail.com", "Santa Clara, ate"));
        
        ArrayList<ItemOrder> itemOrderList = new ArrayList<>();
        itemOrderList.add(new ItemOrder(10, "", itemMenuList.get(0)));
        
        Order order = new Order(employeeList.get(2), tableList.get(2), itemOrderList);
        order.setStatus("Preparado");
        orderList = new ArrayList<>();
        orderList.add(order);
        
        //lista de facturas
        billList = new ArrayList<>();
        
        //lista de boletas
        ticketList = new ArrayList<>();
    }

    //patron singleton
    public static RestaurantDB getInstance() {
        if (instance == null) {
            instance = new RestaurantDB();
        }
        
        return instance;
    }

    public ArrayList<Bill> getBillList() {
        return billList;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
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

    public ArrayList<NaturalCustomer> getNaturalCustomerList() {
        return naturalCustomerList;
    }

    public ArrayList<JuridicalCustomer> getJuridicalCustomerList() {
        return juridicalCustomerList;
    }
    
}
