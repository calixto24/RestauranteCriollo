
package utp.restaurant.admin.controller;
import utp.restaurant.admin.view.PreviewAdminView;
import utp.restaurant.store.Store;

public class PreviewAdminViewController {

    private PreviewAdminView previewAdminView;
    private Store store;

    public PreviewAdminViewController(PreviewAdminView previewAdminView) {
        this.previewAdminView = previewAdminView;
        
        store = Store.getInstance();
    }
    
    public void getUser() {
        
        previewAdminView.getjLBuser().setText(store.getEmploye().fullName());
        
    }
    
}
