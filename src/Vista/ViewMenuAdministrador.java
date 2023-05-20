package Vista;

import Controlador.ViewAdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenuAdministrador {
    private JFrame frame;
    private ViewAdminController adminController;

    public ViewMenuAdministrador(ViewAdminController controller){
        this.adminController = controller;
        showView();
    }
    public void showView() {
        frame = new JFrame("Bicifast - Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel titleLabel = new JLabel("<html><h2>MENU PRINCIPAL</h2></html>");
        panel.add(titleLabel);

        JButton imprimirButton = new JButton("Imprimir Base Datos");
        imprimirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para imprimir la base de datos
            }
        });
        panel.add(imprimirButton);

        JButton agregarButton = new JButton("Agregar Usuario");
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar un usuario
            }
        });
        panel.add(agregarButton);

        JButton borrarButton = new JButton("Borrar Usuario");
        borrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para borrar un usuario
            }
        });
        panel.add(borrarButton);

        JButton editarButton = new JButton("Editar Usuario");
        editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para editar un usuario
            }
        });
        panel.add(editarButton);

        JButton verButton = new JButton("Ver rutas");
        verButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver rutas
            }
        });
        panel.add(verButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
