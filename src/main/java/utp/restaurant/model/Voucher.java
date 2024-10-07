
package utp.restaurant.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public abstract class Voucher {
    
    protected long id_Voucher;
    protected LocalTime time;
    protected LocalDate date;
    protected double taxed;
    protected double totalPrice;
    protected double discount;
    protected double additionalPayments;
    protected double igv;
    protected String status;
    protected Order order;
    protected Employee cashier;

    public Voucher(Order order, Employee cashier) {
        this.id_Voucher = System.currentTimeMillis() + new Random().nextInt(1000);
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.status = "Pendiente";
        this.order = order;
        this.cashier = cashier;
    }
    
    //metodos abstractos
    public abstract void calculateIgv();
    public abstract void calculateDiscount(int desc);
    public abstract void calculateTotalPrice();

    //getters y setters
    public long getId_Voucher() {
        return id_Voucher;
    }

    public double getAdditionalPayments() {
        return additionalPayments;
    }

    public void setAdditionalPayments(double additionalPayments) {
        this.additionalPayments = additionalPayments;
    }
    
    public void setId_Voucher(long id_Voucher) {
        this.id_Voucher = id_Voucher;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTaxed() {
        return taxed;
    }

    public void setTaxed(double taxed) {
        this.taxed = taxed;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }
    
    
}
