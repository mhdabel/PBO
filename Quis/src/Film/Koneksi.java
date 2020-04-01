package Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private Connection Koneksi = null;

    public Connection connect() {

        try {// untuk koneksi ke driver
            // untuk mencari library
            Class.forName("com.mysql.jdbc.Driver"); //LOAD DRIVER
            System.out.println("berhasil load driver");
        } catch (ClassNotFoundException no) {
            System.out.println("Tidak ada Driver " + no);
        }
        try {// untuk koneksi ke database
            String url = "jdbc:mysql://localhost:3306/buku"; //driver yg akan dpakai dan nama basis datanya
            Koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil koneksi ke database");
        } catch (SQLException e) {
            System.out.println("Gagal koneksi " + e);
            JOptionPane.showMessageDialog(null, "Gagal Mengoneksikan ke Database", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        return Koneksi;
    }
}
