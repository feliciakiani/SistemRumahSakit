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
import javax.swing.JPanel;

/**
 *
 * @author Felicia
 */
public class ManagerMainMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelSelamatDatang, labelPilihMenu;
    JButton btnPendapatanRS, btnPendapatanDokter, btnTotalTransaksi, btnPendapatanSpesialis, btnBackToMainMenu;

    public ManagerMainMenu() {

        frame = new JFrame("Menu Manager");
        frame.setSize(500, 485);

        panel = new JPanel();
        panel.setSize(500, 485);

        labelSelamatDatang = new JLabel("<html>Selamat datang " + "<b>///NAMA///</b></html>");
        labelSelamatDatang.setBounds(90, 20, 300, 40);
        labelPilihMenu = new JLabel("Silahkan pilih menu yang diinginkan");
        labelPilihMenu.setBounds(90, 45, 300, 40);

        btnPendapatanRS = new JButton("Lihat Total Pendapatan RS");
        btnPendapatanRS.setBounds(90, 100, 300, 40);
        btnPendapatanRS.setBackground(Color.BLACK);
        btnPendapatanRS.setForeground(Color.white);
        btnPendapatanRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new ManagerPendapatanRSMenu();
            }
        });

        btnPendapatanDokter = new JButton("Lihat Pendapatan Dokter");
        btnPendapatanDokter.setBounds(90, 160, 300, 40);
        btnPendapatanDokter.setBackground(Color.BLACK);
        btnPendapatanDokter.setForeground(Color.white);
        btnPendapatanDokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new ManagerPendapatanDokterMenu();
            }
        });

        btnTotalTransaksi = new JButton("Lihat Total Transaksi");
        btnTotalTransaksi.setBounds(90, 220, 300, 40);
        btnTotalTransaksi.setBackground(Color.BLACK);
        btnTotalTransaksi.setForeground(Color.white);
        btnTotalTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new ManagerTotalTransaksiMenu();
            }
        });

        btnPendapatanSpesialis = new JButton("Lihat Pendapatan Per Spesialis");
        btnPendapatanSpesialis.setBounds(90, 280, 300, 40);
        btnPendapatanSpesialis.setBackground(Color.BLACK);
        btnPendapatanSpesialis.setForeground(Color.white);
        btnPendapatanSpesialis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new ManagerPendapatanSpesialisMenu();
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

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //Add
        panel.add(btnPendapatanRS);
        panel.add(btnPendapatanDokter);
        panel.add(btnTotalTransaksi);
        panel.add(btnPendapatanSpesialis);
        panel.add(btnBackToMainMenu);
        panel.add(labelSelamatDatang);
        panel.add(labelPilihMenu);
        frame.add(panel);
    }

    public static void main(String[] args) {
        new ManagerMainMenu();
    }

}
