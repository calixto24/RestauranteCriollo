package utp.restaurant.waiter.controller;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.dao.TableDAO;
import utp.restaurant.waiter.view.TakeOrderView;
import utp.restaurant.model.Table;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.store.Store;

public class TakeOrderController {

    //atributos
    private TakeOrderView takeOrderView;
    private TableDAO tableDAO;
    private Store store;
    private ItemMenuDAO itemMenuDAO;

    //constructor
    public TakeOrderController(TakeOrderView takeOrderView) {

        this.takeOrderView = takeOrderView;
        tableDAO = new TableDAO();
        itemMenuDAO = new ItemMenuDAO();
        
        store = Store.getInstance();
    }

    public void renderCBTable() {

        ArrayList<Table> tableList = tableDAO.getAll();

        takeOrderView.getjCBtable().removeAllItems();

        for (Table e : tableList) {
            
            if (store.getEmploye().getId_employee() == e.getEmployee().getId_employee()) {
                
                takeOrderView.getjCBtable().addItem(e);
                
            }

        }

    }
    
    public DefaultTableModel getTableModel() {
        
        String columns[] = {
            "Id",
            "Nombre",
            "Precio",
            "Descripcion",
            "Categoria",
            "Imagen"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        
        ArrayList<ItemMenu> itemMenuList = itemMenuDAO.getAll();
        
        for(ItemMenu itemMenu : itemMenuList) {
            
            Object row[] = {
                
                itemMenu.getId(),
                itemMenu.getName(),
                itemMenu.getPrice(),
                itemMenu.getDescription(),
                itemMenu.getCategory(),
                new ImageIcon(getClass().getResource("/utp/restaurant/images/" + itemMenu.getImage()))
                
            };
            
            tableModel.addRow(row);
            
        }
        
        return tableModel;
        
    }
    
    

}
