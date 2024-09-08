
package controller;

import dao.EmployeeDao;
import view.LoginView;
import model.Employee;
import view.Register;

public class LoginController {
    
    //atributos
    private LoginView loginView;
    private EmployeeDao employeeDao;
    private Register registerView;

    public LoginController(LoginView loginView) {
        
        this.loginView = loginView;
        
        employeeDao = new EmployeeDao();
        registerView = new Register();
        
    }
    
    public void handleLoginClick() {
        
        String username = loginView.getjTFUsername().getText();
        String password = loginView.getjTFPassword().getText();
        
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
                
                loginView.showMessage("Incorrecto");
                
            }
            
        } else {
            
            loginView.showMessage("Incorrecto");
            
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
