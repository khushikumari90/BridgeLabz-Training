package com.example.greeting.dao;

import com.example.greeting.model.Greeting;
import com.example.greeting.util.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GreetingDaoImpl implements GreetingDao {

    @Override
    public void addGreeting(Greeting greeting) {
        String sql = "INSERT INTO greetings (name, message) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, greeting.getName());
            ps.setString(2, greeting.getMessage());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Greeting> getAllGreetings() {
        List<Greeting> greetings = new ArrayList<>();
        String sql = "SELECT * FROM greetings";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Greeting greeting = new Greeting(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("message")
                );
                greetings.add(greeting);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return greetings;
    }

    @Override
    public Greeting getGreetingById(int id) {
        String sql = "SELECT * FROM greetings WHERE id = ?";
        Greeting greeting = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                greeting = new Greeting(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("message")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return greeting;
    }

    @Override
    public void updateGreeting(Greeting greeting) {
        String sql = "UPDATE greetings SET name = ?, message = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, greeting.getName());
            ps.setString(2, greeting.getMessage());
            ps.setInt(3, greeting.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGreeting(int id) {
        String sql = "DELETE FROM greetings WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
