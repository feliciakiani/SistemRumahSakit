/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Dokter;
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
public class UpdateDokterMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihDokter, lbThisMenu, lbIdSpesialis, lbFirstName, lbLastName, lbEmail, lbAddress, lbPhone, lbDob, lbGender, lbJamMulai, lbJamSelesai;
    JTextField tfIdSpesialis, tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone, tfDob, tfGender, tfJamMulai, tfJamSelesai;
    JButton btnSearch, btSubmitUpdateDokter;
    JRadioButton[] rbListDokter;
    ButtonGroup bgListDokter;
    String _firstName = "", _lastName = "", _email = "", _address = "", _phone = "", _dob = "", _gender = "";
    int _idSpesialis = 0, _jamMulai = 0, _jamSelesai = 0;

    Controller.AdminFunctions a = new Controller.AdminFunctions();

    public UpdateDokterMenu() {

        final ArrayList<Dokter> listAllDokter = Controller.Controller.getAllDokter();
        int y = 90;

        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Update Data Dokter");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihDokter = new JLabel("Silahkan pilih dokter yang diinginkan");
        labelPilihDokter.setBounds(90, 45, 300, 40);

        rbListDokter = new JRadioButton[Controller.Controller.getAllDokter().size()];
        bgListDokter = new ButtonGroup();

        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            String name = listAllDokter.get(i).getFirstName() + " " + listAllDokter.get(i).getLastName();
            rbListDokter[i] = new JRadioButton(name);
            rbListDokter[i].setActionCommand(String.valueOf(i));
            rbListDokter[i].setBounds(90, y, 200, 40);
            rbListDokter[i].setBackground(Color.CYAN);
            y += 40;
            rbListDokter[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int index = Integer.valueOf(ae.getActionCommand());
                    _idSpesialis = listAllDokter.get(index).getIdSpesialis();
                    _firstName = listAllDokter.get(index).getFirstName();
                    _lastName = listAllDokter.get(index).getLastName();
                    _email = listAllDokter.get(index).getEmail();
                    _address = listAllDokter.get(index).getAddress();
                    _phone = listAllDokter.get(index).getPhone();
                    _gender = listAllDokter.get(index).getGender();
                    _jamMulai = listAllDokter.get(index).getJamMulaiPrak();
                    _jamSelesai = listAllDokter.get(index).getJamSelesaiPrak();

                }
            });
            bgListDokter.add(rbListDokter[i]);
        }

        btnSearch = new JButton("Search");
        btnSearch.setBounds(180, 560, 100, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!_firstName.equals("") && !_lastName.equals("")) {
                    frame.setVisible(false);
                    lbThisMenu = new JLabel("Menu Registrasi Dokter");
                    lbThisMenu.setBounds(130, 20, 300, 40);
                    lbThisMenu.setFont(new Font("Serif", Font.BOLD, 20));

                    lbIdSpesialis = new JLabel("Id Spesialis :");
                    lbIdSpesialis.setBounds(70, 60, 300, 40);
                    lbFirstName = new JLabel("First Name :");
                    lbFirstName.setBounds(70, 90, 300, 40);
                    lbLastName = new JLabel("Last Name:");
                    lbLastName.setBounds(70, 120, 300, 40);
                    lbEmail = new JLabel("Email :");
                    lbEmail.setBounds(70, 150, 300, 40);
                    lbAddress = new JLabel("Address :");
                    lbAddress.setBounds(70, 180, 300, 40);
                    lbPhone = new JLabel("Phone :");
                    lbPhone.setBounds(70, 210, 300, 40);
                    lbDob = new JLabel("Date of Birth :");
                    lbDob.setBounds(70, 240, 300, 40);
                    lbGender = new JLabel("Gender :");
                    lbGender.setBounds(70, 270, 300, 40);
                    lbJamMulai = new JLabel("Jam Mulai Praktek :");
                    lbJamMulai.setBounds(70, 300, 300, 40);
                    lbJamSelesai = new JLabel("Jam Selesai Praktek :");
                    lbJamSelesai.setBounds(70, 330, 300, 40);

                    tfIdSpesialis = new JTextField(_idSpesialis);
                    tfIdSpesialis.setBounds(220, 70, 200, 20);
                    tfFirstName = new JTextField(_firstName);
                    tfFirstName.setBounds(220, 100, 200, 20);
                    tfLastName = new JTextField();
                    tfLastName.setBounds(220, 130, 200, 20);
                    tfEmail = new JTextField();
                    tfEmail.setBounds(220, 160, 200, 20);
                    tfAddress = new JTextField();
                    tfAddress.setBounds(220, 190, 200, 20);
                    tfPhone = new JTextField();
                    tfPhone.setBounds(220, 220, 200, 20);
                    tfDob = new JTextField();
                    tfDob.setBounds(220, 250, 200, 20);
                    tfGender = new JTextField();
                    tfGender.setBounds(220, 280, 200, 20);
                    tfJamMulai = new JTextField();
                    tfJamMulai.setBounds(220, 310, 200, 20);
                    tfJamSelesai = new JTextField();
                    tfJamSelesai.setBounds(220, 340, 200, 20);

                    btSubmitUpdateDokter = new JButton("Submit");
                    btSubmitUpdateDokter.setBounds(90, 400, 300, 40);
                    btSubmitUpdateDokter.setBackground(Color.YELLOW);
                    btSubmitUpdateDokter.setForeground(Color.black);
                    btSubmitUpdateDokter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            frame.setVisible(false);
                            String idSpesialis = tfIdSpesialis.getText();
                            int intIdSpesialis = Integer.parseInt(idSpesialis);
                            String dob = tfDob.getText();
                            Date dateDob = Date.valueOf(dob);
                            String gender = tfGender.getText();
                            char charGender = gender.charAt(0);
                            String jamMulai = tfJamMulai.getText();
                            int intJamMulai = Integer.parseInt(jamMulai);
                            String jamSelesai = tfJamSelesai.getText();
                            int intJamSelesai = Integer.parseInt(jamSelesai);
                            int intPendapatan = 0;
                            boolean updateDokter;
                            updateDokter = a.updateDataDokter(intIdSpesialis, tfFirstName.getText(), tfLastName.getText(), tfEmail.getText(), tfAddress.getText(), tfPhone.getText(), dateDob, charGender, intJamMulai, intJamSelesai, intPendapatan);
                            if (updateDokter == true) {
                                JOptionPane.showMessageDialog(null, "Input berhasil!", "Update Data Dokter", JOptionPane.INFORMATION_MESSAGE);
                                new UpdateDokterMenu();
                            } else {
                                JOptionPane.showMessageDialog(null, "Input gagal!", "Update Data Dokter", JOptionPane.ERROR_MESSAGE);
                                new UpdateDokterMenu();
                            }

                        }
                    });
                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Anda belum memililh dokter", "Update Data Dokter", JOptionPane.ERROR_MESSAGE);
                    new UpdateDokterMenu();
                }
                
                panel.add(lbIdSpesialis);
        panel.add(lbFirstName);
        panel.add(lbLastName);
        panel.add(lbEmail);
        panel.add(lbAddress);
        panel.add(lbPhone);
        panel.add(lbDob);
        panel.add(lbGender);
        panel.add(lbJamMulai);
        panel.add(lbJamSelesai);
        panel.add(tfIdSpesialis);
        panel.add(tfFirstName);
        panel.add(tfLastName);
        panel.add(tfEmail);
        panel.add(tfAddress);
        panel.add(tfPhone);
        panel.add(tfDob);
        panel.add(tfGender);
        panel.add(tfJamMulai);
        panel.add(tfJamSelesai);
        panel.add(btSubmitUpdateDokter);
        frame.add(panel);

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
            }

        }
        );

        //Add
        panel.add(btnSearch);
        for (int i = 0;
                i < Controller.Controller.getAllDokter()
                        .size(); i++) {
            panel.add(rbListDokter[i]);
        }
        panel.add(labelThisMenu);
        panel.add(labelPilihDokter);
        frame.add(panel);

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateDokterMenu();
    }
}
