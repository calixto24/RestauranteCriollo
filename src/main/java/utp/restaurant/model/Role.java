package utp.restaurant.model;

import java.util.Random;

public class Role {
    private long id;
    private String name;

    public Role(String name) {
        this.id = System.currentTimeMillis() + new Random().nextInt(1000);
        this.name = name;
    }
    
    public Role() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
