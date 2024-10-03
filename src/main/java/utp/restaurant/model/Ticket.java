
package utp.restaurant.model;

import java.util.Random;

public class Ticket extends Voucher implements PaymentApplicable{
    
    private long id_Ticket;
    private int dni;
    private String paymentType;

    public Ticket(int dni, String paymentType, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Ticket = System.currentTimeMillis() + new Random().nextInt(1000);
        this.dni = dni;
        this.paymentType = paymentType;
    }
    
    @Override
    public void calculateIgv() {
        System.out.println("");
    }
    
    @Override
    public void calculateDiscount(){
        System.out.println("");
    }
    
    @Override
    public void calculateTotalPrice(){
        System.out.println("");
    }
    
    @Override
    public void paymentType() {
        
    }
    
    @Override
    public void calculateAdditionalPayments() {
        
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

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    
}
