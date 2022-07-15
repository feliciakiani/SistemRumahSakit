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

public class UpdateJadwalMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihDokter, lbThisMenu;
    JButton btnSearch;
    JRadioButton[] rbListDokter;
    ButtonGroup bgListDokter;
    String _firstName = "", _lastName = "";
    int _idDokter = 0, _jamMulai = 0, _jamSelesai = 0;

    Controller.AdminFunctions a = new Controller.AdminFunctions();

    public UpdateJadwalMenu() {
        final ArrayList<Dokter> listAllDokter = Controller.Controller.getAllDokter();
        int y = 90;

        frame = new JFrame("Menu Admin");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Update Jadwal Praktek Dokter");
        labelThisMenu.setBounds(80, 20, 400, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihDokter = new JLabel("Silahkan pilih dokter yang diinginkan");
        labelPilihDokter.setBounds(80, 45, 300, 40);

        rbListDokter = new JRadioButton[Controller.Controller.getAllDokter().size()];
        bgListDokter = new ButtonGroup();

        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            String name = listAllDokter.get(i).getFirstName() + " " + listAllDokter.get(i).getLastName();
            rbListDokter[i] = new JRadioButton(name);
            rbListDokter[i].setActionCommand(String.valueOf(i));
            rbListDokter[i].setBounds(90, y, 200, 40);
            rbListDokter[i].setBackground(Color.CYAN);
            y += 40;
            rbListDokter[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int index = Integer.valueOf(ae.getActionCommand());
                    _idDokter = listAllDokter.get(index).getIdDokter();
                    _firstName = listAllDokter.get(index).getFirstName();
                    _lastName = listAllDokter.get(index).getLastName();
                    _jamMulai = listAllDokter.get(index).getJamMulaiPrak();
                    _jamSelesai = listAllDokter.get(index).getJamSelesaiPrak();
                }
            });
            bgListDokter.add(rbListDokter[i]);
        }

        btnSearch = new JButton("Search");
        btnSearch.setBounds(180, 560, 100, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!_firstName.equals("") && !_lastName.equals("")) {
                    frame.setVisible(false);
                    new ShowFormUpdateJadwal(_idDokter, _jamMulai, _jamSelesai);
                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Anda belum memililh dokter", "Update Jadwal Pemeriksaan Dokter", JOptionPane.ERROR_MESSAGE);
                    new UpdateJadwalMenu();
                }
            }

        }
        );

        //Add
        panel.add(btnSearch);
        for (int i = 0;
                i < Controller.Controller.getAllDokter()
                        .size(); i++) {
            panel.add(rbListDokter[i]);
        }
        panel.add(labelThisMenu);
        panel.add(labelPilihDokter);
        frame.add(panel);

        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
