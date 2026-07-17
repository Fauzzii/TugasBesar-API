/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import tugasbesar.config.Database;
import model.Anggota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BRAVO
 */
public class AnggotaDAO {
    public boolean tambahAnggota(
            Anggota anggota
    ) {
        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "INSERT INTO anggota(" +
                    "nim,nama,alamat" +
                    ") VALUES(?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    anggota.getNim()
            );

            ps.setString(
                    2,
                    anggota.getNama()
            );

            ps.setString(
                    3,
                    anggota.getAlamat()
            );

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }

    public List<Anggota> getAllAnggota() {

        List<Anggota> list =
                new ArrayList<>();

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "SELECT * FROM anggota";

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while (rs.next()) {

                Anggota anggota =
                        new Anggota();

                anggota.setId(
                        rs.getInt("id")
                );

                anggota.setNim(
                        rs.getString("nim")
                );

                anggota.setNama(
                        rs.getString("nama")
                );

                anggota.setAlamat(
                        rs.getString("alamat")
                );

                list.add(anggota);
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return list;
    }

    public Anggota getAnggotaById(
            int id
    ) {

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "SELECT * " +
                    "FROM anggota " +
                    "WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                Anggota anggota =
                        new Anggota();

                anggota.setId(
                        rs.getInt("id")
                );

                anggota.setNim(
                        rs.getString("nim")
                );

                anggota.setNama(
                        rs.getString("nama")
                );

                anggota.setAlamat(
                        rs.getString("alamat")
                );

                return anggota;
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return null;
    }

    public boolean updateAnggota(
            Anggota anggota
    ) {

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "UPDATE anggota " +
                    "SET nim=?, " +
                    "nama=?, " +
                    "alamat=? " +
                    "WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    anggota.getNim()
            );

            ps.setString(
                    2,
                    anggota.getNama()
            );

            ps.setString(
                    3,
                    anggota.getAlamat()
            );

            ps.setInt(
                    4,
                    anggota.getId()
            );

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }

    public boolean deleteAnggota(
            int id
    ) {

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "DELETE FROM anggota " +
                    "WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }
}
