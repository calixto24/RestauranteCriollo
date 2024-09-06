package controller;

import dao.EmployeeDao;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import view.Register;
import model.Employee;
import utils.Validate;

public class EmployeeController {
    
    //atributos
    private EmployeeDao employeeDao;
    private Register view;
    private DefaultTableModel defaultTableModel;
    
    //constructor vacio
    public EmployeeController (Register view) {
        this.view = view;
        
        //instancia de los objetos a utilizar
        employeeDao = new EmployeeDao();
        defaultTableModel = new DefaultTableModel();
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
        
        
        String rucstr = view.getjTFRuc().getText();
            if( !Validate.isRequired(rucstr)){
            view.showMessage("el RUC es obligatorio");
            view.getjTFRuc().requestFocus();
            return;
        }
        if( !Validate.isInt(rucstr)){
            view.showMessage("el RUC tiene que ser numerico");
            view.getjTFRuc().requestFocus();
            return;
        }
         if(!Validate.equalsLength(rucstr, 11)){
            view.showMessage("el RUC tiene que ser igual a 11 digitos");
            view.getjTFRuc().requestFocus();
            return;
        }
        int ruc = Integer.parseInt(rucstr);
        
        String email = view.getjTFEmail().getText();
        
        String datesta = view.getjTFBirthdate().getText();
        if ( !Validate.isRequired(datesta)){
            view.showMessage("la fecha es obligatorio");
            view.getjTFRuc().requestFocus();
            return;
        }
        int[] date = new int[3];
        
        String[] datePart = view.getjTFBirthdate().getText().split("/");
            date[0] = Integer.parseInt(datePart[0]);
            date[1] = Integer.parseInt(datePart[1]);
            date[2] = Integer.parseInt(datePart[2]);
            
            
            
        //employeeDao.add(new Employee(user, pass, role, name, ap, am, dni, LocalDate.of(date[2], date[1], date[0]), ruc, email));
        
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
        defaultTableModel.addRow(rowData);
        
        try {
            
            view.showMessage("Usuario creado");
            
        } catch (Exception e) {
            
            view.showMessage("Usuario no creado" + e.toString());
            
        }
        
    }
    
    public void tableUser() {
        
        //titulando encabezados
        defaultTableModel.addColumn("Usuario");
        defaultTableModel.addColumn("Contraseña");
        defaultTableModel.addColumn("Rol");
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("A. Paterno");
        defaultTableModel.addColumn("A. Materno");
        defaultTableModel.addColumn("DNI");
        defaultTableModel.addColumn("Fecha Nacimiento");
        defaultTableModel.addColumn("RUC");
        defaultTableModel.addColumn("Email");
        
        //pintando
        view.getjTUserList().setModel(defaultTableModel);
        
        //mostrar lista de arreglos (USUARIOS QUE YA EXISTEN)
        for(Employee employee : employeeDao.getAll()) {
        
            Object[] rowData = {
                employee.getUsername(), 
                employee.getPassword(),
                employee.getRole(),
                employee.getName(),
                employee.getLastname_paternal(),
                employee.getLastname_maternal(),
                employee.getDni(),
                employee.getBirthdate(),
                employee.getRuc(),
                employee.getEmail()
            };
            
            defaultTableModel.addRow(rowData);
        
        }
        
    }
}
