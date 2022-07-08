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
public class ManagerPendapatanDokterMenu {

    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihDokter;
    JRadioButton[] rbListDokter;
    ButtonGroup bgListDokter;
    JButton btnSearch;
    String _firstName="", _lastName="";

    Controller.ManagerFunctions m = new Controller.ManagerFunctions();

    public ManagerPendapatanDokterMenu() {

        final ArrayList<Dokter> listAllDokter = Controller.Controller.getAllDokter();
        int y = 90;

        frame = new JFrame("Menu Manager");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Pendapatan Dokter");
        labelThisMenu.setBounds(90, 20, 300, 40);
        labelThisMenu.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihDokter = new JLabel("Silahkan pilih dokter yang diinginkan");
        labelPilihDokter.setBounds(90, 45, 300, 40);

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
                    _firstName = listAllDokter.get(index).getFirstName();
                    _lastName = listAllDokter.get(index).getLastName();
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
                    double pendapatan = m.lihatPendapatanDokter(_firstName, _lastName);
                    JOptionPane.showMessageDialog(null, "Pendapatan dari " + _firstName + " " + _lastName + " : Rp" + (int)pendapatan, "Pendapatan Dokter", JOptionPane.INFORMATION_MESSAGE);

                    new ManagerMainMenu();
                } else {
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Anda belum memililh dokter", "Pendapatan Dokter", JOptionPane.ERROR_MESSAGE);
                    new ManagerPendapatanDokterMenu();
                }
            }
        });
        

        //Add
        panel.add(btnSearch);
        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
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

    public static void main(String[] args) {
        new ManagerPendapatanDokterMenu();
    }

}
