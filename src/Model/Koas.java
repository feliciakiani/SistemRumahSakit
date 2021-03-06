
package Model;

import java.time.LocalDate;


public class Koas extends Pengguna {
    private int idKoas;
    private String universitas;

    public Koas() {
    }

    
    public Koas(int idKoas, String universitas, String firstName, String lastName, String email, String address, String phone, LocalDate dob, char gender) {
        super(firstName, lastName, email, address, phone, dob, gender);
        this.idKoas = idKoas;
        this.universitas = universitas;
    }

    public int getIdKoas() {
        return idKoas;
    }

    public void setIdKoas(int idKoas) {
        this.idKoas = idKoas;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }
    
    
}
