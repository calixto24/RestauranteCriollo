package utp.restaurant.utils;

import utp.restaurant.dao.EmployeeDAO;
import utp.restaurant.dao.TableDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.dao.RoleDAO;
import utp.restaurant.model.Employee;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.Table;
import utp.restaurant.model.Role;

public class Validate {

    //atributos
    private EmployeeDAO employeeDAO;
    private TableDAO tableDAO;
    private RoleDAO roleDAO;
    private ItemMenuDAO itemMenuDAO;

    private String message;
    private boolean valid;
    private String el;

    public Validate() {
        message = "";
        valid = true;
        el = "";

        employeeDAO = new EmployeeDAO();
        tableDAO = new TableDAO();
        roleDAO = new RoleDAO();
        itemMenuDAO = new ItemMenuDAO();
    }
public Validate maxPriceLength(int max, String msg) {
    if (!valid) {
        return this;
    }

    try {
        double price = Double.parseDouble(el);
        String[] parts = el.split("\\.");       
        
        if (parts[0].length() > max) {
            valid = false;
            message = msg;
        }
        
    } catch (NumberFormatException e) {
        valid = false;
        message = "El precio debe ser un número válido";
    }

    return this;
}
    public Validate(String el) {
        message = "";
        valid = true;
        this.el = el;
    }

    public Validate setElement(String el) {
        this.el = el;
        valid = true;
        message = "";

        return this;
    }

    public Validate isRequired(String msg) {
        if (!valid) {
            return this;
        }

        if (el.equals("")) {
            valid = false;
            message = msg;
        }

        return this;
    }

    public Validate isInt(String msg) {
        if (!valid) {
            return this;
        }

        try {
            Integer.parseInt(el);
        } catch (Exception e) {
            valid = false;
            message = msg;
        } finally {
            return this;
        }
    }

    public Validate isLong(String msg) {

        if (!valid) {
            return this;
        }

        try {
            Long.parseLong(el);
        } catch (Exception e) {
            valid = false;
            message = msg;
        } finally {
            return this;
        }

    }

    public Validate minLength(int min, String msg) {
        if (!valid) {
            return this;
        }

        if (el.length() < min) {
            valid = false;
            message = msg;
        }

        return this;
    }

    public Validate maxLength(int max, String msg) {
        if (!valid) {
            return this;
        }

        if (el.length() > max) {
            valid = false;
            message = msg;
        }

        return this;
    }

    public Validate equalsLength(int equals, String msg) {
        if (!valid) {
            return this;
        }

        if (el.length() != equals) {
            valid = false;
            message = msg;
        }

        return this;
    }

    public Validate isEmail(String msg) {
        if (!valid) {
            return this;
        }

        String regex = "^[a-z0-9.-_]+@[a-z0-9.-]+\\.[a-z]{2,}$";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(el);

        if (!matcher.matches()) {
            valid = false;
            message = msg;
        }

        return this;
    }

    public Validate isDate(String msg) {
        if (!valid) {
            return this;
        }

        String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])/(0[1-9]|[1-9]|1[0-2])/[0-9]{4}$"; // 01/05/2004

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(el);

        if (!matcher.matches()) {
            valid = false;
            message = msg;
        }

        return this;
    }

    //METODOS DE IGUALDAD para empleado
    public Validate equalsAttribute(String msg, String attribute) {
        if (!valid) {
            return this;
        }

        for (Employee employee : employeeDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(employee.getEmail())) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "username":
                    if (el.equals(employee.getUsername())) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "dni":
                    if (Integer.parseInt(el) == employee.getDni()) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "phoneNumber":
                    if (Integer.parseInt(el) == employee.getPhoneNumber()) {
                        valid = false;
                        message = msg;
                    }
                    break;
            }
        }

        return this;
    }

    public Validate equalsAttribute(String msg, String attribute, long id) {
        if (!valid) {
            return this;
        }

        for (Employee employee : employeeDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(employee.getEmail())) {
                        if (id != employee.getId_employee()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "username":
                    if (el.equals(employee.getUsername())) {
                        if (id != employee.getId_employee()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "dni":
                    if (Integer.parseInt(el) == employee.getDni()) {
                        if (id != employee.getId_employee()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "phoneNumber":
                    if (Integer.parseInt(el) == employee.getPhoneNumber()) {
                        if (id != employee.getId_employee()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
            }
        }

        return this;
    }

    //para el nombre del rol
    public Validate equalsNameRol(String msg, String attribute) {

        if (!valid) {
            return this;
        }

        for (Role role : roleDAO.getAll()) {

            switch (attribute.toLowerCase()) {

                case "name":
                    if (el.equals(role.getName())) {

                        valid = false;
                        message = msg;

                    }
                    break;

            }

        }

        return this;

    }

    public Validate equalsNameRol(String msg, String attribute, long id) {

        if (!valid) {
            return this;
        }

        for (Role role : roleDAO.getAll()) {

            switch (attribute.toLowerCase()) {

                case "name":
                    if (el.equals(role.getName())) {

                        if (id != role.getId()) {

                            valid = false;
                            message = msg;

                        }

                    }
                    break;

            }

        }

        return this;

    }

    //para el numero de mesa
    public Validate equalsNtable(String msg, String attribute) {

        if (!valid) {
            return this;
        }

        for (Table table : tableDAO.getAll()) {

            switch (attribute.toLowerCase()) {

                case "ntable":
                    if (Integer.parseInt(el) == table.getNumber_table()) {

                        valid = false;
                        message = msg;

                    }
                    break;

            }

        }

        return this;

    }

    public Validate equalsNtable(String msg, String attribute, long id) {

        if (!valid) {
            return this;
        }

        for (Table table : tableDAO.getAll()) {

            switch (attribute.toLowerCase()) {

                case "ntable":
                    if (Integer.parseInt(el) == table.getNumber_table()) {

                        if (id != table.getId()) {

                            valid = false;
                            message = msg;

                        }

                    }
                    break;

            }

        }

        return this;
    }

    public String getMessage() {
        return message;
    }

    public boolean exec() {
        return valid;
    }

    
    
    
    
    
    // PARA EL Nombre de la comida y el id 
    public Validate equalsNameMenu(String msg, String attribute) {

        if (!valid) {
            return this;
        }
         
            for (ItemMenu itemMenu : itemMenuDAO.getAll()) {
                switch (attribute.toLowerCase()) {
                    case "name":
                        if (el.equals(itemMenu.getName())) {
                            valid = false;
                            message = msg;
                        }
                        break;
                }

            }
            return this ; 
        }

   public Validate equalsNameMenu(String msg , String attribute , long id ){
       if (!valid){
       return this ; 
       }
       for (ItemMenu itemMenu : itemMenuDAO.getAll()){
       switch(attribute.toLowerCase()){
           case "name":
               if (el.equals(itemMenu.getName())){
               if (id  != itemMenu.getId()){
               valid = false ; 
               message = msg ; 
               }
               }
               break; 
       }
       
       }
   return this ; 
   }
        
    }
