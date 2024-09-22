package utp.restaurant.admin.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.CategoryView;
import utp.restaurant.dao.CategoryDAO;
import utp.restaurant.model.Category;
import utp.restaurant.utils.Validate;

public class CategoryController {

    private CategoryView categoryView;
    private CategoryDAO categoryDAO;
    private long selectedId;
    private Validate vld;
    private String action;

    public CategoryController(CategoryView categoryView) {
        this.categoryView = categoryView;
        this.action = "add";
        selectedId = 0;
        categoryDAO = new CategoryDAO();
        vld = new Validate();
    }

    public void handleResgisterClick() {

        //nombre
        String name = categoryView.getTxtName().getText();
        vld.setElement(name)
                .isRequired("El nombre es obligatorio");

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

        Category newCategory = new Category(name, descrip, "");
        if (action.equals("add")) {

            try {
                categoryDAO.add(newCategory);
                categoryView.showMessage("categoria creada");
            } catch (Exception e) {
                categoryView.showMessage("la categoria no fue guardada");
            }

        } else if (action.equals("edit")) {
            try {
                categoryDAO.update(selectedId, newCategory);
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
            "id","Nombre", " Descripcion", "imagen"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, column);
        ArrayList<Category> categoriaList = categoryDAO.getAll();

        for (Category y : categoriaList) {
            Object[] row = {
                y.getId(),
                y.getName(),
                y.getDescription(),
                y.getImage()
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
        int selectedRow = categoryView.getjTableC().getSelectedRow();
        if (selectedRow >= 0) {

            String name = categoryView.getjTableC().getModel().getValueAt(categoryView.getRow(), 1).toString();
            String description = categoryView.getjTableC().getModel().getValueAt(categoryView.getRow(), 2).toString();

            
            categoryView.getTxtName().setText(name);
            categoryView.getTxtDescrip().setText(description);
            selectedId = Long.parseLong(categoryView.getjTableC().getModel().
                    getValueAt(categoryView.getRow(), 0).toString());
         
            categoryView.getjBDelete().setVisible(true);
            
            action = "edit";
        }

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


