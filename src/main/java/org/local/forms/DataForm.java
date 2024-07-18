package org.local.forms;

import org.local.controller.Controller;
import org.local.models.Mascota;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class DataForm extends JFrame {
    private JPanel contentPane;
    private JTable dataTable;
    private JButton editButton;
    private JButton deleteButton;

    private MainForm mainForm;
    private EditForm editForm;
    private Controller controller;

    public DataForm() {
        setTitle("Consultar registro");
        setContentPane(contentPane);
        setResizable(false);
        pack();
        loadTable();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadTable();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainForm = new MainForm();
                // POSICIÓN de MainForm AL CERRAR VENTANA
                mainForm.setLocationRelativeTo(contentPane);
                mainForm.setVisible(true);
            }
        });


        // BOTÓN BORRAR
        deleteButton.addActionListener(e -> {
            if(dataTable.getRowCount() > 0) {
                if(dataTable.getSelectedRow() != -1) {
                    Long rowId = Long.parseLong(dataTable.getModel()
                            .getValueAt(dataTable.getSelectedRow(), 0).toString());

                    controller.deleteMascota(rowId);

                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente",
                            "Ok", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un registro",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay registros para eliminar",
                        "Alert", JOptionPane.ERROR_MESSAGE);
            }
            loadTable();
        });



        // BOTÓN EDITAR
        editButton.addActionListener(e -> {
            // OBTENER ID DE LA FILA SELECCIONADA
            if(dataTable.getRowCount() > 0) {
                if(dataTable.getSelectedRow() != -1) {
                    // OBTENER ID DE LA FILA SELECCIONADA
                    Long rowId = Long.parseLong(dataTable.getModel()
                            .getValueAt(dataTable.getSelectedRow(), 0).toString());
                    // CARGAR DATOS EN EL FORMULARIO Y HACER VISIBLE
                    editForm = new EditForm(rowId);
                    editForm.setLocationRelativeTo(contentPane);
                    editForm.setVisible(true);
                    // CERRAR VENTANA DataForm
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un registro",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay registros",
                        "Alert", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


    private void loadTable() {
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // NOMBRES PARA LA CABECERA DE LA TABLA
        String[] tableHeader = {"ID", "NOMBRE", "RAZA", "COLOR", "ALÉRGICO", "AT. ESPECIAL", "DUEÑO", "TELÉFONO"};
        // ESTABLECER LOS NOMBRES DE LA CABECERA
        tableModel.setColumnIdentifiers(tableHeader);
        // TRAER REGISTROS DE LA BASE DE DATOS
        this.controller = new Controller();
        List<Mascota> listing = controller.listMascotas();

        if (listing != null) {
            for (Mascota mascota : listing) {
                Object[] row = {
                        mascota.getId(),
                        mascota.getNombreMascota(),
                        mascota.getRaza(),
                        mascota.getColor(),
                        mascota.getAlergico(),
                        mascota.getAtencionEspecial(),
                        mascota.getDuenio().getNombreDuenio(),
                        mascota.getDuenio().getTelefono()
                };
                tableModel.addRow(row);
            }
        }
        dataTable.setModel(tableModel);
    }
}
