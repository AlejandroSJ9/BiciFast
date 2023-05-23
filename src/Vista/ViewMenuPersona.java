package Vista;

import Controlador.ViewFormBicicletaController;
import Controlador.ViewMainController;
import Controlador.ViewMenuPersonaController;
import Modelo.BicicletaModel;
import Modelo.PersonaModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ViewMenuPersona {

    private JFrame frame;
    private JTextArea textArea;
    private ViewMenuPersonaController controller;
    //private ArrayList<BicicletaModel> bicicletas = controller.getDataBase().getBicicletasDePersona(controller.getPersonaModel());
    private BicicletaModel bicicletaSeleccionada;
    private JTable tablaBicicletas;
    public ViewMenuPersona(ViewMenuPersonaController controller) {
        this.controller = controller;
    }
    public ViewMenuPersona(){}

    public void iniciarVista(){
        frame = new JFrame("Bicifast - " + controller.getPersonaModel().getNombre());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1)); // Cambiamos a GridLayout

        JLabel titleLabel = new JLabel("<html><h2>MENU PRINCIPAL</h2></html>");
        panel.add(titleLabel);

        String text = "<html><h3>" + controller.getPersonaModel().getNombre() + "</h3></html>";
        JLabel h3 = new JLabel(text);
        panel.add(h3);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Marca");
        tableModel.addColumn("ID");
        tableModel.addColumn("Color");

        tablaBicicletas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tablaBicicletas);
        panel.add(scrollPane);

        frame.add(panel, BorderLayout.CENTER);

        ArrayList<BicicletaModel> bicicletas = controller.getDataBase().getBicicletasDePersona(controller.getPersonaModel());
        for (BicicletaModel bicicleta : bicicletas) {
            Object[] rowData = { bicicleta.getMarca(), bicicleta.getUnique_id(), bicicleta.getColor() };
            tableModel.addRow(rowData);
        }
        // Añadir un MouseListener a la tabla de bicicletas
        tablaBicicletas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener la fila seleccionada
                    int filaSeleccionada = tablaBicicletas.getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        bicicletaSeleccionada = bicicletas.get(filaSeleccionada);

                        // Llamar al método del controlador para gestionar la bicicleta seleccionada
                        controller.gestionarBicicletaSeleccionada(bicicletaSeleccionada);
                    }
                }
            }
        });
        controller.actualizarTablaBicicletas(bicicletas);
        // Botón para agregar bicicleta
        JButton agregarBicicletaButton = new JButton("Agregar Bicicleta");
        agregarBicicletaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actualizarTablaBicicletas(bicicletas);
                ViewFormBicicleta viewFormBicicleta = new ViewFormBicicleta();
                ViewFormBicicletaController bicicletaController = new ViewFormBicicletaController(viewFormBicicleta, controller.getDataBase(), controller.getPersonaModel());
                viewFormBicicleta.setController(bicicletaController);
                bicicletaController.iniciarVista();
                controller.actualizarTablaBicicletas(bicicletas);
            }
        });
        panel.add(agregarBicicletaButton);

        // Botón para eliminar bicicleta
        JButton eliminarBicicletaButton = new JButton("Eliminar Bicicleta");
        eliminarBicicletaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actualizarTablaBicicletas(bicicletas);
                controller.eliminarBicicleta(bicicletaSeleccionada);
                controller.actualizarTablaBicicletas(bicicletas);
            }
        });
        panel.add(eliminarBicicletaButton);

        // Botón para actualizar bicicleta
        JButton actualizarBicicletaButton = new JButton("Actualizar Bicicleta");
        actualizarBicicletaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para actualizar una bicicleta
                // Puedes abrir un formulario de edición o realizar las acciones necesarias según tu diseño
            }
        });
        panel.add(actualizarBicicletaButton);



        frame.setVisible(true);
    }

    public JTable getTablaBicicletas () {
        return tablaBicicletas;
    }

    public void setTablaBicicletas (JTable tablaBicicletas) {
        this.tablaBicicletas = tablaBicicletas;
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
