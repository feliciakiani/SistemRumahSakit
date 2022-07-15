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
public class ManagerMainMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelSelamatDatang, labelPilihMenu;
    JButton btnPendapatanRS, btnPendapatanDokter, btnTotalTransaksi, btnPendapatanSpesialis, btnBackToMainMenu;

    Controller.ManagerFunctions m = new Controller.ManagerFunctions();
    Controller.Controller controller = new Controller.Controller();

    public ManagerMainMenu() {

        frame = new JFrame("Menu Manager");
        frame.setSize(500, 485);

        panel = new JPanel();
        panel.setSize(500, 485);

        ActiveUserID idManager = ActiveUserID.ActiveUserID();
        labelSelamatDatang = new JLabel("<html>Selamat datang " + controller.getStaffNameById(idManager.getUserID()));
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
                double totalPendapatan = m.lihatTotalPendapatanRS();
                JOptionPane.showMessageDialog(null, "Total pendapatan  Rumah Sakit : Rp" + totalPendapatan, "Total Pendapatan RS", JOptionPane.INFORMATION_MESSAGE);
                
                new ManagerMainMenu();
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
                int totalTransaksi = m.lihatTotalTransaksi();
                JOptionPane.showMessageDialog(null, "Total transaksi dalam RS :" + totalTransaksi, "Total Transaksi RS", JOptionPane.INFORMATION_MESSAGE);
                
                new ManagerMainMenu();
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

        btnBackToMainMenu = new JButton("Log Out");
        btnBackToMainMenu.setBounds(160, 360, 150, 40);
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
        panel.add(btnPendapatanRS);
        panel.add(btnPendapatanDokter);
        panel.add(btnTotalTransaksi);
        panel.add(btnPendapatanSpesialis);
        panel.add(btnBackToMainMenu);
        panel.add(labelSelamatDatang);
        panel.add(labelPilihMenu);
        frame.add(panel);
    }


}
