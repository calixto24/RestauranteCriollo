package utp.restaurant.admin.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import utp.restaurant.dao.EmployeeDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.Register;
import utp.restaurant.dao.RoleDAO;
import utp.restaurant.model.Employee;
import utp.restaurant.model.Role;
import utp.restaurant.utils.Validate;

public class EmployeeController {
    
    //atributos
    private EmployeeDAO employeeDAO;
    private RoleDAO roleDao;
    private Register view;
    private String action;
    private Validate vldt;
    private long selectedId;

    //constructor vacio
    public EmployeeController(Register view) {
        this.view = view;
        action = "add";
        selectedId = 0;

        //instancia de los objetos a utilizar
        employeeDAO = new EmployeeDAO();
        roleDao = new RoleDAO();
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

        String ap = view.getjTFAP().getText();
        vldt.setElement(ap)
                .isRequired("El apellido materno es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFAP().requestFocus();
            return;

        }

        //VALIDACION A. MATERNO
        String am = view.getjTFAM().getText();
        vldt.setElement(am)
                .isRequired("El apellido materno es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFAM().requestFocus();
            return;

        }

        //VALIDACION F, NACIMIENTO
        String date = view.getjTFBirthdate().getText();

        vldt.setElement(date).isRequired("La fecha es obligatoria")
                .isDate("formato de fecha invalida");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFBirthdate().requestFocus();
            return;
        }

        int[] dateV = new int[3];

        String[] datePart = date.split("/");
        dateV[0] = Integer.parseInt(datePart[0]);
        dateV[1] = Integer.parseInt(datePart[1]);
        dateV[2] = Integer.parseInt(datePart[2]);

