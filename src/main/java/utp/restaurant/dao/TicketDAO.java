
package utp.restaurant.dao;

import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.database.RestaurantDB;
import utp.restaurant.model.Ticket;

public class TicketDAO implements DAO<Ticket>{
    
    private ArrayList<Ticket> ticketList;

    public TicketDAO() {
        ticketList = RestaurantDB.getInstance().getTicketList();
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
    public void update(long id, Ticket ticket) {
        int index = getIndex(id);
        ticketList.set(index, ticket);
    }

    @Override
    public void delete(long id) {
        int index = getIndex(id);
        ticketList.remove(index);
    }

    public int getIndex(long id) {
        Ticket ticket = get(id);
        return ticketList.indexOf(ticket);
    }
    
}
