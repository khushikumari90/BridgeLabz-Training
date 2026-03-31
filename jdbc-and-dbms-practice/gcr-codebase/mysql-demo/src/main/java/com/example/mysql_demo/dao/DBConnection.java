package com.example.mysql_demo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection
{
	public static Connection getConnection() {

    Connection connection = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/health_clinic",
                "root",
                "ckjain1166");

    } catch (Exception e) {
        e.printStackTrace();
    }

    return connection;
}
}
