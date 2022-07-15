/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Antrian;
import Model.Dokter;
import java.awt.Color;
import java.time.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author User
 */
public class DaftarOnlinePemeriksaan {
    JFrame frame;
    JPanel panel;
    JLabel labelThisMenuDokter, labelPilihDokter, labelTanggalPeriksa;
    JRadioButton[] rbListDokter;
    ButtonGroup bgListDokter;
    LocalDate tanggalPeriksa;
    Date tanggalPeriksaSQL;
    JDatePickerImpl datePickerTanggalPeriksa;
    JButton btnSearch;
    String _firstNameDokter="", _lastNameDokter="";
    int _idSpesialisDokter=0, _idDokter=0;
    
    
    Controller.PasienFunction p = new Controller.PasienFunction();
    Controller.Controller c = new Controller.Controller();
    
    public DaftarOnlinePemeriksaan() {
        final ArrayList<Dokter> listAllDokter = Controller.Controller.getAllDokter();
        int yDokter = 90;

        frame = new JFrame("Menu Daftar Online");
        frame.setSize(500, 700);

        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);
        panel = new JPanel();
        panel.setSize(500, 700);
        panel.setBackground(Color.CYAN);

        labelThisMenuDokter = new JLabel("Menu Pilih Dokter");
        labelThisMenuDokter.setBounds(90, 20, 300, 40);
        labelThisMenuDokter.setFont(new Font("Serif", Font.BOLD, 20));
        labelPilihDokter = new JLabel("Silahkan pilih dokter yang diinginkan");
        labelPilihDokter.setBounds(90, 45, 300, 40);

        rbListDokter = new JRadioButton[Controller.Controller.getAllDokter().size()];
        bgListDokter = new ButtonGroup();

        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            String name = listAllDokter.get(i).getFirstName() + " " + listAllDokter.get(i).getLastName();
            rbListDokter[i] = new JRadioButton(name);
            rbListDokter[i].setActionCommand(String.valueOf(i));
            rbListDokter[i].setBounds(90, yDokter, 200, 40);
            rbListDokter[i].setBackground(Color.CYAN);
            yDokter += 40;
            rbListDokter[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int index = Integer.valueOf(ae.getActionCommand());
                    _firstNameDokter = listAllDokter.get(index).getFirstName();
                    _lastNameDokter = listAllDokter.get(index).getLastName();
                    _idSpesialisDokter = listAllDokter.get(index).getIdSpesialis();
                    _idDokter = listAllDokter.get(index).getIdDokter();
                }
            });
            bgListDokter.add(rbListDokter[i]);
        }

        btnSearch = new JButton("Insert Database");
        btnSearch.setBounds(140, 480, 200, 50);
        btnSearch.setBackground(Color.yellow);
        btnSearch.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tanggalPeriksa = new java.sql.Date( tanggalPeriksaSQL.getTime() ).toLocalDate();
                if (!_firstNameDokter.equals("") && !_lastNameDokter.equals("") && tanggalPeriksa != null) {
                    frame.setVisible(false);
                    if (tanggalPeriksaSQL.compareTo(new java.util.Date()) < 0) {
                        JOptionPane.showMessageDialog(null, "tanggal periksa tidak bisa sebelum hari ini", "Menu Daftar Online", JOptionPane.ERROR_MESSAGE);
                        new DaftarOnlinePemeriksaan();
                    } else {
                        Antrian antrian2 = new Antrian(0, _idSpesialisDokter, _idDokter, 5, java.time.LocalDate.now(), tanggalPeriksa); // kolom 4 ganti id pasien
                        c.insertAntrian(antrian2);
                        JOptionPane.showMessageDialog(null, "insert antrian ke database berhasil", "Menu Daftar Online", JOptionPane.INFORMATION_MESSAGE);
                        new PasienMainMenu();
                    }
                } else {
                    frame.setVisible(false);
                    System.out.println(tanggalPeriksa);
                    JOptionPane.showMessageDialog(null, "dokter atau tanggal periksa masih kosong", "Menu Daftar Online", JOptionPane.ERROR_MESSAGE);
                    new DaftarOnlinePemeriksaan();
                }
            }
        });
        
        labelTanggalPeriksa = new JLabel("Tanggal Periksa: ");
        labelTanggalPeriksa.setBounds(90, 420, 125, 25);
        UtilDateModel dateModel = new UtilDateModel();
        Properties pe = new Properties();
        pe.put("text.today", "Today");
        pe.put("text.month", "Month");
        pe.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, pe);
        datePickerTanggalPeriksa = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePickerTanggalPeriksa.setBounds(190, 420, 125, 25);
        datePickerTanggalPeriksa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tanggalPeriksaSQL = (Date) datePickerTanggalPeriksa.getModel().getValue();
            }
        });
        
        //Add
        panel.add(btnSearch);
        for (int i = 0; i < Controller.Controller.getAllDokter().size(); i++) {
            panel.add(rbListDokter[i]);
        }
        panel.add(labelThisMenuDokter);
        panel.add(labelPilihDokter);
        panel.add(labelTanggalPeriksa);
        panel.add(datePickerTanggalPeriksa);
        frame.add(panel);
        
        // Init
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        public DateLabelFormatter() {
            TimeZone zone = TimeZone.getTimeZone("GMT");
            dateFormatter.setTimeZone(zone);
        }
        
        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }
        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                TimeZone zone = TimeZone.getTimeZone("GMT");
                cal.setTimeZone(zone);
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }
    

}