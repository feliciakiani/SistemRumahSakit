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
public class UpdateKoasMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihKoas, lbThisMenu;
    JButton btnSearch;
    JRadioButton[] rbListKoas;
    ButtonGroup bgListKoas;
    String _firstName = "", _lastName = "", _email = "", _address = "", _phone = "", _dob = "", _gender = "", _universitas = "";
    int _idKoas = 0;
    
    Controller.AdminFunctions a = new Controller.AdminFunctions();

    public UpdateKoasMenu() {
        final ArrayList<Koas> listAllKoas = Controller.Controller.getAllKoas();
        int y = 90;

        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Update Data Koas");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihKoas = new JLabel("Silahkan pilih koas yang diinginkan");
        labelPilihKoas.setBounds(90, 45, 300, 40);

        rbListKoas = new JRadioButton[Controller.Controller.getAllKoas().size()];
        bgListKoas = new ButtonGroup();

        for (int i = 0; i < Controller.Controller.getAllKoas().size(); i++) {
            String name = listAllKoas.get(i).getFirstName() + " " + listAllKoas.get(i).getLastName();
            rbListKoas[i] = new JRadioButton(name);
            rbListKoas[i].setActionCommand(String.valueOf(i));
            rbListKoas[i].setBounds(90, y, 200, 40);
            rbListKoas[i].setBackground(Color.CYAN);
            y += 40;
            rbListKoas[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int index = Integer.valueOf(ae.getActionCommand());
                    _idKoas = listAllKoas.get(index).getIdKoas();
                    _firstName = listAllKoas.get(index).getFirstName();
                    _lastName = listAllKoas.get(index).getLastName();
                    _email = listAllKoas.get(index).getEmail();
                    _address = listAllKoas.get(index).getAddress();
                    _phone = listAllKoas.get(index).getPhone();
                    _dob = String.valueOf(listAllKoas.get(index).getDob());
                    _gender = listAllKoas.get(index).getGender();
                    _universitas = listAllKoas.get(index).getUniversitas();

                }
            });
            bgListKoas.add(rbListKoas[i]);
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
                    new ShowFormUpdateKoas(_idKoas, _firstName, _lastName, _email, _address, _phone, _dob, _gender, _universitas);
                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Anda belum memililh koas", "Update Data Koas", JOptionPane.ERROR_MESSAGE);
                    new UpdateKoasMenu();
                }

            }

        }
        );

        //Add
        panel.add(btnSearch);
        for (int i = 0;
                i < Controller.Controller.getAllKoas()
                        .size(); i++) {
            panel.add(rbListKoas[i]);
        }
        panel.add(labelThisMenu);
        panel.add(labelPilihKoas);
        frame.add(panel);

//        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateKoasMenu();
    }
}
