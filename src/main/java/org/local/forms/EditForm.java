package org.local.forms;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditForm extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JCheckBox siCheckBox;
    private JCheckBox siCheckBox1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextArea textArea1;
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel titlePane;

    public EditForm() {
        setTitle("Modificar Registro");
        setContentPane(contentPane);
        pack();
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadData();
            }
        });
    }

    private void loadData() {

    }
}
