package utp.restaurant.admin.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.ItemMenuRegisterView;
import utp.restaurant.dao.CategoryDAO;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.model.Category;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.utils.Validate;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.File;

public class ItemMenuController {

    // atributos
    private ItemMenuRegisterView itemMenuRegisterView;
    private ItemMenuDAO itemMenuDao;
    private ItemMenuRegisterView view;
    private String action;
    private Validate vldt;
    private CategoryDAO categoryDao;
    private long idPlato;
    private JFileChooser jFileChooser;
    private File selectedFile;

    public ItemMenuController(ItemMenuRegisterView view) {
        this.view = view;
        action = "add";
        idPlato = 0;

        jFileChooser = new JFileChooser();
        itemMenuDao = new ItemMenuDAO();
        vldt = new Validate();
        categoryDao = new CategoryDAO();

    }

    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Id", 
            "Nombre", 
            "Precio", 
            "Descripcion", 
            "Estado", 
            "Categoria", 
            "Imagen"

        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<ItemMenu> itemMenuList = itemMenuDao.getAll();

        for (ItemMenu e : itemMenuList) {
            
            //obtener y cargar la imagen
            ImageIcon image = new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + e.getImage()));
            
            //imagen escalada
            Image scaledImage = image.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            
            Object row[] = {
                e.getId(), 
                e.getName(), 
                e.getPrice(), 
                e.getDescription(), 
                e.getStatus(), 
                e.getCategory(), 
                new ImageIcon(scaledImage)
            };
            
            tableModel.addRow(row);

        }
        return tableModel;

    }

    public void handleRegisterClick() {
        //guardar datos ingresados
        // validacion Nombre del platos (ingresado y exisitente )
        String name = view.getjTFname().getText();
        vldt.setElement(name)
                .isRequired("El nombre del plato es obligatorio");

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
        vldt.setElement(priceCO)
                .isRequired("Debe ingresar un precio al platillo ")
                .isDouble("El precio del plato debe ser numerico");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFprice().requestFocus();
            return;
        }

        double price = Double.parseDouble(priceCO);

        // validar descripcion
        String description = view.getjTFdescription().getText();
        vldt.setElement(description)
                .isRequired("Debe ingresar la descripcion de la comida ");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFdescription().requestFocus();
            return;
        }

        Category category = (Category) view.getJcate().getSelectedItem();

        //imagen
        String image = view.getjTFimage().getText();
        vldt.setElement(image)
                .isRequired("Debe ingresar una imagen");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFimage().requestFocus();
            return;
        }

        //crear nuevo plato y agregar ala tabla
        ItemMenu itemMenu = new ItemMenu(name, price, description, status, category, image);

        if (action.equals("add")) {

            try {

                itemMenuDao.add(itemMenu);
                view.showMessage("Plato creado");

            } catch (Exception e) {

                view.showMessage("Plato no creado" + e.toString());

            }

        } else if (action.equals("edit")) {
            
            try {

                itemMenuDao.update(itemMenu);
                view.showMessage("Plato modificado");

            } catch (Exception e) {

                view.showMessage("Plato no modificado" + e.toString());

            }
            
        }

        handleCleanForm();
        view.renderTable();

    }

    public void renderCBCate() {
        ArrayList<Category> categoryList = categoryDao.getAll();
        
        view.getJcate().removeAllItems();
                
        for (Category x : categoryList) {
            view.getJcate().addItem(x);
        }
    }

    public void heandleExplorerClick() {

        int result = jFileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            //ruta de la imagen seleccionada
            selectedFile = jFileChooser.getSelectedFile();

            view.getjTFimage().setText(selectedFile.getName());

            try {

                //creacion de la imagen
                Image img = ImageIO.read(selectedFile);
                ImageIcon imageIcon = new ImageIcon(img);

                //establecer tamaño a la imagen
                int width = view.getjLBmostrar().getWidth();
                int height = view.getjLBmostrar().getHeight();

                Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

                view.getjLBmostrar().setIcon(new ImageIcon(scaledImage));

            } catch (Exception e) {

                view.showMessage("No se pudo agregar imagen");

            }
        }

    }

    public void handleCleanForm() {
        //limpiar

        view.getjTFname().setText("");
        view.getjTFprice().setText("");
        view.getjTFdescription().setText("");

        view.getjTFimage().setText("");
        view.getjLBmostrar().setIcon(new ImageIcon(""));

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
        idPlato = Long.parseLong(view.getjTItemMenuList().getModel().getValueAt(view.getRow(), 0).toString());
        action = "edit";

        //pintar
        view.getjTFname().setText(view.getjTItemMenuList().getValueAt(view.getRow(), 0).toString());
        view.getjTFprice().setText(view.getjTItemMenuList().getValueAt(view.getRow(), 1).toString());
        view.getjTFdescription().setText(view.getjTItemMenuList().getValueAt(view.getRow(), 2).toString());
        view.getJcate().setSelectedItem(view.getjTItemMenuList().getValueAt(view.getRow(), 4));
        view.getjTFimage().setText(itemMenuDao.get(idPlato).getImage());
        view.getjLBmostrar().setIcon(new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + itemMenuDao.get(idPlato).getImage())));

    }

}
