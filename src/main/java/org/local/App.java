package org.local;

import org.local.forms.Principal;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Principal form = new Principal();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
            }
        });
    }
}
