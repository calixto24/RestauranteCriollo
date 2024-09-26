package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.ItemOrder;

public class ItemOrderDAO implements DAO<ItemOrder> {

    private ArrayList<ItemOrder> itemorderList;

    public ItemOrderDAO() {
        itemorderList = RestaurantDB.getInstance().getItemorderList();
    }

    @Override
    public ArrayList<ItemOrder> getAll() {
        return itemorderList;
    }

    @Override
    public ItemOrder get(long id) {
        for (ItemOrder e : itemorderList) {
            if (e.getId_itemOrder()== id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void add(ItemOrder itemOrder) {
        itemorderList.add(itemOrder);
    }

    @Override
    public void update(long id, ItemOrder itemOrder) {
        itemorderList.set(getIndex(id), itemOrder);
    }

    @Override
    public void delete(long id) {
        itemorderList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return itemorderList.indexOf(get(id));
    }

}
