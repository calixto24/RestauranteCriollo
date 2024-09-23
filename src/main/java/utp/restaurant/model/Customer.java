package utp.restaurant.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Customer extends Person {

    private long id_customer;
    private LocalDate register;
    private String ruc;

    public Customer(String name, String lastname_paternal, String lastname_maternal,
            int dni, LocalDate birthdate, int phoneNumber, String email, String address, String ruc) {
        super(name, lastname_paternal, lastname_maternal, dni, birthdate, phoneNumber, email, address);
        
        this.id_customer = System.currentTimeMillis() + new Random().nextInt(1000);
        register = LocalDate.now();
        this.register = register;
        this.ruc = ruc;
    }

    public Customer() {
    }

    public long getId_customer() {
        return id_customer;
    }

    public LocalDate getRegister() {
        return register;
    }

    public String getRegisterFormatted() {
        DateTimeFormatter fr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fr.format(register);
    }

    public void setRegister(LocalDate register) {
        this.register = register;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

}
