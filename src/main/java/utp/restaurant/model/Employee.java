
package utp.restaurant.model;

import java.time.LocalDate;
import java.util.Random;

public class Employee extends NaturalPerson {
    private long id_employee;
    private String username; 
    private String password;
    private Role role;

    public Employee(String username, String password, Role role, int dni, String name, String lastname_paternal, String lastname_maternal, LocalDate birthdate, int phoneNumber, String email, String address) {
        super( dni, name, lastname_paternal, lastname_maternal, birthdate, phoneNumber, email, address);
        
        this.id_employee = System.currentTimeMillis() + new Random().nextInt(1000);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Employee() {
    }
    
    //getters y setters
    public long getId_employee() {
        return id_employee;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}
