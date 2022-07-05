
package Model;


public abstract class Staff {
    private String username;
    private String fullName;
    private String password;
    private String email;
    private UserTypeEnum role;

    public Staff() {
    }

    
    public Staff(String username, String fullName, String password, String email, UserTypeEnum role) {
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

    public UserTypeEnum getRole() {
        return role;
    }

    public void setRole(UserTypeEnum role) {
        this.role = role;
    }
    
    
    
}
