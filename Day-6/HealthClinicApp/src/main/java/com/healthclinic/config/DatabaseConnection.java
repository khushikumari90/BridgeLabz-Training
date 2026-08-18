package com.healthclinic.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/health_clinic_training";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Bhuvi@123";
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Database Connection Failed",e);
        }
    }

    //how does mysql driver open a TCP connection to localhost:3306 ?
    //how does a TCP connections works here ?
    //how does credentials are sent to MySQL, in deep ?
    //how does mysql verified the credentials, like does it matches character by charater or what ?
    //HikariPool vs Driver Manager

}
