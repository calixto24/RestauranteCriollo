
package model;

import java.util.Date;

public class Person {
    
    protected String name;
    protected String lastname_paternal;
    protected String lastname_maternal;
    protected int dni;
    protected Date birthdate;
    protected int ruc;
    protected String email;

    public Person(String name, String lastname_paternal, String lastname_maternal, int dni, Date birthdate, int ruc, String email) {
        this.name = name;
        this.lastname_paternal = lastname_paternal;
        this.lastname_maternal = lastname_maternal;
        this.dni = dni;
        this.birthdate = birthdate;
        this.ruc = ruc;
        this.email = email;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
