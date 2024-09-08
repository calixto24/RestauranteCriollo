
package controller;

import model.Table;
import utils.Validate;
import view.TableRegisterView;

public class TableController {
    
    private TableRegisterView tableRegisterView;
    private String action;
    private Validate vld;
    
    public TableController(TableRegisterView tableRegisterView){
      this.tableRegisterView=tableRegisterView;
      this.action= "add";
      vld= new Validate();
    } 
    public void handleRegisterClick(){
        
        //validacion de numero de mesa
        String nTablestr = tableRegisterView.getjTFNmesa().getText();
        vld.setElement(nTablestr).isRequired(" este campo es obligatorio").isInt(" el numero de mesa tiene que ser numerico");
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
        //rol
        String status= (String)tableRegisterView.getjCBestatus().getSelectedItem();
        Table newTable = new Table(nTable, nCapaci, status);
    }
   
}
