package Controller;

import Model.Admin;
import Model.Antrian;
import Model.Dokter;
import Model.Koas;
import Model.Manager;
import Model.Pasien;
import Model.Pemeriksaan;
import Model.Spesialis;
import Model.Staff;
import Model.UserTypeEnum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
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

    // SELECT ALL from table dokter
    public static ArrayList<Dokter> getAllDokter() {
        ArrayList<Dokter> listDokter = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM dokter";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Dokter dokter = new Dokter();
                dokter.setIdDokter(rs.getInt("idDokter"));
                dokter.setIdSpesialis(rs.getInt("idSpesialis"));
                dokter.setFirstName(rs.getString("firstName"));
                dokter.setLastName(rs.getString("lastName"));
                dokter.setEmail(rs.getString("email"));
                dokter.setAddress(rs.getString("address"));
                dokter.setPhone(rs.getString("phone"));
                dokter.setDob(rs.getDate("dob").toLocalDate());
                dokter.setGender(rs.getString("gender").charAt(0));
                dokter.setJamMulaiPrak(rs.getInt("jamMulaiPrak"));
                dokter.setJamSelesaiPrak(rs.getInt("jamSelesaiPrak"));
                dokter.setPendapatan(rs.getInt("pendapatan"));
                listDokter.add(dokter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listDokter);
    }

    // SELECT ALL from table dokter BY first and last name
    public static Dokter getDokter(String _firstName, String _lastName) {
        Dokter dokter = new Dokter();
        conn.connect();
        String query = "SELECT * FROM dokter WHERE firstName='" + _firstName + "'&&lastName='" + _lastName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dokter.setIdDokter(rs.getInt("idDokter"));
                dokter.setIdSpesialis(rs.getInt("idSpesialis"));
                dokter.setFirstName(rs.getString("firstName"));
                dokter.setLastName(rs.getString("lastName"));
                dokter.setEmail(rs.getString("email"));
                dokter.setAddress(rs.getString("address"));
                dokter.setPhone(rs.getString("phone"));
                dokter.setDob(rs.getDate("dob").toLocalDate());
                dokter.setGender(rs.getString("gender").charAt(0));
                dokter.setJamMulaiPrak(rs.getInt("jamMulaiPrak"));
                dokter.setJamSelesaiPrak(rs.getInt("jamSelesaiPrak"));
                dokter.setPendapatan(rs.getInt("pendapatan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dokter;
    }

    // SELECT ALL from table koas
    public static ArrayList<Koas> getAllKoas() {
        ArrayList<Koas> listKoas = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM koas";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Koas koas = new Koas();
                koas.setIdKoas(rs.getInt("idKoas"));
                koas.setFirstName(rs.getString("firstName"));
                koas.setLastName(rs.getString("lastName"));
                koas.setEmail(rs.getString("email"));
                koas.setAddress(rs.getString("address"));
                koas.setPhone(rs.getString("phone"));
                koas.setDob(rs.getDate("dob").toLocalDate());
                koas.setGender(rs.getString("gender").charAt(0));
                koas.setUniversitas(rs.getString("universitas"));
                listKoas.add(koas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listKoas);
    }

    // SELECT ALL from table koas BY first and last name
    public static Koas getKoas(String _firstName, String _lastName) {
        Koas koas = new Koas();
        conn.connect();
        String query = "SELECT * FROM koas WHERE firstName='" + _firstName + "'&&lastName='" + _lastName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                koas.setIdKoas(rs.getInt("idKoas"));
                koas.setFirstName(rs.getString("firstName"));
                koas.setLastName(rs.getString("lastName"));
                koas.setEmail(rs.getString("email"));
                koas.setAddress(rs.getString("address"));
                koas.setPhone(rs.getString("phone"));
                koas.setDob(rs.getDate("dob").toLocalDate());
                koas.setGender(rs.getString("gender").charAt(0));
                koas.setUniversitas(rs.getString("universitas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return koas;
    }

    // SELECT ALL from table spesialis
    public static ArrayList<Spesialis> getAllSpesialis() {
        ArrayList<Spesialis> listSpesialis = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM spesialis";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Spesialis spesialis = new Spesialis();
                spesialis.setIdSpesialis(rs.getInt("idSpesialis"));
                spesialis.setBidangSpesialis(rs.getString("bidangSpesialis"));
                listSpesialis.add(spesialis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listSpesialis);
    }

    // SELECT ALL from table staff BY username, password, role (admin)
    public static Admin getAdmin(String _username, String _password, UserTypeEnum _role) {
        Admin admin = new Admin();
        conn.connect();
        String query = "SELECT * FROM staff WHERE username='" + _username + "'&&password='" + _password + "'&&role='" + _role + "'";
        if (_role.equals(Model.UserTypeEnum.ADMIN)) {
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    admin.setFullName(rs.getString("fullname"));
                    admin.setEmail(rs.getString("email"));
                    admin.setRole(UserTypeEnum.ADMIN);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin;
    }

    // SELECT ALL from table staff BY username, password, role (manager) 
    public static Manager getManager(String _username, String _password, UserTypeEnum _role) {
        Manager manager = new Manager();
        conn.connect();
        String query = "SELECT * FROM staff WHERE username='" + _username + "'&&password='" + _password + "'&&role='" + _role + "'";
        if (_role.equals(Model.UserTypeEnum.MANAGER)) {
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    manager.setUsername(rs.getString("username"));
                    manager.setPassword(rs.getString("password"));
                    manager.setFullName(rs.getString("fullname"));
                    manager.setEmail(rs.getString("email"));
                    manager.setRole(UserTypeEnum.MANAGER);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return manager;
    }
    
    public static ArrayList<Antrian> getAllAntrian() {
        ArrayList<Antrian> listAntrian = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM antrian";
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
                listAntrian.add(antrian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listAntrian);
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
    
    public static boolean insertAntrian(Antrian antrian) {
         conn.connect();
         String query = "INSERT INTO pemeriksaan VALUES(?,?,?,?,?,?,?)";
         try {
             PreparedStatement stmt = conn.con.prepareStatement(query);
             stmt.setInt(1, antrian.getIdAntrian());
             stmt.setInt(2, antrian.getIdSpesialis());
             stmt.setInt(3, antrian.getIdDokter());
             stmt.setInt(4, antrian.getIdPasien());
             stmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
             stmt.setDate(6, java.sql.Date.valueOf(antrian.getTanggalPeriksa()));
             stmt.executeUpdate();
             return (true);
         } catch (SQLException e) {
             e.printStackTrace();
             return (false);
         }
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
        System.out.println("getAllDokter : ");
        ArrayList<Dokter> listDokter = new ArrayList<>();
        listDokter = getAllDokter();

        System.out.println("listDokter.get(1).getPendapatan = " + listDokter.get(1).getPendapatan());

        System.out.println("");
        System.out.println("getDokter :");
        Dokter dokter = new Dokter();
        dokter = getDokter("Dr. Ani", "Sumarni");

        System.out.println("dokter.getIdDokter() = " + dokter.getIdDokter());

        System.out.println("");
        System.out.println("getAllKoas : ");
        ArrayList<Koas> listKoas = new ArrayList<>();
        listKoas = getAllKoas();

        System.out.println("listDokter.get(1).getUniversitas = " + listKoas.get(1).getUniversitas());

        System.out.println("");
        System.out.println("getKoas :");
        Koas koas = new Koas();
        koas = getKoas("Anto", "Sumanto");

        System.out.println("koas.getPhone() = " + koas.getPhone());
        
        System.out.println("");
        System.out.println("getAdmin :");
        Admin admin = new Admin();
        admin = getAdmin("admin", "admin", Model.UserTypeEnum.ADMIN);

        System.out.println("admin.getFullname() = " + admin.getFullName());
        
        System.out.println("");
        System.out.println("getManager :");
        Manager manager = new Manager();
        manager = getManager("manager", "manager", Model.UserTypeEnum.MANAGER);

        System.out.println("manager.getFullname() = " + manager.getFullName()); 
        
        System.out.println("");
        System.out.println("getAllSpesialis : ");
        ArrayList<Spesialis> listSpesialis = new ArrayList<>();
        listSpesialis = getAllSpesialis();

        System.out.println("listSpesialis.get(2).getBidangSpesialis = " + listSpesialis.get(2).getBidangSpesialis());

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
