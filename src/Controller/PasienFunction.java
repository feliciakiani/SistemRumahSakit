/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pasien;
import Model.Antrian;
import Model.Dokter;
import Model.Pemeriksaan;
import Model.Spesialis;
import View.PasienMainMenu;
import java.awt.Desktop;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PasienFunction {
    public void lihatAntrianPasien(int _idPasien) {
        ArrayList<Antrian> listAllAntiran = new ArrayList<>();
        listAllAntiran = Controller.getAllAntrian();
        
        for(Antrian antrian : listAllAntiran){
            if(antrian.getIdPasien() == _idPasien){
                JOptionPane.showMessageDialog(null, "anda sedang berada diantrian nomor: " 
                    + antrian.getIdAntrian(), "Lihat Antrian Pasien", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void lihatRiwayatPemeriksaan(int _idPasien) {
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        String penyakit = "";
        double biaya = 0;
        LocalDate tanggal;
        
        for (Pemeriksaan pemeriksaan : listAllPemeriksaan) {
            if (pemeriksaan.getIdPasien() == _idPasien) {
                penyakit = pemeriksaan.getPenyakit();
                biaya = pemeriksaan.getBiaya();
                tanggal = pemeriksaan.getTanggal();
                JOptionPane.showMessageDialog(null, "penyakit: " + penyakit 
                    + "\nbiaya: " + biaya + "\ntanggal: " + tanggal, 
                    "Lihat Riwayat Pemeriksaan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void lihatJadwaldanDataDokter(String _firstName, String _lastName) {
        Dokter dokter = new Dokter();
        dokter = Controller.getDokter(_firstName, _lastName);
        ArrayList<Spesialis> listAllSpesialis = Controller.getAllSpesialis();
        ArrayList<Pemeriksaan> listAllPemeriksaan = Controller.getAllPemeriksaan();
        String firstName = "";
        String lastName = "";
        String keahlian = "";
        String email = "";
        String address = "";
        String phone = "";
        String gender = "";
        int jamMulaiPrak = 0;
        int jamSelesaiPrak = 0;
        for (int i = 0; i < Controller.getAllSpesialis().size(); i++) {
            if (dokter.getIdSpesialis() == listAllSpesialis.get(i).getIdSpesialis()) {
                firstName = dokter.getFirstName();
                lastName = dokter.getLastName();
                keahlian = listAllSpesialis.get(i).getBidangSpesialis();
                email = dokter.getEmail();
                address = dokter.getAddress();
                phone = dokter.getPhone();
                LocalDate dob = dokter.getDob();
                gender = dokter.getGender();
                jamMulaiPrak = dokter.getJamMulaiPrak();
                jamSelesaiPrak = dokter.getJamSelesaiPrak();
                JOptionPane.showMessageDialog(null, "first name: " + firstName 
                    + "\nlast name: " + lastName + "\nspesialis: " + keahlian 
                    + "\nemail: " + email + "\naddress: " + address + "\nphone: " 
                    + phone + "\ntanggal lahir: " + dob + "\ngender: " + gender 
                    + "\njam mulai praktik: " + jamMulaiPrak + "\njam selesai praktik: " 
                    + jamSelesaiPrak, "Lihat Data Dokter", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        for (int i = 0; i < Controller.getAllPemeriksaan().size(); i++) {
            if (dokter.getIdDokter() == listAllPemeriksaan.get(i).getIdDokter()) {
                String penyakit = listAllPemeriksaan.get(i).getPenyakit();
                LocalDate tanggal = listAllPemeriksaan.get(i).getTanggal();
                JOptionPane.showMessageDialog(null,firstName + " akan memeriksa penyakit " 
                    + penyakit + " pada tanggal " + tanggal, "Lihat Jadwal Dokter", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        new PasienMainMenu();
    }
    
    public void lihatProfile(String _firstName, String _lastName) {
        Pasien pasien = new Pasien();
        pasien = Controller.getPasien(_firstName, _lastName);
        String firstName = pasien.getFirstName();
        String lastName = pasien.getLastName();
        String email = pasien.getEmail();
        String address = pasien.getAddress();
        String phone = pasien.getPhone();
        LocalDate dob = pasien.getDob();
        String gender = pasien.getGender();
        JOptionPane.showMessageDialog(null, "first name: " + firstName 
            + "\nlast name: " + lastName + "\nemail: " + email + "\naddress: " 
            + address + "\nphone: " + phone + "\ntanggal lahir: " + dob 
            + "\ngender: " + gender, "Lihat Data Pasien", JOptionPane.INFORMATION_MESSAGE);
    }
    
//    public void updateProfile(int _idPasien) {
//        Pasien pasien = new Pasien();
//        
//    }
    
    public void melakukanPembayaran(int _idPasien) {
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        double pembayaran = 0;
        
        for(Pemeriksaan pemeriksaan : listAllPemeriksaan){
            if (_idPasien == pemeriksaan.getIdPasien()) {
                pembayaran = pemeriksaan.getBiaya();
                JOptionPane.showMessageDialog(null, "pembayaran yang harus anda bayar sebesar: " 
                    + pembayaran, "Melakukan Pembayaran", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void melakukanPembayaranBCA(int _idPasien) {
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        
        for(Pemeriksaan pemeriksaan : listAllPemeriksaan){
            if (_idPasien == pemeriksaan.getIdPasien()) {
                JOptionPane.showMessageDialog(null, "sihlakan scan code qr BCA RS ITHB: "
                    , "Melakukan Pembayaran", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void melakukanPembayaranGoPay(int _idPasien) {
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        
        for(Pemeriksaan pemeriksaan : listAllPemeriksaan){
            if (_idPasien == pemeriksaan.getIdPasien()) {
                JOptionPane.showMessageDialog(null, "sihlakan scan code qr gopay RS ITHB: "
                    , "Melakukan Pembayaran", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}