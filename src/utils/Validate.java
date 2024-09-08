package utils;

import dao.EmployeeDao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Employee;

public class Validate {

    //atributos
    private EmployeeDao employeeDao;
    private String message;
    private boolean valid;
    private String el;

    public Validate() {
        message = "";
        valid = true;
        el = "";

        employeeDao = new EmployeeDao();
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
        
        if(!valid) {
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

    //METODOS DE IGUALDAD
    public Validate equalsAttribute(String msg, String attribute) {
        if (!valid) {
            return this;
        }

        for (Employee employee : employeeDao.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(employee.getEmail())) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "ruc":
                    if (el.equals(employee.getRuc())) {
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
            }
        }

        return this;
    }
    
    public Validate equalsAttribute(String msg, String attribute, long id) {
        if (!valid) return this;
        
        for (Employee employee : employeeDao.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(employee.getEmail())) {
                        if(id != employee.getId()) {
                            
                            valid = false;
                            message = msg;
                            
                        }
                    }
                    break;
                case "ruc":
                    if (el.equals(employee.getRuc())) {
                        if(id != employee.getId()) {
                            
                            valid = false;
                            message = msg;
                            
                        }
                    }
                    break;
                case "username":
                    if (el.equals(employee.getUsername())) {
                        if(id != employee.getId()) {
                            
                            valid = false;
                            message = msg;
                            
                        }
                    }
                    break;
                case "dni":
                    if (Integer.parseInt(el) == employee.getDni()) {
                        if(id != employee.getId()) {
                            
                            valid = false;
                            message = msg;
                            
                        }
                    }
                    break;
            }
        }

        return this;
    }

    /*public Validate equalsDNI(String msg, long id) {
        if (!valid) {
            return this;
        }

        for (Employee employee : employeeDao.getAll()) {
            if (Integer.parseInt(el) == employee.getDni()) {
                if (id != employee.getId()) {
                    valid = false;
                    message = msg;
                }
            }
        }

        return this;
    }*/

    //////
    public String getMessage() {
        return message;
    }

    public boolean exec() {
        return valid;
    }
}
