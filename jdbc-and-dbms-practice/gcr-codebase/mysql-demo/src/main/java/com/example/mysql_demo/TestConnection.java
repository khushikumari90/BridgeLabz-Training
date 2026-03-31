package com.example.mysql_demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "ckjain1166"; 

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Database Connected Successfully!");
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}
