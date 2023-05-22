package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenuPersona {

    private JFrame frame;
    private JTextArea textArea;

    public void vista(){
        frame = new JFrame("Bicifast - usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2));

        JLabel titleLabel = new JLabel("<html><h2>MENU PRINCIPAL</h2></html>");
        panel.add(titleLabel);

        textArea= new JTextArea(10,20);
        textArea.setEditable(false);
        JButton registrarBiciButton = new JButton("Registrar Bicicleta");
       registrarBiciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel.add(registrarBiciButton);

        JButton bicicletasButton = new JButton("Bicicletas");
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

        JButton rutasButton= new JButton("Rutas");
        rutasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
