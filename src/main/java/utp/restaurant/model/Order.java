
package utp.restaurant.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    
    private long id_Order;
    //private int number;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private ArrayList<ItemOrder> itemOrderList;
    private double total_Price;
    private Employee waiter;
    private Table table;

    public Order( Employee waiter, Table table) {
        
        this.id_Order = System.currentTimeMillis() + new Random().nextInt(1000); 
        //this.number = number;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.status = "Pendiente";
        this.itemOrderList = new ArrayList<>();
        this.waiter = waiter;
        this.table = table;
        
        calcTotalPrice();
    }

    public Order() {
        
        this.id_Order = System.currentTimeMillis() + new Random().nextInt(1000); 
        //this.number = number;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.status = "Pendiente";
        this.itemOrderList = new ArrayList<>();
        
    }
    
    public void calcTotalPrice() {
        
        for(ItemOrder e : itemOrderList) {
            
            total_Price += e.getTotal();
            
        }
        
    }

    public long getId_Order() {
        return id_Order;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ItemOrder> getItemOrderList() {
        return itemOrderList;
    }

    public void setItemOrderList(ArrayList<ItemOrder> itemOrderList) {
        this.itemOrderList = itemOrderList;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    
}
