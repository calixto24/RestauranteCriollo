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
    
    //constructor vacio
    public EmployeeController (Register view) {
        this.view = view;
        action = "add";
        
        //instancia de los objetos a utilizar
        employeeDao = new EmployeeDao();
    }
    
    public void handleRegisterClick() {
        
        if (action.equals("add")) {
            
            //addEmployee();
            
        } else {
            
            editEmployee();
            
        }
        
        
    }
    
    /*public void addEmployee() {
        
        //VALIDACION USUARIO
        String user = view.getjTFUser().getText();
        if( !Validate.isRequired(user)){
            view.showMessage("el campo usuario es requerido");
            view.getjTFUser().requestFocus();
            return ;
        }
        
        for(Employee employee : employeeDao.getAll()) {
            
            if ( employee.getUsername().equals(user) ) {
                
                view.showMessage("el usuario ya existe");
                view.getjTFUser().requestFocus();
                return ;
                
            }
            
        }
        
        //VALIDACION CONTRASEÑA
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
        
        //VALIDACION NOMBRE
        String name = view.getjTFName().getText();
        if( !Validate.isRequired(name)){
            view.showMessage(" el nombre es obligatorio");
            view.getjTFName().requestFocus();
            return;
        }
        
        //VALIDACION PATERNO
        String ap = view.getjTFAP().getText();
         if( !Validate.isRequired(ap)){
            view.showMessage(" el apellido paterno es obligatorio");
            view.getjTFAP().requestFocus();
            return;
        }

        //VALIDACION MATERNO
        String am = view.getjTFAM().getText();
         if( !Validate.isRequired(am)){
            view.showMessage(" el apellido materno es obligatorio");
            view.getjTFAM().requestFocus();
            return;
        }
        
        //VALIDACION DNI
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
        
        for(Employee employee : employeeDao.getAll()) {
            
            if (dni == employee.getDni()) {
                
                view.showMessage("el DNI ya existe");
                view.getjTFDni().requestFocus();
                return;
                
            }
            
        }
        
        //VALIDACION RUC
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
        
        for(Employee employee : employeeDao.getAll()) {
            
            if (ruc.equals(employee.getRuc())) {
                
                view.showMessage("el RUC ya existe");
                view.getjTFRuc().requestFocus();
                return;
                
            }
            
        }
        
        //VALIDACION EMAIL
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
        
        for(Employee employee : employeeDao.getAll()) {
            
            if (employee.getEmail().equals(email)) {
                
                view.showMessage("el email ya existe");
                view.getjTFEmail().requestFocus();
                return;
                
            }
            
        }
        
        //VALIDACION FECHA DE NACIMIENTO
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
        
        try {
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

            view.showMessage("Usuario creado");       
        } catch (Exception e) {
            view.showMessage("Usuario no creado" + e.toString());       
        }
        
    }*/
    
    public void editEmployee() {
        
        int dni = Integer.parseInt(view.getjTFDni().getText());
        
        Employee employeeUp = employeeDao.get(dni);
        
        //actualizando valores
        employeeUp.setName(view.getjTFName().toString());
        employeeUp.setLastname_paternal(view.getjTFAP().toString());
        employeeUp.setLastname_maternal(view.getjTFAM().toString());
        
        
        
    }
    
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
                employee.getBirthdate(),
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
    
    public void heandleViewEditClick(int row) {
        System.out.println(view.getjTUserList().getModel().getValueAt(row, 0));
        //pintando la columna con la informacion de la fila
        view.getjTFUser().setText(view.getjTUserList().getValueAt(row, 0).toString());
        view.getjTFPass().setText(view.getjTUserList().getValueAt(row, 1).toString());
        view.getjCBRole().setSelectedItem(view.getjTUserList().getValueAt(row,2).toString());
        view.getjTFName().setText(view.getjTUserList().getValueAt(row, 3).toString());
        view.getjTFAP().setText(view.getjTUserList().getValueAt(row, 4).toString());
        view.getjTFAM().setText(view.getjTUserList().getValueAt(row, 5).toString());
        view.getjTFDni().setText(view.getjTUserList().getValueAt(row, 6).toString());
        view.getjTFBirthdate().setText(view.getjTUserList().getValueAt(row, 7).toString());
        view.getjTFRuc().setText(view.getjTUserList().getValueAt(row, 8).toString());
        view.getjTFEmail().setText(view.getjTUserList().getValueAt(row, 9).toString());
    
        action = "edit";
        editEmployee();
        
    }
    
    
}
