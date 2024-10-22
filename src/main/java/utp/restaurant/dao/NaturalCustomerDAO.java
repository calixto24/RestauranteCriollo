
package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.NaturalCustomer;

public class NaturalCustomerDAO implements DAO<NaturalCustomer>{
    
    private ArrayList<NaturalCustomer> naturalCustomerList;
    
    //constructor vacio
    public NaturalCustomerDAO() {
        naturalCustomerList = RestaurantDB.getInstance().getNaturalCustomerList();
    }
    
    @Override
    public ArrayList<NaturalCustomer> getAll() {
        return naturalCustomerList;  
    }
    
    @Override
    public NaturalCustomer get(long id) {
        for(NaturalCustomer e:naturalCustomerList) {
            if (e.getId_naturalCustomer() == id) return e;
        }
        return null;
    }
    
    @Override 
    public void add(NaturalCustomer naturalCustomer) {
        naturalCustomerList.add(naturalCustomer);
    }
    
    @Override
    public void update(long id, NaturalCustomer naturalCustomer) {
        naturalCustomerList.set(getIndex(id), naturalCustomer);
    }

    @Override
    public void delete(long id) {
       naturalCustomerList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return naturalCustomerList.indexOf(get(id));
    }
    
}
