
package model;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    
    protected int id;
    protected String name;
    protected String lastname_paternal;
    protected String lastname_maternal;
    protected int dni;
    protected LocalDate birthdate;
    protected String ruc;
    protected String email;

    public Person(int id, String name, String lastname_paternal, String lastname_maternal, int dni, LocalDate birthdate, String ruc, String email) {
        this.id = id;
        this.name = name;
        this.lastname_paternal = lastname_paternal;
        this.lastname_maternal = lastname_maternal;
        this.dni = dni;
        this.birthdate = birthdate;
        this.ruc = ruc;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
