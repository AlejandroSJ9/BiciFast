package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;
import Vista.ViewFormPersonaModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class ViewFormPersonaController {
    private DataBase dataBase;
    private ViewFormPersonaModel viewFormPersonaModel;

    public ViewFormPersonaController(DataBase dataBase, ViewFormPersonaModel viewFormPersonaModel) {
        this.dataBase = dataBase;
        this.viewFormPersonaModel = viewFormPersonaModel;
        viewFormPersonaModel = new ViewFormPersonaModel(this);
    }
    public void iniciarVista(){
        viewFormPersonaModel.iniciarVista();
    }
    private PersonaModel obtenerDatosVista(){
        PersonaModel model = null;
        try{
            String nombre = viewFormPersonaModel.getNombreTextField().getText();
            String apellido = viewFormPersonaModel.getApellidoTextField().getText();
            int documento = Integer.parseInt(viewFormPersonaModel.getDocumentoTextField().getText());
            String numero = viewFormPersonaModel.getNumeroTextField().getText();
            String pass = viewFormPersonaModel.getPassTextField().getText();
            model = new PersonaModel(nombre,apellido,documento,numero,pass);
        }catch (Exception e){
            JOptionPane.showMessageDialog(viewFormPersonaModel.getFrame(), "Error: tipos de datos invalidos","Error",JOptionPane.ERROR_MESSAGE);
            viewFormPersonaModel.getFrame().setVisible(false);
        }
        return model;
    }
    public void registrarPersona(PersonaModel personaForm){
        PersonaModel personaModel = new PersonaModel(personaForm.getNombre(),personaForm.getApellido(), personaForm.getId(), personaForm.getPhoneNumber(), personaForm.getPass());
        dataBase.agregarPersonaBicicleta(personaModel,null);
    }
    public boolean validarDatosPersona() {
        boolean huboRegistro = false;
        PersonaModel personaModel = obtenerDatosVista();

        if(personaModel != null){
            if (this.dataBase.getDataBase().isEmpty()) {
                // Agregar el primer usuario al mapa de datos
                ArrayList<BicicletaModel> bicicletas = new ArrayList<>();
                this.dataBase.getDataBase().put(personaModel, bicicletas);
                huboRegistro = true;
            } else {
                for (Map.Entry<PersonaModel, ArrayList<BicicletaModel>> entry : this.dataBase.getDataBase().entrySet()) {
                    PersonaModel personaModelDB = entry.getKey();
                    if (personaModel.getId() == personaModelDB.getId()) {
                        JOptionPane.showMessageDialog(viewFormPersonaModel.getFrame(), "Error: Base de Datos Vacía", "Error", JOptionPane.ERROR_MESSAGE);
                        huboRegistro = false;
                    } else {
                        registrarPersona(personaModel);
                        huboRegistro = true;
                    }
                }
            }
        }

        return huboRegistro;
    }
}
