package Vista;

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
    private ViewFormPersonaController personaModelController;



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
                if (personaModelController.validarDatosPersona()) {
                    JOptionPane.showMessageDialog(frame,"Registro Exitoso");
                    frame.setVisible(false);
                }

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
}
