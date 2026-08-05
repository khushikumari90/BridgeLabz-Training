package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int insertVisitHistory(VisitHistory visitHistory) {
        try (Connection conn = HikariConnectionPool.getConnection()) {
            return insertVisitHistory(conn, visitHistory);
        } catch (SQLException e) {
            System.out.println("Insert visit history failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int insertVisitHistory(Connection conn, VisitHistory visitHistory) throws SQLException {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis, notes) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, visitHistory.getAppointmentId());
            pstmt.setString(2, visitHistory.getDiagnosis());
            pstmt.setString(3, visitHistory.getNotes());
            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public VisitHistory getVisitHistoryById(int id) {
        String sql = "SELECT * FROM visit_history WHERE visit_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get visit history failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<VisitHistory> getVisitHistoryByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ? ORDER BY visit_id";
        List<VisitHistory> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Get visit history by appointment failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<VisitHistory> getAllVisitHistory() {
        String sql = "SELECT * FROM visit_history ORDER BY visit_id";
        List<VisitHistory> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Get all visit history failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateVisitHistory(VisitHistory visitHistory) {
        String sql = "UPDATE visit_history SET diagnosis = ?, notes = ? WHERE visit_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, visitHistory.getDiagnosis());
            pstmt.setString(2, visitHistory.getNotes());
            pstmt.setInt(3, visitHistory.getVisitId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update visit history failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteVisitHistory(int id) {
        String sql = "DELETE FROM visit_history WHERE visit_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete visit history failed: " + e.getMessage());
            return false;
        }
    }

    private VisitHistory mapRow(ResultSet rs) throws SQLException {
        VisitHistory v = new VisitHistory();
        v.setVisitId(rs.getInt("visit_id"));
        v.setAppointmentId(rs.getInt("appointment_id"));
        v.setDiagnosis(rs.getString("diagnosis"));
        v.setNotes(rs.getString("notes"));
        v.setVisitDate(rs.getTimestamp("visit_date"));
        return v;
    }
}
