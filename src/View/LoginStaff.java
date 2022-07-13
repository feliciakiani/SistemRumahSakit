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

public class LoginStaff extends JFrame {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    JFrame f;
    public LoginStaff() {
        Controller controller = new Controller();

        JLabel lblJudul = new JLabel("Selamat Datang di Halaman Login Staff RS ITHB !");
        lblJudul.setBounds(100, 30, 300, 25);
        add(lblJudul);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(100, 80, 100,25);
        add(lblUsername);

        JTextField textUsername = new JTextField(16);
        textUsername.setBounds(200, 80, 200, 25);
        add(textUsername);

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
                if (textUsername.getText().isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ada Data Kosong!");
                } else {
                    if (controller.getUsernamePasswordPair().get(textUsername.getText()) == password) {
                        int id = controller.getIdByUsername(textUsername.getText());
                        ActiveUserID activeID = ActiveUserID.ActiveUserID();
                        activeID.setUserID(id);
                        JOptionPane.showMessageDialog(null, "Berhasil Login!");
                        dispose();
                        if (controller.getRoleById(activeID.getUserID()) == "MANAGER") {
                            new ManagerMainMenu();
                        } else if (controller.getRoleById(activeID.getUserID()) == "ADMIN") {
                            // new admin main menu
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Informasi Login Tidak Sesuai!");
                    }
                }
            }
        });
        add(btnSubmit);

        JButton btnLogin = new JButton("Login User");
        btnLogin.setBounds(275, 150, 100, 25);
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
        setTitle("Login Staff");
        setSize(500, 325);

    }

    public static void main(String[] args) {
        new LoginStaff();
    }
}