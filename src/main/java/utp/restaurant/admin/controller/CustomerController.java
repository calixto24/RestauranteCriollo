package utp.restaurant.admin.controller;

//author cristian
import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.CustomerRegisterView;
import utp.restaurant.dao.JuridicalCustomerDAO;
import utp.restaurant.dao.NaturalCustomerDAO;
import utp.restaurant.model.JuridicalCustomer;
import utp.restaurant.model.NaturalCustomer;
import utp.restaurant.utils.Validate;

public class CustomerController {

    //Atributos
    private NaturalCustomerDAO naturalCustomerDAO;
    private JuridicalCustomerDAO juridicalCustomerDAO;
    private CustomerRegisterView view;

    private String action;
    private String typeCustomer;
    private Validate vldt;
    private long naturalSelectedId;
    private long juridicalSelectedId;

    //constructor vacio
    public CustomerController(CustomerRegisterView view) {
        this.view = view;
        action = "add";
        typeCustomer = "NATURAL";
        naturalSelectedId = 0;
        juridicalSelectedId = 0;

        //instancia de los objetos a utilizar
        naturalCustomerDAO = new NaturalCustomerDAO();
        juridicalCustomerDAO = new JuridicalCustomerDAO();

        vldt = new Validate();
    }

    public void handleCustomerTypeClick() {

        CardLayout cl = (CardLayout) view.getjPCustomerType().getLayout();

        typeCustomer = view.getjCBcustomerType().getSelectedItem().toString();

        switch (typeCustomer) {

            case "NATURAL":
                typeCustomer = "NATURAL";
                cl.show(view.getjPCustomerType(), "naturalCustomer");
                view.renderTable();
                break;
            case "JURIDICO":
                typeCustomer = "JURIDICO";
                view.renderTable();
                cl.show(view.getjPCustomerType(), "juridicalCustomer");
                break;
        }

    }

    public DefaultTableModel getCustomerModel() {

        DefaultTableModel customerModel = null;

        if (typeCustomer.equals("NATURAL")) {

            String[] columns = {
                "naturalCustomer_id",
                "naturalPerson_id",
                "person_id",
                "Nombre",
                "A. Paterno",
                "A. Materno",
                "DNI",
                "Fecha Nacimiento",
                "Telefono",
                "Email",
                "Direccion"
            };

            customerModel = new DefaultTableModel(null, columns);
            ArrayList<NaturalCustomer> naturalCustomerList = naturalCustomerDAO.getAll();

            for (NaturalCustomer naturalCustomer : naturalCustomerList) {
                Object[] row = {
                    naturalCustomer.getId_naturalCustomer(),
                    naturalCustomer.getId_naturalPerson(),
                    naturalCustomer.getId_person(),
                    naturalCustomer.getName(),
                    naturalCustomer.getLastname_paternal(),
                    naturalCustomer.getLastname_maternal(),
                    naturalCustomer.getDni(),
                    naturalCustomer.getBirthdateFormatted(),
                    naturalCustomer.getPhoneNumber(),
                    naturalCustomer.getEmail(),
                    naturalCustomer.getAddress()
                };

                customerModel.addRow(row);
            }

        } else if (typeCustomer.equals("JURIDICO")) {

            String[] columns = {
                "juridicalCustomer_id",
                "juridicalPerson_id",
                "person_id",
                "Razon Social",
                "Ruc",
                "Tipo",
                "Actividad Economica",
                "Tipo Facturacion",
                "Telefono",
                "Email",
                "Direccion"
            };

            customerModel = new DefaultTableModel(null, columns);
            ArrayList<JuridicalCustomer> juridicalCustomerList = juridicalCustomerDAO.getAll();

            for (JuridicalCustomer juridicalCustomer : juridicalCustomerList) {
                Object[] row = {
                    juridicalCustomer.getId_juridicalCustomer(),
                    juridicalCustomer.getId_juridicalPerson(),
                    juridicalCustomer.getId_person(),
                    juridicalCustomer.getSocialReason(),
                    juridicalCustomer.getRuc(),
                    juridicalCustomer.getType(),
                    juridicalCustomer.getEconomicActivity(),
                    juridicalCustomer.getTypeBilling(),
                    juridicalCustomer.getPhoneNumber(),
                    juridicalCustomer.getEmail(),
                    juridicalCustomer.getAddress()
                };

                customerModel.addRow(row);
            }

        }

        return customerModel;

    }

