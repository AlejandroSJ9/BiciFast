package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;

import java.util.ArrayList;
import java.util.Map;

public class ViewMainController {
    private DataBase dataBase;

    public ViewMainController(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public PersonaModel validarLogIn(String user, String password){
        for(Map.Entry<PersonaModel, ArrayList<BicicletaModel>> entry: this.dataBase.getDataBase().entrySet()){
            PersonaModel personaModel = entry.getKey();
            if(personaModel.getNombre().equals(user) && personaModel.getPass().equals(password)){
                respuestaLoginToUser(personaModel);
                return personaModel;
            }
        }
        return null;
    }

    public void respuestaLoginToAdmin(String user, String pass){
        if(user.equals("admin") && pass.equals("1234")){
            ViewAdminController viewAdminController = new ViewAdminController();
        }
    }

    private void respuestaLoginToUser(PersonaModel personaLogin){
        ViewMenuPersonaController viewMenuPersonaController = new ViewMenuPersonaController(personaLogin,this.dataBase);
    }
}
