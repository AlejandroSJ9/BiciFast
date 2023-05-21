package Vista;

import Controlador.ViewFormUpdateByIDController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFormUpdateByID {
    private ViewFormUpdateByIDController controller;
    private JFrame frame;
    private JTextField buscarById;
    private JButton buttonSearch;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField documentoTextField;
    private JTextField numeroTextField;
    private JTextField passTextField;

    public ViewFormUpdateByID(ViewFormUpdateByIDController c){
        this.controller = c;
    }
    public void iniciarVista(){
        frame = new JFrame("Actualizar Usuario");
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(6,2));

        JLabel textActualizar = new JLabel("Ingresa el ID: ");
        buscarById = new JTextField();

        buttonSearch = new JButton("Buscar");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //logica de buscar y agregar los datos del
            }
        });

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField();

        JLabel apellidoLabel = new JLabel("Apellidos:");
        apellidoTextField = new JTextField();

        JLabel documentoLabel = new JLabel("Número de documento:");
        documentoTextField = new JTextField();

        JLabel numeroLabel = new JLabel("Número de celular:");
        numeroTextField = new JTextField();

        JLabel passLabel = new JLabel("Contraseña:");
        passTextField = new JTextField();

        frame.add(textActualizar);
        frame.add(buscarById);
        frame.add(buttonSearch);

        frame.add(nombreLabel);
        frame.add(nombreTextField);

        frame.add(apellidoLabel);
        frame.add(apellidoTextField);

        frame.add(documentoLabel);
        frame.add(documentoTextField);

        frame.add(numeroLabel);
        frame.add(numeroTextField);

        frame.add(passLabel);
        frame.add(passTextField);

        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getBuscarById() {
        return buscarById;
    }

    public void setBuscarById(JTextField buscarById) {
        this.buscarById = buscarById;
    }

    public JButton getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(JButton buttonSearch) {
        this.buttonSearch = buttonSearch;
    }

    public JTextField getNombreTextField() {
        return nombreTextField;
    }

    public void setNombreTextField(JTextField nombreTextField) {
        this.nombreTextField = nombreTextField;
    }

    public JTextField getApellidoTextField() {
        return apellidoTextField;
    }

    public void setApellidoTextField(JTextField apellidoTextField) {
        this.apellidoTextField = apellidoTextField;
    }

    public JTextField getDocumentoTextField() {
        return documentoTextField;
    }

    public void setDocumentoTextField(JTextField documentoTextField) {
        this.documentoTextField = documentoTextField;
    }

    public JTextField getNumeroTextField() {
        return numeroTextField;
    }

    public void setNumeroTextField(JTextField numeroTextField) {
        this.numeroTextField = numeroTextField;
    }

    public JTextField getPassTextField() {
        return passTextField;
    }

    public void setPassTextField(JTextField passTextField) {
        this.passTextField = passTextField;
    }
}
