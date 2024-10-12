package utp.restaurant.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NaturalPerson extends Person{

    protected long id_naturalPerson;
    protected int dni;
    protected String name;
    protected String lastname_paternal;
    protected String lastname_maternal;
    protected LocalDate birthdate;

    public NaturalPerson(int dni, String name, String lastname_paternal, String lastname_maternal, LocalDate birthdate, int phoneNumber, String email, String address) {
        super(phoneNumber, email, address);
        
        this.id_naturalPerson = System.currentTimeMillis() + new Random().nextInt(1000);
        this.dni = dni;
        this.name = name;
        this.lastname_paternal = lastname_paternal;
        this.lastname_maternal = lastname_maternal;
        this.birthdate = birthdate;
    }

    public NaturalPerson() {
    }

    public long getId_naturalPerson() {
        return id_naturalPerson;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getBirthdateFormatted() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return df.format(birthdate);
    }
    
    //metodo abstracto
    @Override
    public String fullData() {
        return name + "  " + lastname_paternal + "  " 
                + lastname_maternal;
    }
    
    @Override
    public String toString() {
        return fullData();
    }
    
}
