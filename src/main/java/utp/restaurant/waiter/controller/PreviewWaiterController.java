/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utp.restaurant.waiter.controller;

import utp.restaurant.store.Store;
import utp.restaurant.waiter.view.PreviewWaiterView;

/**
 *
 * @author JHORDAN
 */
public class PreviewWaiterController {
    
    //atributos
    private PreviewWaiterView pwv;
    private Store store;

    //constructor
    public PreviewWaiterController(PreviewWaiterView pwv) {
        this.pwv = pwv;
        store = Store.getInstance();
    }
    
    public void getUser() {
        
        pwv.getjLBuser().setText(store.getEmploye().fullData());
        
    }
        
}
