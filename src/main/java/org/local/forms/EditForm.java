package org.local.forms;

import org.local.controller.Controller;
import org.local.models.Mascota;

import javax.swing.*;
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

    private Mascota mascota;
    private DataForm dataForm;
    private Controller controller;

    public EditForm(Long idMascota) {
        setTitle("Modificar Registro");
        setContentPane(contentPane);
        setResizable(false);
        pack();
        loadData(idMascota);

        // HACER VISIBLE DataForm CUANDO SE CIERRA LA VENTANA
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dataForm = new DataForm();
                // POSICIÓN de DataForm AL CERRAR VENTANA
                dataForm.setLocationRelativeTo(contentPane);
                dataForm.setVisible(true);
            }
        });

        // BOTÓN CANCELAR
        cancelButton.addActionListener(e -> loadData(idMascota));

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

            controller.updateMascota(mascota, namePet, race, color, allergic, attSpecial, obs, own, phone);

            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            dispose();
            dataForm = new DataForm();
            dataForm.setLocationRelativeTo(contentPane);
            dataForm.setVisible(true);
        });
    }

    // CARGAR DATOS AL FORMULARIO
    public void loadData(Long idMascota) {
        this.controller = new Controller();
        this.mascota = controller.findMascotaById(idMascota);
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
