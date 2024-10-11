package utp.restaurant.model;

import java.util.Random;

public class Ticket extends Voucher<Integer, NaturalCustomer> {

    private long id_Ticket;
    private NaturalPerson naturalPerson;

    public Ticket(NaturalPerson naturalPerson, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Ticket = System.currentTimeMillis() + new Random().nextInt(1000);
        this.naturalPerson = naturalPerson;
    }

    public Ticket() {
        this.id_Ticket = System.currentTimeMillis() + new Random().nextInt(1000);
    }

    /** METODOS ABSTRACTOS**/
    @Override
    public void getInfo(Integer dni) {

    }
    
    @Override
    public void generatePdf(NaturalCustomer nc) {
        
    }
    
    public long getId_Ticket() {
        return id_Ticket;
    }

    public void setId_Ticket(long id_Ticket) {
        this.id_Ticket = id_Ticket;
    }

    public NaturalPerson getNaturalPerson() {
        return naturalPerson;
    }

    public void setNaturalPerson(NaturalPerson naturalPerson) {
        this.naturalPerson = naturalPerson;
    }
}
