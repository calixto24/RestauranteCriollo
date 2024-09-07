package controller;

import dao.EmployeeDao;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import view.Register;
import model.Employee;
import utils.Validate;

public class EmployeeController {
    
    //atributos
    private EmployeeDao employeeDao;
    private Register view;
    private String action;
    private Validate vldt;
    
    //constructor vacio
    public EmployeeController (Register view) {
        this.view = view;
        action = "add";
        
        //instancia de los objetos a utilizar
        employeeDao = new EmployeeDao();
        vldt = new Validate();
    }
    
    public void handleRegisterClick() {
        
        if (action.equals("add")) {
            
            addEmployee();
            
        } else if (action.equals("edit")){
            
            editEmployee();
            
        }
        
        
    }
    
    public void addEmployee() {

        //VALIDACION NOMBRE
        String name = view.getjTFName().getText();

        if (!validateName(name, action)) {
            
            view.showMessage(vldt.getMessage());
            view.getjTFName().requestFocus();
            return;
            
        }
            
        //VALIDACION A. PATERNO
        String ap = view.getjTFAP().getText();
            
        if(!validateAP(ap, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFAP().requestFocus();
            return;
                
        }
            
        //VALIDACION A. MATERNO
        String am = view.getjTFAM().getText();
        
        if(!validateAM(am, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFAM().requestFocus();
            return;
                
        }
            
        //VALIDACION F, NACIMIENTO
        String date = view.getjTFBirthdate().getText();
            
        vldt.setElement(date).isRequired("La fecha es obligatoria")
            .isDate("formato de fecha invalida");
            
        if(!vldt.exec()){
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
        int dni = Integer.parseInt(dnistr);
        
        if(!validateDNI(dni, dnistr, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFDni().requestFocus();
            return;
                
        }
            
        //VALIDACION RUC
        String ruc = view.getjTFRuc().getText();
        if(!validateRUC(ruc, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFRuc().requestFocus();
            return;
                
        }
            
        //VALIDACION CORREO
        String email = view.getjTFEmail().getText();  
        if(!validateEmail(email, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFEmail().requestFocus();
            return;
                
        }
            
        //VALIDACION USERNAME
        String username = view.getjTFUser().getText();
        if(!validateUsername(username, action)) {
            view.showMessage(vldt.getMessage());
            view.getjTFUser().requestFocus();
            return;
        }
            
        //VALIDACION CONTRASEÑA
        String password = view.getjTFPass().getText();  
        if(!validatePassword(password, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFPass().requestFocus();
            return;
                
        }   
        
        //ROL
        String role = (String) view.getjCBRole().getSelectedItem();
            
        //---------------------------------------------- Crear el nuevo empleado
        Employee newEmployee = new Employee(username, password, role, name, ap, am, dni, LocalDate.of(dateV[2], dateV[1], dateV[0]), ruc, email);
        
        try {
            
            // Guardar el nuevo empleado en LA LISTA DE ARREGLOS (DAO)
            employeeDao.add(newEmployee);

            Object[] rowData = {
                newEmployee.getUsername(), 
                newEmployee.getPassword(),
                newEmployee.getRole(),
                newEmployee.getName(),
                newEmployee.getLastname_paternal(),
                newEmployee.getLastname_maternal(),
                newEmployee.getDni(),
                newEmployee.getBirthdate(),
                newEmployee.getRuc(),
                newEmployee.getEmail()
            };

            //renderizar los cambios en la tabla
            view.renderTable();

            view.showMessage("Usuario creado"); 
            handleCleanClick();
            
            
        } catch (Exception e) {
            
            view.showMessage("Usuario no creado" + e.toString()); 
            
        }
        
    }
    
    public void editEmployee() {
        
        //Obtengo el id unico de la fila
        long idEmployee = (long) view.getjTUserList().getModel().getValueAt(view.getRow(), 0);
        
        //envio el id unico al dao y traigo el objeto empleado con sus atributos
        Employee employeeUp = employeeDao.get(idEmployee);
        
        /* ------- VALIDACION DE EDICION (EMPLOYEE) --------*/
        
        //VALIDACION NOMBRE
        String name = view.getjTFName().getText();
        
        if(!validateName(name, action)) {
            
            view.showMessage(vldt.getMessage());
            view.getjTFName().requestFocus();
            return;
            
        }
        employeeUp.setName(name);
        
        //VALIDACION AP
        String ap = view.getjTFAP().getText();
        
        if(!validateAP(ap, action)) {
            
            view.showMessage(vldt.getMessage());
            view.getjTFAP().requestFocus();
            return;
            
        } 
        employeeUp.setLastname_paternal(ap);
        
        //VALIDACION AM
        String am = view.getjTFAM().getText();
        if(!validateAM(am, action)) {
            
            view.showMessage(vldt.getMessage());
            view.getjTFAM().requestFocus();
            return;
            
        }
        employeeUp.setLastname_maternal(am);

        //VALIDACION DNI
        String dnistr = view.getjTFDni().getText();
        int dni = Integer.parseInt(dnistr);
        
        if(!validateDNI(dni, dnistr, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFDni().requestFocus();
            return;
                
        }
        employeeUp.setDni(dni);
        
        //VALIDACION RUC
        String ruc = view.getjTFRuc().getText();
        if(!validateRUC(ruc, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFRuc().requestFocus();
            return;
                
        }
        employeeUp.setRuc(ruc);
        
        //VALIDACION EMAIL
        String email = view.getjTFEmail().getText();
        if(!validateEmail(email, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFEmail().requestFocus();
            return;
                
        }
        employeeUp.setEmail(email);
        
        //VALIDACION USERNAME
        String username = view.getjTFUser().getText();
        if(!validateUsername(username, action)) {
            view.showMessage(vldt.getMessage());
            view.getjTFUser().requestFocus();
            return;
        }
        employeeUp.setUsername(username);
            
        //VALIDACION CONTRASEÑA
        String password = view.getjTFPass().getText();  
        if(!validatePassword(password, action)) {
                
            view.showMessage(vldt.getMessage());
            view.getjTFPass().requestFocus();
            return;
                
        }
        employeeUp.setPassword(password);
        
        //ROL
        String role = (String) view.getjCBRole().getSelectedItem();
        employeeUp.setRole(role);
        
        try {
            
            employeeDao.update(idEmployee, employeeUp);

            //renderizar los cambios en la tabla
            view.renderTable();
            view.showMessage("Usuario modificado correctamente");
            handleCleanClick();
            
        } catch (Exception e) {
            
            view.showMessage("Error al modificar el usuario" + e.toString()); 
            
        }
        
    }
    
    //OPTIMIZACION DE VALIDACION 
    public boolean validateName(String name, String action) {
        
        if(action.equals("add") || action.equals("edit")) {
            
            vldt.setElement(name)
                    .isRequired("El nombre es obligatorio");
            
            return vldt.exec();
            
        } 
        
        return false;
        
    }
    
    public boolean validateAP(String ap, String accion) {
        
        if(action.equals("add") || action.equals("edit")) {
            
            vldt.setElement(ap)
                    .isRequired("El apellido paterno es obligatorio");
            
            return vldt.exec();
            
        }
        
        return false;
        
    }
    
    public boolean validateAM(String ap, String accion) {
        
        if(action.equals("add") || action.equals("edit")) {
            
            vldt.setElement(ap)
                    .isRequired("El apellido materno es obligatorio");
            
            return vldt.exec();
            
        }
        
        return false;
        
    }
    
    public boolean validateDNI(int dni, String dnistr, String accion) {
        
        if (action.equals("add")) {
            
            vldt.setElement(dnistr)
                    .isRequired("El DNI es obligatorio")
                    .isInt("El DNI debe ser numerico")
                    .equalsLength(8, "El DNI debe tener 8 digitos")
                    .equalsDNI("El DNI ya existe", dni);
            
            return vldt.exec();
            
        } else if (action.equals("edit")) {
            
            vldt.setElement(dnistr)
                    .isRequired("El DNI es obligatorio")
                    .isInt("El DNI debe ser numerico")
                    .equalsLength(8, "El DNI debe tener 8 digitos");
            
            return vldt.exec();
            
        }
        
        return false;
        
    }
    
    public boolean validateRUC(String ruc, String accion) {
        
        if (action.equals("add")) {
            
            vldt.setElement(ruc)
                    .isRequired("El RUC es obligatorio")
                    .equalsLength(11, "El RUC debe tener 11 digitos")
                    .equalsAttribute("El RUC ya existe", ruc, "ruc");
            
            return vldt.exec();
            
        } else if (action.equals("edit")) {
            
            vldt.setElement(ruc)
                    .isRequired("El RUC es obligatorio")
                    .equalsLength(11, "El RUC debe tener 11 digitos");
            
            return vldt.exec();
            
        }
        
        return false;
        
    }
    
    public boolean validateEmail(String email, String accion) {
        
        if (action.equals("add")) {
            
            vldt.setElement(email)
                    .isRequired("El email es obligatorio")
                    .isEmail("Email invalido")
                    .equalsAttribute("El email ya existe", email, "email");
            
            return vldt.exec();
            
        } else if (action.equals("edit")) {
            
            vldt.setElement(email)
                    .isRequired("El email es obligatorio")
                    .isEmail("Email invalido");
            
            return vldt.exec();
            
        }
        
        return false;
        
    }
    
    public boolean validateUsername(String username, String accion) {
        
        if (action.equals("add")) {
            
            vldt.setElement(username)
                    .isRequired("El usuario es obligatorio")
                    .equalsAttribute("El usuario ya existe", username, "username");
            
            return vldt.exec();
            
        } else if (action.equals("edit")) {
            
            vldt.setElement(username)
                    .isRequired("El usuario es obligatorio");
            
            return vldt.exec();
            
        }
        
        return false;
        
    }
    
    public boolean validatePassword(String password, String action) {
        
        if(action.equals("add") || action.equals("edit")) {
            
            vldt.setElement(password)
                    .isRequired("La contraseña es obligatoria")
                    .minLength(8, "La contraseña debe tener minimo 8 caracteres");
            
            return vldt.exec();
            
        } 
        
        return false;
        
    }
    
    //FIN OPTIMIZACION DE VALIDACION
    
    
    
    public DefaultTableModel getEmployeeModel() {
        String[] columns = {
            "Id",
            "Usuario", 
            "Contraseña", 
            "Rol", 
            "Nombre",
            "A. Paterno",
            "A. Materno",
            "DNI",
            "Fecha Nacimiento",
            "RUC",
            "Email"
        };
        DefaultTableModel employeeModel = new DefaultTableModel(null, columns);
        
        ArrayList<Employee> employeeList = employeeDao.getAll();
        
        for(Employee employee : employeeList) {   
            Object[] row = {
                employee.getId(),
                employee.getUsername(), 
                employee.getPassword(),
                employee.getRole(),
                employee.getName(),
                employee.getLastname_paternal(),
                employee.getLastname_maternal(),
                employee.getDni(),
                employee.getBirthdateFormatted(),
                employee.getRuc(),
                employee.getEmail()
            };
            
            employeeModel.addRow(row);
        }
        
        return employeeModel;
    }
    
    public void handleCleanClick() {
        
        view.getjTFUser().setText(" ");
        view.getjTFAM().setText(" ");
        view.getjTFAP().setText(" ");
        view.getjTFBirthdate().setText(" ");
        view.getjTFDni().setText(" ");
        view.getjTFEmail().setText(" ");
        view.getjTFName().setText(" ");
        view.getjTFPass().setText(" ");
        view.getjTFRuc().setText(" ");
        
    }
    
    public void heandleViewEditClick() {
        System.out.println(view.getjTUserList().getModel().getValueAt(view.getRow(), 0));
        
        //pintando la columna con la informacion de la fila
        view.getjTFUser().setText(view.getjTUserList().getValueAt(view.getRow(), 0).toString());
        view.getjTFPass().setText(view.getjTUserList().getValueAt(view.getRow(), 1).toString());
        view.getjCBRole().setSelectedItem(view.getjTUserList().getValueAt(view.getRow(),2).toString());
        view.getjTFName().setText(view.getjTUserList().getValueAt(view.getRow(), 3).toString());
        view.getjTFAP().setText(view.getjTUserList().getValueAt(view.getRow(), 4).toString());
        view.getjTFAM().setText(view.getjTUserList().getValueAt(view.getRow(), 5).toString());
        view.getjTFDni().setText(view.getjTUserList().getValueAt(view.getRow(), 6).toString());
        view.getjTFBirthdate().setText(view.getjTUserList().getValueAt(view.getRow(), 7).toString());
        view.getjTFRuc().setText(view.getjTUserList().getValueAt(view.getRow(), 8).toString());
        view.getjTFEmail().setText(view.getjTUserList().getValueAt(view.getRow(), 9).toString());
    
        action = "edit";
    }
    
    public void heandleDeleteClick() {
        
        long idEmployee = (long) view.getjTUserList().getModel().getValueAt(view.getRow(), 0);
        
        try {
            
            employeeDao.delete(idEmployee);

            //renderizar los cambios en la tabla
            view.renderTable();
            view.showMessage("Usuario eliminado correctamente");
            handleCleanClick();
            
        } catch (Exception e) {
            
            view.showMessage("Error al eliminar el usuario" + e.toString()); 
            
        }
        
    }
}
