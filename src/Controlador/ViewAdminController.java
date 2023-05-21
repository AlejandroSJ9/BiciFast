package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;
import Vista.ViewMenuAdministrador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class ViewAdminController {

    private ViewMenuAdministrador menuAdministrador ;
    private DataBase dataBase;

    public ViewAdminController(DataBase dataBase) {
        this.dataBase = dataBase;
        iniciarVista();
    }

    public void iniciarVista(){
        menuAdministrador = new ViewMenuAdministrador(this,dataBase);
    }
    public void mostrarDataBase(JTextArea textArea) {
        textArea.setText("");
        for (Map.Entry<PersonaModel, ArrayList<BicicletaModel>> entry : this.dataBase.getDataBase().entrySet()) {
            PersonaModel personaModel = entry.getKey();
            ArrayList<BicicletaModel> bicicletaModels = entry.getValue();
            textArea.append("- " + personaModel.getNombre() + " " + personaModel.getApellido() + " | " + personaModel.getId() + " |" +"\n");
            for (BicicletaModel b : bicicletaModels) {
                textArea.append("\t* " + b.getMarca() + " - " + b.getUnique_id() + "\n");
            }
        }
    }
}
