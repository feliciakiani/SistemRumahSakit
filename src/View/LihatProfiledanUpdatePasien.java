<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pasien;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 * @author User
 */
public class LihatProfiledanUpdatePasien {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihMenu;
    JButton btnUpdate, btnLihat;

    Controller.PasienFunction p = new Controller.PasienFunction();

    public LihatProfiledanUpdatePasien(String _firstName, String _lastName) {

        final Pasien pasien = Controller.Controller.getPasien(_firstName, _lastName);

        frame = new JFrame("Menu Lihat Profile atau Update Pasien");
        frame.setSize(480, 300);

        panel = new JPanel();
        panel.setSize(480, 500);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Lihat atau Update Profile");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihMenu = new JLabel("Silahkan pilih menu yang diinginkan");
        labelPilihMenu.setBounds(90, 45, 300, 40);

        btnLihat = new JButton("Lihat");
        btnLihat.setFont(new Font("Serif", Font.BOLD, 20));
        btnLihat.setBounds(180, 95, 100, 50);
        btnLihat.setBackground(Color.yellow);
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.lihatProfile(_firstName, _lastName);
                new PasienMainMenu();
            }
        });
        
        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Serif", Font.BOLD, 20));
        btnUpdate.setBounds(180, 155, 100, 50);
        btnUpdate.setBackground(Color.yellow);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                // new UpdatePasien();
                new PasienMainMenu();
            }
        });
        

        //Add
        panel.add(btnLihat);
        panel.add(btnUpdate);
        panel.add(labelThisMenu);
        panel.add(labelPilihMenu);
        frame.add(panel);
        
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pasien;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 * @author User
 */
public class LihatProfiledanUpdatePasien {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihMenu;
    JButton btnUpdate, btnLihat;

    Controller.PasienFunction p = new Controller.PasienFunction();

    public LihatProfiledanUpdatePasien(String _firstName, String _lastName) {

        final Pasien pasien = Controller.Controller.getPasien(_firstName, _lastName);

        frame = new JFrame("Menu Lihat Profile atau Update Pasien");
        frame.setSize(480, 300);

        panel = new JPanel();
        panel.setSize(480, 500);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Lihat atau Update Profile");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihMenu = new JLabel("Silahkan pilih menu yang diinginkan");
        labelPilihMenu.setBounds(90, 45, 300, 40);

        btnLihat = new JButton("Lihat");
        btnLihat.setFont(new Font("Serif", Font.BOLD, 20));
        btnLihat.setBounds(180, 95, 100, 50);
        btnLihat.setBackground(Color.yellow);
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.lihatProfile(_firstName, _lastName);
                new PasienMainMenu();
            }
        });
        
        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Serif", Font.BOLD, 20));
        btnUpdate.setBounds(180, 155, 100, 50);
        btnUpdate.setBackground(Color.yellow);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new UpdatePasien();
            }
        });
        

        //Add
        panel.add(btnLihat);
        panel.add(btnUpdate);
        panel.add(labelThisMenu);
        panel.add(labelPilihMenu);
        frame.add(panel);
        
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
>>>>>>> ef1b116517d086a4be961b30c82288aac565630f
