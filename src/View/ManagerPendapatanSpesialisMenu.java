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
    int _idSpesialis = -1;
    String namaSpesialisDipilih;

    Controller.ManagerFunctions m = new Controller.ManagerFunctions();

    public ManagerPendapatanSpesialisMenu() {

        final ArrayList<Spesialis> listAllSpesialis = Controller.Controller.getAllSpesialis();
        int y = 90;

        frame = new JFrame("Menu Manager");
        frame.setSize(500, 600);

        panel = new JPanel();
        panel.setSize(500, 600);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Pendapatan Spesialis");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihSpesialis = new JLabel("Silahkan pilih spesialis yang diinginkan");
        labelPilihSpesialis.setBounds(90, 45, 300, 40);

        rbListSpesialis = new JRadioButton[Controller.Controller.getAllSpesialis().size()];
        bgListSpesialis = new ButtonGroup();

        for (int i = 0; i < Controller.Controller.getAllSpesialis().size(); i++) {
            String namaSpesialis = listAllSpesialis.get(i).getBidangSpesialis();
            rbListSpesialis[i] = new JRadioButton(namaSpesialis);
            rbListSpesialis[i].setActionCommand(String.valueOf(i));
            rbListSpesialis[i].setBounds(90, y, 200, 40);
            rbListSpesialis[i].setBackground(Color.CYAN);
            y += 40;
            rbListSpesialis[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int index = Integer.valueOf(ae.getActionCommand());
                    _idSpesialis = listAllSpesialis.get(index).getIdSpesialis();
                    namaSpesialisDipilih = listAllSpesialis.get(index).getBidangSpesialis();
                }
            });
            bgListSpesialis.add(rbListSpesialis[i]);
        }

        btnSearch = new JButton("Search");
        btnSearch.setBounds(180, 460, 100, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (_idSpesialis != -1) {
                    frame.setVisible(false);
                    double pendapatan = m.lihatPendapatanPerSpesialis(_idSpesialis);
                    JOptionPane.showMessageDialog(null, "Pendapatan dari bidang spesialis "
                            + namaSpesialisDipilih
                            + " : Rp" + (int)pendapatan, "Pendapatan Spesialis", JOptionPane.INFORMATION_MESSAGE);

                    new ManagerMainMenu();
                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Anda belum memililh spesialis", "Pendapatan Spesialis", JOptionPane.ERROR_MESSAGE);
                    new ManagerPendapatanSpesialisMenu();
                }
            }
        });

        //Add
        panel.add(btnSearch);
        for (int i = 0; i < Controller.Controller.getAllSpesialis().size(); i++) {
            panel.add(rbListSpesialis[i]);
        }
        panel.add(labelThisMenu);
        panel.add(labelPilihSpesialis);
        frame.add(panel);

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ManagerPendapatanSpesialisMenu();
    }
}
