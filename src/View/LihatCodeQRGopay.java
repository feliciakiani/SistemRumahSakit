/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class LihatCodeQRGopay {
    
    JFrame frame;
    JPanel panel;
    JLabel labelLogo, labelText;
    JButton btnSelesai;
    ImageIcon icon;
    
    public LihatCodeQRGopay() {
        frame = new JFrame("Menu QR Code");
        frame.setSize(480, 450);

        panel = new JPanel();
        panel.setSize(480, 450);
        panel.setBackground(Color.CYAN);
        
        labelText = new JLabel("Sihlakan scan QR Gopay ITHB: ");
        labelText.setBounds (150, 15, 200, 20);
        
        labelLogo = new JLabel();
        icon = new ImageIcon ("qrgopay.jpg");
        labelLogo.setIcon(icon);
        labelLogo.setBounds(80, 45, 300, 301);
        
        btnSelesai = new JButton("Selesai");
        btnSelesai.setFont(new Font("Serif", Font.BOLD, 20));
        btnSelesai.setBounds(180, 365, 100, 30);
        btnSelesai.setBackground(Color.yellow);
        btnSelesai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new PasienMainMenu();
            }
        });
        
        //Add
        panel.add(btnSelesai);
        panel.add(labelText);
        panel.add(labelLogo);
        frame.add(panel);
        
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}