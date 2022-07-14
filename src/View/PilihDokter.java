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
 * @author User
 */
public class PilihDokter {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenu, labelPilihDokter;
    JRadioButton[] rbListDokter;
    ButtonGroup bgListDokter;
    JButton btnSearch;
    String _firstName="", _lastName="";
    int index = -1;

    Controller.PasienFunction p = new Controller.PasienFunction();

    public PilihDokter() {

        final ArrayList<Dokter> listAllDokter = Controller.Controller.getAllDokter();
        int y = 90;

        frame = new JFrame("Menu Lihat Data Dokter");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenu = new JLabel("Menu Riwayat Pemeriksaan Dokter");
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
                    index = Integer.valueOf(ae.getActionCommand()) + 1;
                }
            });
            bgListDokter.add(rbListDokter[i]);
        }

        btnSearch = new JButton("Lihat Riwayat Pemeriksaan");
        btnSearch.setBounds(180, 560, 100, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index != -1) {
                    frame.dispose();
                    new RiwayatPemeriksaanMenu(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Anda belum memililh dokter", "Gagal!", JOptionPane.ERROR_MESSAGE);
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
}