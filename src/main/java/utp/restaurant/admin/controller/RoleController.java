package utp.restaurant.admin.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.admin.view.RoleRegisterView;
import utp.restaurant.dao.RoleDAO;
import utp.restaurant.model.Role;
import utp.restaurant.utils.Validate;

public class RoleController {

    //atributo
    private RoleRegisterView roleRegisterView;
    private RoleDAO roleDao;
    private Validate vldt;
    private long selectedId;
    private String action;

    //constructor
    public RoleController(RoleRegisterView registerView) {

        this.roleRegisterView = registerView;
        roleDao = new RoleDAO();
        vldt = new Validate();

        selectedId = 0;
        action = "add";

    }

    public void handleRegisterClick() {

        roleRegisterView.getjBDelete().setVisible(false);

        //NAME
        String name = roleRegisterView.getjTFNameRol().getText();

        vldt.setElement(name)
                .isRequired("El nombre del rol es requerido");

        if (action.equals("add")) {
            vldt.equalsNameRol("El rol ya existe", "name");
        } else if (action.equals("edit")) {
            vldt.equalsNameRol("El rol ya existe", "name", selectedId);
        }

        if (!vldt.exec()) {

            roleRegisterView.showMessage(vldt.getMessage());
            roleRegisterView.getjTFNameRol().requestFocus();

        }

        //creando objeto rol
        Role newRole = new Role(name);

        if (action.equals("add")) {

            try {

                roleDao.add(newRole);
                roleRegisterView.showMessage("Rol creado correctamente");

            } catch (Exception e) {

                roleRegisterView.showMessage("Rol no creado");

            }

        } else if (action.equals("edit")) {

            try {

                roleDao.update(selectedId, newRole);
                roleRegisterView.showMessage("Rol actualizado correctamente");

            } catch (Exception e) {

                roleRegisterView.showMessage("Rol no actualizado");

            }

        }

        handleCleanForm();
        roleRegisterView.renderTable();

    }

    //metodo model table
    public DefaultTableModel getTableModel() {

        String columns[] = {
            "Id",
            "Nombre"
        };

        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        ArrayList<Role> roleList = roleDao.getAll();

        for (Role role : roleList) {

            Object row[] = {
                role.getId(),
                role.getName()

            };

            tableModel.addRow(row);

        }

        return tableModel;

    }

    //metodo limpiar
    public void handleCleanForm() {

        roleRegisterView.getjBDelete().setVisible(false);

        roleRegisterView.getjTFNameRol().setText("");
        action = "add";
    }

    //metodo rellenar cuando va a editar
    public void heandleViewEditClick() {

        selectedId = Long.parseLong(roleRegisterView.getjTRoleList().getModel().getValueAt(roleRegisterView.getRow(), 0).toString());

        roleRegisterView.getjTFNameRol().setText(roleRegisterView.getjTRoleList().getModel().getValueAt(roleRegisterView.getRow(), 1).toString());

        roleRegisterView.getjBDelete().setVisible(true);

        action = "edit";

    }

    public void heandleDeleteClick() {

        selectedId = Long.parseLong(roleRegisterView.getjTRoleList().getModel().getValueAt(roleRegisterView.getRow(), 0).toString());

        int op = roleRegisterView.showConfirmation("¿Desea eliminar este rol?");

        if (op != 0) {

            return;

        }

        try {

            roleDao.delete(selectedId);
            roleRegisterView.showMessage("Rol eliminado correctamente");

            handleCleanForm();
            roleRegisterView.renderTable();

        } catch (Exception e) {

            roleRegisterView.showMessage("Rol no eliminado");

        }
    }

}
