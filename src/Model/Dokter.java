
package Model;

import java.time.LocalDate;


public class Dokter extends Pengguna {
    
    private int idDokter;
    private int pendapatan;
    private int jamMulaiPrak;
    private int jamSelesaiPrak;
    private int idSpesialis;

    public Dokter() {
    }

    
    public Dokter(int idDokter, int pendapatan, int jamMulaiPrak, int jamSelesaiPrak, int idSpesialis, String firstName, String lastName, String email, String address, String phone, LocalDate dob, char gender) {
        super(firstName, lastName, email, address, phone, dob, gender);
        this.idDokter = idDokter;
        this.pendapatan = pendapatan;
        this.jamMulaiPrak = jamMulaiPrak;
        this.jamSelesaiPrak = jamSelesaiPrak;
        this.idSpesialis = idSpesialis;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(int idDokter) {
        this.idDokter = idDokter;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(int pendapatan) {
        this.pendapatan = pendapatan;
    }

    public int getJamMulaiPrak() {
        return jamMulaiPrak;
    }

    public void setJamMulaiPrak(int jamMulaiPrak) {
        this.jamMulaiPrak = jamMulaiPrak;
    }

    public int getJamSelesaiPrak() {
        return jamSelesaiPrak;
    }

    public void setJamSelesaiPrak(int jamSelesaiPrak) {
        this.jamSelesaiPrak = jamSelesaiPrak;
    }

    public int getIdSpesialis() {
        return idSpesialis;
    }

    public void setIdSpesialis(int idSpesialis) {
        this.idSpesialis = idSpesialis;
    }
    
    
    
}
