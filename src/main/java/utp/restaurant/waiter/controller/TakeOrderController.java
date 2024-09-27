package utp.restaurant.waiter.controller;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.dao.TableDAO;
import utp.restaurant.waiter.view.TakeOrderView;
import utp.restaurant.model.Table;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;
import utp.restaurant.store.Store;

public class TakeOrderController {

    //atributos
    private TakeOrderView takeOrderView;
    private TableDAO tableDAO;
    private Store store;
    private ItemMenuDAO itemMenuDAO;
    private Order order;

    private long selectedId;

    //constructor
    public TakeOrderController(TakeOrderView takeOrderView) {

        this.takeOrderView = takeOrderView;
        tableDAO = new TableDAO();
        itemMenuDAO = new ItemMenuDAO();

        order = new Order();
        store = Store.getInstance();

        order.setWaiter(store.getEmploye());

        selectedId = 0;
    }

    public void renderCBTable() {

        ArrayList<Table> tableList = tableDAO.getAll();

        takeOrderView.getjCBtable().removeAllItems();

        for (Table e : tableList) {

            if (store.getEmploye().getId_employee() == e.getEmployee().getId_employee() && e.getStatus().equals("Disponible")) {

                takeOrderView.getjCBtable().addItem(e);

            }

        }

    }

    /* ------------------------------------------------------------------------------------------ */
    public void setTable() {

        order.setTable((Table) takeOrderView.getjCBtable().getSelectedItem());

    }

    public void addItemOrder(ItemOrder itemOrder) {

        order.getItemOrderList().add(itemOrder);

    }

    public void updateItemOrder(ItemOrder itemOrder) {

        order.getItemOrderList().set(takeOrderView.getRowItemOrder(), itemOrder);

    }

    public ItemOrder getItemOrder() {

        return order.getItemOrderList().get(takeOrderView.getRowItemOrder());

    }
    
    /* ------------------------------------------------------------------------------------------ */
    
    public void handleSaveClick() {
        
        
        
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

        for (ItemMenu itemMenu : itemMenuList) {

            if (itemMenu.getStatus().equals("Disponible")) {

                //obtengo y cargo la imagen a traves de su direcciom
                ImageIcon img = new ImageIcon(getClass().getResource("/utp/restaurant/images/platillos/" + itemMenu.getImage()));

                //le agrego dimensiones
                Image scaledImage = img.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

                Object row[] = {
                    itemMenu.getId(),
                    itemMenu.getName(),
                    itemMenu.getPrice(),
                    itemMenu.getDescription(),
                    itemMenu.getCategory(),
                    new ImageIcon(scaledImage)

                };

                tableModel.addRow(row);

            }

        }

        return tableModel;

    }

    public DefaultTableModel getTableOrderModel() {
        String columns[] = {
            "Id",
            "Nombre",
            "Cantidad",
            "Total",
            "Descripcion"
        };

        DefaultTableModel defaulttablemodel = new DefaultTableModel(null, columns);
        ArrayList<ItemOrder> itemOrderList = order.getItemOrderList();

        for (ItemOrder e : itemOrderList) {
            Object row[] = {
                e.getId_itemOrder(),
                e.getItemMenu().getName(),
                e.getAmount(),
                e.getTotal(),
                e.getDescription()
            };

            defaulttablemodel.addRow(row);

        }

        return defaulttablemodel;

    }

    public void heandleDeleteClick() {

        int op = takeOrderView.showConfirmation("¿Desea eliminar la orden del platillo?");

        if (op != 0) {
            return;
        }

        try {

            order.getItemOrderList().remove(takeOrderView.getRowItemOrder());
            takeOrderView.showMessage("Orden de platillo eliminado");

            takeOrderView.renderItemOrderTable();

        } catch (Exception e) {

            takeOrderView.showMessage("Orden de platillo no eliminado");

        }

    }

    public void manageButtonVisibility() {

        boolean isEmpty = order.getItemOrderList().isEmpty();

        takeOrderView.getjBTNguardar().setVisible(!isEmpty);
        takeOrderView.getjBTNeditar().setVisible(!isEmpty);
        takeOrderView.getjBTNeliminar().setVisible(!isEmpty);

    }
}
