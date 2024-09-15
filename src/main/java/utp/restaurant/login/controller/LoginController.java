
package utp.restaurant.login.controller;

import utp.restaurant.dao.EmployeeDAO;
import utp.restaurant.login.view.LoginView;
import utp.restaurant.model.Employee;
import utp.restaurant.utils.Validate;
import utp.restaurant.admin.view.PreviewAdminView;

public class LoginController {
    
    //atributos
    private LoginView loginView;
    private EmployeeDAO employeeDao;
    
    private Validate vldt;
    private PreviewAdminView previewAdminView; //objeto 

    public LoginController(LoginView loginView) {
        
        this.loginView = loginView;
        
        employeeDao = new EmployeeDAO();
        previewAdminView = new PreviewAdminView();
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
        
        String password = new String(loginView.getjTFPassword().getPassword());
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
                
                switch(user.getRole()) {
                    
                    case "Administrador": 
                     previewAdminView.setVisible(true); 
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
