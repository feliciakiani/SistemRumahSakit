/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pasien;
import Model.Pemeriksaan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class LihatPembayaranPasien {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihMenu;
    JButton btnUpdate, btnLihat;
    Controller.PasienFunction p = new Controller.PasienFunction();

    public LihatPembayaranPasien(int _idPasien) {

        final ArrayList<Pemeriksaan> listAllPemeriksaan = Controller.Controller.getAllPemeriksaan();

        frame = new JFrame("Menu Pembayaran");
        frame.setSize(480, 300);

        panel = new JPanel();
        panel.setSize(480, 500);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Pembayaran");
        labelThisMenu.setBounds(150, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihMenu = new JLabel("Silahkan pilih cara yang diinginkan");
        labelPilihMenu.setBounds(130, 45, 300, 40);

        btnLihat = new JButton("BCA");
        btnLihat.setFont(new Font("Serif", Font.BOLD, 20));
        btnLihat.setBounds(180, 95, 100, 40);
        btnLihat.setBackground(Color.yellow);
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.melakukanPembayaranBCA(_idPasien);
                new LihatCodeQRBCA();
            }
        });
        
        btnUpdate = new JButton("Go-Pay");
        btnUpdate.setFont(new Font("Serif", Font.BOLD, 20));
        btnUpdate.setBounds(180, 155, 100, 40);
        btnUpdate.setBackground(Color.yellow);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.melakukanPembayaranGoPay(_idPasien);
                new LihatCodeQRGopay();
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