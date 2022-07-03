/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Felicia
 */
public class Pasien extends Pengguna{
    
    private int idPasien;
    private int idAntrian;
    ArrayList<Integer> idPemeriksaan = new ArrayList<>();

    public Pasien(int idPasien, int idAntrian, String firstName, String lastName, String email, String address, String phone, LocalDate dob, char gender) {
        super(firstName, lastName, email, address, phone, dob, gender);
        this.idPasien = idPasien;
        this.idAntrian = idAntrian;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public int getIdAntrian() {
        return idAntrian;
    }

    public void setIdAntrian(int idAntrian) {
        this.idAntrian = idAntrian;
    }

    public ArrayList<Integer> getIdPemeriksaan() {
        return idPemeriksaan;
    }

    public void setIdPemeriksaan(ArrayList<Integer> idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }
    
}
