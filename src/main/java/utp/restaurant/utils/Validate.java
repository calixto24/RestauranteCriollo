package utp.restaurant.utils;

import utp.restaurant.dao.EmployeeDAO;
import utp.restaurant.dao.TableDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utp.restaurant.dao.CategoryDAO;
import utp.restaurant.dao.ItemMenuDAO;
import utp.restaurant.dao.RoleDAO;
import utp.restaurant.model.Employee;
import utp.restaurant.model.ItemMenu;
import utp.restaurant.model.Table;
import utp.restaurant.model.Role;
import utp.restaurant.dao.JuridicalCustomerDAO;
import utp.restaurant.dao.NaturalCustomerDAO;
import utp.restaurant.model.Category;
import utp.restaurant.model.JuridicalCustomer;
import utp.restaurant.model.NaturalCustomer;

public class Validate {

    //atributos
    private EmployeeDAO employeeDAO;
    private TableDAO tableDAO;
    private RoleDAO roleDAO;
    private CategoryDAO categoryDAO;
    private ItemMenuDAO itemMenuDAO;
    private NaturalCustomerDAO naturalCustomerDAO;
    private JuridicalCustomerDAO juridicalCustomerDAO;

    private String message;
    private boolean valid;
    private String el;

    public Validate() {
        message = "";
        valid = true;
        el = "";

        categoryDAO = new CategoryDAO();
        employeeDAO = new EmployeeDAO();
        tableDAO = new TableDAO();
        roleDAO = new RoleDAO();
        itemMenuDAO = new ItemMenuDAO();
        naturalCustomerDAO = new NaturalCustomerDAO();
        juridicalCustomerDAO = new JuridicalCustomerDAO();
    }

    public Validate greaterThan(int n, String msg) {
        if (!valid) {
            return this;
        }

        if (Integer.parseInt(el) <= n) {
            valid = false;
            message = msg;
        }

        return this;
    }
    
    public Validate greaterThanDouble(double n, String msg) {
        if (!valid) {
            return this;
        }

        if (Double.parseDouble(el) < n) {
            valid = false;
            message = msg;
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

    public Validate isDouble(String msg) {
        if (!valid) {
            return this;
        }

        try {
            Double.parseDouble(el);
        } catch (Exception e) {
            valid = false;
            message = msg;
        } finally {
            return this;
        }
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

    //para el nombre de la categoria
    public Validate equalsNameCategory(String msg, String attribute) {

        if (!valid) {
            return this;
        }

        for (Category category : categoryDAO.getAll()) {

            switch (attribute.toLowerCase()) {

                case "name":
                    if (el.equals(category.name())) {

                        valid = false;
                        message = msg;

                    }
                    break;

            }

        }

        return this;

    }

    public Validate equalsNameCategory(String msg, String attribute, long id) {

        if (!valid) {
            return this;
        }

        for (Category category : categoryDAO.getAll()) {

            switch (attribute.toLowerCase()) {

                case "name":
                    if (el.equals(category.name())) {

                        if (id != category.id()) {

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
                    if (Integer.parseInt(el) == table.getNumber_table() && id != table.getId()) {

                        valid = false;
                        message = msg;

                    }
                    break;

            }

        }

        return this;
    }

    //Para el cliente natural
    public Validate equalsAttNatural(String msg, String attribute) {
        if (!valid) {
            return this;
        }

        for (NaturalCustomer naturalCustomer : naturalCustomerDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(naturalCustomer.getEmail())) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "dni":
                    if (Integer.parseInt(el) == naturalCustomer.getDni()) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "phoneNumber":
                    if (Integer.parseInt(el) == naturalCustomer.getPhoneNumber()) {
                        valid = false;
                        message = msg;
                    }
                    break;
            }
        }

        return this;
    }

    public Validate equalsAttNatural(String msg, String attribute, long id) {
        if (!valid) {
            return this;
        }

        for (NaturalCustomer naturalCustomer : naturalCustomerDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(naturalCustomer.getEmail())) {
                        if (id != naturalCustomer.getId_naturalCustomer()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "dni":
                    if (Integer.parseInt(el) == naturalCustomer.getDni()) {
                        if (id != naturalCustomer.getId_naturalCustomer()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "phoneNumber":
                    if (Integer.parseInt(el) == naturalCustomer.getPhoneNumber()) {
                        if (id != naturalCustomer.getId_naturalCustomer()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
            }
        }

        return this;
    }

    //Para el cliente juridico
    public Validate equalsAttJuridical(String msg, String attribute) {
        if (!valid) {
            return this;
        }

        for (JuridicalCustomer juridicalCustomer : juridicalCustomerDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(juridicalCustomer.getEmail())) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "ruc":
                    if (Long.parseLong(el) == juridicalCustomer.getRuc()) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "phoneNumber":
                    if (Integer.parseInt(el) == juridicalCustomer.getPhoneNumber()) {
                        valid = false;
                        message = msg;
                    }
                    break;
                case "socialReason":
                    if (el.equals(juridicalCustomer.getSocialReason())) {
                        valid = false;
                        message = msg;
                    }
                    break;
            }
        }

        return this;
    }

    public Validate equalsAttJuridical(String msg, String attribute, long id) {
        if (!valid) {
            return this;
        }

        for (JuridicalCustomer juridicalCustomer : juridicalCustomerDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "email":
                    if (el.equals(juridicalCustomer.getEmail())) {
                        if (id != juridicalCustomer.getId_juridicalCustomer()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "ruc":
                    if (Long.parseLong(el) == juridicalCustomer.getRuc()) {
                        if (id != juridicalCustomer.getId_juridicalCustomer()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "phoneNumber":
                    if (Integer.parseInt(el) == juridicalCustomer.getPhoneNumber()) {
                        if (id != juridicalCustomer.getId_juridicalCustomer()) {

                            valid = false;
                            message = msg;

                        }
                    }
                    break;
                case "socialReason":
                    if (el.equals(juridicalCustomer.getSocialReason())) {
                        if (id != juridicalCustomer.getId_juridicalCustomer()) {

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
        return this;
    }

    public Validate equalsNameMenu(String msg, String attribute, long id) {
        if (!valid) {
            return this;
        }
        for (ItemMenu itemMenu : itemMenuDAO.getAll()) {
            switch (attribute.toLowerCase()) {
                case "name":
                    if (el.equals(itemMenu.getName())) {
                        if (id != itemMenu.getId()) {
                            valid = false;
                            message = msg;
                        }
                    }
                    break;
            }

        }
        return this;
    }

}
