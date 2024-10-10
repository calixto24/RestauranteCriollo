/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utp.restaurant.cashier.controller;

import utp.restaurant.cashier.view.PreviewCashierView;
import utp.restaurant.store.Store;

/**
 *
 * @author JHORDAN
 */
public class PreviewCashierController {

    private PreviewCashierView previewCashierView;
    private Store store;

    public PreviewCashierController(PreviewCashierView previewCashierView) {
        this.previewCashierView = previewCashierView;

        store = Store.getInstance();
    }

    public void getUser() {

        previewCashierView.getjLBuser().setText(store.getEmploye().fullData());

    }

}
