package controller;

import dao.EmployeeDao;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import view.Register;
import model.Employee;

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
        String pass = view.getjTFPass().getText();
        String role = (String) view.getjCBRole().getSelectedItem();
        String name = view.getjTFName().getText();
        String ap = view.getjTFAP().getText();
        String am = view.getjTFAM().getText();
        int dni = Integer.parseInt(view.getjTFDni().getText());
        int ruc = Integer.parseInt(view.getjTFRuc().getText());
        String email = view.getjTFEmail().getText();
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
