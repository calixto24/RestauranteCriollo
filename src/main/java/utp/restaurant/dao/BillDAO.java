
package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Bill;


public class BillDAO implements DAO<Bill>{
    
    private ArrayList<Bill> billList;

    public BillDAO() {
        billList = RestaurantDB.getInstance().getBillList();
    }

    @Override
    public ArrayList<Bill> getAll() {
        return billList;
    }

    @Override
    public Bill get(long id) {
        for (Bill bill : billList) {
            if (id == bill.getId_Bill()) {
                return bill;
            }
        }

        return null;
    }

    @Override
    public void add(Bill table) {
        billList.add(table);
    }

    @Override
    public void update(long id, Bill bill) {
        int index = getIndex(id);
        billList.set(index, bill);
    }

    @Override
    public void delete(long id) {
        int index = getIndex(id);
        billList.remove(index);
    }

    public int getIndex(long id) {
        Bill bill = get(id);
        return billList.indexOf(bill);
    }
    
}
