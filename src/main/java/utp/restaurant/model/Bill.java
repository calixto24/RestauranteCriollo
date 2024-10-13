package utp.restaurant.model;

import java.util.Random;

public class Bill extends Voucher<Long, JuridicalCustomer> {
    private long id_Bill;
    private JuridicalCustomer customer;

    public Bill(JuridicalCustomer customer, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
        this.customer = customer;
    }

    public Bill() {
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
    }

    /** METODOS ABSTRACTOS**/
    @Override
    public JuridicalCustomer getCustomerData(Long ruc) throws Exception {
        return null;
    }
    
    @Override
    public void generateTicket(JuridicalCustomer jp) throws Exception {
        
    }
    
    public long getId_Bill() {
        return id_Bill;
    }

    public void setId_Bill(long id_Bill) {
        this.id_Bill = id_Bill;
    }

    public JuridicalCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(JuridicalCustomer customer) {
        this.customer = customer;
    }
}
