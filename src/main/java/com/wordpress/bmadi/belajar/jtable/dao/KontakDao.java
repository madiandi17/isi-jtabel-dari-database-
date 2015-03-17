package com.wordpress.bmadi.belajar.jtable.dao;

import com.wordpress.bmadi.belajar.jtable.model.Kontak;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KontakDao {

    private Connection connection;

    private void connect() {
        try {
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost/belajar";
            String dbUsername = "root";
            String dbPassword = "java";

            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception ex) {
            Logger.getLogger(KontakDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void disconnet() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KontakDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Kontak> cariSemua() {
        List<Kontak> hasil = new ArrayList<Kontak>();
        try {

            String sql = "SELECT * FROM t_kontak ORDER BY nama";

            connect();
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Kontak k = konversiResultSetJadiKontak(rs);
                hasil.add(k);
            }
            disconnet();
        } catch (SQLException ex) {
            Logger.getLogger(KontakDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;

    }

    public List<Kontak> cariByNama(String nama) {
        List<Kontak> hasil = new ArrayList<Kontak>();
        try {

            String sql = "SELECT * FROM t_kontak WHERE nama like ? ORDER BY nama";

            connect();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + nama + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Kontak k = konversiResultSetJadiKontak(rs);
                hasil.add(k);
            }
            disconnet();
        } catch (SQLException ex) {
            Logger.getLogger(KontakDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;

    }

    private Kontak konversiResultSetJadiKontak(ResultSet rs) throws SQLException {
        Kontak k = new Kontak();
        k.setId(rs.getInt("id"));
        k.setNama(rs.getString("nama"));
        k.setAlamat(rs.getString("alamat"));
        k.setTanggalLahir(new Date(rs.getDate("tanggal_lahir").getTime()));
        k.setAktif(rs.getBoolean("aktif"));

        return k;
    }
}
