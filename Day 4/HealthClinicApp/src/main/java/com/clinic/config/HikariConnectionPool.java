package com.clinic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The one doorway every DAO and Service walks through to reach MySQL.
 *
 * This is the "hardened" version of Step 3's DatabaseConnection class:
 * instead of opening a brand-new TCP connection to MySQL on every single
 * call (expensive, and doesn't scale), it keeps a small pool of already-open
 * connections ready to hand out and take back. Nothing in the DAOs or
 * Service layer had to change to get this upgrade — they just call
 * getConnection(), same as before.
 */
public class HikariConnectionPool {

    private static final String URL =
            "jdbc:mysql://localhost:3306/health_clinic_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "clinic_app_user";
    private static final String PASSWORD = "StrongPassword123!";

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Pool sizing — plenty for a single-clinic console app
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(10000);
        config.setPoolName("HealthClinicPool");

        dataSource = new HikariDataSource(config);
    }

    private HikariConnectionPool() {
        // utility class — never instantiated
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
