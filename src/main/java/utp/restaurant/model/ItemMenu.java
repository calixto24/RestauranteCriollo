
package utp.restaurant.model;

import java.util.Random;


public class ItemMenu {
    // atributos 
    private long id ; 
    private String name ;  // name 
    private double price ; // precio 
    private String description ; // descripcion
    private String status;
    private String image ; 
    
    
    

    public ItemMenu(String name, double price, String description , String status, String image ) {
        this.id = System.currentTimeMillis()+new Random().nextInt(1000); //ID AUTOMATICO
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image ; 
        this.status=status;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    
}