        //VALIDACION DNI
        String dnistr = view.getjTFDni().getText();
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
            view.getjTFDni().requestFocus();
            return;
        }

        int dni = Integer.parseInt(dnistr);

        //VALIDACION TELEFONO
        String phoneNumber = view.getjTFphoneNumber().getText();
        vldt.setElement(phoneNumber)
                .isRequired("El telefono es obligatorio")
                .isInt("El telefono debe ser numero")
                .equalsLength(9, "El telefono debe tener 9 digitos");

        if (action.equals("add")) {
            vldt.equalsAttribute("El numero ya existe", "phoneNumber");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El numero ya existe tarao", "phoneNumber", selectedId);
        }

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFphoneNumber().requestFocus();
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
        String direction = view.getjTFaddress().getText();

        vldt.setElement(direction)
                .isRequired("La direccion es obligatorio");

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFaddress().requestFocus();
            return;
        }

        //VALIDACION USERNAME
        String username = view.getjTFUser().getText();

        vldt.setElement(username)
                .isRequired("El usuario es obligatorio");

        if (action.equals("add")) {
            vldt.equalsAttribute("El username ya existe", "username");
        } else if (action.equals("edit")) {
            vldt.equalsAttribute("El username ya existe", "username", selectedId);
        }

        if (!vldt.exec()) {
            view.showMessage(vldt.getMessage());
            view.getjTFUser().requestFocus();
            return;
        }

        //VALIDACION CONTRASEÑA
        String password;

        if (!action.equals("edit")) {

            password = view.getjTFPass().getText();

            vldt.setElement(password)
                    .isRequired("La contraseña es obligatoria")
                    .minLength(8, "La contraseña debe tener minimo 8 caracteres");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFPass().requestFocus();
                return;

            }

            password = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        } else {

            password = view.getjTUserList().getModel().getValueAt(view.getRow(), 2).toString();

        }

        //ROL
        Role role = (Role) view.getjCBRole().getSelectedItem();

        //---------------------------------------------- Crear el nuevo empleado
        Employee newEmployee = new Employee(username, password, role, name,
                ap, am, dni, LocalDate.of(dateV[2],
                        dateV[1], dateV[0]), phonenumber, email, direction);

        if (action.equals("add")) {

            try {
                employeeDAO.add(newEmployee);
                view.showMessage("Usuario creado");

            } catch (Exception e) {

                view.showMessage("Usuario no creado" + e.toString());

            }
        } else if (action.equals("edit")) {

            try {
                employeeDAO.update(selectedId, newEmployee);
                view.showMessage("Usuario actualizado");

            } catch (Exception e) {

                view.showMessage("Usuario no actualizado" + e.toString());

            }

        }

        handleCleanForm();
        view.renderTable();
    }

    public DefaultTableModel getEmployeeModel() {
        String[] columns = {
            "employee_id",
            "person_id",
            "Contraseña",
            "Usuario",
            "Rol",
            "Nombre",
            "A. Paterno",
            "A. Materno",
            "DNI",
            "Fecha Nacimiento",
            "Telefono",
            "Email",
            "Direccion"
        };
        DefaultTableModel employeeModel = new DefaultTableModel(null, columns);

        ArrayList<Employee> employeeList = employeeDAO.getAll();

        for (Employee employee : employeeList) {
            Object[] row = {
                employee.getId_employee(),
                employee.getId_person(),
                employee.getPassword(),
                employee.getUsername(),
                employee.getRole(),
                employee.getName(),
                employee.getLastname_paternal(),
                employee.getLastname_maternal(),
                employee.getDni(),
                employee.getBirthdateFormatted(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getAddress()
            };

            employeeModel.addRow(row);
        }

        return employeeModel;
    }

    public void renderCBRole() {
        
        ArrayList<Role> roleList = roleDao.getAll();
        
        view.getjCBRole().removeAllItems();
        
        for (Role r : roleList) {
            view.getjCBRole().addItem(r);
        }
    }

    public void handleCleanForm() {

        view.getjBDelete().setVisible(false);
        view.getBtnUpdatePassword().setVisible(false);

        view.getjTFUser().setText("");
        view.getjTFAM().setText("");
        view.getjTFAP().setText("");
        view.getjTFBirthdate().setText("");
        view.getjTFDni().setText("");
        view.getjTFEmail().setText("");
        view.getjTFName().setText("");
        view.getjTFPass().setText("");
        view.getjTFRuc().setText("");
        view.getjTFaddress().setText("");

        action = "add";
        view.getjTFPass().setEnabled(true);
    }

    public void heandleViewEditClick() {
        selectedId = Long.parseLong(view.getjTUserList().getModel().getValueAt(view.getRow(), 0).toString());

        action = "edit";

        //pintando la columna con la informacion de la fila
        view.getjTFUser().setText(view.getjTUserList().getValueAt(view.getRow(), 0).toString());
        view.getjCBRole().setSelectedItem((Role) view.getjTUserList().getValueAt(view.getRow(), 1));
        view.getjTFName().setText(view.getjTUserList().getValueAt(view.getRow(), 2).toString());
        view.getjTFAP().setText(view.getjTUserList().getValueAt(view.getRow(), 3).toString());
        view.getjTFAM().setText(view.getjTUserList().getValueAt(view.getRow(), 4).toString());
        view.getjTFDni().setText(view.getjTUserList().getValueAt(view.getRow(), 5).toString());
        view.getjTFBirthdate().setText(view.getjTUserList().getValueAt(view.getRow(), 6).toString());
        view.getjTFRuc().setText(view.getjTUserList().getValueAt(view.getRow(), 7).toString());
        view.getjTFEmail().setText(view.getjTUserList().getValueAt(view.getRow(), 8).toString());
        view.getjTFaddress().setText(view.getjTUserList().getValueAt(view.getRow(), 9).toString());

        view.getjBDelete().setVisible(true);
        view.getBtnUpdatePassword().setVisible(true);

        view.getjTFPass().setEnabled(false);
    }

    public void heandleDeleteClick() {

        selectedId = Long.parseLong(view.getjTUserList().getModel().getValueAt(view.getRow(), 0).toString());

        int op = view.showConfirmation("¿Desea eliminar este empleado?");

        if (op != 0) {

            return;

        }

        try {
            employeeDAO.delete(selectedId);

            //renderizar los cambios en la tabla
            view.renderTable();
            view.showMessage("Usuario eliminado correctamente");
            handleCleanForm();

        } catch (Exception e) {
            view.showMessage("Error al eliminar el usuario" + e.toString());
        }
        ///xd
        
        
        

    }
}
