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

    private DataForm dataForm = new DataForm();
    private RegistrationForm registrationForm = new RegistrationForm();

    public MainForm() {
        setTitle("Peluquería Canina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setResizable(false);
        pack();


        // BOTÓN REGISTRAR MASCOTA
        btnRegistroMascota.addActionListener(e -> {
            registrationForm.setVisible(true);
            // POSICIÓN AL ABRIR VENTANA
            registrationForm.setLocationRelativeTo(contentPane);
            // OCULTAR VENTANA MainForm
            dispose();
            // HACER VISIBLE MainForm CUANDO SE CIERRA LA VENTANA
            registrationForm.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(true);
                    // POSICIÓN AL CERRAR VENTANA registrationForm
                    setLocationRelativeTo(registrationForm);
                }
            });
        });

        // BOTÓN VER REGISTROS
        btnConsultaRegistro.addActionListener(e -> {
            dataForm.setVisible(true);
            // POSICIÓN AL ABRIR VENTANA DataForm
            dataForm.setLocationRelativeTo(contentPane);
            // OCULTAR VENTANA MainForm
            dispose();
            // HACER VISIBLE MainForm CUANDO SE CIERRA LA VENTANA
            dataForm.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(true);
                    // POSICIÓN AL CERRAR VENTANA DataForm
                    setLocationRelativeTo(dataForm);
                }
            });
        });

        // FUNCIÓN BOTÓN SALIR
        salirButton.addActionListener(e -> System.exit(0));

    }
}
