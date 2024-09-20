package utp.restaurant.admin.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.ItemMenuRegisterView;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.utils.Validate;

public class ItemMenuController {

    // atributos
    private ItemMenuRegisterView itemMenuRegisterView;
    private ItemMenuDAO itemMenuDao;

    private Validate vld;

    public ItemMenuController(ItemMenuRegisterView itemMenuRegisterView) {
        this.itemMenuRegisterView = itemMenuRegisterView;
        itemMenuDao = new ItemMenuDAO();

    }

    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Id", "Nombre", "Precio", "Descripcion", "Estado", "Imagen"

        };
        
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<ItemMenu> itemMenuList = itemMenuDao.getAll();

        for (ItemMenu e : itemMenuList) {
            Object row[] = {
                e.getId(), e.getName(), e.getPrice(), e.getDescription(), e.getStatus(), e.getImage()
            };
            tableModel.addRow(row);

        }
        return tableModel;

    }

}
