
package Model;
import java.time.LocalDate;


public abstract class Pengguna implements GenderInterface{
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private LocalDate dob;
    private char gender;

    public Pengguna() {
    }

    
    public Pengguna(String firstName, String lastName, String email, String address, String phone, LocalDate dob, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        
        if(gender == GenderInterface.MALE){
            return "Laki-laki";
        }
        return "Perempuan";
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
