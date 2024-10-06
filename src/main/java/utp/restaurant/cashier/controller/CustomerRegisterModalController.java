/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utp.restaurant.cashier.controller;

import java.time.LocalDate;
import java.time.Month;
import utp.restaurant.cashier.view.CustomerRegisterModalView;
import utp.restaurant.dao.CustomerDAO;
import utp.restaurant.model.Customer;

/**
 *
 * @author PC
 */
public class CustomerRegisterModalController {

    private CustomerRegisterModalView view;
    private CustomerDAO customerDAO;

    public CustomerRegisterModalController(CustomerRegisterModalView view) {
        customerDAO = new CustomerDAO();
        this.view = view;
    }

    public void handleRegisterClick() {
        // nombre 
        String name = view.getjTFName().getText();
        // apellido materno 
        String apellidom = view.getjTFLastNameM().getText();
        // apellido paterino
        String apellidoP = view.getjTFLastNameP().getText();
        // dni 
        int dni = Integer.parseInt(view.getjTFdni().getText());
        // fecha de nacimiento
        String date = view.getjTFBhirtday().getText();
        int datev[] = new int[3];
        String[] datePart = date.split("/");
        datev[0] = Integer.parseInt(datePart[0]);
        datev[1] = Integer.parseInt(datePart[1]);
        datev[2] = Integer.parseInt(datePart[2]);
        // telefono
        int telefono = Integer.parseInt(view.getjTFTelephone().getText());
        // email
        String email = view.getjTFEmail().getText();
        // calle
        String address = view.getjTFAddress().getText();
        //ruc
        String ruc = view.getjTFruc().getText();

        Customer newCustomer = new Customer(name, name, email, dni, LocalDate.of(datev[2], datev[1], datev[0]), telefono, email, address, ruc);
        
        try {
            customerDAO.add(newCustomer);
            view.showmMessage("Cliente agregado corrrectamente");
            
        } catch (Exception e) {
            view.showmMessage("Error al agregar cliente");
        }
        
        
 

    }

}
