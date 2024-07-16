package org.local.forms;

import org.local.controller.PersistenceControl;
import org.local.models.RegistroMascota;

import javax.swing.*;

public class FormRegistro extends JFrame {

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
    private JPanel buttonPane;
    private JButton limpiarButton;
    private JButton guardarButton;

    public FormRegistro() {
        setTitle("Registro de Mascotas");
        setContentPane(contentPane);
        pack();
        setVisible(true);


        // GUARDAR DATOS DEL FORMULARIO
        guardarButton.addActionListener(e -> {
            RegistroMascota registro = new RegistroMascota();
            registro.setNombreMascota(nombreMascotaField.getText());
            registro.setRaza(razaField.getText());
            registro.setColor(colorField.getText());
            registro.setAlergico(alergicoComboBox.getSelectedItem().toString());
            registro.setAtencionEspecial(ateEspecialComboBox.getSelectedItem().toString());
            registro.setNombreDuenio(nombreDuenioField.getText());
            registro.setTelefono(telefonoField.getText());
            registro.setObservaciones(observacionesTextArea.getText());

            controller.save(registro);

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
