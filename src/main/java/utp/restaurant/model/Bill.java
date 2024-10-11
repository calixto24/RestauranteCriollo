package utp.restaurant.model;

import java.util.Random;

public class Bill extends Voucher<Long, JuridicalCustomer> {
    private long id_Bill;
    private JuridicalPerson customer;

    public Bill(JuridicalPerson customer, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
        this.customer = customer;
    }

    public Bill() {
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
    }

    /** METODOS ABSTRACTOS**/
    @Override
    public void getInfo(Long ruc) {

    }
    
    @Override
    public void generatePdf(JuridicalCustomer jp) {
        
    }
    
    public long getId_Bill() {
        return id_Bill;
    }

    public void setId_Bill(long id_Bill) {
        this.id_Bill = id_Bill;
    }

    public JuridicalPerson getCustomer() {
        return customer;
    }

    public void setCustomer(JuridicalPerson customer) {
        this.customer = customer;
    }
}
