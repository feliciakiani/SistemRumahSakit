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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;


public class RegistKoasMenu {
    JFrame frame;
    JPanel panel;
    
    JLabel lbThisMenu, lbFirstName, lbLastName, lbEmail, lbAddress, lbPhone, lbDob, lbGender, lbUniversitas;
    JTextField tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone, tfUniversitas;
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

        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl tglLahir = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        tglLahir.setBounds(220, 220, 200, 20);
        frame.add(tglLahir);

        JRadioButton priaBtn = new JRadioButton("Pria");
        priaBtn.setBounds(220, 250, 100, 20);
        priaBtn.setActionCommand("M");
        frame.add(priaBtn);
        JRadioButton wanitaBtn = new JRadioButton("Wanita");
        wanitaBtn.setBounds(320,250,100,20);
        wanitaBtn.setActionCommand("F");
        frame.add(wanitaBtn);
        ButtonGroup groupJK = new ButtonGroup();
        groupJK.add(priaBtn);
        groupJK.add(wanitaBtn);

        tfUniversitas = new JTextField();
        tfUniversitas.setBounds(220, 280, 200, 20);
        
        btSubmitRegistKoas = new JButton("Submit");
        btSubmitRegistKoas.setBounds(90, 400, 300, 40);
        btSubmitRegistKoas.setBackground(Color.YELLOW);
        btSubmitRegistKoas.setForeground(Color.black);
        btSubmitRegistKoas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                java.sql.Date dateDob = (java.sql.Date) tglLahir.getModel().getValue();
                if (tfPhone.getText().isEmpty() || tfAddress.getText().isEmpty() || tfEmail.getText().isEmpty() || tfLastName.getText().isEmpty() || tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfUniversitas.getText().isEmpty() || (priaBtn.isSelected() && wanitaBtn.isSelected()) || dateDob == null) {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                } else {
                    frame.setVisible(false);
                    String gender = groupJK.getSelection().getActionCommand();
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
