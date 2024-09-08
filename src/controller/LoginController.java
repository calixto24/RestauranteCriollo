
package controller;

import dao.EmployeeDao;
import view.LoginView;
import model.Employee;
import utils.Validate;
import view.Register;

public class LoginController {
    
    //atributos
    private LoginView loginView;
    private EmployeeDao employeeDao;
    private Register registerView;
    private Validate vldt;

    public LoginController(LoginView loginView) {
        
        this.loginView = loginView;
        
        employeeDao = new EmployeeDao();
        registerView = new Register();
        vldt = new Validate();
        
    }
    
    public void handleLoginClick() {
        
        //Obtencion y validacion
        String username = loginView.getjTFUsername().getText();
        vldt.setElement(username)
                .isRequired("Este campo es requerido");
        
        if(!vldt.exec()) {
            
            loginView.showMessage(vldt.getMessage());
            loginView.getjTFUsername().requestFocus();
            return;
            
        }
        
        String password = loginView.getjTFPassword().getText();
        vldt.setElement(password)
                .isRequired("Este campo es requerido");
        
        if(!vldt.exec()) {
            
            loginView.showMessage(vldt.getMessage());
            loginView.getjTFPassword().requestFocus();
            return;
            
        }
        
        //obtiene el empleado de ser existente
        Employee user = verifyUsername(username);
        
        if (user != null) {
            
            boolean verifyPass = verifyPassword(password, user);
            
            if(verifyPass) {
                
                loginView.showMessage("Correcto");
                
                switch(user.getRole()) {
                    
                    case "Administrador": 
                        
                        registerView.setVisible(true); 
                        loginView.setVisible(false);
                    
                    break;
                    
                    case "Mesero": 
                        
                        loginView.showMessage("Usted es mesero"); 
                    
                    break;
                    
                }
                
            } else {
                
                loginView.showMessage("Credenciales incorrectas");
                
            }
            
        } else {
            
            loginView.showMessage("Credenciales incorrectas");
            
        }
        
    }
    
    public Employee verifyUsername(String username) {
        
        for(Employee employee : employeeDao.getAll()) {
            
            if (username.equals(employee.getUsername())) {
                
                return employee;
                
            }
            
        }
        
        return null;
        
    }
    
    public boolean verifyPassword(String password, Employee employee) {
        
        return employee.getPassword().equals(password);
        
    }
    
}
