
package utp.restaurant.model;

import java.time.LocalDate;
import java.util.Random;

public class Customer extends Person {
    private long id_customer;
    private LocalDate register;
    protected long ruc;
    
    public Customer(String name, String lastname_paternal, String lastname_maternal,
            int dni, LocalDate birthdate, int phoneNumber, String email, String address) {
        super(name, lastname_paternal, lastname_maternal, dni, birthdate, phoneNumber, email, address);
                this.id_customer=System.currentTimeMillis() + new Random().nextInt(1000);;
                this.register=register;
    }
    public Customer(){
    }

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
    }

    public LocalDate getRegister() {
        return register;
    }

    public void setRegister(LocalDate register) {
        this.register = register;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }
    
}

