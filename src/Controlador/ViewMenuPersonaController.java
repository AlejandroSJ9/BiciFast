package Controlador;

import Modelo.PersonaModel;
import Vista.ViewMenuPersona;

public class ViewMenuPersonaController {
    private PersonaModel personaModel;
    private DataBase dataBase;
    private ViewMenuPersona viewMenuPersona;

    public ViewMenuPersonaController(PersonaModel personaModel, DataBase dataBase, ViewMenuPersona v) {
        this.personaModel = personaModel;
        this.dataBase = dataBase;
        this.viewMenuPersona = v;
    }

    public void iniciarVista(){
        viewMenuPersona.iniciarVista();
    }

    public PersonaModel getPersonaModel() {
        return personaModel;
    }

    public void setPersonaModel(PersonaModel personaModel) {
        this.personaModel = personaModel;
    }
}
