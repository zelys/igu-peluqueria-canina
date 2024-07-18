package org.local;

import org.local.forms.MainForm;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainForm form = new MainForm();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }
}
