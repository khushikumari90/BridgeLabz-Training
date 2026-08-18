package com.healthclinic.dao;

import com.healthclinic.config.DatabaseConnection;
import com.healthclinic.dto.Patient;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean addPatient(Patient patient) {
        String sql = """
                INSERT INTO patients
                (first_name, last_name, gender, dob, phone_number, email, address)
                VALUES (?,?,?,?,?,?,?)
                """;

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getGender());
            ps.setDate(4, java.sql.Date.valueOf(patient.getDob()));
            ps.setString(5, patient.getPhoneNumber());
            ps.setString(6, patient.getEmail());
            ps.setString(7, patient.getAddress());

            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Patient getPatientById(int patientId) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setGender(rs.getString("gender"));
                patient.setDob(rs.getDate("dob").toLocalDate());
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setEmail(rs.getString("email"));
                patient.setAddress(rs.getString("address"));

                return patient;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM patients";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setGender(rs.getString("gender"));
                patient.setDob(rs.getDate("dob").toLocalDate());
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setEmail(rs.getString("email"));
                patient.setAddress(rs.getString("address"));

                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        String sql = """
                UPDATE patients
                SET first_name = ?,
                    last_name = ?,
                    gender = ?,
                    dob = ?,
                    phone_number = ?,
                    email = ?,
                    address = ?
                WHERE patient_id = ?
                """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
                ps.setString(1, patient.getFirstName());
                ps.setString(2, patient.getLastName());
                ps.setString(3, patient.getGender());
                ps.setDate(4, java.sql.Date.valueOf(patient.getDob()));
                ps.setString(5, patient.getPhoneNumber());
                ps.setString(6, patient.getEmail());
                ps.setString(7, patient.getAddress());

                //WHERE patient_id = ?
                ps.setInt(8, patient.getPatientId());

                return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePatient(int patientId) {

        String sql = "DELETE FROM patients WHERE patient_id = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, patientId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
