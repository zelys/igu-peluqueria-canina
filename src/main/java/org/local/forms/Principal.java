package org.local.forms;

import javax.swing.*;

public class Principal extends JFrame {
    private JPanel contentPane;
    private JLabel imgLabel;
    private JPanel titlePane;
    private JPanel buttonPane;
    private JPanel imgPane;
    private JButton btnRegistroMascota;
    private JButton btnConsultaRegistro;
    private JButton salirButton;

    public Principal() {
        setTitle("Peluquería Canina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setResizable(false);
        pack();

        setVisible(true);


        // FUNCIÓN BOTÓN REGISTRAR MASCOTA
        btnRegistroMascota.addActionListener(e -> {
            FormRegistro formRegistro = new FormRegistro();
            formRegistro.setVisible(true);
            formRegistro.setLocationRelativeTo(null);
            formRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });

        // FUNCIÓN BOTÓN VER REGISTROS
        btnConsultaRegistro.addActionListener(e -> {
            FormConsulta formConsulta = new FormConsulta();
            formConsulta.setVisible(true);
            formConsulta.setLocationRelativeTo(null);
            formConsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });

        // FUNCIÓN BOTÓN SALIR
        salirButton.addActionListener(e -> System.exit(0));
    }
}
