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
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Sheren
 */
public class AdminFunctions {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean registDokter(Dokter dokter) throws SQLException {
        conn.connect();
        String query = "INSERT INTO dokter VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, dokter.getIdDokter());
            stmt.setInt(2, dokter.getIdSpesialis());
            stmt.setString(3, dokter.getFirstName());
            stmt.setString(4, dokter.getLastName());
            stmt.setString(5, dokter.getEmail());
            stmt.setString(6, dokter.getAddress());
            stmt.setString(7, dokter.getPhone());
            stmt.setDate(8, Date.valueOf(dokter.getDob()));
            stmt.setString(9, dokter.getGender());
            stmt.setInt(10, dokter.getJamMulaiPrak());
            stmt.setInt(11, dokter.getJamSelesaiPrak());
            stmt.setInt(12, dokter.getPendapatan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean registKoas(Koas koas) {
        conn.connect();
        String query = "INSERT INTO koas VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, koas.getIdKoas());
            stmt.setString(2, koas.getFirstName());
            stmt.setString(3, koas.getLastName());
            stmt.setString(4, koas.getEmail());
            stmt.setString(5, koas.getAddress());
            stmt.setString(6, koas.getPhone());
            stmt.setDate(7, Date.valueOf(koas.getDob()));
            stmt.setString(8, koas.getGender());
            stmt.setString(9, koas.getUniversitas());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean lihatRiwayatPemeriksaan(int _idDokter) {
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        String riwayatPemeriksaan = "";

        for (Pemeriksaan pemeriksaan : listAllPemeriksaan) {
            if (pemeriksaan.getIdDokter() == _idDokter) {
                riwayatPemeriksaan += pemeriksaan.getIdPemeriksaan();
                riwayatPemeriksaan += pemeriksaan.getIdPasien();
                riwayatPemeriksaan += pemeriksaan.getIdKoas();
                riwayatPemeriksaan += pemeriksaan.getBiaya();
                riwayatPemeriksaan += pemeriksaan.getPenyakit();
                riwayatPemeriksaan += pemeriksaan.getTanggal();
            }
        }
        return (true);
    }

    public void updateDataDokterKoas() {

    }

    public void updateJadwalPemeriksaan() {

    }
}
