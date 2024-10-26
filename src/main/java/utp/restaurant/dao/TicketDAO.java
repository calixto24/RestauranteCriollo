
package utp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Ticket;

public class TicketDAO implements DAO<Ticket>{
    
    private Connection conn;
    private String query;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<Ticket> ticketList;

    public TicketDAO() {
        conn = RestaurantDB.getInstance().getConn();
    }

    @Override
    public ArrayList<Ticket> getAll() {
        return ticketList;
    }

    @Override
    public Ticket get(long id) {
        for (Ticket ticket : ticketList) {
            if (id == ticket.getId_Ticket()) {
                return ticket;
            }
        }

        return null;
    }

    @Override
    public void add(Ticket ticket) {
        ticketList.add(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        
    }

    @Override
    public void delete(long id) {
        
    }
    
}
