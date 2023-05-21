package Controlador;

import Modelo.PersonaModel;
import Vista.ViewFormUpdateByID;

import javax.swing.*;

public class ViewFormUpdateByIDController {
    private ViewFormUpdateByID view;
    private DataBase dataBase;

    public ViewFormUpdateByIDController(ViewFormUpdateByID view, DataBase dataBase) {
        this.dataBase = dataBase;
        this.view = view;
    }

    public void setTextOfPersona(int id){
        PersonaModel personaDB = dataBase.buscarByID(id);
        if(personaDB != null){
            //buscar la persona y darle los datos a los textfield
        }
    }
}
