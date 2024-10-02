
package utp.restaurant.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public abstract class Person {
    
    protected long id_person;
    protected String name;
    protected String lastname_paternal;
    protected String lastname_maternal;
    protected int dni;
    protected LocalDate birthdate;
    protected int phoneNumber;
    protected String email;
    protected String address;

    public Person(String name, String lastname_paternal, String lastname_maternal, 
            int dni, LocalDate birthdate, int phoneNumber, String email, String address) {
        this.id_person = System.currentTimeMillis() + new Random().nextInt(1000);
        this.name = name;
        this.lastname_paternal = lastname_paternal;
        this.lastname_maternal = lastname_maternal;
        this.dni = dni;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public Person() {
    }
    
    public long getId_person() {
        return id_person;
    }
    
    public void setId_person(long id_person) {
        this.id_person = id_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname_paternal() {
        return lastname_paternal;
    }

    public void setLastname_paternal(String lastname_paternal) {
        this.lastname_paternal = lastname_paternal;
    }

    public String getLastname_maternal() {
        return lastname_maternal;
    }

    public void setLastname_maternal(String lastname_maternal) {
        this.lastname_maternal = lastname_maternal;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public String getBirthdateFormatted() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return df.format(birthdate);
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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
