package Vista;

import Controlador.AdministradorController;
import Controlador.ViewMainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMain{
    private JFrame ventana;
    private ViewMainController controller;
    private JPanel panel;
    private JTextField nameField;
    private JPasswordField passwordField;

    public ViewMain(ViewMainController c){
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
                AdministradorController a = new AdministradorController();
                ViewMenuAdministrador va = new ViewMenuAdministrador(a);
            }
        });

        panel.add(loginButton);
        ventana.add(panel,BorderLayout.CENTER);
        ventana.setVisible(true);

    }
}
