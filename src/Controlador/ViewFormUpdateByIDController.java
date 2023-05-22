package Controlador;

import Modelo.PersonaModel;
import Vista.ViewFormUpdateByID;

import javax.swing.*;

public class ViewFormUpdateByIDController {
    private ViewFormUpdateByID view;
    private DataBase dataBase;
    private PersonaModel personaUpdate;

    public ViewFormUpdateByIDController(ViewFormUpdateByID view, DataBase dataBase) {
        this.dataBase = dataBase;
        this.view = view;
    }
    public void iniciarVista(){
        view.iniciarVista();
    }
    public void setTextOfPersona(int id){
        this.personaUpdate = dataBase.buscarByID(id);
        if(personaUpdate != null){
            view.getNombreTextField().setText(personaUpdate.getNombre());
            view.getApellidoTextField().setText(personaUpdate.getApellido());
            view.getDocumentoTextField().setText(String.valueOf(personaUpdate.getId()));
            view.getNumeroTextField().setText(personaUpdate.getPhoneNumber());
            view.getPassTextField().setText(personaUpdate.getPass());
        }else{
            JOptionPane.showMessageDialog(view.getFrame(),"Error: Persona no encontrada","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarPersona(){
        dataBase.actualizarPersona(this.personaUpdate,view.getNombreTextField().getText(),view.getApellidoTextField().getText(),Integer.parseInt(view.getDocumentoTextField().getText()),view.getNumeroTextField().getText());
        JOptionPane.showMessageDialog(view.getFrame(),"Datos Actualizados");
        view.getFrame().setVisible(false);
    }
}
