package Vista;

import Controlador.ViewAdminController;
import Controlador.ViewMainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenuMain {
    private JFrame ventana;
    private ViewMainController controller;
    private JPanel panel;
    private JTextField nameField;
    private JPasswordField passwordField;

    public ViewMenuMain(ViewMainController c){
        this.controller = c;
        startView();
    }
    public void startView(){
        ventana = new JFrame("Bicifast");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ventana.setSize(500,300);
            ventana.setLayout(new BorderLayout());
        panel = new JPanel();
            panel.setLayout(new GridLayout(3,2));
            panel.setSize(300,200);

        JLabel labelUser = new JLabel("Nombre: ");
            panel.add(labelUser);
            nameField = new JTextField();
            panel.add(nameField);
        JLabel labelPassword = new JLabel("Contraseña: ");
            panel.add(labelPassword);
            passwordField = new JPasswordField();
            panel.add(passwordField);

        JButton loginButton = new JButton("Iniciar Sesion");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(false);
                String username = nameField.getText();
                char[] password = passwordField.getPassword();
                String passwordStr = new String(password);
                controller.respuestaLoginToAdmin(username,passwordStr);
                controller.validarLogIn(username,passwordStr);
            }
        });

        panel.add(loginButton);
        ventana.add(panel,BorderLayout.CENTER);
        ventana.setVisible(true);

    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
