package utp.restaurant.dao;

import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Role;

public class RoleDAO implements DAO<Role> {
    private ArrayList<Role> roleList;

    //constructor vacio
    public RoleDAO() {
        roleList = RestaurantDB.getInstance().getRoleList();
    }
    
    @Override
    public ArrayList<Role> getAll() {
        return roleList;
    }

    @Override
    public Role get(long id) {
        for(Role e: roleList) {
            if (e.getId() == id) return e;
        }
        
        return null;
    }

    @Override
    public void add(Role role) {
        roleList.add(role);
    }

    @Override
    public void update(long id, Role role) {
        roleList.set(getIndex(id), role);
    }

    @Override
    public void delete(long id) {
       roleList.remove(getIndex(id));
    }

    public int getIndex(long id) {
        return roleList.indexOf(get(id));
    }
}
