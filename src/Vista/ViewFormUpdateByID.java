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
    private JButton buttonUpdate;

    public ViewFormUpdateByID(ViewFormUpdateByIDController c){
        this.controller = c;
    }
    public ViewFormUpdateByID(){

    }
    public void iniciarVista() {
        frame = new JFrame("Actualizar Usuario");
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel textActualizar = new JLabel("Ingresa el ID: ");
        buscarById = new JTextField(10);

        buttonSearch = new JButton("Buscar");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setTextOfPersona(Integer.parseInt(buscarById.getText()));
            }
        });

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField(20);

        JLabel apellidoLabel = new JLabel("Apellidos:");
        apellidoTextField = new JTextField(20);

        JLabel documentoLabel = new JLabel("Número de documento:");
        documentoTextField = new JTextField(20);

        JLabel numeroLabel = new JLabel("Número de celular:");
        numeroTextField = new JTextField(20);

        JLabel passLabel = new JLabel("Contraseña:");
        passTextField = new JTextField(20);

        buttonUpdate = new JButton("Actualizar");
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actualizarPersona();
            }
        });

        // Primera columna
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(textActualizar, gbc);

        gbc.gridy = 1;
        frame.add(nombreLabel, gbc);

        gbc.gridy = 2;
        frame.add(apellidoLabel, gbc);

        gbc.gridy = 3;
        frame.add(documentoLabel, gbc);

        gbc.gridy = 4;
        frame.add(numeroLabel, gbc);

        gbc.gridy = 5;
        frame.add(passLabel, gbc);

        // Segunda columna
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(buscarById, gbc);

        gbc.gridy = 1;
        frame.add(nombreTextField, gbc);

        gbc.gridy = 2;
        frame.add(apellidoTextField, gbc);

        gbc.gridy = 3;
        frame.add(documentoTextField, gbc);

        gbc.gridy = 4;
        frame.add(numeroTextField, gbc);

        gbc.gridy = 5;
        frame.add(passTextField, gbc);

        // Botón de búsqueda
        gbc.gridx = 2;
        gbc.gridy = 0;
        frame.add(buttonSearch, gbc);

        // Botón de actualización
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonUpdate, gbc);

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

    public ViewFormUpdateByIDController getController() {
        return controller;
    }

    public void setController(ViewFormUpdateByIDController controller) {
        this.controller = controller;
    }
}
