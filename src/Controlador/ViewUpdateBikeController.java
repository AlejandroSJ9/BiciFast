package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;
import Vista.ViewMenuPersona;
import Vista.ViewUpdateBike;

import javax.swing.*;

public class ViewUpdateBikeController {
    private DataBase dataBase;
    private ViewUpdateBike view;
    private PersonaModel personaUpdate;
    private BicicletaModel bikeToUpdate;

    public ViewUpdateBikeController (DataBase dataBase, ViewUpdateBike view, BicicletaModel b, PersonaModel p) {
        this.dataBase = dataBase;
        this.view = view;
        this.bikeToUpdate = b;
        this.personaUpdate = p;
    }
    public void iniciarVista(){
        view.iniciarVista();
    }
    public void setTextOnTextField(BicicletaModel bicicletaModel){
        if(bicicletaModel != null){
            view.getMarca().setText(bicicletaModel.getMarca());
            view.getColor().setText(bicicletaModel.getColor());
            view.getId().setEditable(false);
            view.getId().setText(String.valueOf(bicicletaModel.getUnique_id()));
        }else{
            JOptionPane.showMessageDialog(view.getFrame(),"Error: No se pudo actulizar bicicleta");
        }

    }

    public void actualizarBicicleta(){
        BicicletaModel newBike = new BicicletaModel(view.getMarca().getText(),Integer.parseInt(view.getId().getText()),view.getColor().getText());
        dataBase.actualizarBicicleta(personaUpdate,newBike,bikeToUpdate);
        view.getFrame().setVisible(false);
    }

    public BicicletaModel getBikeToUpdate () {
        return bikeToUpdate;
    }

    public void setBikeToUpdate (BicicletaModel bikeToUpdate) {
        this.bikeToUpdate = bikeToUpdate;
    }
}
