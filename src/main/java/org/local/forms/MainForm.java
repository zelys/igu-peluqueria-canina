package org.local.forms;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {
    private JPanel contentPane;
    private JPanel titlePane;
    private JPanel imgPane;
    private JLabel imgLabel;
    private JPanel buttonPane;
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
        salirButton.addActionListener(e -> System.exit(0));

    }
}
