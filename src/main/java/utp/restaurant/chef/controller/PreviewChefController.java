
package utp.restaurant.chef.controller;

import utp.restaurant.chef.view.PreviewChefView;
import utp.restaurant.store.Store;

public class PreviewChefController {
    
    private PreviewChefView previewChefView;
    private Store store;

    public PreviewChefController(PreviewChefView previewChefView) {
        this.previewChefView = previewChefView;
        
        store = Store.getInstance();
    }
    
    //metodo para pintar el usuario
    public void getUser() {
        
        previewChefView.getjLBuser().setText(store.getEmploye().toString());
        
    }
    
}
