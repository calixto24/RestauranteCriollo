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
    private String action;

    public CustomerRegisterModalController(CustomerRegisterModalView view) {

        this.view = view;
        customerDAO = new CustomerDAO();
        vldt = new Validate();
        action = "add";

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

        // dni 
        String dnitx = view.getjTFdni().getText();
        vldt.setElement(dnitx)
                .isRequired("El DNI es obligatorio")
                .isInt("El DNI debe ser numerico")
                .equalsLength(8, "El DNI debe tener 8 digitos");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFdni().requestFocus();
            return;
        }

        int dni = Integer.parseInt(dnitx);

// fecha de nacimiento
        String date = view.getjTFBhirtday().getText();

        vldt.setElement(date).isRequired("La fecha es obligatoria")
                .isDate("formato de fecha invalida");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFBhirtday().requestFocus();
            return;
        }

        int datev[] = new int[3];
        String[] datePart = date.split("/");
        datev[0] = Integer.parseInt(datePart[0]);
        datev[1] = Integer.parseInt(datePart[1]);
        datev[2] = Integer.parseInt(datePart[2]);

        // telefono
        String phone = view.getjTFTelephone().getText();
        vldt.setElement(phone).isRequired("El telefono es obligatorio para resivir promociones").isInt("El telefono debe ser numerico").equalsLength(9, "El telefono debe tener 9 digitoss");
        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFTelephone().requestFocus();
            return;
        }
        int telefono = Integer.parseInt(phone);
        // email
        String email = view.getjTFEmail().getText();
        // calle
        String address = view.getjTFAddress().getText();
        vldt.setElement(address)
                .isRequired("La direccion es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFAddress().requestFocus();
            return;
        }
//ruc
        String ruc = view.getjTFruc().getText();
        vldt.setElement(ruc).isInt("El Ruc debe ser numerico").equalsLength(11," El ruc debe tener 11 digitos");
        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFruc().requestFocus();
            return;
        }

        Customer newCustomer = new Customer(name, name, email, dni, LocalDate.of(datev[2], datev[1], datev[0]), telefono, email, address, ruc);

        try {
            customerDAO.add(newCustomer);
            view.showMessage("Cliente agregado correctamente");

        } catch (Exception e) {
            view.showMessage("Error al agregar cliente");
        }

    }

}
