package utp.restaurant.model;

import java.util.Random;

public class ItemMenu {

    // atributos 
    private long id;
    private String name;  // name 
    private double price; // precio 
    private String description; // descripcion
    private String status;
    private String image;
    private Category category; 

    public ItemMenu( String name, double price, String description, String status , Category category,String image ) {
        this.id = System.currentTimeMillis() + new Random().nextInt(1000); //ID AUTOMATICO
        this.image = image;
        this.name = name;
        this.price= price ; 
        this.description = description;
        this.status = status;
        this.category = category ; }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
