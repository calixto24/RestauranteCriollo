package utp.restaurant.login.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import utp.restaurant.dao.EmployeeDAO;
import utp.restaurant.login.view.LoginView;
import utp.restaurant.model.Employee;
import utp.restaurant.utils.Validate;
import utp.restaurant.admin.view.PreviewAdminView;
import utp.restaurant.cashier.view.PreviewCashierView;
import utp.restaurant.chef.view.PreviewChefView;
import utp.restaurant.store.Store;
import utp.restaurant.waiter.view.PreviewWaiterView;

public class LoginController {

    //atributos
    private LoginView loginView;
    private EmployeeDAO employeeDao;
    private Store store;

    private Validate vldt;

    public LoginController(LoginView loginView) {

        this.loginView = loginView;

        employeeDao = new EmployeeDAO();
        vldt = new Validate();

        store = Store.getInstance();

    }

    public void handleLoginClick() {

        //Obtencion y validacion
        String username = loginView.getjTFUsername().getText();
        vldt.setElement(username)
                .isRequired("Este campo es requerido");

        if (!vldt.exec()) {

            loginView.showMessage(vldt.getMessage());
            loginView.getjTFUsername().requestFocus();
            return;

        }

        String password = new String(loginView.getjTFPassword().getPassword());
        vldt.setElement(password)
                .isRequired("Este campo es requerido");

        if (!vldt.exec()) {

            loginView.showMessage(vldt.getMessage());
            loginView.getjTFPassword().requestFocus();
            return;

        }

        //obtiene el empleado de ser existente
        Employee user = verifyUsername(username);

        if (user != null) {

            boolean verifyPass = verifyPassword(password, user);

            if (verifyPass) {

                store.setEmploye(user);

                switch (user.getRole().getName()) {

                    case "administrador":

                        PreviewAdminView previewAdminView = new PreviewAdminView();
                        previewAdminView.setVisible(true);
                        loginView.dispose();

                        break;

                    case "mesero":

                        PreviewWaiterView previewWaiterView = new PreviewWaiterView();
                        previewWaiterView.setVisible(true);
                        loginView.dispose();

                        break;

                    case "cocinero":

                        PreviewChefView previewChefView = new PreviewChefView();
                        previewChefView.setVisible(true);
                        loginView.dispose();

                        break;

                    case "cajero":

                        PreviewCashierView previewCashierView = new PreviewCashierView();
                        previewCashierView.setVisible(true);
                        loginView.dispose();

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

        for (Employee employee : employeeDao.getAll()) {

            if (username.equals(employee.getUsername())) {

                return employee;

            }

        }

        return null;

    }

    public boolean verifyPassword(String password, Employee employee) {

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), employee.getPassword());
        return result.verified;

    }

}
