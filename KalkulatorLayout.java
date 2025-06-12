/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kalkulatorlayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author ACER
 */
public class KalkulatorLayout extends JFrame {
     private JTextField textField;
    private JPanel panelTombol;

    public KalkulatorLayout() {
        
        setTitle("Kalkulator Layout");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Komponen teks di atas (JTextField)
        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Panel tombol
        panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 5, 5, 5)); 

        
        String[] tombol = {
            "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0", "+", "-",
            "*", "/", "=", "%", "Mod", "Exit"
        };

        // Tambahkan tombol-tombol ke panel
        for (String teks : tombol) {
            JButton btn = new JButton(teks);
            btn.addActionListener(new TombolListener());
            panelTombol.add(btn);
        }

        add(panelTombol, BorderLayout.CENTER);
        setVisible(true);
    }

    // Listener tombol
    private class TombolListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton)e.getSource()).getText();
            if (command.equals("Exit")) {
                System.exit(0);
            } else {
                textField.setText(textField.getText() + command + " ");
            }
        }
    }

    public static void main(String[] args) {
        new KalkulatorLayout();
    }
    
}
