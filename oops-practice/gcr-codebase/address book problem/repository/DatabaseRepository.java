package com.example.AddressBookProblem.repository;

import com.example.AddressBookProblem.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseRepository {

    // UC 18 – Save to Database
    public void save(Contact c) {
        String sql = "INSERT INTO contacts VALUES (NULL,?,?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
        	 ps.setString(1, c.getFirstName());
             ps.setString(2, c.getLastName());
             ps.setString(3, c.getAddress());
             ps.setString(4, c.getCity());
             ps.setString(5, c.getState());
             ps.setString(6, c.getZip());
             ps.setString(7, c.getPhone());
             ps.setString(8, c.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
