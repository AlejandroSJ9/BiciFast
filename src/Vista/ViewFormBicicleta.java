package Vista;

import Controlador.ViewFormBicicletaController;
import Controlador.ViewFormPersonaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFormBicicleta {
    private JFrame frame;
    private JTextField marcaTF;
    private JTextField idTF;
    private JTextField coloTF;
    private ViewFormBicicletaController controller;

    public ViewFormBicicleta (ViewFormBicicletaController controller) {
        this.controller = controller;
    }

    public ViewFormBicicleta(){

    }

    public void iniciarVista(){
        frame = new JFrame("Registrar Bicicleta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel nombreLabel = new JLabel("Marca:");
        marcaTF = new JTextField();

        JLabel apellidoLabel = new JLabel("Id:");
        idTF = new JTextField();

        JLabel documentoLabel = new JLabel("Color");
        coloTF = new JTextField();

        frame.add(nombreLabel);
        frame.add(marcaTF);

        frame.add(apellidoLabel);
        frame.add(idTF);

        frame.add(documentoLabel);
        frame.add(coloTF);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.agregarBicicleta();
            }
        });
        frame.add(registrarButton);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getMarcaTF() {
        return marcaTF;
    }

    public JTextField getIdTF() {
        return idTF;
    }

    public JTextField getColoTF() {
        return coloTF;
    }

    public ViewFormBicicletaController getController() {
        return controller;
    }

    public void setController(ViewFormBicicletaController controller) {
        this.controller = controller;
    }
}
