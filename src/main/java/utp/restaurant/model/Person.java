
package utp.restaurant.model;
import java.util.Random;

public abstract class Person {
    
    protected long id_person;
    protected int phoneNumber;
    protected String email;
    protected String address;

    public Person(int phoneNumber, String email, String address) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
    
    public Person() {
    }
    
    //metodo abstracto
    public abstract String fullData();
    
    //getters y setters
    public long getId_person() {
        return id_person;
    }
    
    public void setId_person(long id_person) {
        this.id_person = id_person;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addres) {
        this.address = addres;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
