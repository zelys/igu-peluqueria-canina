package org.local.forms;

import org.local.controller.Controller;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {
    private JPanel contentPane;
    private JButton btnRegistroMascota;
    private JButton btnConsultaRegistro;
    private JButton salirButton;

    private DataForm dataForm;
    private RegistrationForm registrationForm;

    public MainForm() {
        setTitle("Peluquería Canina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeController();
            }
        });

        // BOTÓN REGISTRAR MASCOTA
        btnRegistroMascota.addActionListener(e -> {
            registrationForm = new RegistrationForm();
            // POSICIÓN AL ABRIR VENTANA
            registrationForm.setLocationRelativeTo(contentPane);
            registrationForm.setVisible(true);
            // OCULTAR VENTANA MainForm
            dispose();
        });

        // BOTÓN VER REGISTROS
        btnConsultaRegistro.addActionListener(e -> {
            dataForm = new DataForm();
            // POSICIÓN AL ABRIR VENTANA DataForm
            dataForm.setLocationRelativeTo(contentPane);
            dataForm.setVisible(true);
            // OCULTAR VENTANA MainForm
            dispose();
        });

        // FUNCIÓN BOTÓN SALIR
        salirButton.addActionListener(e -> {
            closeController();
            System.exit(0);
        });
    }

    public void closeController() {
        Controller controller = new Controller();
        controller.close();
    }
}
