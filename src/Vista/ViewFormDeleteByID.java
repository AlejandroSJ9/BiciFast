package Vista;

import Controlador.ViewFormDeleteByIDController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFormDeleteByID {
    private ViewFormDeleteByIDController controller;

    public ViewFormDeleteByID(ViewFormDeleteByIDController c){
        this.controller = c;
    }

    public void iniciarVista(){
        JFrame frame = new JFrame("Eliminar user");
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel nombreLabel = new JLabel("Ingresa el ID:");
        JTextField id = new JTextField();

        JButton button = new JButton("Borrar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setFrame(frame);
                controller.borrarByID(Integer.parseInt(id.getText()));
            }
        });
        frame.add(nombreLabel);
        frame.add(id);
        frame.add(button);
        frame.setVisible(true);


    }

}
