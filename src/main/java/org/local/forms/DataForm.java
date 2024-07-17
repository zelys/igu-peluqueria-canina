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

    public DataForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Consultar registro");
        setContentPane(contentPane);
        pack();
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadTable();
            }
        });


        deleteButton.addActionListener(e -> {
            if(dataTable.getRowCount() > 0) {
                if(dataTable.getSelectedRow() != -1) {
                    Long row = Long.parseLong(dataTable.getModel()
                            .getValueAt(dataTable.getSelectedRow(), 0).toString());

                    control.remove(row);

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
    }


    private void loadTable() {

        DefaultTableModel tableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] tableHeader = {"ID", "NOMBRE", "RAZA", "COLOR", "ALÉRGICO", "AT. ESPECIAL", "DUEÑO", "TELÉFONO"};

        tableModel.setColumnIdentifiers(tableHeader);

        // TRAER REGISTROS DE LA BASE DE DATOS
        List<Mascota> recordsList = control.getDatos();

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
