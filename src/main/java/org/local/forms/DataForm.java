package org.local.forms;

import org.local.controller.PersistenceControl;
import org.local.models.Mascota;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class DataForm extends JFrame {
    private JPanel contentPane;
    private JPanel tablePane;
    private JTable dataTable;
    private JButton editButton;
    private JButton deleteButton;

    private PersistenceControl control = new PersistenceControl();
    private EditForm editForm = new EditForm();

    public DataForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Consultar registro");
        setContentPane(contentPane);
        setResizable(false);
        pack();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadTable();
            }
        });


        // BOTÓN BORRAR
        deleteButton.addActionListener(e -> {
            if(dataTable.getRowCount() > 0) {
                if(dataTable.getSelectedRow() != -1) {
                    Long rowId = Long.parseLong(dataTable.getModel()
                            .getValueAt(dataTable.getSelectedRow(), 0).toString());

                    control.remove(rowId);

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
                    editForm.loadData(rowId);
                    editForm.setVisible(true);
                    editForm.setLocationRelativeTo(contentPane);
                    // OCULTAR VENTANA DataForm
                    dispose();
                    // HACER VISIBLE DataForm CUANDO SE CIERRA LA VENTANA
                    editForm.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            setVisible(true);
                            setLocationRelativeTo(editForm);
                        }
                    });


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
        List<Mascota> recordsList = control.getDataList();

        if (recordsList != null) {
            for (Mascota d : recordsList) {
                Object[] row = {
                        d.getId(),
                        d.getNombreMascota(),
                        d.getRaza(),
                        d.getColor(),
                        d.getAlergico(),
                        d.getAtencionEspecial(),
                        d.getDuenio().getNombreDuenio(),
                        d.getDuenio().getTelefono()
                };
                tableModel.addRow(row);
            }
        }
        dataTable.setModel(tableModel);
    }
}
