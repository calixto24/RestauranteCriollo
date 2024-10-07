package utp.restaurant.cashier.controller;

import java.time.LocalDate;
import java.time.Month;
import utp.restaurant.cashier.view.CustomerRegisterModalView;
import utp.restaurant.dao.CustomerDAO;
import utp.restaurant.model.Customer;
import utp.restaurant.utils.Validate;

public class CustomerRegisterModalController {

    private CustomerRegisterModalView view;
    private CustomerDAO customerDAO;
    private Validate vldt;

    public CustomerRegisterModalController(CustomerRegisterModalView view) {

        this.view = view;
        customerDAO = new CustomerDAO();
        vldt = new Validate();

    }

    public void handleRegisterClick() {

        // nombre 
        String name = view.getjTFName().getText();
        vldt.setElement(name).isRequired("El nombre del cliente es obligarotio");

        if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFName().requestFocus();
            return;
        }

        // apellido materno 
        String apellidom = view.getjTFLastNameM().getText();
        vldt.setElement(apellidom).isRequired("El apellido del cliente es obligatorio");
        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFLastNameM().requestFocus();
            return;
        }

        // apellido paterno
        String apellidoP = view.getjTFLastNameP().getText();
        vldt.setElement(apellidoP).isRequired("El apellido paterno es obligatorio");

        if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFLastNameP().requestFocus();
            return;
        }

        // fecha de nacimiento
        String date = view.getjTFBhirtday().getText();

        /*vldt.setElement(date)
                .isDate("formato de fecha invalida");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFBhirtday().requestFocus();
            return;
        }*/
        
        int datev[] = new int[3];
        String[] datePart = date.split("/");
        datev[0] = Integer.parseInt(datePart[0]);
        datev[1] = Integer.parseInt(datePart[1]);
        datev[2] = Integer.parseInt(datePart[2]);

        // telefono
        String phone = view.getjTFTelephone().getText();

        /*vldt.setElement(phone)
                .isInt("El telefono debe ser numerico")
                .equalsLength(9, "El telefono debe tener 9 digitoss");
        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFTelephone().requestFocus();
            return;
        }*/
        int telefono = 0;

        if (!phone.trim().isEmpty()) {
            telefono = Integer.parseInt(phone);
        }

        // email
        String email = view.getjTFEmail().getText();

        // direccion
        String address = view.getjTFAddress().getText();

        if (view.getTypeDocument().equals("Factura")) {

            //ruc
            String ruc = view.getjTFruc().getText();
            vldt.setElement(ruc)
                    .isLong("El Ruc debe ser numerico")
                    .equalsLength(11, " El ruc debe tener 11 digitos");
            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFruc().requestFocus();
                return;
            }

            Customer newCustomer = new Customer(name, apellidoP, apellidom, 0, LocalDate.of(datev[2], datev[1], datev[0]), telefono, email, address, ruc);
            try {
                customerDAO.add(newCustomer);
                view.showMessage("Cliente agregado correctamente");
                view.dispose();

            } catch (Exception e) {
                view.showMessage("Error al agregar cliente");
            }

        } else if (view.getTypeDocument().equals("Boleta")) {

            // dni 
            String dnitx = view.getjTFdni().getText();
            vldt.setElement(dnitx)
                .isInt("El DNI debe ser numerico")
                .equalsLength(8, "El DNI debe tener 8 digitos");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFdni().requestFocus();
                return;
            }

            int dni = 0;

            if (!phone.trim().isEmpty()) {
                dni = Integer.parseInt(dnitx);
            }

            Customer newCustomer = new Customer(name, apellidoP, apellidom, dni, LocalDate.of(datev[2], datev[1], datev[0]), telefono, email, address, null);

            try {
                customerDAO.add(newCustomer);
                view.showMessage("Cliente agregado correctamente");
                view.dispose();

            } catch (Exception e) {
                view.showMessage("Error al agregar cliente");
            }
        }

    }

}
