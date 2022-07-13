///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package View;
//
//import Model.Pasien;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import static java.lang.Integer.parseInt;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Properties;
//import java.util.TimeZone;
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JFormattedTextField;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;
///**
// *
// * @author User
// */
//public class UpdatePasien {
//    JFrame frame;
//    JPanel panel;
//    JLabel labelThisMenuUpdatePasien, labelFirstNamePasien, labelLastNamePasien, labelEmailPasien, labelAddressPasien, labelPhonePasien, labelDobPasien, labelGenderPasien;
//    JTextField tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone;
//    JRadioButton rbGenderM, rbGenderF;
//    Date tanggalPeriksa;
//    JDatePickerImpl datePickerTanggalPeriksa;
//    JButton btnUpdate;
//    String gender;
//    
//    Controller.Controller c = new Controller.Controller();
//    
//    public UpdatePasien() {
//        Pasien pasien = new Pasien();
//        frame = new JFrame("Menu Update Pasien");
//        frame.setSize(500, 700);
//
//        panel = new JPanel();
//        panel.setSize(500, 700);
//        panel.setBackground(Color.CYAN);
//        
//        labelThisMenuUpdatePasien = new JLabel("Menu Update Pasien");
//        labelThisMenuUpdatePasien.setBounds(90, 20, 300, 40);
//        labelThisMenuUpdatePasien.setFont(new Font("Serif", Font.BOLD, 20));
//        
//        labelFirstNamePasien = new JLabel("Silahkan pilih dokter yang diinginkan");
//        labelFirstNamePasien.setBounds(90, 60, 200, 40);
//        
//        switch (Pasien.getGender()) {
//                case "M":
//                    rbGenderM.setSelected(true);
//                    break;
//                case "F":
//                    rbGenderF.setSelected(true);
//                    break;
//            }
//            gender = pasien.getGender();
//            
//        btnUpdate = new JButton("Search");
//        btnUpdate.setBounds(200, 480, 100, 50);
//        btnUpdate.setBackground(Color.yellow);
//        btnUpdate.setFont(new Font("Serif", Font.BOLD, 20));
//        btnUpdate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if (!tfFirstName.getText().equals("") && !tfLastName.getText().equals("") && !tfEmail.getText().equals("") && !tfAddress.getText().equals("") && !tfPhone.getText().equals("") && (!rbGenderM.isSelected() || !rbGenderF.isSelected()) && tanggalPeriksa != null) {
//                    frame.setVisible(false);
//                    SimpleDateFormat formatNowDay = new SimpleDateFormat("dd");
//                    SimpleDateFormat formatNowMonth = new SimpleDateFormat("MM");
//                    SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY");
//
//                    int tglLahirDay = parseInt(formatNowDay.format(pasien.getDob()));
//                    int tglLahirMonth = parseInt(formatNowMonth.format(pasien.getDob()))-1;
//                    int tglLahirYear = parseInt(formatNowYear.format(pasien.getDob()));
//
//                    datePickerTanggalPeriksa.getModel().setDate(tglLahirYear,tglLahirMonth,tglLahirDay);
//                    datePickerTanggalPeriksa.getModel().setSelected(true);
//                    tanggalPeriksa = java.sql.Date.valueOf(pasien.getTanggalPeriksa());
//                    Pasien pasien = new Pasien(0, tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone, tanggalPeriksa, gender);
//                    c.updatePasien(pasien);
//                } else {
//                    frame.setVisible(false);
//                    JOptionPane.showMessageDialog(null, "masih ada data yang kosong", "Menu Daftar Online", JOptionPane.ERROR_MESSAGE);
//                    new LihatJadwaldanDataDokterMenu();
//                }
//            }
//        });
//    }
//}
