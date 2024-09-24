package utp.restaurant.waiter.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import utp.restaurant.dao.TableDAO;
import utp.restaurant.waiter.view.TakeOrderView;
import utp.restaurant.model.Table;

public class TakeOrderController {

    //atributos
    private TakeOrderView takeOrderView;
    private TableDAO tableDAO;

    //constructor
    public TakeOrderController(TakeOrderView takeOrderView) {

        this.takeOrderView = takeOrderView;

        tableDAO = new TableDAO();
    }

    public void renderCBTable() {

        ArrayList<Table> tableList = tableDAO.getAll();

        takeOrderView.getjCBtable().removeAllItems();

        for (Table e : tableList) {

            takeOrderView.getjCBtable().addItem(e);

        }

    }

}
