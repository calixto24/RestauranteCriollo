package utp.restaurant.waiter.controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import utp.restaurant.dao.CategoryDAO;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.dao.OrderDAO;
import utp.restaurant.dao.TableDAO;
import utp.restaurant.model.Category;
import utp.restaurant.waiter.view.TakeOrderView;
import utp.restaurant.model.Table;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.ItemOrder;
import utp.restaurant.model.Order;
import utp.restaurant.store.Store;
import utp.restaurant.waiter.view.OrderView;

public class TakeOrderController {

    //atributos
    private TakeOrderView takeOrderView;
    private TableDAO tableDAO;
    private ItemMenuDAO itemMenuDAO;
    private OrderDAO orderDAO;
    private CategoryDAO categoryDAO;
    
    private Store store;
    private Order order;

    private String action;

    //constructor
    public TakeOrderController(TakeOrderView takeOrderView) {

        this.takeOrderView = takeOrderView;
        tableDAO = new TableDAO();
        itemMenuDAO = new ItemMenuDAO();
        orderDAO = new OrderDAO();
        categoryDAO = new CategoryDAO();

        order = new Order();
        store = Store.getInstance();
        action = "add";
    }

    public void renderCBTable() {

        ArrayList<Table> tableList = tableDAO.getAll();

        takeOrderView.getjCBtable().removeAllItems();

        if (tableList.isEmpty()) {

            takeOrderView.getjCBtable().addItem(null);

        } else {

            if (action.equals("edit")) {

                takeOrderView.getjCBtable().addItem(order.getTable());

            }

            for (Table e : tableList) {
                if (store.getEmploye().getId_employee() == e.getEmployee().getId_employee() && e.getStatus().equals("Disponible")) {
                    takeOrderView.getjCBtable().addItem(e);
                } 
            }

        }

    }

    /* ------------------------------------------------------------------------------------------ */
    public void setTable() {

        Table selectedTable = (Table) takeOrderView.getjCBtable().getSelectedItem();

        if (selectedTable != null) {
            
            if(action.equals("add")) {
                
                order.setTable(selectedTable);
                
            } else {
                
                if(selectedTable.getNumber_table() != order.getTable().getNumber_table()) {
                    
                    order.getTable().setStatus("Disponible");
                    order.setTable(selectedTable);
                    
                }
                
            }
            
        }

    }

    public void addItemOrder(ItemOrder itemOrder) {

        order.getItemOrderList().add(itemOrder);
        order.calcTotalPrice();

    }

    public void updateItemOrder(ItemOrder itemOrder) {

        order.getItemOrderList().set(takeOrderView.getRowItemOrder(), itemOrder);
        order.calcTotalPrice();

    }

    public ItemOrder getItemOrder() {

        return order.getItemOrderList().get(takeOrderView.getRowItemOrder());

    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void handleSaveClick() {

        try {

            if (action.equals("edit")) {

                order.getTable().setStatus("Ocupado");
                tableDAO.update(order.getTable());
                
                //updater order
                orderDAO.update(order);
                takeOrderView.showMessage("Orden actualizada correctamente");

                OrderView orderView = new OrderView();
                orderView.setVisible(true);
                takeOrderView.dispose();

            } else {

                //cambiar estado de la mesa
                order.getTable().setStatus("Ocupado");
                tableDAO.update(order.getTable());

                Order newOrder = new Order(store.getEmploye(), order.getTable(), order.getItemOrderList());

                //añade a la lista de ordenes
                orderDAO.add(newOrder);
                takeOrderView.showMessage("Orden guardada correctamente");

            }

            //nuevo objeto para resetear filas
            order = new Order();

            //actualiza el estado dekComBox de las mesas
            takeOrderView.renderCBTable();
            takeOrderView.renderItemOrderTable();

        } catch (Exception e) {

            takeOrderView.showMessage("Orden no guardada");

        }

    }

    public DefaultTableModel getTableModel(String category) {

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
        
        if (!category.equals("Todos")) {
            itemMenuList = itemMenuList.stream()
                    .filter(itemMenu -> itemMenu.getCategory().name().equals(category))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

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
            "Precio Unitario",
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
                e.getItemMenu().getPrice(),
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
    
    public void manageButtonAdd() {
        
        if(takeOrderView.getjCBtable().getItemCount() != 0) {
            
            takeOrderView.getjBTNadd().setEnabled(true);
            
        }
        
    }

    public void getTotalPrice() {

        order.calcTotalPrice();
        takeOrderView.getjLBTotal().setText(order.getTotal_Price() + "");

    }

    public void setAction(String action) {
        this.action = action;

        takeOrderView.getjBTNguardar().setText("ACTUALIZAR");

    }
    
    public void renderCBCategory() {
        ArrayList<Category> categoryList = categoryDAO.getAll();
        
        
        takeOrderView.getCbCategory().removeAllItems();
        takeOrderView.getCbCategory().addItem(new Category(1, "Todos", ""));
        
        categoryList.stream()
                .forEach(category -> takeOrderView.getCbCategory().addItem(category));
    }
    
    public void handleCategoryChange() {
        Category category = (Category) takeOrderView.getCbCategory().getSelectedItem();
        
        takeOrderView.renderTable(category.name());
    }
}
