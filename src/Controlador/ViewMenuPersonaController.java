package Controlador;

import Modelo.BicicletaModel;
import Modelo.PersonaModel;
import Vista.ViewMenuPersona;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

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
    public void actualizarTablaBicicletas(ArrayList<BicicletaModel> bicicletas) {
        JTable tablaBicicletas = viewMenuPersona.getTablaBicicletas();
        DefaultTableModel tableModel = (DefaultTableModel) tablaBicicletas.getModel();
        tableModel.setRowCount(0);
        for (BicicletaModel bicicleta : bicicletas) {
            Object[] rowData = { bicicleta.getMarca(), bicicleta.getUnique_id(), bicicleta.getColor() };
            tableModel.addRow(rowData);
        }
    }
    public void eliminarBicicleta(BicicletaModel bici){
        BicicletaModel bicicleta = gestionarBicicletaSeleccionada(bici);
        if(bicicleta!=null){
            this.dataBase.eliminarBicicleta(personaModel,bicicleta);
            JOptionPane.showMessageDialog(viewMenuPersona.getFrame(),"Bicicleta Eliminada");
        }else{
            JOptionPane.showMessageDialog(viewMenuPersona.getFrame(),"Error");
        }
    }

    public BicicletaModel gestionarBicicletaSeleccionada(BicicletaModel bicicletaSeleccionada) {
        if (bicicletaSeleccionada != null) {
            return bicicletaSeleccionada;
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna bicicleta", "Alerta", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }


    public DataBase getDataBase () {
        return dataBase;
    }

    public void setDataBase (DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public ViewMenuPersona getViewMenuPersona () {
        return viewMenuPersona;
    }

    public void setViewMenuPersona (ViewMenuPersona viewMenuPersona) {
        this.viewMenuPersona = viewMenuPersona;
    }

    public PersonaModel getPersonaModel() {
        return personaModel;
    }

    public void setPersonaModel(PersonaModel personaModel) {
        this.personaModel = personaModel;
    }
}
