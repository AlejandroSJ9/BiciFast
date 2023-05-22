package Vista;

import Modelo.CronometroModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCronometro {
    private JFrame frame;
    private JButton startButton;
    private JButton pauseButton;
    private CronometroModel cronometro = new CronometroModel();

    public ViewCronometro(){
        frame= new JFrame("Cronometro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();

        startButton= new JButton("iniciar");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarCronometro();
            }
        });
        panel.add(startButton);

        pauseButton= new JButton("Pausar");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausarCronometro();
            }
        });

        panel.add(pauseButton);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void iniciarCronometro(){
        cronometro.iniciar();
    }

    private void pausarCronometro(){
        cronometro.pausar();
    }
}
