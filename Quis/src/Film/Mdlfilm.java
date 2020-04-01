
package Film;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Mdlfilm {

    public void simpanfilm(String kode, String judul, String tipe, String genre) {
        java.sql.Connection con;
        con = new Koneksi().connect();
        String sql = "INSERT INTO `film`(`kode`, `judul`, `tipe`, `genre`) VALUES (?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, kode);
            pstmt.setString(2, judul);
            pstmt.setString(3, tipe);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void hapusfilm(String kode) {
        java.sql.Connection con;
        con = new Koneksi().connect();
        String sql = "DELETE FROM `film` WHERE `kode`='" + kode + "' ";
        Statement s;
        try {
            s = con.createStatement();
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Terhapus", "sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updatefilm(String kode, String judul, String tipe, String genre) {
        java.sql.Connection con;
        con = new Koneksi().connect();
        String sql = "UPDATE `film` SET `judul`='" + judul + "',`tipe`='" + tipe + "',`genre`='" + genre + "' WHERE `kode`='" + kode + "' ";
        Statement s;
        try {
            s = con.createStatement();
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}