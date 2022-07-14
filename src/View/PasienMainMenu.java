/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.ActiveUserID;

/**
 *
 * @author Felicia
 */
public class PasienMainMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelSelamatDatang, labelPilihMenu;
    JButton btnLihatUbahProfile, btnMelakukanPembayaran, btnLihatAntrian, btnDaftarOnline, btnLihatJadwalDataDokter, btnLihatRiwayatPemeriksaan, btnBackToMainMenu;


    public PasienMainMenu() {
        Controller.PasienFunction p = new Controller.PasienFunction();
        Controller.Controller controller = new Controller.Controller();
        frame = new JFrame("Menu Pasien");
        frame.setSize(500, 585);

        panel = new JPanel();
        panel.setSize(500, 585);

        ActiveUserID idPasien = ActiveUserID.ActiveUserID();
        labelSelamatDatang = new JLabel("<html>Selamat datang " ); // + controller.getNameById(idPasien.getUserID())
        labelSelamatDatang.setBounds(90, 20, 300, 40);
        labelPilihMenu = new JLabel("Silahkan pilih menu yang diinginkan");
        labelPilihMenu.setBounds(90, 45, 300, 40);

        btnLihatUbahProfile = new JButton("Lihat dan Ubah Profile");
        btnLihatUbahProfile.setBounds(90, 100, 300, 40);
        btnLihatUbahProfile.setBackground(Color.BLACK);
        btnLihatUbahProfile.setForeground(Color.white);
        btnLihatUbahProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LihatProfiledanUpdatePasien("hansel", "raphaelo"); //first name dan last name
            }
        });

        btnMelakukanPembayaran = new JButton("Melakukan Pembayaran");
        btnMelakukanPembayaran.setBounds(90, 160, 300, 40);
        btnMelakukanPembayaran.setBackground(Color.BLACK);
        btnMelakukanPembayaran.setForeground(Color.white);
        btnMelakukanPembayaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.melakukanPembayaran(idPasien.getUserID()); //idPasien
                new LihatPembayaranPasien(idPasien.getUserID()); //idPasien
            }
        });

        btnLihatAntrian = new JButton("Lihat Antrian");
        btnLihatAntrian.setBounds(90, 220, 300, 40);
        btnLihatAntrian.setBackground(Color.BLACK);
        btnLihatAntrian.setForeground(Color.white);
        btnLihatAntrian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.lihatAntrianPasien(idPasien.getUserID()); //idPasien
                new PasienMainMenu();
            }
        });

        btnDaftarOnline = new JButton("Daftar Online");
        btnDaftarOnline.setBounds(90, 280, 300, 40);
        btnDaftarOnline.setBackground(Color.BLACK);
        btnDaftarOnline.setForeground(Color.white);
        btnDaftarOnline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new DaftarOnlinePemeriksaan();
            }
        });
        
        btnLihatJadwalDataDokter = new JButton("Lihat Jadwal dan Data Dokter");
        btnLihatJadwalDataDokter.setBounds(90, 340, 300, 40);
        btnLihatJadwalDataDokter.setBackground(Color.BLACK);
        btnLihatJadwalDataDokter.setForeground(Color.white);
        btnLihatJadwalDataDokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LihatJadwaldanDataDokterMenu();
            }
        });
        
        btnLihatRiwayatPemeriksaan = new JButton("Lihat Riwayat Pemeriksaan");
        btnLihatRiwayatPemeriksaan.setBounds(90, 400, 300, 40);
        btnLihatRiwayatPemeriksaan.setBackground(Color.BLACK);
        btnLihatRiwayatPemeriksaan.setForeground(Color.white);
        btnLihatRiwayatPemeriksaan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                p.lihatRiwayatPemeriksaan(idPasien.getUserID()); //masukin id pasien
                new PasienMainMenu();
            }
        });

        btnBackToMainMenu = new JButton("Log Out");
        btnBackToMainMenu.setBounds(160, 460, 150, 40);
        btnBackToMainMenu.setBackground(Color.white);
        btnBackToMainMenu.setForeground(Color.BLACK);
        btnBackToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Login();
            }
        });

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //Add
        panel.add(btnLihatUbahProfile);
        panel.add(btnMelakukanPembayaran);
        panel.add(btnLihatAntrian);
        panel.add(btnDaftarOnline);
        panel.add(btnLihatJadwalDataDokter);
        panel.add(btnLihatRiwayatPemeriksaan);
        panel.add(btnBackToMainMenu);
        panel.add(labelSelamatDatang);
        panel.add(labelPilihMenu);
        frame.add(panel);
    }

    public static void main(String[] args) {
        new PasienMainMenu();
    }
}