package utp.restaurant.dao;

import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Table;
import java.util.ArrayList;

public class TableDAO implements DAO <Table>{
    private ArrayList<Table> tableList;
    
    public TableDAO() {
        tableList = RestaurantDB.getInstance().getTableList();
       
    }
    
    @Override
    public ArrayList <Table> getAll () {  
        return tableList;
    }
    
    @Override
    public Table get(long id) {
        for (Table table: tableList) {
            if (id == table.getId()) {
                return table;
            }
        }
        
        return null;
    }
    
    @Override
    public void add (Table table) {
        tableList.add(table);
    }
    
    @Override 
    public void update (long id, Table table ) {
        int index = getIndex(id); 
        tableList.set(index, table);
    }
    
    @Override
    public void delete (long id){
        int index = getIndex(id);
        tableList.remove(index);
    }
    
    public int getIndex(long id) {
        Table table = get(id);
        return tableList.indexOf(table);
    }
}
