/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Spesialis;
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
 * @author Felicia
 */
public class ManagerPendapatanSpesialisMenu {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihSpesialis;
    JRadioButton[] rbListSpesialis;
    ButtonGroup bgListSpesialis;
    JButton btnSearch;
    int _idSpesialis;
    String namaSpesialis;
    
    Controller.ManagerFunctions m = new Controller.ManagerFunctions();

    public ManagerPendapatanSpesialisMenu() {
        
        ArrayList<Spesialis> listAllSpesialis = new ArrayList<>();
        int x = 90;

        frame = new JFrame("Menu Manager");
        frame.setSize(500, 600);
        frame.setBackground(Color.CYAN);

        panel = new JPanel();
        panel.setSize(500, 600);
        
        labelThisMenu = new JLabel("Menu Pendapatan Dokter");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihSpesialis = new JLabel("Silahkan pilih menu yang diinginkan");
        labelPilihSpesialis.setBounds(90, 45, 300, 40);

        rbListSpesialis = new JRadioButton[Controller.Controller.getAllDokter().size()];
        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            namaSpesialis = listAllSpesialis.get(i).getBidangSpesialis();
            rbListSpesialis[i].setText(namaSpesialis);
            rbListSpesialis[i].setBounds(90, x, 100, 40);
            x += 40;
            rbListSpesialis[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
//                    _idSpesialis = listAllSpesialis.get(i).getIdSpesialis();
                }
            });
        }

        bgListSpesialis = new ButtonGroup();
        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            bgListSpesialis.add(rbListSpesialis[i]);
        }
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(750, 530, 100, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double pendapatan = m.lihatPendapatanPerSpesialis(_idSpesialis);
                JOptionPane.showMessageDialog (null, "Pendapatan dari bidang spesialis " 
                        + listAllSpesialis.get(_idSpesialis - 1).getBidangSpesialis() 
                        + " : Rp" + pendapatan , "Pendapatan Spesialis", JOptionPane.INFORMATION_MESSAGE);
                
                new ManagerMainMenu();
            }
        });
        
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //Add
        panel.add(btnSearch);
        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            panel.add(rbListSpesialis[i]);
        }
        panel.add(labelThisMenu);
        panel.add(labelPilihSpesialis);
        frame.add(panel);
        
    }
    
    public static void main(String[] args) {
        new ManagerPendapatanSpesialisMenu();
    }
}
