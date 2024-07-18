package org.local.forms;

import org.local.controller.PersistenceControl;
import org.local.models.Duenio;
import org.local.models.Mascota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditForm extends JFrame {
    private JPanel contentPane;
    private JTextField namePetField;
    private JTextField raceField;
    private JTextField colorField;
    private JCheckBox allergicCheck;
    private JCheckBox attSpecialCheck;
    private JTextField ownField;
    private JTextField phoneField;
    private JTextArea obsTextArea;
    private JButton cancelButton;
    private JButton saveButton;
    private JPanel titlePane;

    private PersistenceControl control = new PersistenceControl();
    Mascota mascota = new Mascota();
    Duenio duenio = new Duenio();
    private Long rowId;

    public EditForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Modificar Registro");
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadData(rowId);
            }
        });

        // BOTÓN CANCELAR
        cancelButton.addActionListener(e -> loadData(rowId));

        // BOTÓN GUARDAR
        saveButton.addActionListener(e -> {
            String namePet = namePetField.getText();
            String race = raceField.getText();
            String color = colorField.getText();
            Boolean allergic = allergicCheck.isSelected();
            Boolean attSpecial = attSpecialCheck.isSelected();
            String obs = obsTextArea.getText();
            String own = ownField.getText();
            String phone = phoneField.getText();

            control.updateMascota(namePet, race, color, allergic, attSpecial, obs, own, phone);
            JOptionPane.showMessageDialog(contentPane, "Registro actualizado exitosamente");
        });
    }

    // CARGAR DATOS AL FORMULARIO
    public void loadData(Long rowId) {
        this.rowId = rowId;
        mascota = control.getMascota(rowId);
        namePetField.setText(mascota.getNombreMascota());
        raceField.setText(mascota.getRaza());
        colorField.setText(mascota.getColor());
        allergicCheck.setSelected(mascota.getAlergico());
        attSpecialCheck.setSelected(mascota.getAtencionEspecial());
        ownField.setText(mascota.getDuenio().getNombreDuenio());
        phoneField.setText(mascota.getDuenio().getTelefono());
        obsTextArea.setText(mascota.getObservacion());
    }
}
