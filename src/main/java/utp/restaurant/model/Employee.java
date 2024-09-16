
package utp.restaurant.model;

import java.time.LocalDate;

public class Employee extends Person {
    private String username; 
    private String password;
    private Role role;

    public Employee(String username, String password, Role role, String name, String lastname_paternal, String lastname_maternal,
            int dni, LocalDate birthdate, int phoneNumber, String email, String addres ) {
        
        super(name, lastname_paternal, lastname_maternal, dni, birthdate, phoneNumber, email, addres);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Employee() {
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
    
    @Override
    public String toString() {
        return name + " " + lastname_paternal;
    }
    
}
