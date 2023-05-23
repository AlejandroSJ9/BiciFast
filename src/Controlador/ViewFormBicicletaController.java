package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;
import Vista.ViewFormBicicleta;

import javax.swing.*;

import java.util.ArrayList;

public class ViewFormBicicletaController {
    private ViewFormBicicleta view;
    private DataBase dataBase;
    private PersonaModel personaModel;

    public ViewFormBicicletaController(ViewFormBicicleta formBicicleta, DataBase dataBase, PersonaModel personaModel) {
        this.view = formBicicleta;
        this.dataBase = dataBase;
        this.personaModel = personaModel;
    }

    public void iniciarVista(){
        view.iniciarVista();
    }
    private BicicletaModel obtenerDatosView(){
        BicicletaModel bicicletaModel  = null;
        try{
            String marca = view.getMarcaTF().getText();
            String color = view.getColoTF().getText();
            int id = Integer.parseInt(view.getIdTF().getText());
            bicicletaModel = new BicicletaModel(marca,id,color);
            return bicicletaModel;
        }catch (Exception e){
            JOptionPane.showMessageDialog(view.getFrame(),"Error: Tipos de datos invalidos","Error",JOptionPane.ERROR_MESSAGE);
            view.getFrame().setVisible(false);
        }
        return bicicletaModel;
    }
    public void agregarBicicleta() {
        BicicletaModel newBicke = obtenerDatosView();
        if (newBicke != null && !camposVacios()) {
            if (!verificarBicicletaDuplicada(newBicke.getUnique_id())) {
                dataBase.agregarPersonaBicicleta(personaModel, newBicke);
                JOptionPane.showMessageDialog(view.getFrame(),"Bicicleta agregada");
                view.getFrame().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view.getFrame(), "Error: No es posible registrar la bicicleta", "Error", JOptionPane.ERROR_MESSAGE);
                view.getFrame().setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(view.getFrame(), "Error: Los campos no pueden estar vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean camposVacios() {
        return view.getMarcaTF().getText().isEmpty() ||
                view.getColoTF().getText().isEmpty() ||
                view.getIdTF().getText().isEmpty();
    }

    public boolean verificarBicicletaDuplicada(int idBicicleta) {
        for (ArrayList<BicicletaModel> bicicletas : this.dataBase.getDataBase().values()) {
            for (BicicletaModel bicicleta : bicicletas) {
                if (bicicleta.getUnique_id() ==  idBicicleta) {
                    return true;
                }
            }
        }
        return false;
    }
}
