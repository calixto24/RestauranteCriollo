
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
    
    public void handleRegisterClick(){
        
        //NAME
        String name = roleRegisterView.getjTFNameRol().getText();
        
        vldt.setElement(name)
                .isRequired("El nombre del rol es requerido")
                .equalsNameRol("Ya existe ese rol", "name")
                .equalsNameRol("Ya existe ese rol", "name", selectedId);
                
        if (!vldt.exec()) {
            
            roleRegisterView.showMessage(vldt.getMessage());
            roleRegisterView.getjTFNameRol().requestFocus();
            
        }
        
        //creando objeto rol
        Role newRole = new Role(name);
        
        if(action.equals("add")) {
            
            roleDao.add(newRole);
            roleRegisterView.showMessage("Rol creado");
            
        }
        
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
                
        for(Role role : roleList) {
            
            Object row[] = {
                
                role.getId(),
                role.getName()
                
            };
            
            tableModel.addRow(row);
            
        }
        
        return tableModel;
        
    }
    
}
