package utp.restaurant.dao;

import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.ItemMenu;

public class ItemMenuDAO
        implements DAO<ItemMenu> {

    private ArrayList<ItemMenu> itemMenuList;

    // constructor 
    public ItemMenuDAO() {
        itemMenuList = RestaurantDB.getInstance().getItemMenuList();
    }

    @Override
    public ArrayList<ItemMenu> getAll() {

        return itemMenuList;
    }

    @Override
    public ItemMenu get(long id) {
        for (ItemMenu e : itemMenuList){
        if (e.getId()==id)
            return e ; 
        }
        return null; 
    }

    @Override
    public void add(ItemMenu item_Menu) {
        itemMenuList.add(item_Menu);
    }

    @Override
    public void update(long id, ItemMenu item_Menu) {
        itemMenuList.set(getIndex(id), item_Menu);

    }

    @Override
    public void delete(long id) {
        itemMenuList.remove(getIndex(id));

    }

    public int getIndex(long id) {
        return itemMenuList.indexOf(get(id));
    }
}
