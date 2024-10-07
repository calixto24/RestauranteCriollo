package utp.restaurant.model;

import java.util.Random;

public class Bill extends Voucher implements PaymentApplicable {

    private long id_Bill;
    private Customer customer;
    private String paymentType;

    public Bill(Customer customer, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
        this.customer = customer;
        this.paymentType = paymentType;
    }

    /** METODOS ABSTRACTOS**/
    
    @Override
    public void calculateIgv() {
        igv = (order.getTotal_Price() - discount) * 0.18;
    }

    @Override
    public void calculateDiscount(int desc) {
        discount = order.getTotal_Price() * (desc / 100.0);
    }

    @Override
    public void calculateTotalPrice() {
        totalPrice = (order.getTotal_Price() - discount) + igv + additionalPayments;
    }

    /** INTERFACE**/
    
    @Override
    public void paymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public void calculateAdditionalPayments() {
        if ("tarjeta".equalsIgnoreCase(paymentType)) {
            additionalPayments = order.getTotal_Price() * 0.05;
        } else {
            additionalPayments = 0;
        }
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

}
