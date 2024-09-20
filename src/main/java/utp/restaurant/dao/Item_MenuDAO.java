package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Item_Menu;

public class Item_MenuDAO
        implements DAO<Item_Menu> {

    private ArrayList<Item_Menu> Menulist;

    // constructor 
    public Item_MenuDAO() {
        Menulist = RestaurantDB.getInstance().getMenulist();
    }

    @Override
    public ArrayList<Item_Menu> getAll() {

        return Menulist;
    }

    @Override
    public Item_Menu get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Item_Menu item_Menu) {
        Menulist.add(item_Menu);
    }

    @Override
    public void update(long id, Item_Menu item_Menu) {
        Menulist.set(getIndex(id), item_Menu);

    }

    @Override
    public void delete(long id) {
        Menulist.remove(getIndex(id));

    }

    public int getIndex(long id) {
        return Menulist.indexOf(get(id));
    }
}
