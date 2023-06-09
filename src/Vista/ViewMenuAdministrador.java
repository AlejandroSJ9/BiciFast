package Vista;

import Controlador.*;

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
                ViewFormPersonaController viewFormPersonaController = new ViewFormPersonaController(dataBase,viewFormPersonaModel);
                viewFormPersonaModel.setPersonaModelController(viewFormPersonaController);
                viewFormPersonaController.iniciarVista();
            }
        });
        panel.add(agregarButton);

        JButton borrarButton = new JButton("Borrar Usuario");
        borrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminController.mostrarDataBase(textArea);
                ViewFormDeleteByIDController deleteController = new ViewFormDeleteByIDController(dataBase,frame);
                deleteController.iniciarVista();
                adminController.mostrarDataBase(textArea);
            }
        });
        panel.add(borrarButton);

        JButton editarButton = new JButton("Editar Usuario");
        editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ViewFormUpdateByID formUpdateByID = new ViewFormUpdateByID();
                ViewFormUpdateByIDController updateByIDController = new ViewFormUpdateByIDController(formUpdateByID,dataBase);
                formUpdateByID.setController(updateByIDController);
                updateByIDController.iniciarVista();
                adminController.mostrarDataBase(textArea);
            }
        });
        panel.add(editarButton);

        JButton verButton = new JButton("Ver rutas");
        verButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver rutas
            }
        });

        JButton back = new JButton("Volver");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ViewMainController viewMain = new ViewMainController(dataBase);
                ViewMenuMain viewMenuMain = new ViewMenuMain(viewMain);

            }
        });

        panel.add(verButton);
        panel.add(textArea);
        panel.add(back);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public ViewAdminController getAdminController() {
        return adminController;
    }

    public void setAdminController(ViewAdminController adminController) {
        this.adminController = adminController;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
