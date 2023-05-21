package Vista;

import Controlador.ViewFormPersonaModelController;
import Modelo.PersonaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFormPersonaModel {
    private JFrame frame;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField documentoTextField;
    private JTextField numeroTextField;
    private JTextField passTextField;
    private ViewFormPersonaModelController personaModelController;

    public ViewFormPersonaModel(ViewFormPersonaModelController c){
        this.personaModelController = c;
    }
    public ViewFormPersonaModel(){

    }

    public void iniciarVista(){
        frame = new JFrame("Registrar Persona");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(6, 2));

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

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (personaModelController.validarDatosPersona()) {
                    JOptionPane.showMessageDialog(frame,"Registro Exitoso");
                    frame.setVisible(false);
                }

            }
        });
        frame.add(registrarButton);

        frame.setVisible(true);
    }

    public ViewFormPersonaModelController getPersonaModelController() {
        return personaModelController;
    }

    public void setPersonaModelController(ViewFormPersonaModelController personaModelController) {
        this.personaModelController = personaModelController;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getNombreTextField() {
        return nombreTextField;
    }

    public JTextField getApellidoTextField() {
        return apellidoTextField;
    }

    public JTextField getDocumentoTextField() {
        return documentoTextField;
    }

    public JTextField getNumeroTextField() {
        return numeroTextField;
    }

    public JTextField getPassTextField() {
        return passTextField;
    }
}
