package utp.restaurant.admin.controller;

import java.util.ArrayList;
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

    public DefaultTableModel getTableModel() {
        String column[] = {
            "Nombre", " Descripcion", "imagen"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, column);
        ArrayList<Category> categoriaList = categoryDAO.getAll();

        for (Category y : categoriaList) {
            Object row[] = {
                y.getName(), y.getDescription(), y.getImage()
            };
            tableModel.addRow(row);
        }
        return tableModel;
    }

    public void handleResgisterClick() {
        
        
    String name = categoryView.getTxtName().getText();
    vld.setElement(name)
            .isRequired("El nombre es obligatorio");
    
        if (!vld.exec()){
            categoryView.showMessage(vld.getMessage());
            categoryView.getTxtName().requestFocus();
            return;  
        }
        
    String descrip = categoryView.getTxtDescrip().getText();
    vld.setElement(descrip)
            .isRequired("La descripcion es obligatorio");
    
      if (!vld.exec()){
            categoryView.showMessage(vld.getMessage());
            categoryView.getTxtName().requestFocus();
            return;  
        }
   
    }

}
