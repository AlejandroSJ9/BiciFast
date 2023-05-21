package Vista;

import Controlador.DataBase;
import Controlador.ViewAdminController;
import Controlador.ViewFormPersonaModelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenuAdministrador {
    private JFrame frame;
    private ViewAdminController adminController;
    private JTextArea textArea;
    private DataBase dataBase;

    public ViewMenuAdministrador(ViewAdminController controller, DataBase dataBase){
        this.adminController = controller;
        this.dataBase = dataBase;
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

        textArea = new JTextArea(10,30);
        textArea.setEditable(false);
        JButton imprimirButton = new JButton("Imprimir Base Datos");
        imprimirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminController.mostrarDataBase(textArea);
            }
        });

        panel.add(imprimirButton);

        JButton agregarButton = new JButton("Agregar Usuario");
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewFormPersonaModel viewFormPersonaModel = new ViewFormPersonaModel();
                ViewFormPersonaModelController viewFormPersonaModelController = new ViewFormPersonaModelController(dataBase,viewFormPersonaModel);
                viewFormPersonaModel.setPersonaModelController(viewFormPersonaModelController);
                viewFormPersonaModelController.iniciarVista();
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
        panel.add(textArea);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
