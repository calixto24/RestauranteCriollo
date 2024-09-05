package controller;

import dao.EmployeeDao;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import view.Register;
import model.Employee;

public class EmployeeController {
    private EmployeeDao employeeDao;
    private Register view;
    
    public EmployeeController (Register view) {
        employeeDao = new EmployeeDao();
        this.view = view;
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
        
        employeeDao.add(new Employee(user, pass, role, name, ap, am, dni, LocalDate.of(date[2], date[1], date[0]), ruc, email));
        
        JOptionPane.showConfirmDialog(null, "asd");
    }
}
