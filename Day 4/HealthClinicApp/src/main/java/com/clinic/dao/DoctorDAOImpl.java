package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    private static final String SELECT_WITH_SPECIALIZATION =
            "SELECT d.*, s.name AS specialization_name FROM doctors d " +
            "LEFT JOIN specializations s ON d.specialization_id = s.specialization_id ";

    @Override
    public int insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, email, phone, specialization_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getEmail());
            pstmt.setString(4, doctor.getPhone());
            if (doctor.getSpecializationId() != null) {
                pstmt.setInt(5, doctor.getSpecializationId());
            } else {
                pstmt.setNull(5, Types.INTEGER);
            }

            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Insert doctor failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Doctor getDoctorById(int id) {
        String sql = SELECT_WITH_SPECIALIZATION + "WHERE d.doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get doctor failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        String sql = SELECT_WITH_SPECIALIZATION + "ORDER BY d.doctor_id";
        List<Doctor> doctors = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) doctors.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Get all doctors failed: " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public List<Doctor> getDoctorsBySpecialization(int specializationId) {
        String sql = SELECT_WITH_SPECIALIZATION + "WHERE d.specialization_id = ? ORDER BY d.doctor_id";
        List<Doctor> doctors = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, specializationId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) doctors.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Get doctors by specialization failed: " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET first_name = ?, last_name = ?, email = ?, phone = ?, " +
                "specialization_id = ? WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getEmail());
            pstmt.setString(4, doctor.getPhone());
            if (doctor.getSpecializationId() != null) {
                pstmt.setInt(5, doctor.getSpecializationId());
            } else {
                pstmt.setNull(5, Types.INTEGER);
            }
            pstmt.setInt(6, doctor.getDoctorId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update doctor failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete doctor failed: " + e.getMessage());
            return false;
        }
    }

    private Doctor mapRow(ResultSet rs) throws SQLException {
        Doctor d = new Doctor();
        d.setDoctorId(rs.getInt("doctor_id"));
        d.setFirstName(rs.getString("first_name"));
        d.setLastName(rs.getString("last_name"));
        d.setEmail(rs.getString("email"));
        d.setPhone(rs.getString("phone"));
        int specId = rs.getInt("specialization_id");
        d.setSpecializationId(rs.wasNull() ? null : specId);
        d.setSpecializationName(rs.getString("specialization_name"));
        d.setCreatedAt(rs.getTimestamp("created_at"));
        return d;
    }
}
