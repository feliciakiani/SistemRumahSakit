package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DatabaseHandler {

    public Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    // ubah server, username, sama password sesuai konfigurasi masing masing ygy
    private String url = "jdbc:mysql://localhost:4306/tubespbo";
    private String username = "root";
    private String password = "";

    private Connection logOn() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
        return con;
    }

    private void logOff() {
        try {
            //tutup koneksi
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Ocurred when logoff" + ex);
        }
    }

    public void connect() {
        try {
            con = logOn();
        } catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }

    public void disconnect() {
        try {
            logOff();
        } catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }

    public void initialize() throws Exception {
        ScriptRunner sr = new ScriptRunner(con);
        Reader reader = new BufferedReader(new FileReader("tubespbo.sql"));
        sr.runScript(reader);
    }
}