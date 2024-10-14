package utp.restaurant.model;

import utp.restaurant.Interface.CardPayment;
import utp.restaurant.Interface.CashPayment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public abstract class Voucher<T, S> implements CardPayment, CashPayment {

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
    private String paymentType;
    protected double turned;
    protected double paymentReceived;

    protected final double IGV;

    public Voucher(Order order, Employee cashier) {
        this.id_Voucher = System.currentTimeMillis() + new Random().nextInt(1000);
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.status = "Pendiente";
        this.order = order;
        this.cashier = cashier;
        IGV = 0.18;
        discount = 0;
        
        calculateDiscount();
        calculateIgv();
        calcTaxed();
        calculateTotalPrice();
        
    }

    public Voucher() {
        IGV = 0.18;
    }

    //metodos abstractos
    public abstract S getCustomerData(T t) throws Exception;

    public abstract void generateTicket(S s) throws Exception;

    //
    public void calculateDiscount(NaturalCustomer nc) {

        if (nc.getBirthdate().getDayOfMonth() == LocalDate.now().getDayOfMonth() && nc.getBirthdate().getMonth() == LocalDate.now().getMonth()) {

            discount += order.getTotal_Price() * 0.03;

        }

    }

    public void calculateDiscount() {

        if (order.getTotal_Price() >= 300) {

            discount += order.getTotal_Price() * 0.05;

        }

    }

    public double calculateIgv() {
        igv = order.getTotal_Price() * IGV;

        return igv;
    }

    public double calcTaxed() {
        taxed = order.getTotal_Price() - igv;

        return taxed;
    }

    public double calculateTotalPrice() {

        totalPrice = (order.getTotal_Price() - discount) + additionalPayments;

        return totalPrice;
    }

    // Interfaces
    @Override
    public double calcAddPayment() {
        additionalPayments = order.getTotal_Price() * CARD_ADD_PORCENT;

        return additionalPayments;
    }

    @Override
    public double calcTurned(double paymentReceived) {
        this.paymentReceived = paymentReceived;
        turned = paymentReceived - totalPrice;

        return turned;
    }

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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getTurned() {
        return turned;
    }

    public void setTurned(double turned) {
        this.turned = turned;
    }
}
