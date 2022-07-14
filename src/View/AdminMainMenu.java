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
import javax.swing.JTextField;

import Model.ActiveUserID;

/**
 *
 * @author Sheren
 */
public class AdminMainMenu {
    JFrame frame;
    JPanel panel;
    
    JLabel labelSelamatDatang, labelPilihMenu, lbIdSpesialis, lbFirstName, lbLastName, lbEmail, lbAddress, lbPhone, lbDob, lbGender, lbJamMulai, lbJamSelesai, lbUniversitas;
    JTextField tfIdSpesialis, tfFirstName, tfLastName, tfEmail, tfAddress, tfPhone, tfDob, tfGender, tfJamMulai, tfJamSelesai, tfUniversitas;
    JButton btnRegistDokter, btnRegistKoas, btnRiwayatPemeriksaan, btnUpdateDokter, btnUpdateKoas, btnUpdateJadwal, btnBackToMainMenu;

    Controller.AdminFunctions a = new Controller.AdminFunctions();
    Controller.Controller controller = new Controller.Controller();
    
    public AdminMainMenu(){
        
        frame = new JFrame("Menu Admin");
        frame.setSize(500, 510);

        panel = new JPanel();
        panel.setSize(500, 510);

        ActiveUserID idManager = ActiveUserID.ActiveUserID();
        labelSelamatDatang = new JLabel("<html>Selamat datang " + controller.getStaffNameById(idManager.getUserID()));
        labelSelamatDatang.setBounds(90, 20, 300, 40);
        labelPilihMenu = new JLabel("Silahkan pilih menu yang diinginkan");
        labelPilihMenu.setBounds(90, 45, 300, 40);
        
        btnRegistDokter = new JButton("Registrasi Dokter");
        btnRegistDokter.setBounds(90, 100, 300, 40);
        btnRegistDokter.setBackground(Color.BLACK);
        btnRegistDokter.setForeground(Color.white);
        btnRegistDokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new RegistDokterMenu();
            }
        });
        
        btnRegistKoas = new JButton("Registrasi Koas");
        btnRegistKoas.setBounds(90, 160, 300, 40);
        btnRegistKoas.setBackground(Color.BLACK);
        btnRegistKoas.setForeground(Color.white);
        btnRegistKoas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new RegistKoasMenu();
            }
        });
        
        btnRiwayatPemeriksaan = new JButton("Lihat Riwayat Pemeriksaan");
        btnRiwayatPemeriksaan.setBounds(90, 220, 300, 40);
        btnRiwayatPemeriksaan.setBackground(Color.BLACK);
        btnRiwayatPemeriksaan.setForeground(Color.white);
        btnRiwayatPemeriksaan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new PilihDokter();
            }
        });
        
        btnUpdateDokter = new JButton("Update Data Dokter");
        btnUpdateDokter.setBounds(90, 280, 300, 40);
        btnUpdateDokter.setBackground(Color.BLACK);
        btnUpdateDokter.setForeground(Color.white);
        btnUpdateDokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new UpdateDokterMenu();
            }
        });
        
        btnUpdateKoas = new JButton("Update Data Koas");
        btnUpdateKoas.setBounds(90, 340, 300, 40);
        btnUpdateKoas.setBackground(Color.BLACK);
        btnUpdateKoas.setForeground(Color.white);
        btnUpdateKoas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new UpdateKoasMenu();
            }
        });
        
        btnUpdateJadwal = new JButton("Update Jadwal Pemeriksaan Dokter");
        btnUpdateJadwal.setBounds(90, 400, 300, 40);
        btnUpdateJadwal.setBackground(Color.BLACK);
        btnUpdateJadwal.setForeground(Color.white);
        btnUpdateJadwal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new UpdateJadwalMenu();
            }
        });
        
        btnBackToMainMenu = new JButton("Back to Main Menu");
        btnBackToMainMenu.setBounds(160, 360, 150, 40);
        btnBackToMainMenu.setBackground(Color.white);
        btnBackToMainMenu.setForeground(Color.BLACK);
        btnBackToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
//                new MainMenu();
            }
        });
        
        // Add
        panel.add(labelSelamatDatang);
        panel.add(labelPilihMenu);
        panel.add(btnRegistDokter);
        panel.add(btnRegistKoas);
        panel.add(btnRiwayatPemeriksaan);
        panel.add(btnUpdateDokter);
        panel.add(btnUpdateKoas);
        panel.add(btnUpdateJadwal);
        frame.add(panel);
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new AdminMainMenu();
    }
}
