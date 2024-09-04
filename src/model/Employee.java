
package model;

import java.time.LocalDate;
import java.util.Date;

public class Employee  extends Person{
    private String username; 
    private String password;
    private String role;

    public Employee(String username, String password, String role, String name, String lastname_paternal, String lastname_maternal, int dni, LocalDate birthdate, int ruc, String email) {
        super(name, lastname_paternal, lastname_maternal, dni, birthdate, ruc, email);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
