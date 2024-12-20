
package utp.restaurant.model;

import java.time.LocalDate;
import java.util.Random;

public class JuridicalCustomer extends JuridicalPerson{
    
    private long id_juridicalCustomer;
    private LocalDate register;

    public JuridicalCustomer(long ruc, String socialReason, String type, String economicActivity, String typeBilling, int phoneNumber, String email, String address) {
        super(ruc, socialReason, type, economicActivity, typeBilling, phoneNumber, email, address);
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

    public void setId_juridicalCustomer(long id_juridicalCustomer) {
        this.id_juridicalCustomer = id_juridicalCustomer;
    }

    public void setRegister(LocalDate register) {
        this.register = register;
    }
    
    
}
