package Model;


public class Admin extends Staff {

    public Admin(String username, String fullName, String password, String email, UserTypeEnum role) {
        super(username, fullName, password, email, role);
    }
    
}
