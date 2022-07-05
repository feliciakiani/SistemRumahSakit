/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.time.LocalDate;
/**
 *
 * @author Felicia
 */
public class Antrian {
    private int idAntrian;
    private int idSpesialis;
    private int idDokter;
    private int idPasien;
    private LocalDate tanggalPesan;
    private LocalDate tanggalPeriksa;

    public Antrian() {
    }

    
    public Antrian(int idAntrian, int idSpesialis, int idDokter, int idPasien, LocalDate tanggalPesan, LocalDate tanggalPeriksa) {
        this.idAntrian = idAntrian;
        this.idSpesialis = idSpesialis;
        this.idDokter = idDokter;
        this.idPasien = idPasien;
        this.tanggalPesan = tanggalPesan;
        this.tanggalPeriksa = tanggalPeriksa;
    }

    public int getIdAntrian() {
        return idAntrian;
    }

    public void setIdAntrian(int idAntrian) {
        this.idAntrian = idAntrian;
    }

    public int getIdSpesialis() {
        return idSpesialis;
    }

    public void setIdSpesialis(int idSpesialis) {
        this.idSpesialis = idSpesialis;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public LocalDate getTanggalPesan() {
        return tanggalPesan;
    }

    public void setTanggalPesan(LocalDate tanggalPesan) {
        this.tanggalPesan = tanggalPesan;
    }

    public LocalDate getTanggalPeriksa() {
        return tanggalPeriksa;
    }

    public void setTanggalPeriksa(LocalDate tanggalPeriksa) {
        this.tanggalPeriksa = tanggalPeriksa;
    }
    
    
}
