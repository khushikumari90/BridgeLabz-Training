package com.json;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.*;

public class DbToJsonReport {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root";

        String query = "SELECT id, name, email, age FROM users";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()
        ) {

            List<Map<String, Object>> reportData = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                row.put("id", rs.getInt("id"));
                row.put("name", rs.getString("name"));
                row.put("email", rs.getString("email"));
                row.put("age", rs.getInt("age"));

                reportData.add(row);
            }

            // Convert DB records to JSON
            ObjectMapper mapper = new ObjectMapper();
            String jsonReport = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(reportData);

            // Print JSON report
            System.out.println(jsonReport);

            // Optional: save to file
            mapper.writeValue(new java.io.File("user-report.json"), reportData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
