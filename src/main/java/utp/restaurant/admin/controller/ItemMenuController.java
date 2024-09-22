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
    private ItemMenuRegisterView view;
    private String action;
    private Validate vldt;
    private long idPlato; 

    public ItemMenuController(ItemMenuRegisterView view) {
        this.view = view;
        action="add";

        itemMenuDao = new ItemMenuDAO();
        vldt = new Validate();

    }

    // public ItemMenuController(ItemMenuRegisterView itemMenuRegisterView) {
    ///   this.itemMenuRegisterView = itemMenuRegisterView;
    ///itemMenuDao = new ItemMenuDAO();
    //}
    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Id", "Imagen", "Nombre", "Precio", "Descripcion", "Estado"

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

    public void handleRegisterClick() {
        //guardar datos ingresados
        // validacion Nombre del platos (ingresado y exisitente )
        String name = view.getjTFname().getText();
        vldt.setElement(name).isRequired("El nombre del plato es obligatorio");
        if (action.equals("add")) {
            vldt.equalsAttribute("El nombre del plato ya existe ", "name");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El nomre del plato ya existe", "name", 0);
        }

        if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFname().requestFocus();
            return;

        }
        String status = (String) view.getjCBstatus().getSelectedItem();
        
        //validacion precio 
        String priceCO = view.getjTFprice().getText();
        vldt.setElement(priceCO).isRequired("Debe ingresar un precio al platillo ")
                .isInt("El precio del plato debe ser numerico"); //.maxPriceLength(3, "El Precio no debe pasarse de 4 digitos");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFprice().requestFocus();
            return ; 
        }
        double price = Double.parseDouble(priceCO);
        // validar descripcion
        String description = view.getjTFdescription().getText();
        vldt.setElement(description).isRequired("Debe ingresar la descripcion de la comida ");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFdescription().requestFocus();
            return;
        }
        handleCleanForm();
        view.renderTable();
        //crear nuevo plato y agregar ala tabla
        ItemMenu itemMenu = new ItemMenu(name, name, price , description, status);
        
        if (action.equals("add")){
        try {
        itemMenuDao.add(itemMenu);
        view.showMessage("Plato creado");
        }catch(Exception e){
        view.showMessage("Plato no creado"+e.toString());
        }
        
        }
        view.renderTable();
        

    }

    public void handleCleanForm() {
        //limpiar

        view.getjTFname().setText("");
        view.getjTFprice().setText("");
        view.getjTFdescription().setText("");

        action = "add";

    }

    public void heandleDeleteClick() {
        //Eliminar
        
        
    }

}
