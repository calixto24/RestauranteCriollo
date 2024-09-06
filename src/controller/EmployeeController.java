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
    
    //constructor vacio
    public EmployeeController (Register view) {
        this.view = view;
        
        //instancia de los objetos a utilizar
        employeeDao = new EmployeeDao();
    }
    
    public void handleRegisterClick() {
        String user = view.getjTFUser().getText();
        if( !Validate.isRequired(user)){
            view.showMessage("el campo usuario es requerido");
            view.getjTFUser().requestFocus();
            return ;
        }
        
        String pass = view.getjTFPass().getText();
        if( !Validate.isRequired(pass)){
            view.showMessage(" la contraseña es obligatoria");
            view.getjTFPass().requestFocus();
            return ;
        }
        if( !Validate.minLength(pass, 8)){
             view.showMessage(" la contraseña debe de tener 8 caracteres  como minimo ");
            view.getjTFPass().requestFocus();
            return ;
        }
        
        String role = (String) view.getjCBRole().getSelectedItem();
        
        String name = view.getjTFName().getText();
        if( !Validate.isRequired(name)){
            view.showMessage(" el nombre es obligatorio");
            view.getjTFName().requestFocus();
            return;
        }
        
        String ap = view.getjTFAP().getText();
         if( !Validate.isRequired(ap)){
            view.showMessage(" el apellido paterno es obligatorio");
            view.getjTFAP().requestFocus();
            return;
        }

        String am = view.getjTFAM().getText();
         if( !Validate.isRequired(am)){
            view.showMessage(" el apellido materno es obligatorio");
            view.getjTFAM().requestFocus();
            return;
        }
        
        String dnistr = view.getjTFDni().getText();
        if( !Validate.isRequired(dnistr)){
            view.showMessage("el DNI es obligatorio");
            view.getjTFDni().requestFocus();
            return;
        }
        if( !Validate.isInt(dnistr)){
            view.showMessage("el DNI tiene que ser numerico");
            view.getjTFDni().requestFocus();
            return;
        }
        if(!Validate.equalsLength(dnistr, 8)){
            view.showMessage("el DNI tiene que ser igual a 8 digitos");
            view.getjTFDni().requestFocus();
            return;
        }
        int dni = Integer.parseInt(dnistr);
        
        
        String ruc = view.getjTFRuc().getText();
        if( !Validate.isRequired(ruc)){
            view.showMessage("el RUC es obligatorio");
            view.getjTFRuc().requestFocus();
            return;
        }
        
        if(!Validate.equalsLength(ruc, 11)){
            view.showMessage("el RUC tiene que ser igual a 11 digitos");
            view.getjTFRuc().requestFocus();
            return;
        }
        
        
        String email = view.getjTFEmail().getText();
        if( !Validate.isRequired(email)){
            view.showMessage("el email es obligatorio");
            view.getjTFEmail().requestFocus();
            return;
        }
        if( !Validate.isEmail(email)){
            view.showMessage("el email no es valido");
            view.getjTFEmail().requestFocus();
            return;
        }
        
        String datestr = view.getjTFBirthdate().getText();
        
        if ( !Validate.isRequired(datestr)){
            view.showMessage("la fecha es obligatorio");
            view.getjTFBirthdate().requestFocus();
            return;
        }
        
        if( !Validate.isDate(datestr)){
            view.showMessage("la fecha no es valida");
            view.getjTFBirthdate().requestFocus();
            return;
        }
        int[] date = new int[3];
        
        String[] datePart = datestr.split("/");
            date[0] = Integer.parseInt(datePart[0]);
            date[1] = Integer.parseInt(datePart[1]);
            date[2] = Integer.parseInt(datePart[2]);

            
        // Crear el nuevo empleado
        Employee newEmployee = new Employee(user, pass, role, name, ap, am, dni, LocalDate.of(date[2], date[1], date[0]), ruc, email);

        // Guardar el nuevo empleado en LA LISTA DE ARREGLOS
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
    
        // Agregar fila al modelo de tabla
        view.renderTable();
        
        try {
            
            view.showMessage("Usuario creado");
            
        } catch (Exception e) {
            
            view.showMessage("Usuario no creado" + e.toString());
            
        }
        
    }
    
    public ArrayList<Employee> getEmployeeList() {
        return employeeDao.getAll();
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
}
