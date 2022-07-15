/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pemeriksaan;
import View.PilihDokter;
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


public class RiwayatPemeriksaanMenu {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, lbRiwayat, lbIdPemeriksaan, lbIdDokter, lbIdPasien, lbIdKoas, lbBiaya, lbPenyakit, lbTanggal;
    JRadioButton[] rbListDokter;
    ButtonGroup bgListDokter;
    JButton btnSearch;
    String _firstName="", _lastName="";
    int _idDokter = 0;

    Controller.AdminFunctions a = new Controller.AdminFunctions();
    
    public RiwayatPemeriksaanMenu(int _idDokter){

        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Lihat Riwayat Pemeriksaan");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        
        String riwayat = a.lihatRiwayatPemeriksaan(_idDokter);
        lbRiwayat = new JLabel(riwayat);
        lbRiwayat.setBounds(50, 10, 300, 300);
        
        btnSearch = new JButton("Back to Admin Main Menu");
        btnSearch.setBounds(180, 560, 100, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new AdminMainMenu();
            }
        });
        
        //Add
        panel.add(btnSearch);
        panel.add(labelThisMenu);
        panel.add(lbRiwayat);
        frame.add(panel);
        
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}

