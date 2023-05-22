package Vista;

import Controlador.ViewMenuPersonaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenuPersona {

    private JFrame frame;
    private JTextArea textArea;
    private ViewMenuPersonaController controller;

    public ViewMenuPersona(ViewMenuPersonaController controller) {
        this.controller = controller;
    }
    public ViewMenuPersona(){}

    public void iniciarVista(){
        frame = new JFrame("Bicifast - " + controller.getPersonaModel().getNombre());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2));

        JLabel titleLabel = new JLabel("<html><h2>MENU PRINCIPAL</h2></html>");
        panel.add(titleLabel);
        String text = "<html><h3>"+ controller.getPersonaModel().getNombre() +"</h3></html>";
        JLabel h3 = new JLabel(text);
        panel.add(h3);
        textArea= new JTextArea(10,20);
        textArea.setEditable(false);
       JButton registrarBiciButton = new JButton("Registrar Bicicleta");
       registrarBiciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

       panel.add(registrarBiciButton);

        JButton bicicletasButton = new JButton("Ver Bicicletas");
        bicicletasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel.add(bicicletasButton);

        JButton actualizarBiciButton= new JButton("Actualizar bicicleta");
        actualizarBiciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel.add(actualizarBiciButton);

        JButton rutasButton= new JButton("Agregar tiempo en Rutas");
        rutasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        frame.add(panel);
        frame.setVisible(true);


    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public ViewMenuPersonaController getController() {
        return controller;
    }

    public void setController(ViewMenuPersonaController controller) {
        this.controller = controller;
    }
}
