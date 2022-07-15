/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Dokter;
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


public class ShowFormUpdateJadwal {

    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, lbThisMenu, lbHari, lbJamMulai, lbJamSelesai;
    JTextField tfJamMulai, tfJamSelesai;
    JButton btSubmitUpdateJadwal;
    String _firstName = "", _lastName = "";
    int _jamMulai = 0, _jamSelesai = 0;

    Controller.AdminFunctions a = new Controller.AdminFunctions();

    public ShowFormUpdateJadwal(int _idDokter, int _jamMulai, int _jamSelesai) {
        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Update Jadwal Praktek Dokter");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));

        lbHari = new JLabel("Senin-Minggu");
        lbHari.setBounds(70, 60, 300, 40);
        lbJamMulai = new JLabel("Jam Mulai Praktek :");
        lbJamMulai.setBounds(70, 90, 300, 40);
        lbJamSelesai = new JLabel("Jam Selesai Praktek:");
        lbJamSelesai.setBounds(70, 120, 300, 40);

        tfJamMulai = new JTextField();
        tfJamMulai.setBounds(220, 100, 200, 20);
        tfJamMulai.setText(String.valueOf(_jamMulai));
        tfJamSelesai = new JTextField();
        tfJamSelesai.setBounds(220, 130, 200, 20);
        tfJamSelesai.setText(String.valueOf(_jamSelesai));

        btSubmitUpdateJadwal = new JButton("Submit");
        btSubmitUpdateJadwal.setBounds(90, 400, 300, 40);
        btSubmitUpdateJadwal.setBackground(Color.YELLOW);
        btSubmitUpdateJadwal.setForeground(Color.black);
        btSubmitUpdateJadwal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                String jamMulai = tfJamMulai.getText();
                int intJamMulai = Integer.parseInt(jamMulai);
                String jamSelesai = tfJamSelesai.getText();
                int intJamSelesai = Integer.parseInt(jamSelesai);
                boolean updateDokter;
                updateDokter = a.updateJadwalPemeriksaan( _idDokter, intJamMulai, intJamSelesai);
                if (updateDokter == true) {
                    JOptionPane.showMessageDialog(null, "Update berhasil!", "Update Jadwal Pemeriksaan Dokter", JOptionPane.INFORMATION_MESSAGE);
                    new AdminMainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Update gagal!", "Update Jadwal Pemeriksaan Dokter", JOptionPane.ERROR_MESSAGE);
                    new AdminMainMenu();
                }

            }
        });

        panel.add(lbHari);
        panel.add(lbJamMulai);
        panel.add(lbJamSelesai);
        panel.add(tfJamMulai);
        panel.add(tfJamSelesai);
        panel.add(btSubmitUpdateJadwal);
        frame.add(panel);

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
