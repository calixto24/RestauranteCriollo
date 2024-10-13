package utp.restaurant.cashier.controller;

import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.Month;
import utp.restaurant.cashier.view.CustomerRegisterModalView;
import utp.restaurant.dao.JuridicalCustomerDAO;
import utp.restaurant.dao.NaturalCustomerDAO;
import utp.restaurant.model.JuridicalCustomer;
import utp.restaurant.model.NaturalCustomer;
import utp.restaurant.utils.Validate;

public class CustomerRegisterModalController {

    private CustomerRegisterModalView view;
    private Validate vldt;
    private NaturalCustomerDAO naturalCustomerDao;
    private JuridicalCustomerDAO juridicalCustomerDAO;

    public CustomerRegisterModalController(CustomerRegisterModalView view) {

        this.view = view;
        vldt = new Validate();
        naturalCustomerDao = new NaturalCustomerDAO();
        juridicalCustomerDAO = new JuridicalCustomerDAO();

    }

    public void handleCustomerTypeClick() {

        CardLayout cl = (CardLayout) view.getjPtypeCustomer().getLayout();

        switch (view.getTypeDocument()) {

            case "Boleta":
                cl.show(view.getjPtypeCustomer(), "Boleta");
                break;
            case "Factura":
                cl.show(view.getjPtypeCustomer(), "Factura");
                break;

        }

    }

    public void handleRegisterClick() {

        if (view.getTypeDocument().equals("Boleta")) {

            //nombre
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
                    .equalsLength(8, "El DNI debe tener 8 digitos")
                    .equalsAttNatural("El dni ya existe", "dni");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFdni().requestFocus();
                return;
            }

            int dni = Integer.parseInt(dnitx);

            // fecha de nacimiento
            String date = view.getjTFBhirtday().getText();

            int[] datev = new int[3];

            vldt.setElement(date)
                    .isRequired("La fecha de nacimiento es requerido")
                    .isDate("formato de fecha invalida");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFBhirtday().requestFocus();
                return;
            }

            String[] datePart = date.split("/");

            datev[0] = Integer.parseInt(datePart[0]);
            datev[1] = Integer.parseInt(datePart[1]);
            datev[2] = Integer.parseInt(datePart[2]);

            // telefono
            String phone = view.getjTFTelephone().getText();

            if (!phone.isEmpty()) {

                vldt.setElement(phone)
                        .isInt("El telefono debe ser numerico")
                        .equalsLength(9, "El telefono debe tener 9 digitoss");
                if (!vldt.exec()) {
                    view.showMessage(vldt.getMessage());
                    view.getjTFTelephone().requestFocus();
                    return;
                }

            }

            int telefono = 0;

            if (!phone.trim().isEmpty()) {
                telefono = Integer.parseInt(phone);
            }

            // email
            String email = view.getjTFEmail().getText();

            if (!email.isEmpty()) {

                vldt.setElement(email)
                        .isEmail("Email invalido")
                        .equalsAttribute("El email ya existe", "email");

                if (!vldt.exec()) {

                    view.showMessage(vldt.getMessage());
                    view.getjTFEmail().requestFocus();
                    return;
                }

            }

            // direccion
            String address = view.getjTFAddress().getText();

            NaturalCustomer naturalCustomer = new NaturalCustomer(dni, name, apellidoP, apellidom, LocalDate.of(datev[2], datev[1], datev[0]), telefono, email, address);

            try {
                naturalCustomerDao.add(naturalCustomer);
                view.showMessage("Cliente agregado correctamente");
                view.dispose();

            } catch (Exception e) {
                view.showMessage("Error al agregar cliente");

            }

        } else if (view.getTypeDocument().equals("Factura")) {

            //VALIDACION DE RUC
            String rucstr = view.getjTFruc().getText();
            vldt.setElement(rucstr)
                    .isRequired("El RUC es obligatorio")
                    .isLong("El RUC debe ser numerico")
                    .equalsLength(11, "El RUC debe tener 11 digitos")
                    .equalsAttJuridical("El ruc ya exiiste", "ruc");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFruc().requestFocus();
                return;
            }

            long ruc = Long.parseLong(rucstr);

            //Razon Social
            String razonSocial = view.getjTFrazonSocial().getText();
            vldt.setElement(razonSocial)
                    .isRequired("La razon social es obligatorio")
                    .equalsAttJuridical("La razon social ya existe", "socialReason");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFrazonSocial().requestFocus();
                return;
            }

            //Tipo
            String type = view.getjTFtype().getText();

            //Actividad economica
            String activityEco = view.getjTFactivityEconomic().getText();

            //tipo de facturacion
            String typeBilling = view.getjTFtypeBilling().getText();

            //VALIDACION TELEFONO
            String phoneNumber = view.getjTFThelephoneJuridical().getText();
            
            if (!phoneNumber.isEmpty()) {

                vldt.setElement(phoneNumber)
                        .isInt("El telefono debe ser numerico")
                        .equalsLength(9, "El telefono debe tener 9 digitoss");
                if (!vldt.exec()) {
                    view.showMessage(vldt.getMessage());
                    view.getjTFThelephoneJuridical().requestFocus();
                    return;
                }

            }

            int telefono = 0;

            if (!phoneNumber.trim().isEmpty()) {
                telefono = Integer.parseInt(phoneNumber);
            }

            //VALIDACION CORREO
            String email = view.getjTFEmailJuridical().getText();
            
            if (!email.isEmpty()) {

                vldt.setElement(email)
                        .isEmail("Email invalido")
                        .equalsAttribute("El email ya existe", "email");

                if (!vldt.exec()) {

                    view.showMessage(vldt.getMessage());
                    view.getjTFEmailJuridical().requestFocus();
                    return;
                }

            }

            //VALIDACION DIRECCION
            String direction = view.getjTFAddressJuridical().getText();

            //creando objeto cliente juridico
            JuridicalCustomer newJuridicalCustomer = new JuridicalCustomer(ruc, razonSocial, type, activityEco, typeBilling, telefono, email, direction);

            try {
                juridicalCustomerDAO.add(newJuridicalCustomer);
                view.showMessage("Cliente agregado correctamente");
                view.dispose();

            } catch (Exception e) {
                view.showMessage("Error al agregar cliente");

            }

        }

    }

}