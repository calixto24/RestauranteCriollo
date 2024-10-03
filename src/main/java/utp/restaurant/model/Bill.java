package utp.restaurant.model;

import java.util.Random;

public class Bill extends Voucher implements PaymentApplicable {

    private long id_Bill;
    private Customer customer;
    private String paymentType;

    public Bill(Customer customer, String paymentType, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
        this.customer = customer;
        this.paymentType = paymentType;
    }

    @Override
    public void calculateIgv() {
        System.out.println("");
    }

    @Override
    public void calculateDiscount() {
        System.out.println("");
    }

    @Override
    public void calculateTotalPrice() {
        System.out.println("");
    }
    
    @Override
    public void paymentType() {
        
    }
    
    @Override
    public void calculateAdditionalPayments() {
        
    }

    public long getId_Bill() {
        return id_Bill;
    }

    public void setId_Bill(long id_Bill) {
        this.id_Bill = id_Bill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    

}
