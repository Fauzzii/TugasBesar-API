/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Fauzi
 */
public class Database {
    
        private static Connection conn;
    
    public static Connection getConnection() {

        try {

            if (conn == null) {

                String url =
                        "jdbc:mysql://localhost:3306/perpustakaan";

                String username = "root";

                String password = "";

                conn = DriverManager.getConnection(
                        url,
                        username,
                        password
                );

                System.out.println(
                        "Koneksi Database Berhasil!"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Koneksi Gagal!"
            );

            System.out.println(
                    e.getMessage()
            );
        }

        return conn;
    }
}
    
