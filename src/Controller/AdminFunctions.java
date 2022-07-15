/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dokter;
import Model.Koas;
import Model.Pemeriksaan;
import Controller.DatabaseHandler;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;


public class AdminFunctions {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean registDokter(int _idSpesialis, String _firstName, String _lastName, String _email, String _address, String _phone, Date _dob, char _gender, int _jamMulai, int _jamSelesai, int _pendapatan) {
        conn.connect();
        String query = "INSERT INTO dokter (idSpesialis, firstName, lastName, email, address, phone, dob, gender, jamMulaiPrak, jamSelesaiPrak, pendapatan) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, _idSpesialis);
            stmt.setString(2, _firstName);
            stmt.setString(3, _lastName);
            stmt.setString(4, _email);
            stmt.setString(5, _address);
            stmt.setString(6, _phone);
            stmt.setDate(7, _dob);
            stmt.setString(8, String.valueOf(_gender));
            stmt.setInt(9, _jamMulai);
            stmt.setInt(10, _jamSelesai);
            stmt.setInt(11, _pendapatan);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean registKoas(String _firstName, String _lastName, String _email, String _address, String _phone, Date _dob, char _gender, String _universitas) {
        conn.connect();
        String query = "INSERT INTO koas (firstName, lastName, email, address, phone, dob, gender, universitas) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, _firstName);
            stmt.setString(2, _lastName);
            stmt.setString(3, _email);
            stmt.setString(4, _address);
            stmt.setString(5, _phone);
            stmt.setDate(6, _dob);
            stmt.setString(7, String.valueOf(_gender));
            stmt.setString(8, _universitas);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public String lihatRiwayatPemeriksaan(int _idDokter) {
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        String riwayatPemeriksaan = "<html>";
        int _idPemeriksaan, _idPasien, _idKoas, _biaya;
        String _penyakit;
        LocalDate _tanggal;

        for (Pemeriksaan pemeriksaan : listAllPemeriksaan) {
            if (pemeriksaan.getIdDokter() == _idDokter) {
                _idPemeriksaan = pemeriksaan.getIdPemeriksaan();
                _idPasien= pemeriksaan.getIdPasien();
                String _namaPasien = Controller.getPasienNameById(_idPasien);
                _idKoas = pemeriksaan.getIdKoas();
                String _namaKoas = Controller.getKoasNameById(_idKoas);
                _biaya = pemeriksaan.getBiaya();
                _penyakit = pemeriksaan.getPenyakit();
                _tanggal = pemeriksaan.getTanggal();
                riwayatPemeriksaan += "Id Pemeriksaan : " + _idPemeriksaan + "<br>Nama Pasien : " + _namaPasien +
                        "<br>Nama Koas : " + _namaKoas + "<br>Biaya : " + _biaya + "<br>Penyakit : " + _penyakit +
                        "<br>Tanggal : " + _tanggal + "<br><br>";
            }
        }
        riwayatPemeriksaan += "</html>";
        return (riwayatPemeriksaan);
    }

    public boolean updateDataDokter(int _idDokter, int _idSpesialis, String _firstName, String _lastName, String _email, String _address, String _phone, Date _dob, char _gender, int _pendapatan) {
        conn.connect();
        String query = "UPDATE dokter SET idSpesialis='"
                + _idSpesialis + "', firstName='" + _firstName + "', lastName='"
                + _lastName + "', email='" + _email + "', address='"
                + _address + "', phone='" + _phone + "', dob='"
                + _dob + "', gender='" + _gender + "', pendapatan='" + _pendapatan + "'" + "WHERE idDokter='" + _idDokter + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }

    public boolean updateDataKoas(int _idKoas, String _firstName, String _lastName, String _email, String _address, String _phone, Date _dob, char _gender, String _universitas) {
        conn.connect();
        String query = "UPDATE koas SET firstName='"
                + _firstName + "', lastName='" + _lastName + "', email='"
                + _email + "', address='" + _address + "', phone='" + _phone
                + "', dob='" + _dob + "', gender='" + _gender + "', universitas='"
                + _universitas + "'" + "WHERE idKoas='" + _idKoas + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }

    public boolean updateJadwalPemeriksaan(int _idDokter, int _jamMulai, int _jamSelesai) {
        conn.connect();
        String query = "UPDATE dokter SET  jamMulaiPrak='" 
                + _jamMulai + "', jamSelesaiPrak='" + _jamSelesai + "'" + "WHERE idDokter='" + _idDokter + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }
}
