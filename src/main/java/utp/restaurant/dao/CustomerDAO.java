
package utp.restaurant.dao;
import utp.restaurant.database.RestaurantDB;
import java.util.ArrayList;
import utp.restaurant.model.Customer;
public class CustomerDAO implements DAO<Customer>{
    private ArrayList<Customer> customerList;
    
    //constructor vacio
    public CustomerDAO() {
        customerList = RestaurantDB.getInstance().getCustomerList();
    }
    
    @Override
    public ArrayList<Customer> getAll() {
        return customerList;  
    }
    
    @Override
    public Customer get(long id) {
        for(Customer e:customerList) {
            if (e.getId_customer()== id) return e;
        }
        return null;
    }
    
    @Override 
    public void add(Customer customer) {
        customerList.add(customer);
    }
    
    @Override
    public void update(long id, Customer customer) {
        customerList.set(getIndex(id), customer);
    }

    @Override
    public void delete(long id) {
       customerList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return customerList.indexOf(get(id));
    }
    
}
