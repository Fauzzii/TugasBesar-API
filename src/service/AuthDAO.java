/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import tugasbesar.config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author BRAVO
 */
public class AuthDAO {
    
    public User login(
            String email,
            String password
    ){
        
        try {

            Connection conn =
                    Database.getConnection();

            String sql =
                    "SELECT * " +
                    "FROM user " +
                    "WHERE email=? " +
                    "AND password=?";

            PreparedStatement ps =
                    conn.prepareStatement(
                            sql
                    );

            ps.setString(
                    1,
                    email
            );

            ps.setString(
                    2,
                    password
            );

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                User user =
                        new User();

                user.setId(
                        rs.getInt(
                                "id"
                        )
                );

                user.setEmail(
                        rs.getString(
                                "email"
                        )
                );

                user.setNama(
                        rs.getString(
                                "nama"
                        )
                );

                user.setAlamat(
                        rs.getString(
                                "alamat"
                        )
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
}