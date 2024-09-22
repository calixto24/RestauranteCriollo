
package utp.restaurant.admin.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.CustomerRegisterView;
import utp.restaurant.dao.CustomerDAO;
import utp.restaurant.model.Customer;
import utp.restaurant.utils.Validate;

public class CustomerController {
    
    //Atributos
    private CustomerDAO customerDAO;
    private CustomerRegisterView view;
    private String action;
    private Validate vldt;
    private long selectedId;
    
    //constructor vacio
    public CustomerController(CustomerRegisterView view) {
        this.view = view;
        action = "add";
        selectedId = 0;

        //instancia de los objetos a utilizar
        customerDAO = new CustomerDAO();
        vldt = new Validate();
    }
    
    public void handleRegisterClick() {
        String name = view.getjTFName().getText();
        vldt.setElement(name)
                .isRequired("El nombre es obligatorio");

        if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFName().requestFocus();
            return;

        }
        
        String ap = view.getjTFLast_Name_P().getText();
        vldt.setElement(ap)
                .isRequired("El apellido paterno es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFLast_Name_P().requestFocus();
            return;

        }

        //VALIDACION A. MATERNO
        String am = view.getjTFLast_Name_M().getText();
        vldt.setElement(am)
                .isRequired("El apellido materno es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFLast_Name_M().requestFocus();
            return;

        }
        
        //VALIDACION DNI
        String dnistr = view.getjTFDNI().getText();
        vldt.setElement(dnistr)
                .isRequired("El DNI es obligatorio")
                .isInt("El DNI debe ser numerico")
                .equalsLength(8, "El DNI debe tener 8 digitos");

