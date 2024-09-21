
package utp.restaurant.dao;
import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.Customer;
public class CustomerDAO implements DAO<Customer>{
    private ArrayList<Customer> customerList;
    
    //constructor vacio
    public CustomrDao() {
        customerList = RestaurantDB.getInstance().getCustomerList();
    }
    
    
}
