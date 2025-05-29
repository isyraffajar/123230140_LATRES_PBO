package latihanresponsi.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelApotek {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;

    public ModelApotek() {
        try {
            conn = new Koneksi().getKoneksi();
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
    }

    public List<String[]> getAllData() {
        List<String[]> data = new ArrayList<>();
        try {
            String query = "SELECT * FROM transaksi";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String namaPelanggan = rs.getString("nama_pelanggan");
                String namaObat = rs.getString("nama_obat");
                int harga = rs.getInt("harga");
                int jmlBeli = rs.getInt("jml_beli");

                double diskon = (jmlBeli >= 5) ? 0.1 * harga * jmlBeli : 0;
                double total = harga * jmlBeli - diskon;

                data.add(new String[] {
                    String.valueOf(id), namaPelanggan, namaObat,
                    String.valueOf(jmlBeli), String.valueOf(harga),
                    String.format("%.0f", diskon), String.format("%.0f", total)
                });
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Gagal Ambil Data: " + e.getMessage());
        }
        return data;
    }

    public void insert(String namaPelanggan, String namaObat, int harga, int jmlBeli) {
        try {
            String sql = "INSERT INTO transaksi (nama_pelanggan, nama_obat, harga, jml_beli) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, namaPelanggan);
            pstmt.setString(2, namaObat);
            pstmt.setInt(3, harga);
            pstmt.setInt(4, jmlBeli);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert Gagal: " + e.getMessage());
        }
    }

    public void update(int id, String namaPelanggan, String namaObat, int harga, int jmlBeli) {
        try {
            String sql = "UPDATE transaksi SET nama_pelanggan=?, nama_obat=?, harga=?, jml_beli=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, namaPelanggan);
            pstmt.setString(2, namaObat);
            pstmt.setInt(3, harga);
            pstmt.setInt(4, jmlBeli);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Gagal: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM transaksi WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Gagal: " + e.getMessage());
        }
    }

    public String[] getDataById(int id) {
        try {
            String sql = "SELECT * FROM transaksi WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new String[] {
                    rs.getString("nama_pelanggan"),
                    rs.getString("nama_obat"),
                    String.valueOf(rs.getInt("harga")),
                    String.valueOf(rs.getInt("jml_beli"))
                };
            }
        } catch (SQLException e) {
            System.out.println("Ambil Data by ID Gagal: " + e.getMessage());
        }
        return null;
    }
}
