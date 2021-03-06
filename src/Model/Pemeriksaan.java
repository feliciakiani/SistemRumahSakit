
package Model;
import java.time.LocalDate;

public class Pemeriksaan {
    private int idPemeriksaan;
    private int idDokter;
    private int idKoas;
    private int idPasien;
    private String penyakit;
    private int biaya;
    private LocalDate tanggal;

    public Pemeriksaan() {
    }

    
    public Pemeriksaan(int idPemeriksaan, int idDokter, int idKoas, int idPasien, String penyakit, int biaya, LocalDate tanggal) {
        this.idPemeriksaan = idPemeriksaan;
        this.idDokter = idDokter;
        this.idKoas = idKoas;
        this.idPasien = idPasien;
        this.penyakit = penyakit;
        this.biaya = biaya;
        this.tanggal = tanggal;
    }

    public int getIdPemeriksaan() {
        return idPemeriksaan;
    }

    public void setIdPemeriksaan(int idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public int getIdKoas() {
        return idKoas;
    }

    public void setIdKoas(int idKoas) {
        this.idKoas = idKoas;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tangga) {
        this.tanggal = tangga;
    }
    
    
}
