
package utp.restaurant.model;

import java.time.LocalDate;
import java.util.Random;

public class JuridicalCustomer extends JuridicalPerson{
    
    private long id_juridicalCustomer;
    private LocalDate register;

    public JuridicalCustomer(long ruc, String socialReason, String type, String economicActivity, String typeBilling, int phoneNumber, String email, String address) {
        super(ruc, socialReason, type, economicActivity, typeBilling, phoneNumber, email, address);
        
        this.id_juridicalCustomer = System.currentTimeMillis() + new Random().nextInt(1000);
        this.register = LocalDate.now();
    }

    public JuridicalCustomer() {
    }

    public long getId_juridicalCustomer() {
        return id_juridicalCustomer;
    }

    public LocalDate getRegister() {
        return register;
    }
    
}
