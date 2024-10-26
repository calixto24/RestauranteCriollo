package utp.restaurant.admin.controller;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.CategoryRegisterView;
import utp.restaurant.dao.CategoryDAO;
import utp.restaurant.model.Category;
import utp.restaurant.utils.Validate;

public class CategoryController {

    private CategoryRegisterView categoryView;
    private CategoryDAO categoryDAO;
    private long selectedId;
    private Validate vld;
    private String action;

    private JFileChooser jFileChooser;
    private File selectedFile;

    public CategoryController(CategoryRegisterView categoryView) {
        this.categoryView = categoryView;

        this.action = "add";
        selectedId = 0;

        categoryDAO = new CategoryDAO();
        vld = new Validate();
        jFileChooser = new JFileChooser();
    }

    public void handleResgisterClick() {

        //nombre
        String name = categoryView.getTxtName().getText().toUpperCase();
        vld.setElement(name)
                .isRequired("El nombre es obligatorio");

        if (action.equals("add")) {
            vld.equalsNameCategory("La categoria ya existe", "name");
        } else if (action.equals("edit")) {
            vld.equalsNameCategory("La categoria ya existe", "name", selectedId);
        }

        if (!vld.exec()) {
            categoryView.showMessage(vld.getMessage());
            categoryView.getTxtName().requestFocus();
            return;
        }

        //descripcion
        String descrip = categoryView.getTxtDescrip().getText();
        vld.setElement(descrip)
                .isRequired("La descripcion es obligatorio");

        if (!vld.exec()) {
            categoryView.showMessage(vld.getMessage());
            categoryView.getTxtDescrip().requestFocus();
            return;
        }

        if (action.equals("add")) {
            //creacion del objeto
            Category newCategory = new Category(name, descrip);
            try {
                categoryDAO.add(newCategory);
                categoryView.showMessage("categoria creada");
            } catch (Exception e) {
                categoryView.showMessage("la categoria no fue guardada");
            }

        } else if (action.equals("edit")) {
            Category updateCategory = categoryDAO.get(selectedId);
            updateCategory.setName(name);
            updateCategory.setDescription(descrip);
            
            try {
                categoryDAO.update(updateCategory);  
                categoryView.showMessage("categoria editada");

            } catch (Exception e) {
                categoryView.showMessage("categoria no modificada");
            }
        }
        handleCleanForm();
        categoryView.renderTable();
    }

    public DefaultTableModel getTableModel() {

        String column[] = {
            "id",
            "Nombre",
            "Descripcion"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, column);

        ArrayList<Category> categoriaList = categoryDAO.getAll();

        for (Category y : categoriaList) {

            Object[] row = {
                y.getId(),
                y.getName(),
                y.getDescription()
            };
            tableModel.addRow(row);
        }
        return tableModel;
    }

    public void handleCleanForm() {

        categoryView.getjBDelete().setVisible(false);
        categoryView.getTxtName().setText("");
        categoryView.getTxtDescrip().setText("");

        action = "add";
    }

    public void heandleViewEditClik() {
        selectedId = Long.parseLong(categoryView.getjTableC().getModel().
                getValueAt(categoryView.getRow(), 0).toString());

        String name = categoryView.getjTableC().getModel().getValueAt(categoryView.getRow(), 1).toString();
        String description = categoryView.getjTableC().getModel().getValueAt(categoryView.getRow(), 2).toString();

        categoryView.getTxtName().setText(name);
        categoryView.getTxtDescrip().setText(description);

        categoryView.getjBDelete().setVisible(true);

        action = "edit";

    }

    public void heandleDeleteClick() {

        int omes = categoryView.showConfirmation("¿Desea eliminar la categoría?");
        if (omes != 0) {
            return;
        }
        try {
            categoryDAO.delete(selectedId);
            categoryView.showMessage("categoria eliminado correctamente");
            handleCleanForm();
            categoryView.renderTable();

        } catch (Exception r) {
            categoryView.showMessage("la categoria no fue eliminado");
        }

    }
}
