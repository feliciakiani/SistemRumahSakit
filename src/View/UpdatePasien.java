/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ActiveUserID;
import Model.Pasien;
import Model.UserTypeEnum;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
/**
 *
 * @author User
 */
public class UpdatePasien {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenuUpdatePasien, labelJudul, labelFirstNamePasien, labelLastNamePasien, labelEmailPasien, labelPasswordPasien, labelAddressPasien, labelPhonePasien, labelDobPasien, labelGenderPasien;
    JTextField tfFirstName, tfLastName, tfEmail, tfPassword, tfAddress, tfPhone;
    JRadioButton rbGenderM, rbGenderF;
    LocalDate tanggalLahir;
    Date tanggalLahirSQL;
    JDatePickerImpl datePickerTanggalLahir;
    JButton btnUpdate;
    char gender;
    
    Controller.Controller c = new Controller.Controller();
    
    public UpdatePasien() {
        Pasien pasien = new Pasien();
        ActiveUserID idPasien = ActiveUserID.ActiveUserID();
        frame = new JFrame("Menu Update Pasien");
        frame.setSize(500, 480);

        panel = new JPanel();
        panel.setSize(500, 480);
        panel.setBackground(Color.CYAN);
        
        labelThisMenuUpdatePasien = new JLabel("Menu Update Pasien");
        labelThisMenuUpdatePasien.setBounds(90, 20, 300, 40);
        labelThisMenuUpdatePasien.setFont(new Font("Serif", Font.BOLD, 20));
        
        labelJudul = new JLabel("Silahkan memasukkan update data yang diinginkan");
        labelJudul.setBounds(90, 50, 300, 40);
        
        labelFirstNamePasien = new JLabel("First Name Pasien: ");
        labelFirstNamePasien.setBounds(60, 100, 200, 25);
        tfFirstName = new JTextField();
        tfFirstName.setBounds(200, 100, 200, 25);
        
        labelLastNamePasien = new JLabel("Last Name Pasien: ");
        labelLastNamePasien.setBounds(60, 130, 200, 25);
        tfLastName = new JTextField();
        tfLastName.setBounds(200, 130, 200, 25);
        
        labelEmailPasien = new JLabel("Email Pasien: ");
        labelEmailPasien.setBounds(60, 160, 200, 25);
        tfEmail = new JTextField();
        tfEmail.setBounds(200, 160, 200, 25);
        
        labelAddressPasien = new JLabel("Address Pasien: ");
        labelAddressPasien.setBounds(60, 190, 200, 25);
        tfAddress = new JTextField();
        tfAddress.setBounds(200, 190, 200, 25);
        
        labelPhonePasien = new JLabel("Phone Pasien: ");
        labelPhonePasien.setBounds(60, 220, 200, 25);
        tfPhone = new JTextField();
        tfPhone.setBounds(200, 220, 200, 25);
        
        labelDobPasien = new JLabel("Tanggal Lahir: ");
        labelDobPasien.setBounds(60, 250, 200, 25);
        UtilDateModel dateModel = new UtilDateModel();
        Properties pe = new Properties();
        pe.put("text.today", "Today");
        pe.put("text.month", "Month");
        pe.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, pe);
        datePickerTanggalLahir = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerTanggalLahir.setBounds(200, 250, 200, 25);
        datePickerTanggalLahir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tanggalLahirSQL = (Date) datePickerTanggalLahir.getModel().getValue();
            }
        });
        
        labelGenderPasien = new JLabel("Gender Pasien: ");
        labelGenderPasien.setBounds(60, 280, 200, 25);
        rbGenderM = new JRadioButton("M");
        rbGenderM.setBounds(200, 280, 50, 25);
        rbGenderM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = rbGenderM.getText().charAt(0);
            }
        });
        rbGenderF = new JRadioButton("F");
        rbGenderF.setBounds(250, 280, 150, 25);
        rbGenderF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = rbGenderF.getText().charAt(0);
            }
        });
        
        switch (pasien.getGender()) {
            case "M":
                rbGenderM.setSelected(true);
                break;
            case "F":
                rbGenderF.setSelected(true);
                break;
            }
        gender = pasien.getGender().charAt(0);
            
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(190, 350, 100, 35);
        btnUpdate.setBackground(Color.yellow);
        btnUpdate.setFont(new Font("Serif", Font.BOLD, 20));
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!tfFirstName.getText().equals("") && !tfLastName.getText().equals("") && !tfEmail.getText().equals("") && !tfAddress.getText().equals("") && !tfPhone.getText().equals("") && (!rbGenderM.isSelected() || !rbGenderF.isSelected())) {
                    tanggalLahir = new java.sql.Date( tanggalLahirSQL.getTime() ).toLocalDate();
                    java.sql.Date tanggalLahirSQL = java.sql.Date.valueOf(tanggalLahir);
                    if (tanggalLahir != null) {
                        frame.setVisible(false);
                        c.updatePasien(idPasien.getUserID(), tfFirstName.getText(), tfLastName.getText(), tfEmail.getText(), tfAddress.getText(), tfPhone.getText(), tanggalLahirSQL, gender);
                        JOptionPane.showMessageDialog(null, "pasien berhasil terupdate", "Menu Update Pasien", JOptionPane.INFORMATION_MESSAGE);
                        new PasienMainMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "tanggal lahir kosong", "Menu Update Pasien", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "masih ada data yang kosong", "Menu Update Pasien", JOptionPane.ERROR_MESSAGE);
                    new UpdatePasien();
                }
            }
        });
        
        panel.add(labelThisMenuUpdatePasien);
        panel.add(labelJudul);
        panel.add(labelFirstNamePasien);
        panel.add(tfFirstName);
        panel.add(labelLastNamePasien);
        panel.add(tfLastName);
        panel.add(labelLastNamePasien);
        panel.add(tfLastName);
        panel.add(labelEmailPasien);
        panel.add(tfEmail);
        panel.add(labelAddressPasien);
        panel.add(tfAddress);
        panel.add(labelPhonePasien);
        panel.add(tfPhone);
        panel.add(labelDobPasien);
        panel.add(datePickerTanggalLahir);
        panel.add(labelGenderPasien);
        panel.add(rbGenderM);
        panel.add(rbGenderF);
        panel.add(btnUpdate);
        frame.add(panel);
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        public DateLabelFormatter() {
            TimeZone zone = TimeZone.getTimeZone("GMT");
            dateFormatter.setTimeZone(zone);
        }
        
        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }
        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                TimeZone zone = TimeZone.getTimeZone("GMT");
                cal.setTimeZone(zone);
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }

}
