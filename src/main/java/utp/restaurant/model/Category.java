
package utp.restaurant.model;

import java.util.Random;


public class Category {
   
    private long id;
    private String name;
    private String description;
    private String image;

    public Category(  String name, String description, String image) {
        this.id = System.currentTimeMillis()+new Random().nextInt( 1000);
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Category(){
        
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
