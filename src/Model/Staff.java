/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Felicia
 */
public abstract class Staff {
    private String username;
    private String fullName;
    private String password;
    private String email;
    private StaffTypeEnum role;

    public Staff(String username, String fullName, String password, String email, StaffTypeEnum role) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StaffTypeEnum getRole() {
        return role;
    }

    public void setRole(StaffTypeEnum role) {
        this.role = role;
    }
    
    
    
}
