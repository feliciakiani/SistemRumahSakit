/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sheren
 */
public class RegistKoasMenu {
    JFrame frame;
    JPanel panel;
    
    JLabel lbThisMenu, lbFirstName, lbLastName, lbEmail, lbAddress, lbPhone, lbDob, lbGender, lbUniversitas;
    JTextField tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone, tfDob, tfGender, tfUniversitas;
    JButton btSubmitRegistKoas;
    
    Controller.AdminFunctions a = new Controller.AdminFunctions();
    
    public RegistKoasMenu(){
        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);
        
        lbThisMenu = new JLabel("Menu Registrasi Koas");
        lbThisMenu.setBounds(130, 20, 300, 40);
        lbThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        
        lbFirstName = new JLabel("First Name :");
        lbFirstName.setBounds(70, 60, 300, 40);
        lbLastName = new JLabel("Last Name:");
        lbLastName.setBounds(70, 90, 300, 40);
        lbEmail = new JLabel("Email :");
        lbEmail.setBounds(70, 120, 300, 40);
        lbAddress = new JLabel("Address :");
        lbAddress.setBounds(70, 150, 300, 40);
        lbPhone = new JLabel("Phone :");
        lbPhone.setBounds(70, 180, 300, 40);
        lbDob = new JLabel("Date of Birth :");
        lbDob.setBounds(70, 210, 300, 40);
        lbGender = new JLabel("Gender :");
        lbGender.setBounds(70, 240, 300, 40);
        lbUniversitas = new JLabel("Universitas :");
        lbUniversitas.setBounds(70, 270, 300, 40);
        
        tfFirstName = new JTextField();
        tfFirstName.setBounds(220, 70, 200, 20);
        tfLastName = new JTextField();
        tfLastName.setBounds(220, 100, 200, 20);
        tfEmail = new JTextField();
        tfEmail.setBounds(220, 130, 200, 20);
        tfAddress = new JTextField();
        tfAddress.setBounds(220, 160, 200, 20);
        tfPhone = new JTextField();
        tfPhone.setBounds(220, 190, 200, 20);
        tfDob = new JTextField();
        tfDob.setBounds(220, 220, 200, 20);
        tfGender = new JTextField();
        tfGender.setBounds(220, 250, 200, 20);
        tfUniversitas = new JTextField();
        tfUniversitas.setBounds(220, 280, 200, 20);
        
        btSubmitRegistKoas = new JButton("Submit");
        btSubmitRegistKoas.setBounds(90, 400, 300, 40);
        btSubmitRegistKoas.setBackground(Color.YELLOW);
        btSubmitRegistKoas.setForeground(Color.black);
        btSubmitRegistKoas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                String dob = tfDob.getText();
                Date dateDob = Date.valueOf(dob);
                String gender = tfGender.getText();
                char charGender = gender.charAt(0);
                boolean registKoas;
                registKoas = a.registKoas(tfFirstName.getText(), tfLastName.getText(), tfEmail.getText(), tfAddress.getText(), tfPhone.getText(), dateDob, charGender, tfUniversitas.getText());
                if(registKoas == true){
                    JOptionPane.showMessageDialog(null, "Input berhasil!", "Registrasi Koas", JOptionPane.INFORMATION_MESSAGE);
                    new AdminMainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Input gagal!", "Registrasi Koas", JOptionPane.ERROR_MESSAGE);
                    new AdminMainMenu();
                }
            }
        });
        
    // Add
        panel.add(lbThisMenu);
        panel.add(lbFirstName);
        panel.add(lbLastName);
        panel.add(lbEmail);
        panel.add(lbAddress);
        panel.add(lbPhone);
        panel.add(lbDob);
        panel.add(lbGender);
        panel.add(lbUniversitas);
        panel.add(tfFirstName);
        panel.add(tfLastName);
        panel.add(tfEmail);
        panel.add(tfAddress);
        panel.add(tfPhone);
        panel.add(tfDob);
        panel.add(tfGender);
        panel.add(tfUniversitas);
        panel.add(btSubmitRegistKoas);
        frame.add(panel);
        
    // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new RegistKoasMenu();
    }
}
