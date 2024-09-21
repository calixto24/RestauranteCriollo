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
    private ItemMenuRegisterView view ; 
    private String action ; 
    private Validate vldt;
    
    public ItemMenuController(ItemMenuRegisterView view ){
        this.view=view ; 

    itemMenuDao = new ItemMenuDAO();
    vldt = new Validate();
    
    
    }

   // public ItemMenuController(ItemMenuRegisterView itemMenuRegisterView) {
     ///   this.itemMenuRegisterView = itemMenuRegisterView;
        ///itemMenuDao = new ItemMenuDAO();

    //}

    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Id","Imagen", "Nombre", "Precio", "Descripcion", "Estado"

        };
        
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<ItemMenu> itemMenuList = itemMenuDao.getAll();

        for (ItemMenu e : itemMenuList) {
            Object row[] = {
                e.getId(), e.getImage(), e.getName(), e.getPrice(), e.getDescription(), e.getStatus()
            };
            tableModel.addRow(row);

        }
        return tableModel;
        
    }
    
    public void handleRegisterClick(){
    //guardar datos ingresados
    String name = view.getjTFname().getText();
    vldt.setElement(name).isRequired("El nombre del plato es obligatorio");
    
            if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFname().requestFocus();
            return;

        }
    
    }
    
    
    public void handleCleanForm (){
    //limpiar
    
    view.getjTFname().setText("");
    view.getjTFprice().setText("");
    view.getjTFdescription().setText("");
    
    
    action ="add"; 

    
    }
    public void heandleDeleteClick (){
    //Eliminar
    
    }

}
