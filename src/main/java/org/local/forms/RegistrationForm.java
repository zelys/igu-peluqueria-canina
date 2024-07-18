package org.local.forms;

import org.local.controller.Controller;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistrationForm extends JFrame {

    private JPanel contentPane;
    private JTextField namePetField;
    private JTextField raceField;
    private JTextField colorField;
    private JTextField ownField;
    private JTextField phoneField;
    private JTextArea obsTextArea;
    private JButton limpiarButton;
    private JButton guardarButton;
    private JCheckBox allergicCheck;
    private JCheckBox attSpecialCheck;

    private MainForm mainForm;
    private Controller controller;

    public RegistrationForm() {
        setTitle("Registro de Mascotas");
        setContentPane(contentPane);
        setResizable(false);
        pack();

        // HACER VISIBLE MainForm CUANDO SE CIERRA LA VENTANA
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainForm = new MainForm();
                // POSICIÓN de MainForm AL CERRAR VENTANA
                mainForm.setLocationRelativeTo(contentPane);
                mainForm.setVisible(true);
            }
        });


        // GUARDAR DATOS DEL FORMULARIO
        guardarButton.addActionListener(e -> {
            controller = new Controller();
            String namePet = namePetField.getText();
            String race = raceField.getText();
            String color = colorField.getText();
            Boolean allergic = allergicCheck.isSelected();
            Boolean attSpecial = attSpecialCheck.isSelected();
            String obs = obsTextArea.getText();
            String own = ownField.getText();
            String phone = phoneField.getText();

            controller.saveMascota(namePet, race, color, allergic, attSpecial, obs, own, phone);

            JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
            limpiarCampos();

        });

        // LIMPIAR CAMPOS DEL FORMULARIO
        limpiarButton.addActionListener(e -> {
            limpiarCampos();
        });
    }

    private void limpiarCampos() {
        namePetField.setText("");
        raceField.setText("");
        colorField.setText("");
        allergicCheck.setSelected(false);
        attSpecialCheck.setSelected(false);
        ownField.setText("");
        phoneField.setText("");
        obsTextArea.setText("");
    }
}
