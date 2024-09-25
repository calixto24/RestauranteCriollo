
package utp.restaurant.store;

import utp.restaurant.model.Employee;

public class Store {
    
    private static Store instance;
    private Employee employe;

    private Store() {
        
        
    }

    public Employee getEmploye() {
        return employe;
    }

    public void setEmploye(Employee employe) {
        this.employe = employe;
    }

    //singleton
    public static Store getInstance() {
        
        if(instance == null) {
            
            instance = new Store();
            
        }
        
        return instance;
        
    }
    
}
