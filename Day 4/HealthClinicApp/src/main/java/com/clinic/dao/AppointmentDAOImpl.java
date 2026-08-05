package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    private static final String SELECT_WITH_NAMES =
            "SELECT a.*, " +
            "CONCAT(p.first_name, ' ', p.last_name) AS patient_name, " +
            "CONCAT(dr.first_name, ' ', dr.last_name) AS doctor_name " +
            "FROM appointments a " +
            "JOIN patients p ON a.patient_id = p.patient_id " +
            "JOIN doctors dr ON a.doctor_id = dr.doctor_id ";

    @Override
    public int insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setTimestamp(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getStatus() != null ? appointment.getStatus() : "Scheduled");

            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Insert appointment failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Appointment getAppointmentById(int id) {
        String sql = SELECT_WITH_NAMES + "WHERE a.appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get appointment failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        String sql = SELECT_WITH_NAMES + "ORDER BY a.appointment_date DESC";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Get all appointments failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        String sql = SELECT_WITH_NAMES + "WHERE a.patient_id = ? ORDER BY a.appointment_date DESC";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, patientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Get appointments by patient failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        String sql = SELECT_WITH_NAMES + "WHERE a.doctor_id = ? ORDER BY a.appointment_date DESC";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, doctorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Get appointments by doctor failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, " +
                "status = ? WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setTimestamp(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getStatus());
            pstmt.setInt(5, appointment.getAppointmentId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update appointment failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete appointment failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Takes an existing connection in rather than opening its own — this is
     * what lets the Service layer combine this update with the billing and
     * visit_history inserts into ONE all-or-nothing transaction.
     */
    @Override
    public boolean updateStatus(Connection conn, int appointmentId, String status) throws SQLException {
        String sql = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, appointmentId);
            return pstmt.executeUpdate() > 0;
        }
    }

    private Appointment mapRow(ResultSet rs) throws SQLException {
        Appointment a = new Appointment();
        a.setAppointmentId(rs.getInt("appointment_id"));
        a.setPatientId(rs.getInt("patient_id"));
        a.setDoctorId(rs.getInt("doctor_id"));
        a.setAppointmentDate(rs.getTimestamp("appointment_date"));
        a.setStatus(rs.getString("status"));
        a.setCreatedAt(rs.getTimestamp("created_at"));
        a.setPatientName(rs.getString("patient_name"));
        a.setDoctorName(rs.getString("doctor_name"));
        return a;
    }
}
