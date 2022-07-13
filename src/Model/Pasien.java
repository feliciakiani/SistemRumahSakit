package Model;

import java.time.LocalDate;

public class Pasien extends Pengguna{
    private String password;
    private int idPasien;
    private UserTypeEnum role = UserTypeEnum.PENGGUNA;

    public Pasien() {
    }

    public Pasien(int idPasien, UserTypeEnum role) {
        this.idPasien = idPasien;
        this.role = role;
    }

    public Pasien(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Pasien(int idPasien, UserTypeEnum role, String firstName, String lastName, String email, String address, String phone, LocalDate dob, char gender) {
        super(firstName, lastName, email, address, phone, dob, gender);
        this.idPasien = idPasien;
        this.role = role;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public UserTypeEnum getRole() {
        return role;
    }

    public void setRole(UserTypeEnum role) {
        this.role = role;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
