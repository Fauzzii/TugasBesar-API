/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import tugasbesar.config.Database;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRAVO
 */
public class UserDAO {
    public boolean tambahUser(User user) {
        
        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "INSERT INTO user(" +
                    "email, password, nama, alamat" +
                    ") VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNama());
            ps.setString(4, user.getAlamat());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<User> getAllUser() {

        List<User> users =
                new ArrayList<>();

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "SELECT * FROM user";

            Statement st =
                    conn.createStatement();

            ResultSet rs =
                    st.executeQuery(sql);

            while (rs.next()) {

                User user =
                        new User();

                user.setId(
                        rs.getInt("id")
                );

                user.setEmail(
                        rs.getString("email")
                );

                user.setPassword(
                        rs.getString("password")
                );

                user.setNama(
                        rs.getString("nama")
                );

                user.setAlamat(
                        rs.getString("alamat")
                );

                users.add(user);
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return users;
    }

    public User getUserById(
            int id
    ) {

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "SELECT * " +
                    "FROM user " +
                    "WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                User user =
                        new User();

                user.setId(
                        rs.getInt("id")
                );

                user.setEmail(
                        rs.getString("email")
                );

                user.setPassword(
                        rs.getString("password")
                );

                user.setNama(
                        rs.getString("nama")
                );

                user.setAlamat(
                        rs.getString("alamat")
                );

                return user;
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return null;
    }

    public boolean updateUser(
            User user
    ) {

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "UPDATE user " +
                    "SET email=?, " +
                    "password=?, " +
                    "nama=?, " +
                    "alamat=? " +
                    "WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    user.getEmail()
            );

            ps.setString(
                    2,
                    user.getPassword()
            );

            ps.setString(
                    3,
                    user.getNama()
            );

            ps.setString(
                    4,
                    user.getAlamat()
            );

            ps.setInt(
                    5,
                    user.getId()
            );

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }

    public boolean deleteUser(
            int id
    ) {

        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "DELETE FROM user " +
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
