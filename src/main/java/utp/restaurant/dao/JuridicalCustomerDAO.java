
package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.Interface.DAO;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.JuridicalCustomer;

public class JuridicalCustomerDAO implements DAO<JuridicalCustomer>{
    
    private ArrayList<JuridicalCustomer> juridicalCustomerList;
    
    //constructor vacio
    public JuridicalCustomerDAO() {
        juridicalCustomerList = RestaurantDB.getInstance().getJuridicalCustomerList();
    }
    
    @Override
    public ArrayList<JuridicalCustomer> getAll() {
        return juridicalCustomerList;  
    }
    
    @Override
    public JuridicalCustomer get(long id) {
        for(JuridicalCustomer e: juridicalCustomerList) {
            if (e.getId_juridicalCustomer() == id) return e;
        }
        return null;
    }
    
    @Override 
    public void add(JuridicalCustomer juridicalCustomer) {
        juridicalCustomerList.add(juridicalCustomer);
    }
    
    @Override
    public void update(long id, JuridicalCustomer juridicalCustomer) {
        juridicalCustomerList.set(getIndex(id), juridicalCustomer);
    }

    @Override
    public void delete(long id) {
       juridicalCustomerList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return juridicalCustomerList.indexOf(get(id));
    }
    
}