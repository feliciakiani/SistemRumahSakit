package Controller;

import Model.Antrian;
import Model.Pasien;
import Model.Pemeriksaan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    // public static void tes() {
    //     System.out.println("conn");
    // }
    
    // SELECT ALL from table pemeriksaan
    public static ArrayList<Pemeriksaan> getAllPemeriksaan() {
        ArrayList<Pemeriksaan> listPemeriksaan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pemeriksaan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pemeriksaan pemeriksaan = new Pemeriksaan();
                pemeriksaan.setIdPemeriksaan(rs.getInt("idPemeriksaan"));
                pemeriksaan.setIdDokter(rs.getInt("idDokter"));
                pemeriksaan.setIdPasien(rs.getInt("idPasien"));
                pemeriksaan.setIdKoas(rs.getInt("idKoas"));
                pemeriksaan.setBiaya(rs.getInt("biaya"));
                pemeriksaan.setPenyakit(rs.getString("penyakit"));
                pemeriksaan.setTanggal(rs.getDate("tanggal").toLocalDate());
                listPemeriksaan.add(pemeriksaan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listPemeriksaan);
    }
    
    // SELECT ALL from table pasien
    public static ArrayList<Pasien> getAllPasien() {
        ArrayList<Pasien> listPasien = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pasien";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pasien pasien = new Pasien();
                pasien.setIdPasien(rs.getInt("idPasien"));
                pasien.setFirstName(rs.getString("firstName"));
                pasien.setLastName(rs.getString("lastName"));
                pasien.setEmail(rs.getString("email"));
                pasien.setAddress(rs.getString("address"));
                pasien.setPhone(rs.getString("phone"));
                pasien.setDob(rs.getDate("dob").toLocalDate());
                pasien.setGender(rs.getString("gender").charAt(0));
                // ADA VAR PENYAKIT DI DB
                listPasien.add(pasien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listPasien);
    }
    
    // SELECT ALL from table pasien BY first and last name
    public static Pasien getPasien(String _firstName, String _lastName) {
        Pasien pasien = new Pasien();
        conn.connect();
        String query = "SELECT * FROM pasien WHERE firstName='" + _firstName + "'&&lastName='" + _lastName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pasien.setIdPasien(rs.getInt("idPasien"));
                pasien.setFirstName(rs.getString("firstName"));
                pasien.setLastName(rs.getString("lastName"));
                pasien.setEmail(rs.getString("email"));
                pasien.setAddress(rs.getString("address"));
                pasien.setPhone(rs.getString("phone"));
                pasien.setDob(rs.getDate("dob").toLocalDate());
                pasien.setGender(rs.getString("gender").charAt(0));
                // ADA VAR PENYAKIT DI DB
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasien;
    }
    
    // SELECT ALL from table antrian BY spesialis
    public static ArrayList<Antrian> getAntrian(int _idSpesialis) {
        ArrayList<Antrian> listAntrian = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM antrian WHERE idSpesialis='" + _idSpesialis + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Antrian antrian = new Antrian();
                antrian.setIdAntrian(rs.getInt("idAntrian"));
                antrian.setIdSpesialis(rs.getInt("idSpesialis"));
                antrian.setIdDokter(rs.getInt("idDokter"));
                antrian.setIdPasien(rs.getInt("idPasien"));
                antrian.setTanggalPesan(rs.getDate("tanggalPesan").toLocalDate());
                antrian.setTanggalPeriksa(rs.getDate("tanggalPeriksa").toLocalDate());
                listAntrian.add(antrian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAntrian;
    }
    
    public static void main(String[] args) {
        System.out.println("!UNTUK CEKKKK!");
        System.out.println("");
        
        System.out.println("getAllPemeriksaan : ");
        ArrayList<Pemeriksaan> listPemeriksaan = new ArrayList<>();
        listPemeriksaan = getAllPemeriksaan();
        
        System.out.println("listPemeriksaan.get(0).getPenyakit(); = " + listPemeriksaan.get(0).getPenyakit());
        
        System.out.println("");
        
        System.out.println("getAllPasien :");
        ArrayList<Pasien> listPasien = new ArrayList<>();
        listPasien = getAllPasien();
        
        System.out.println("listPasien.get(2).getAddress() = " + listPasien.get(2).getAddress());
        
        
        System.out.println("");
        System.out.println("getPasien :");
        Pasien pasien = new Pasien();
        pasien = getPasien("Felicia", "Kiani");
        
        System.out.println("pasien.getDob() = " + pasien.getDob());
        
        
        System.out.println("");
        System.out.println("getAntrian :");
        ArrayList<Antrian> listAntrian = new ArrayList<>();
        listAntrian = getAntrian(1);
        
        System.out.println("listAntrian.get(0).getTanggalPesan() = " + listAntrian.get(0).getTanggalPesan());
        
    }
    

    // // SELECT ALL from table users
    // public static ArrayList<User> getAllUsers() {
    //     ArrayList<User> users = new ArrayList<>();
    //     conn.connect();
    //     String query = "SELECT * FROM users";
    //     try {
    //         Statement stmt = conn.con.createStatement();
    //         ResultSet rs = stmt.executeQuery(query);
    //         while (rs.next()) {
    //             User user = new User();
    //             user.setId(rs.getInt("ID"));
    //             user.setName(rs.getString("Name"));
    //             user.setAddress(rs.getString("Address"));
    //             user.setPhone(rs.getString("Phone"));
    //             user.setAge(rs.getInt("Age"));
    //             users.add(user);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return (users);
    // }
    // // SELECT WHERE
    // public static User getUser(String name, String address) {
    //     conn.connect();
    //     String query = "SELECT * FROM users WHERE Name='" + name + "'&&Address='" + address + "'";
    //     User user = new User();
    //     try {
    //         Statement stmt = conn.con.createStatement();
    //         ResultSet rs = stmt.executeQuery(query);
    //         while (rs.next()) {
    //             user.setId(rs.getInt("ID"));
    //             user.setName(rs.getString("Name"));
    //             user.setAddress(rs.getString("Address"));
    //             user.setPhone(rs.getString("Phone"));
    //             user.setAge(rs.getInt("Age"));
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return (user);
    // }
    // // INSERT
    // public static boolean insertNewUser(User user) {
    //     conn.connect();
    //     String query = "INSERT INTO users VALUES(?,?,?,?,?)";
    //     try {
    //         PreparedStatement stmt = conn.con.prepareStatement(query);
    //         stmt.setInt(1, user.getId());
    //         stmt.setString(2, user.getName());
    //         stmt.setString(3, user.getAddress());
    //         stmt.setString(4, user.getPhone());
    //         stmt.setInt(5, user.getAge());
    //         stmt.executeUpdate();
    //         return (true);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return (false);
    //     }
    // }
    // // UPDATE
    // public static boolean updateUser(User user) {
    //     conn.connect();
    //     String query = "UPDATE users SET Name='" + user.getName() + "', "
    //             + "Address='" + user.getAddress() + "', "
    //             + "Phone='" + user.getPhone() + "' "
    //             + "WHERE ID='" + user.getId() + "'";
    //     try {
    //         Statement stmt = conn.con.createStatement();
    //         stmt.executeUpdate(query);
    //         return (true);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return (false);
    //     }
    // }
    // // DELETE
    // public static boolean deleteUser(String name) {
    //     conn.connect();
    //     String query = "DELETE FROM users WHERE Name='" + name + "'";
    //     try {
    //         Statement stmt = conn.con.createStatement();
    //         stmt.executeUpdate(query);
    //         return (true);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return (false);
    //     }
    // }
}
