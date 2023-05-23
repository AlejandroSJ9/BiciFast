package Vista;

import Controlador.ViewUpdateBikeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUpdateBike {
    private ViewUpdateBikeController controller;
    private JTextField marca;
    private JTextField color;
    private JTextField id;
    private JFrame frame;
    private JButton buttonUpdate;

    public ViewUpdateBike(ViewUpdateBikeController controller) {
        this.controller = controller;
    }

    public ViewUpdateBike(){}
    public void iniciarVista() {
        frame = new JFrame("Actualizar Usuario");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nombreLabel = new JLabel("Marca:");
        marca = new JTextField(20);

        JLabel idLabel = new JLabel("Id:");
        id = new JTextField(20);

        JLabel colorLabel = new JLabel("Color:");
        color = new JTextField(20);

        buttonUpdate = new JButton("Actualizar");
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método del controlador para actualizar la bicicleta
                controller.setTextOnTextField(controller.getBikeToUpdate());
                controller.actualizarBicicleta();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(nombreLabel, gbc);

        gbc.gridy = 1;
        frame.add(idLabel, gbc);

        gbc.gridy = 2;
        frame.add(colorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(marca, gbc);

        gbc.gridy = 1;
        frame.add(id, gbc);

        gbc.gridy = 2;
        frame.add(color, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonUpdate, gbc);

        frame.setVisible(true);
    }

    public ViewUpdateBikeController getController() {
        return controller;
    }

    public void setController(ViewUpdateBikeController controller) {
        this.controller = controller;
    }

    public JTextField getMarca() {
        return marca;
    }

    public void setMarca(JTextField marca) {
        this.marca = marca;
    }

    public JTextField getColor() {
        return color;
    }

    public void setColor(JTextField color) {
        this.color = color;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public void setButtonUpdate(JButton buttonUpdate) {
        this.buttonUpdate = buttonUpdate;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }
}
