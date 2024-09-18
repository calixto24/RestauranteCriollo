
package utp.restaurant.admin.controller;

import utp.restaurant.dao.EmployeeDAO;
import utp.restaurant.dao.TableDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utp.restaurant.model.Table;
import utp.restaurant.model.Employee;
import utp.restaurant.utils.Validate;
import utp.restaurant.admin.view.TableRegisterView;


public class TableController {
    
    private TableRegisterView tableRegisterView;
    private TableDAO tableDao;
    private EmployeeDAO employeeDao;
    private String action;
    private Validate vld;
    private long selectedId;
    
    public TableController(TableRegisterView tableRegisterView){
        
      this.tableRegisterView = tableRegisterView;
      this.action= "add";
      selectedId = 0;
      
      vld= new Validate();
      tableDao = new TableDAO();
      employeeDao = new EmployeeDAO();
      
    } 
    public void handleRegisterClick(){
        System.out.println(((Employee) tableRegisterView.getJCBEmployees().getSelectedItem()).getId_employee());
        //validacion de numero de mesa
        String nTablestr = tableRegisterView.getjTFNmesa().getText();
        vld.setElement(nTablestr)
                .isRequired(" este campo es obligatorio")
                .isInt(" el numero de mesa tiene que ser numerico");
        
        if (action.equals("add")) vld.equalsNtable("El numero de mesa ya existe", "ntable");
        else if (action.equals("edit")) vld.equalsNtable("El numero de mesa ya existe", "ntable", selectedId);
        
        if( !vld.exec()){
            tableRegisterView.showMessage(vld.getMessage());
            tableRegisterView.getjTFNmesa().requestFocus();
            return;
        }
        int nTable= Integer.parseInt(nTablestr);
        
        //validacion de capacidad
        String nCapacistr= tableRegisterView.getjTFcapacity().getText();
        vld.setElement(nCapacistr).isRequired("este campo es obligatorio").isInt("tiene que ser numerico");
        if( !vld.exec()){
            tableRegisterView.showMessage(vld.getMessage());
            tableRegisterView.getjTFcapacity().requestFocus();
            return;
        }
        int nCapaci= Integer.parseInt(nCapacistr);
        
        //estado
        String status= (String)tableRegisterView.getjCBestatus().getSelectedItem();
        
        
        // Empleado
        Employee employee = ((Employee) tableRegisterView.getJCBEmployees().getSelectedItem());
        //creando nuevas mesa
        Table newTable = new Table(nTable, nCapaci, status, employee);
        
        if(action.equals("add")) {
            
            try {
                tableDao.add(newTable);
                tableRegisterView.showMessage("Mesa creada");
                
            } catch (Exception e) {
                
                tableRegisterView.showMessage("Mesa no creada");
                
            }
            
        } else if (action.equals("edit")) {

            try {
                
                tableDao.update(selectedId, newTable);
                tableRegisterView.showMessage("Mesa modificada");
                
            } catch (Exception e) {
                
                tableRegisterView.showMessage("Mesa no modificada" + e.toString());
                System.out.println("Mesa no modificada" + e.toString());
                
            }
            
        }
        
        handleCleanForm();
        tableRegisterView.renderTable();
        
    }
    
    public DefaultTableModel getTableModel(){ 
        
        String[] columns = {
            "Id",
            "N° Mesa",
            "Capacidad",
            "Estado"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, columns);
        
        ArrayList<Table> tableList = tableDao.getAll();

        for (Table table : tableList) {
            Object[] row = {
                table.getId(),
                table.getNumber_table(),
                table.getCapacity(),
                table.getStatus()
            };

            tableModel.addRow(row);
        }

        return tableModel;
        
        
    }
    
    public ArrayList<Employee> getEmployeeListFiltered() {
        ArrayList<Employee> EmployeeList = employeeDao.getAll();
        ArrayList<Employee> EmployeeListFiltered = new ArrayList<>();
        
        for(Employee e: EmployeeList) {
            if (e.getRole().equals("Mesero")) {
                EmployeeListFiltered.add(e);
            }
        }
        
        return EmployeeListFiltered;
    }
    
    public void handleCleanForm() {
        
        action = "add";
        tableRegisterView.getjBdelete().setEnabled(false);
        
        tableRegisterView.getjTFNmesa().setText("");
        tableRegisterView.getjTFcapacity().setText("");
        
    }
    
    public void heandleViewEditClick() {
        
        selectedId = Long.parseLong(tableRegisterView.getjTtableList().getModel().getValueAt(tableRegisterView.getRow(), 0).toString());
        
        //pintando la columna con la informacion de la fila
        tableRegisterView.getjTFNmesa().setText(tableRegisterView.getjTtableList().getValueAt(tableRegisterView.getRow(), 0).toString());
        tableRegisterView.getjTFcapacity().setText(tableRegisterView.getjTtableList().getValueAt(tableRegisterView.getRow(), 1).toString());
        
        action = "edit";
        
        tableRegisterView.getjBdelete().setEnabled(true);
        
    }
    
    public void heandleDeleteClick() {
        
        selectedId = Long.parseLong(tableRegisterView.getjTtableList().getModel().
                getValueAt(tableRegisterView.getRow(), 0).toString());
        
        int op = tableRegisterView.showConfirmation("¿Desea eliminar esta mesa?");
        
        if (op != 0) {
            
            return;
            
        }
        
        try {
            
            tableDao.delete(selectedId);
            
            //renderizar los cambios en la tabla
            tableRegisterView.renderTable();
            tableRegisterView.showMessage("Mesa eliminado correctamente");
            handleCleanForm();
            
        } catch (Exception e) {
            
            tableRegisterView.showMessage("Error al eliminar la mesa" + e.toString());
            
        }
        
    }
    
   
}
