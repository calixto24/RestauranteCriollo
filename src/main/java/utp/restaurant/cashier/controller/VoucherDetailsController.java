
package utp.restaurant.cashier.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.cashier.view.VoucherDetailsView;
import utp.restaurant.dao.BillDAO;
import utp.restaurant.dao.TicketDAO;
import utp.restaurant.model.Bill;
import utp.restaurant.model.Ticket;

public class VoucherDetailsController {
    
    private VoucherDetailsView voucherDetailsView;
    private BillDAO billDAO;
    private TicketDAO ticketDAO;

    public VoucherDetailsController(VoucherDetailsView voucherDetailsView) {
        this.voucherDetailsView = voucherDetailsView;
        billDAO = new BillDAO();
        ticketDAO = new TicketDAO();
    }
    
    public DefaultTableModel getTableModelBill () {
        
        String columns[] = {
            "ID",
            "Fecha",
            "Cliente",
            "Cajero",
            "Total"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        
        ArrayList<Bill> billList = billDAO.getAll();
        
        for(Bill b : billList) {
            
            Object row[] = {
                b.getId_Bill(),
                b.getDate(),
                b.getCustomer().fullData(),
                b.getCashier().fullData(),
                b.getTotalPrice()
            };
            
            tableModel.addRow(row);
            
        }
        
        return tableModel;
        
    }
    
    public DefaultTableModel getTableModelTicket () {
        
        String columns[] = {
            "ID",
            "Fecha",
            "Cliente",
            "Cajero",
            "Total"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        
        ArrayList<Ticket> ticketList = ticketDAO.getAll();
        
        for(Ticket t : ticketList) {
            
            Object row[] = {
                t.getId_Ticket(),
                t.getDate(),
                t.getNaturalPerson().fullData(),
                t.getCashier().fullData(),
                t.getTotalPrice()
            };
            
            tableModel.addRow(row);
            
        }
        
        return tableModel;
        
    }
    
}
