package Model;

public class ActiveUserID {
    // Singleton untuk cek user yang aktif
    private static ActiveUserID activeUserID = null;
    public int userID;

    public static ActiveUserID ActiveUserID() {
        if (activeUserID == null) {
            activeUserID = new ActiveUserID();
        }
        return activeUserID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
