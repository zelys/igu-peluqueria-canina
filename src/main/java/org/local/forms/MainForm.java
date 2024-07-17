package org.local.forms;

import javax.swing.*;

public class MainForm extends JFrame {
    private JPanel contentPane;
    private JLabel imgLabel;
    private JPanel titlePane;
    private JPanel buttonPane;
    private JPanel imgPane;
    private JButton btnRegistroMascota;
    private JButton btnConsultaRegistro;
    private JButton salirButton;

    public MainForm() {
        setTitle("Peluquería Canina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setResizable(false);
        pack();

        setVisible(true);


        // FUNCIÓN BOTÓN REGISTRAR MASCOTA
        btnRegistroMascota.addActionListener(e -> {
            RegistrationForm registrationForm = new RegistrationForm();
            registrationForm.setVisible(true);
            registrationForm.setLocationRelativeTo(null);
        });

        // FUNCIÓN BOTÓN VER REGISTROS
        btnConsultaRegistro.addActionListener(e -> {
            DataForm dataForm = new DataForm();
            dataForm.setVisible(true);
            dataForm.setLocationRelativeTo(null);
        });

        // FUNCIÓN BOTÓN SALIR
        salirButton.addActionListener(e -> System.exit(0));
    }
}
