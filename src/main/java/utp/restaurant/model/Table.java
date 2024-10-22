
package utp.restaurant.model;
import java.util.Random;
public class Table {
    private long id;
    private int number_table;
    private int capacity; 
    private String status;
    private Employee employee;
    
    public Table(int number_table, int capacity, String status, Employee employee) {
        this.id = System.currentTimeMillis()+new Random().nextInt(1000);
        this.number_table = number_table; 
        this.capacity = capacity; 
        this.status = status;
        this.employee = employee;
    }
    
    public Table(){}

    public int getNumber_table() {
        return number_table;
    }

    public void setNumber_table(int number_table) {
        this.number_table = number_table;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Override
    public String toString() {
        return "Mesa N° " + number_table;
    }
    
}
