package utp.restaurant.admin.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.ItemMenuRegisterView;
import utp.restaurant.dao.CategoryDAO;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.model.Category;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.utils.Validate;

public class ItemMenuController {

    // atributos
    private ItemMenuRegisterView itemMenuRegisterView;
    private ItemMenuDAO itemMenuDao;
    private ItemMenuRegisterView view;
    private String action;
    private Validate vldt;
    private CategoryDAO categoryDao;
    private long idPlato;

    public ItemMenuController(ItemMenuRegisterView view) {
        this.view = view;
        action = "add";
        idPlato = 0;

        itemMenuDao = new ItemMenuDAO();
        vldt = new Validate();
        categoryDao = new CategoryDAO();

    }

    // public ItemMenuController(ItemMenuRegisterView itemMenuRegisterView) {
    ///   this.itemMenuRegisterView = itemMenuRegisterView;
    ///itemMenuDao = new ItemMenuDAO();
    //}
    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Id", "Nombre", "Precio", "Descripcion", "Estado", "Categoria", "Imagen"

        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<ItemMenu> itemMenuList = itemMenuDao.getAll();

        for (ItemMenu e : itemMenuList) {
            Object row[] = {
                e.getId(), e.getName(), e.getPrice(), e.getDescription(), e.getStatus(), e.getCategory(), e.getImage()
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
            vldt.equalsAttribute("El nomre del plato ya existe", "name", idPlato);
        }

        if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFname().requestFocus();
            return;

        }
        String status = (String) view.getjCBstatus1().getSelectedItem();

        //validacion precio 
        String priceCO = view.getjTFprice().getText();
        vldt.setElement(priceCO).isRequired("Debe ingresar un precio al platillo ")
                .isInt("El precio del plato debe ser numerico"); //.maxPriceLength(3, "El Precio no debe pasarse de 4 digitos");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFprice().requestFocus();
            return;
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

        Category category = (Category) view.getJcate().getSelectedItem();
        //crear nuevo plato y agregar ala tabla
        ItemMenu itemMenu = new ItemMenu(name, price, description, status, category, "");

        if (action.equals("add")) {
            try {
                itemMenuDao.add(itemMenu);
                view.showMessage("Plato creado");
            } catch (Exception e) {
                view.showMessage("Plato no creado" + e.toString());
            }

        }
        handleCleanForm();

        view.renderTable();

    }
    public void renderCBCate() {
        ArrayList<Category> categoryList = categoryDao.getAll();

        for (Category x : categoryList) {
            view.getJcate().addItem(x);
        }
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
        idPlato = Long.parseLong(view.getjTItemMenuList().getModel().getValueAt(view.getRow(), 0).toString());
        int op = view.showConfirmation("¿Desea eliminar Platillo?");

        if (op != 0) {

            return;

        }

        try {
            itemMenuDao.delete(idPlato);

            //renderizar los cambios en la tabla
            view.renderTable();
            view.showMessage("Platillo eliminado correctamente");
            handleCleanForm();

        } catch (Exception e) {
            view.showMessage("Error al eliminar el Platillo" + e.toString());
        }

    }

    public void heandleViewEditClick() {
        idPlato=Long.parseLong(view.getjTItemMenuList().getModel().getValueAt(view.getRow(), 0).toString());
action="edit";
//pintar
view.getjTFname().setText(view.getjTItemMenuList().getValueAt(view.getRow(), 0).toString());
view.getjTFprice().setText(view.getjTItemMenuList().getValueAt(view.getRow(), 1).toString());
view.getjTFdescription().setText(view.getjTItemMenuList().getValueAt(view.getRow(), 2).toString());

    }

}
