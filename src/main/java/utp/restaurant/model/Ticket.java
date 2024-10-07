package utp.restaurant.model;

import java.util.Random;

public class Ticket extends Voucher implements PaymentApplicable {

    private long id_Ticket;
    private int dni;
    private String paymentType;

    public Ticket(int dni, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Ticket = System.currentTimeMillis() + new Random().nextInt(1000);
        this.dni = dni;
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

    public long getId_Ticket() {
        return id_Ticket;
    }

    public void setId_Ticket(long id_Ticket) {
        this.id_Ticket = id_Ticket;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPaymentType() {
        return paymentType;
    }

}