        if (action.equals("add")) {
            vldt.equalsAttribute("El DNI ya existe", "dni");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El DNI ya existe", "dni", selectedId);
        }

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFDNI().requestFocus();
            return;
        }

        int dni = Integer.parseInt(dnistr);
    
    //VALIDACION F, NACIMIENTO
        String date = view.getjTFBhirtday().getText();

        vldt.setElement(date).isRequired("La fecha es obligatoria")
                .isDate("formato de fecha invalida");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFBhirtday().requestFocus();
            return;
        }

        int[] dateV = new int[3];

        String[] datePart = date.split("/");
        dateV[0] = Integer.parseInt(datePart[0]);
        dateV[1] = Integer.parseInt(datePart[1]);
        dateV[2] = Integer.parseInt(datePart[2]);
        
        //VALIDACION DE RUC
        String rucstr = view.getjTFRUC().getText();
        vldt.setElement(rucstr)
                .isRequired("El RUC es obligatorio")
                .isInt("El RUC debe ser numerico")
                .equalsLength(11, "El RUC debe tener 11 digitos");

        if (action.equals("add")) {
            vldt.equalsAttribute("El RUC ya existe", "ruc");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El RUC ya existe", "ruc", selectedId);
        }

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFRUC().requestFocus();
            return;
        }
        long ruc = Long.parseLong(rucstr);
        
        //VALIDACION TELEFONO
        String phoneNumber = view.getjTFTelephone().getText();
        vldt.setElement(phoneNumber)
                .isRequired("El telefono es obligatorio")
                .isInt("El telefono debe ser numero")
                .equalsLength(9, "El telefono debe tener 9 digitos");

        if (action.equals("add")) {
            vldt.equalsAttribute("El numero ya existe", "phoneNumber");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El numero ya existe", "phoneNumber", selectedId);
        }

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFTelephone().requestFocus();
            return;
        }

        int phonenumber = Integer.parseInt(phoneNumber);

        //VALIDACION CORREO
        String email = view.getjTFEmail().getText();

        vldt.setElement(email)
                .isRequired("El email es obligatorio")
                .isEmail("Email invalido");

        if (action.equals("add")) {
            vldt.equalsAttribute("El email ya existe", "email");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El email ya existe", "email", selectedId);
        }

        if (!vldt.exec()) {

            view.showMessage(vldt.getMessage());
            view.getjTFEmail().requestFocus();
            return;
        }
        
        //VALIDACION DIRECCION
        String direction = view.getjTFAddress().getText();

        vldt.setElement(direction)
                .isRequired("La direccion es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFAddress().requestFocus();
            return;
        }
    
    //---------------------------------------------- Crear el nuevo cliente
        Customer newCustomer = new Customer(ruc, name,
                ap, am, dni, LocalDate.of(dateV[2],
                        dateV[1], dateV[0]), phonenumber, email, direction);

        if (action.equals("add")) {

            try {
                customerDAO.add(newCustomer);
                view.showMessage("Cliente creado");

            } catch (Exception e) {

                view.showMessage("Cliente no creado" + e.toString());

            }
        } else if (action.equals("edit")) {

            try {
                customerDAO.update(selectedId, newCustomer);
                view.showMessage("Cliente actualizado");

            } catch (Exception e) {

                view.showMessage("Cliente no actualizado" + e.toString());

            }
        }
        handleCleanForm();
        view.renderTable();
    }
    
        public DefaultTableModel getCustomerModel() {
        String[] columns = {
            "customer_id",
            "person_id",
            "Nombre",
            "A. Paterno",
            "A. Materno",
            "DNI",
            "Fecha Nacimiento",
            "Telefono",
            "RUC",
            "Email",
            "Direccion"
        };
        DefaultTableModel customerModel = new DefaultTableModel(null, columns);

        ArrayList<Customer> customerList = customerDAO.getAll();

        for (Customer customer : customerList) {
            Object[] row = {
                customer.getId_customer(),
                customer.getName(),
                customer.getLastname_paternal(),
                customer.getLastname_maternal(),
                customer.getDni(),
                customer.getBirthdateFormatted(),
                customer.getPhoneNumber(),
                customer.getRuc(),
                customer.getEmail(),
                customer.getAddress()
            };

            customerModel.addRow(row);
        }
        return customerModel;
    }
        
        public void handleCleanForm() {

        view.getBtnDelete().setVisible(false);
        view.getBtnModificar().setVisible(false);

        view.getjTFRUC().setText("");
        view.getjTFLast_Name_M().setText("");
        view.getjTFLast_Name_P().setText("");
        view.getjTFBhirtday().setText("");
        view.getjTFDNI().setText("");
        view.getjTFEmail().setText("");
        view.getjTFName().setText("");
        view.getjTFTelephone().setText("");
        view.getjTFAddress().setText("");

        action = "add";
    }

    public void heandleViewEditClick() {
        selectedId = Long.parseLong(view.getjTList().getModel().getValueAt(view.getRow(), 0).toString());

        action = "edit";

        //pintando la columna con la informacion de la fila
        
        view.getjTFName().setText(view.getjTList().getValueAt(view.getRow(), 2).toString());
        view.getjTFLast_Name_P().setText(view.getjTList().getValueAt(view.getRow(), 3).toString());
        view.getjTFLast_Name_M().setText(view.getjTList().getValueAt(view.getRow(), 4).toString());
        view.getjTFDNI().setText(view.getjTList().getValueAt(view.getRow(), 5).toString());
        view.getjTFBhirtday().setText(view.getjTList().getValueAt(view.getRow(), 6).toString());
        view.getjTFTelephone().setText(view.getjTList().getValueAt(view.getRow(), 7).toString());
        view.getjTFRUC().setText(view.getjTList().getValueAt(view.getRow(), 0).toString());
        view.getjTFEmail().setText(view.getjTList().getValueAt(view.getRow(), 8).toString());
        view.getjTFAddress().setText(view.getjTList().getValueAt(view.getRow(), 9).toString());
        
        view.getBtnDelete().setVisible(true);
    }

    public void heandleDeleteClick() {

        selectedId = Long.parseLong(view.getjTList().getModel().getValueAt(view.getRow(), 0).toString());

        int op = view.showConfirmation("¿Desea eliminar este cliente?");

        if (op != 0) {

            return;

        }

        try {
            customerDAO.delete(selectedId);

            //renderizar los cambios en la tabla
            view.renderTable();
            view.showMessage("Cliente eliminado correctamente");
            handleCleanForm();

        } catch (Exception e) {
            view.showMessage("Error al eliminar al cliente" + e.toString());
        }

    }    
        
}
