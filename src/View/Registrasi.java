package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jasypt.util.password.BasicPasswordEncryptor;
import Model.Pasien;
import Controller.Controller;
import java.util.HashMap;

public class Registrasi extends JFrame {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    JFrame f;
    public Registrasi() {
        Controller controller = new Controller();

        JLabel lblJudul = new JLabel("Masukkan Data Registrasi");
        lblJudul.setBounds(100, 10, 300, 25);
        add(lblJudul);

        JLabel lblFName = new JLabel("First Name");
        lblFName.setBounds(100, 50, 100,25);
        add(lblFName);

        JTextField textFName = new JTextField(16);
        textFName.setBounds(200, 50, 200, 25);
        add(textFName);

        JLabel lblLName = new JLabel("Last Name");
        lblLName.setBounds(100, 80, 100,25);
        add(lblLName);

        JTextField textLName = new JTextField(16);
        textLName.setBounds(200, 80, 200, 25);
        add(textLName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(100, 110, 100,25);
        add(lblEmail);

        JTextField textEmail = new JTextField(16);
        textEmail.setBounds(200, 110, 200, 25);
        add(textEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(100, 140, 100,25);
        add(lblPassword);

        JPasswordField textPassword = new JPasswordField(16);
        textPassword.setBounds(200, 140, 200, 25);
        add(textPassword);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(125, 200, 100, 25);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.white);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(textPassword.getPassword());
                if (textEmail.getText().isEmpty() || password.isEmpty() || textFName.getText().isEmpty() || textLName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ada Data Kosong!");
                } else {
                    if (Controller.getEmailPasswordPair().get(textEmail.getText()) != null) {
                        JOptionPane.showMessageDialog(null, "Email Sudah Digunakan!");
                    } else {
                        password = passwordEncryptor.encryptPassword(password);
                        Pasien pasien = new Pasien(textFName.getText(), textLName.getText(), textEmail.getText(), password);
                        boolean sukses = controller.insertPasien(pasien);
                        if (sukses) {
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                            dispose();
                            new Login();
                        } else {
                            JOptionPane.showMessageDialog(null, "Registrasi Gagal");
                            dispose();
                            new Registrasi();
                        }
                    }
                }
            }
        });
        add(btnSubmit);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(275, 200, 100, 25);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.white);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new Login();
            }
        });
        add(btnLogin);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setTitle("Registrasi Pasien");
        setSize(500, 325);

    }

}