    public void handleRegisterClick() {

        NaturalCustomer newNaturalCustomer = null;
        JuridicalCustomer newJuridicalCustomer = null;

        if (typeCustomer.equals("NATURAL")) {

            //VALIDACION NOMBRE
            String name = view.getjTFName().getText();
            vldt.setElement(name)
                    .isRequired("El nombre es obligatorio");

            if (!vldt.exec()) {

                view.showMessage(vldt.getMessage());
                view.getjTFName().requestFocus();
                return;

            }

            //VALIDACION A. PATERNO
            String ap = view.getjTFLastNameP().getText();
            vldt.setElement(ap)
                    .isRequired("El apellido paterno es obligatorio");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFLastNameP().requestFocus();
                return;

            }
            //VALIDACION A. MATERNO
            String am = view.getjTFLastNameM().getText();
            vldt.setElement(am)
                    .isRequired("El apellido materno es obligatorio");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFLastNameM().requestFocus();
                return;
            }

            //VALIDACION DNI
            String dnistr = view.getjTFdni().getText();
            vldt.setElement(dnistr)
                    .isRequired("El DNI es obligatorio")
                    .isInt("El DNI debe ser numerico")
                    .equalsLength(8, "El DNI debe tener 8 digitos");

            if (action.equals("add")) {
                vldt.equalsAttNatural("El DNI ya existe", "dni");
            } else if (action.equals("edit")) {
                vldt.equalsAttNatural("El DNI ya existe", "dni", naturalSelectedId);
            }

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFdni().requestFocus();
                return;
            }

            int dni = Integer.parseInt(dnistr);

            //VALIDACION F, NACIMIENTO
            String date = view.getjTFBhirtday().getText();

            vldt.setElement(date).isRequired("La fecha es obligatoria")
                    .isDate("formato de fecha invalida");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFBhirtday().requestFocus();
                return;
            }

            int[] dateV = new int[3];

            String[] datePart = date.split("/");
            dateV[0] = Integer.parseInt(datePart[0]);
            dateV[1] = Integer.parseInt(datePart[1]);
            dateV[2] = Integer.parseInt(datePart[2]);

            //VALIDACION TELEFONO
            String phoneNumber = view.getjTFTelephone().getText();
            vldt.setElement(phoneNumber)
                    .isRequired("El telefono es obligatorio")
                    .isInt("El telefono debe ser numero")
                    .equalsLength(9, "El telefono debe tener 9 digitos");

            if (action.equals("add")) {
                vldt.equalsAttNatural("El numero ya existe", "phoneNumber");
            } else if (action.equals("edit")) {
                vldt.equalsAttNatural("El numero ya existe", "phoneNumber", naturalSelectedId);
            }

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFTelephone().requestFocus();
                return;
            }

            int phonenumber = Integer.parseInt(phoneNumber);

            //VALIDACION CORREO
            String email = view.getjTFEmail().getText();

            vldt.setElement(email)
                    .isRequired("El email es obligatorio")
                    .isEmail("Email invalido");

            if (action.equals("add")) {
                vldt.equalsAttNatural("El email ya existe", "email");
            } else if (action.equals("edit")) {
                vldt.equalsAttNatural("El email ya existe", "email", naturalSelectedId);
            }

            if (!vldt.exec()) {

                view.showMessage(vldt.getMessage());
                view.getjTFEmail().requestFocus();
                return;
            }

            //VALIDACION DIRECCION
            String direction = view.getjTFAddress().getText();

            vldt.setElement(direction)
                    .isRequired("La direccion es obligatorio");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFAddress().requestFocus();
                return;
            }

            if (action.equals("add")) {

                //creando objeto cliente natural
                newNaturalCustomer = new NaturalCustomer(dni, name, ap, am, LocalDate.of(dateV[2], dateV[1], dateV[0]), phonenumber, email, direction);

                try {

                    naturalCustomerDAO.add(newNaturalCustomer);
                    view.showMessage("Cliente Natural creado");

                } catch (Exception e) {

                    view.showMessage("Cliente no creado" + e.toString());

                }

            } else if (action.equals("edit")) {

                NaturalCustomer updateNc = naturalCustomerDAO.get(naturalSelectedId);
                updateNc.setDni(dni);
                updateNc.setName(name);
                updateNc.setLastname_paternal(ap);
                updateNc.setLastname_maternal(am);
                updateNc.setBirthdate(LocalDate.of(dateV[2], dateV[1], dateV[0]));
                updateNc.setPhoneNumber(phonenumber);
                updateNc.setEmail(email);
                updateNc.setAddress(direction);

                try {

                    naturalCustomerDAO.update(updateNc);
                    view.showMessage("Cliente Natural actualizado");

                } catch (Exception e) {

                    view.showMessage("Cliente no actualizado" + e.toString());

                }

            }

        } else if (typeCustomer.equals("JURIDICO")) {

            //VALIDACION DE RUC
            String rucstr = view.getjTFruc().getText();
            vldt.setElement(rucstr)
                    .isRequired("El RUC es obligatorio")
                    .isLong("El RUC debe ser numerico")
                    .equalsLength(11, "El RUC debe tener 11 digitos");

            if (action.equals("add")) {
                vldt.equalsAttJuridical("El RUC ya existe", "ruc");
            } else if (action.equals("edit")) {
                vldt.equalsAttJuridical("El RUC ya existe", "ruc", juridicalSelectedId);
            }

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFruc().requestFocus();
                return;
            }

            long ruc = Long.parseLong(rucstr);

            //Razon Social
            String razonSocial = view.getjTFrazonSocial().getText();
            vldt.setElement(razonSocial)
                    .isRequired("La razon social es obligatorio");

            if (action.equals("add")) {
                vldt.equalsAttJuridical("La razon social ya existe", "socialReason");
            } else if (action.equals("edit")) {
                vldt.equalsAttJuridical("La razon social ya existe", "socialReason", juridicalSelectedId);
            }

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFrazonSocial().requestFocus();
                return;
            }

            //Tipo
            String type = view.getjTFtype().getText();
            vldt.setElement(type)
                    .isRequired("El tipo es obligatorio");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFtype().requestFocus();
                return;
            }

            //Actividad economica
            String activityEco = view.getjTFactivityEconomic().getText();
            vldt.setElement(activityEco)
                    .isRequired("La actividad economica es obligatoria");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFactivityEconomic().requestFocus();
                return;
            }

            //tipo de facturacion
            String typeBilling = view.getjTFtypeBilling().getText();
            vldt.setElement(typeBilling)
                    .isRequired("El tipo de facturacion es obligatorio");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFtypeBilling().requestFocus();
                return;
            }

            //VALIDACION TELEFONO
            String phoneNumber = view.getjTFThelephoneJuridical().getText();
            vldt.setElement(phoneNumber)
                    .isRequired("El telefono es obligatorio")
                    .isInt("El telefono debe ser numero")
                    .equalsLength(9, "El telefono debe tener 9 digitos");

            if (action.equals("add")) {
                vldt.equalsAttJuridical("El numero ya existe", "phoneNumber");
            } else if (action.equals("edit")) {
                vldt.equalsAttJuridical("El numero ya existe", "phoneNumber", juridicalSelectedId);
            }

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFThelephoneJuridical().requestFocus();
                return;
            }

            int phonenumber = Integer.parseInt(phoneNumber);

            //VALIDACION CORREO
            String email = view.getjTFEmailJuridical().getText();

            vldt.setElement(email)
                    .isRequired("El email es obligatorio")
                    .isEmail("Email invalido");

            if (action.equals("add")) {
                vldt.equalsAttJuridical("El email ya existe", "email");
            } else if (action.equals("edit")) {
                vldt.equalsAttJuridical("El email ya existe", "email", juridicalSelectedId);
            }

            if (!vldt.exec()) {

                view.showMessage(vldt.getMessage());
                view.getjTFEmailJuridical().requestFocus();
                return;
            }

            //VALIDACION DIRECCION
            String direction = view.getjTFAddressJuridical().getText();

            vldt.setElement(direction)
                    .isRequired("La direccion es obligatorio");

            if (!vldt.exec()) {
                view.showMessage(vldt.getMessage());
                view.getjTFAddressJuridical().requestFocus();
                return;
            }

            if (action.equals("add")) {

                //creando objeto cliente juridico
                newJuridicalCustomer = new JuridicalCustomer(ruc, razonSocial, type, activityEco, typeBilling, phonenumber, email, direction);

                try {

                    juridicalCustomerDAO.add(newJuridicalCustomer);
                    view.showMessage("Cliente Juridico creado");

                } catch (Exception e) {

                    view.showMessage("Cliente no creado" + e.toString());

                }

            } else if (action.equals("edit")) {

                JuridicalCustomer updateJc = juridicalCustomerDAO.get(juridicalSelectedId);
                updateJc.setRuc(ruc);
                updateJc.setSocialReason(razonSocial);
                updateJc.setType(type);
                updateJc.setEconomicActivity(activityEco);
                updateJc.setTypeBilling(typeBilling);
                updateJc.setPhoneNumber(phonenumber);
                updateJc.setEmail(email);
                updateJc.setAddress(direction);

                try {

                    juridicalCustomerDAO.update(updateJc);
                    view.showMessage("Cliente Juridico actualizado");

                } catch (Exception e) {

                    view.showMessage("Cliente no actualizado" + e.toString());

                }

            }

        }

        handleCleanForm();
        view.renderTable();
    }

    public void handleCleanForm() {

        view.getBtnDelete().setVisible(false);

        view.getjTFLastNameM().setText("");
        view.getjTFLastNameP().setText("");
        view.getjTFBhirtday().setText("");
        view.getjTFdni().setText("");
        view.getjTFEmail().setText("");
        view.getjTFName().setText("");
        view.getjTFTelephone().setText("");
        view.getjTFAddress().setText("");
        view.getjTFruc().setText("");
        view.getjTFrazonSocial().setText("");
        view.getjTFtypeBilling().setText("");
        view.getjTFtype().setText("");
        view.getjTFactivityEconomic().setText("");
        view.getjTFThelephoneJuridical().setText("");
        view.getjTFAddressJuridical().setText("");
        view.getjTFEmailJuridical().setText("");
        action = "add";
    }

    public void heandleViewEditClick() {

        if (typeCustomer.equals("NATURAL")) {

            naturalSelectedId = Long.parseLong(view.getjTnaturalList().getModel().getValueAt(view.getNaturalRow(), 0).toString());

            view.getjTFName().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 0).toString());
            view.getjTFLastNameP().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 1).toString());
            view.getjTFLastNameM().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 2).toString());
            view.getjTFdni().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 3).toString());
            view.getjTFBhirtday().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 4).toString());
            view.getjTFTelephone().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 5).toString());
            view.getjTFEmail().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 6).toString());
            view.getjTFAddress().setText(view.getjTnaturalList().getValueAt(view.getNaturalRow(), 7).toString());

        } else if (typeCustomer.equals("JURIDICO")) {

            juridicalSelectedId = Long.parseLong(view.getjTjuridicalList().getModel().getValueAt(view.getJuridicalRow(), 0).toString());

            view.getjTFrazonSocial().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 0).toString());
            view.getjTFruc().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 1).toString());
            view.getjTFtype().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 2).toString());
            view.getjTFactivityEconomic().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 3).toString());
            view.getjTFtypeBilling().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 4).toString());
            view.getjTFThelephoneJuridical().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 5).toString());
            view.getjTFEmailJuridical().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 6).toString());
            view.getjTFAddressJuridical().setText(view.getjTjuridicalList().getValueAt(view.getJuridicalRow(), 7).toString());

        }

        action = "edit";

        view.getBtnDelete().setVisible(true);
    }

    public void heandleDeleteClick() {

        int op = view.showConfirmation("¿Desea eliminar este cliente?");

        if (op != 0) {

            return;

        }

        try {

            if (typeCustomer.equals("NATURAL")) {

                naturalSelectedId = Long.parseLong(view.getjTnaturalList().getModel().getValueAt(view.getNaturalRow(), 0).toString());

                naturalCustomerDAO.delete(naturalSelectedId);
                view.showMessage("Cliente Natural eliminado");

            } else if (typeCustomer.equals("JURIDICO")) {

                juridicalSelectedId = Long.parseLong(view.getjTjuridicalList().getModel().getValueAt(view.getJuridicalRow(), 0).toString());

                juridicalCustomerDAO.delete(juridicalSelectedId);
                view.showMessage("Cliente Juridico eliminado");

            }

            view.renderTable();
            handleCleanForm();

        } catch (Exception e) {

            view.showMessage("Error al eliminar el cliente" + e.toString());

        }

    }
}
