package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jasypt.util.password.BasicPasswordEncryptor;

import Model.ActiveUserID;
import Model.Pasien;
import Controller.Controller;
import java.util.HashMap;

public class Login extends JFrame {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    JFrame f;
    public Login() {
        Controller controller = new Controller();

        JLabel lblJudul = new JLabel("Selamat Datang di RS ITHB !");
        lblJudul.setBounds(100, 30, 300, 25);
        add(lblJudul);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(100, 80, 100,25);
        add(lblEmail);

        JTextField textEmail = new JTextField(16);
        textEmail.setBounds(200, 80, 200, 25);
        add(textEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(100, 110, 100,25);
        add(lblPassword);

        JPasswordField textPassword = new JPasswordField(16);
        textPassword.setBounds(200, 110, 200, 25);
        add(textPassword);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(125, 150, 100, 25);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.white);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(textPassword.getPassword());
                if (textEmail.getText().isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ada Data Kosong!");
                } else {
                    if (controller.getEmailPasswordPair().get(textEmail.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "Email Tidak Ditemukan!");
                    } else {
                        if (passwordEncryptor.checkPassword(password, controller.getEmailPasswordPair().get(textEmail.getText()))) {
                            int id = controller.getIdByEmail(textEmail.getText());
                            ActiveUserID idPasien = ActiveUserID.ActiveUserID();
                            idPasien.setUserID(id);
                            JOptionPane.showMessageDialog(null, "Berhasil Login!");
                            dispose();
                            new PasienMainMenu();
                        } else {
                            JOptionPane.showMessageDialog(null, "Password Salah!");
                        }
                    }
                }
            }
        });
        add(btnSubmit);

        JButton btnRegistrasi = new JButton("Registrasi");
        btnRegistrasi.setBounds(275, 150, 100, 25);
        btnRegistrasi.setBackground(Color.BLACK);
        btnRegistrasi.setForeground(Color.white);
        btnRegistrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new Registrasi();
            }
        });
        add(btnRegistrasi);

        JButton btnLoginStaff = new JButton("Login Untuk Staff");
        btnLoginStaff.setBounds(125, 200, 250, 25);
        btnLoginStaff.setBackground(Color.BLACK);
        btnLoginStaff.setForeground(Color.white);
        btnLoginStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new LoginStaff();
            }
        });
        add(btnLoginStaff);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setTitle("Login");
        setSize(500, 325);

    }

    public static void main(String[] args) {
        new Login();
    }
}