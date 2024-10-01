package utp.restaurant.chef.controller;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.chef.view.SourcersView;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.model.ItemMenu;

public class SourcesController {

    private ItemMenuDAO itemMenuDAO;
    private SourcersView view;

    public SourcesController(SourcersView view) {
        this.view = view;

        itemMenuDAO = new ItemMenuDAO();
    }

    public DefaultTableModel defaultTableModel() {

        String colums[] = {
            "id",
            "Nombre",
            "Descripcion",
            "Estado",
            "Categoria",
            "Imagen"
        };

        DefaultTableModel tableModel = new DefaultTableModel(null, colums);
        ArrayList<ItemMenu> itemMenuList = itemMenuDAO.getAll();

        for (ItemMenu e : itemMenuList) {
            ImageIcon image = new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + e.getImage()));
            Image scaledImage = image.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

            Object row[] = {
                e.getId(),
                e.getName(),
                e.getDescription(),
                e.getStatus(),
                e.getCategory(),
               new ImageIcon(scaledImage)
            
            };

            tableModel.addRow(row);

        }
        return tableModel;

    }

}
