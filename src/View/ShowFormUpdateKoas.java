/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Koas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Sheren
 */
public class ShowFormUpdateKoas {

    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, lbFirstName, lbLastName, lbEmail, lbAddress, lbPhone, lbDob, lbGender, lbUniversitas;
    JTextField tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone, tfDob, tfGender, tfUniversitas;
    JButton btSubmitUpdateKoas;
    String _firstName = "", _lastName = "", _email = "", _address = "", _phone = "", _dob = "", _gender = "", _universitas = "";
    int _idKoas = 0;
    
    Controller.AdminFunctions a = new Controller.AdminFunctions();

    public ShowFormUpdateKoas(int _idKoas, String _firstName, String _lastName, String _email, String _address, String _phone, String _dob, String _gender, String _universitas) {
        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Update Data Koas");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));

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
        tfFirstName.setText(_firstName);
        tfLastName = new JTextField();
        tfLastName.setBounds(220, 100, 200, 20);
        tfLastName.setText(_lastName);
        tfEmail = new JTextField();
        tfEmail.setBounds(220, 130, 200, 20);
        tfEmail.setText(_email);
        tfAddress = new JTextField();
        tfAddress.setBounds(220, 160, 200, 20);
        tfAddress.setText(_address);
        tfPhone = new JTextField();
        tfPhone.setBounds(220, 190, 200, 20);
        tfPhone.setText(_phone);
        tfDob = new JTextField();
        tfDob.setBounds(220, 220, 200, 20);
        tfDob.setText(_dob);
        tfGender = new JTextField();
        tfGender.setBounds(220, 250, 200, 20);
        tfGender.setText(_gender);
        tfUniversitas = new JTextField();
        tfUniversitas.setBounds(220, 280, 200, 20);
        tfUniversitas.setText(_universitas);

        btSubmitUpdateKoas = new JButton("Submit");
        btSubmitUpdateKoas.setBounds(90, 400, 300, 40);
        btSubmitUpdateKoas.setBackground(Color.YELLOW);
        btSubmitUpdateKoas.setForeground(Color.black);
        btSubmitUpdateKoas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                String dob = tfDob.getText();
                Date dateDob = Date.valueOf(dob);
                String gender = tfGender.getText();
                char charGender = gender.charAt(0);
                boolean updateKoas;
                updateKoas = a.updateDataKoas(_idKoas, tfFirstName.getText(), tfLastName.getText(), tfEmail.getText(), tfAddress.getText(), tfPhone.getText(), dateDob, charGender, tfUniversitas.getText());
                if (updateKoas == true) {
                    JOptionPane.showMessageDialog(null, "Update berhasil!", "Update Data Koas", JOptionPane.INFORMATION_MESSAGE);
                    new UpdateKoasMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Update gagal!", "Update Data Koas", JOptionPane.ERROR_MESSAGE);
                    new UpdateKoasMenu();
                }
            }
        });
        
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
                panel.add(btSubmitUpdateKoas);
                frame.add(panel);

                // Init
                panel.setLayout(null);
                panel.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setLayout(null);
                frame.setVisible(true);
    }
}
