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
    private JComboBox alergicoComboBox;
    private JComboBox ateEspecialComboBox;
    private JTextField nombreDuenioField;
    private JTextField telefonoField;
    private JTextArea observacionesTextArea;
    private JButton limpiarButton;
    private JButton guardarButton;

    public RegistrationForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Registro de Mascotas");
        setContentPane(contentPane);
        pack();
        setVisible(true);


        // GUARDAR DATOS DEL FORMULARIO
        guardarButton.addActionListener(e -> {
            Mascota mascota = new Mascota();
            Duenio duenio = new Duenio();
            mascota.setNombreMascota(nombreMascotaField.getText());
            mascota.setRaza(razaField.getText());
            mascota.setColor(colorField.getText());
            mascota.setAlergico(alergicoComboBox.getSelectedItem().toString());
            mascota.setAtencionEspecial(ateEspecialComboBox.getSelectedItem().toString());
            mascota.setObservaciones(observacionesTextArea.getText());
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
            alergicoComboBox.setSelectedIndex(0);
            ateEspecialComboBox.setSelectedIndex(0);
            nombreDuenioField.setText("");
            telefonoField.setText("");
            observacionesTextArea.setText("");
        });
    }
}
