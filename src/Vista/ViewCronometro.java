package Vista;

import Controlador.ViewCronometroController;
import Modelo.CronometroModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCronometro {
    private JFrame frame;
    private JButton startButton;
    private JButton pauseButton;

    private JButton finalizeButton;
    private ViewCronometroController cronometroController;
    private boolean enPausa;

    private CronometroModel cronometro = new CronometroModel();


    public ViewCronometro() {
        frame = new JFrame("Cronometro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        startButton = new JButton("iniciar");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometroController.iniciarCronometro();
            }
        });
        panel.add(startButton);

        pauseButton = new JButton("Pausar");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enPausa) {
                    cronometroController.reanudarCronometro();
                } else {
                    cronometroController.pausarCronometro();
                }
            }
        });
        panel.add(pauseButton);

        finalizeButton = new JButton("Finalizar");
        finalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometroController.finalizarCronometro();
            }
        });
        panel.add(finalizeButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public void setEnPausa(boolean enPausa) {
        this.enPausa = enPausa;
        if (enPausa) {
            pauseButton.setText("Reanudar");
        } else {
            pauseButton.setText("Pausar");
        }
    }
}
