
package utp.restaurant.model;

import java.util.Random;

public class ItemOrder {
    
    private long id_itemOrder;
    private int amount;
    private double total;
    private String description;
    private ItemMenu itemMenu;

    public ItemOrder(int amount, String description, ItemMenu itemMenu) {
        this.id_itemOrder = System.currentTimeMillis() + new Random().nextInt(1000);
        this.amount = amount;
        this.description = description;
        this.itemMenu = itemMenu;
        
        calcTotal();
    }
    
    public void calcTotal() {
        
        this.total = amount * itemMenu.getPrice();
        
    }

    public long getId_itemOrder() {
        return id_itemOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }
    
}
