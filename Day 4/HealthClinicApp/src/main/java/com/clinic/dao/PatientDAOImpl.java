package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (first_name, last_name, email, phone, date_of_birth, address) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setString(3, patient.getEmail());
            pstmt.setString(4, patient.getPhone());
            pstmt.setDate(5, patient.getDateOfBirth());
            pstmt.setString(6, patient.getAddress());

            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Insert patient failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get patient failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Patient getPatientByEmail(String email) {
        String sql = "SELECT * FROM patients WHERE email = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get patient by email failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patients ORDER BY patient_id";
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) patients.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Get all patients failed: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET first_name = ?, last_name = ?, email = ?, phone = ?, " +
                "date_of_birth = ?, address = ? WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setString(3, patient.getEmail());
            pstmt.setString(4, patient.getPhone());
            pstmt.setDate(5, patient.getDateOfBirth());
            pstmt.setString(6, patient.getAddress());
            pstmt.setInt(7, patient.getPatientId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update patient failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete patient failed: " + e.getMessage());
            return false;
        }
    }

    private Patient mapRow(ResultSet rs) throws SQLException {
        Patient p = new Patient();
        p.setPatientId(rs.getInt("patient_id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        p.setEmail(rs.getString("email"));
        p.setPhone(rs.getString("phone"));
        p.setDateOfBirth(rs.getDate("date_of_birth"));
        p.setAddress(rs.getString("address"));
        p.setCreatedAt(rs.getTimestamp("created_at"));
        return p;
    }
}
