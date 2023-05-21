package Controlador;

import Modelo.PersonaModel;
import Vista.ViewFormDeleteByID;

import javax.swing.*;

public class ViewFormDeleteByIDController {
    private DataBase dataBase;
    private JFrame frame;
    public ViewFormDeleteByIDController(DataBase db, JFrame jFrame){
        this.dataBase = db;
        this.frame = jFrame;
    }
    public void iniciarVista(){
        ViewFormDeleteByID viewFormDeleteByID = new ViewFormDeleteByID(this);
        viewFormDeleteByID.iniciarVista();
    }
    public void borrarByID(int id){
        PersonaModel personaBorrar= dataBase.buscarByID(id);
        if(personaBorrar != null){
            dataBase.eliminarPersona(personaBorrar);
            JOptionPane.showMessageDialog(frame,"Borrado");
        }else{
            JOptionPane.showMessageDialog(frame,"Error al intentar borrar");
            frame.setVisible(false);
        }

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
