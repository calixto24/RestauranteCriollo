
package utp.restaurant.model;

import java.time.LocalDate;
import java.util.Random;

public class NaturalCustomer extends NaturalPerson {
    
    private long id_naturalCustomer;
    private LocalDate register;

    public NaturalCustomer(int dni, String name, String lastname_paternal, String lastname_maternal, LocalDate birthdate, int phoneNumber, String email, String address) {
        super(dni, name, lastname_paternal, lastname_maternal, birthdate, phoneNumber, email, address);
        
        this.id_naturalCustomer = System.currentTimeMillis() + new Random().nextInt(1000);
        this.register = LocalDate.now();
    }

    public NaturalCustomer() {
    }

    public long getId_naturalCustomer() {
        return id_naturalCustomer;
    }

    public LocalDate getRegister() {
        return register;
    }
    
}
