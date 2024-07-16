package org.local.forms;

import javax.swing.*;

public class FormConsulta extends JFrame {
    private JPanel contentPane;
    private JPanel titlePane;
    private JPanel tablePane;
    private JTable table1;
    private JButton editarButton;
    private JButton borrarButton;

    public FormConsulta() {
        setTitle("Consultar registro");
        setContentPane(contentPane);
        pack();
        setVisible(true);
    }
}
