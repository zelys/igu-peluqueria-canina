package org.local.forms;

import org.local.controller.PersistenceControl;
import org.local.models.Duenio;
import org.local.models.Mascota;

import javax.swing.*;

public class RegistrationForm extends JFrame {

    PersistenceControl controller = new PersistenceControl();

    private JPanel contentPane;
    private JPanel titlePane;
    private JTextField nombreMascotaField;
    private JTextField razaField;
    private JTextField colorField;
    private JTextField nombreDuenioField;
    private JTextField telefonoField;
    private JTextArea observacionesTextArea;
    private JButton limpiarButton;
    private JButton guardarButton;
    private JCheckBox allergicCheck;
    private JCheckBox attSpecialCheck;

    private Mascota mascota = new Mascota();
    private Duenio duenio = new Duenio();

    public RegistrationForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Registro de Mascotas");
        setContentPane(contentPane);
        setResizable(false);
        pack();


        // GUARDAR DATOS DEL FORMULARIO
        guardarButton.addActionListener(e -> {
            mascota.setNombreMascota(nombreMascotaField.getText());
            mascota.setRaza(razaField.getText());
            mascota.setColor(colorField.getText());
            mascota.setAlergico(allergicCheck.isSelected());
            mascota.setAtencionEspecial(attSpecialCheck.isSelected());
            mascota.setObservacion(observacionesTextArea.getText());
            duenio.setNombreDuenio(nombreDuenioField.getText());
            duenio.setTelefono(telefonoField.getText());
            mascota.setDuenio(duenio);

            controller.save(mascota);

            JOptionPane.showMessageDialog(contentPane, "Registro guardado exitosamente");
        });

        // LIMPIAR CAMPOS DEL FORMULARIO
        limpiarButton.addActionListener(e -> {
            nombreMascotaField.setText("");
            razaField.setText("");
            colorField.setText("");
            allergicCheck.setSelected(false);
            attSpecialCheck.setSelected(false);
            nombreDuenioField.setText("");
            telefonoField.setText("");
            observacionesTextArea.setText("");
        });
    }
}
