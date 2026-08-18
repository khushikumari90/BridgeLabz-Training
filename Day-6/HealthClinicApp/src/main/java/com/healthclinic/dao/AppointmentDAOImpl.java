package com.healthclinic.dao;

import com.healthclinic.config.DatabaseConnection;
import com.healthclinic.dto.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public boolean addAppointment(Appointment appointment) {

        String sql = """
                INSERT INTO appointments
                (patient_id,
                doctor_id,
                appointment_date,
                appointment_time,
                reason,
                status)
                VALUES (?,?,?,?,?,?)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());

            ps.setDate(3,
                    Date.valueOf(appointment.getAppointmentDate()));

            ps.setTime(4,
                    Time.valueOf(appointment.getAppointmentTime()));

            ps.setString(5, appointment.getReason());

            ps.setString(6, appointment.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {

        String sql = """
                UPDATE appointments
                SET patient_id=?,
                    doctor_id=?,
                    appointment_date=?,
                    appointment_time=?,
                    reason=?,
                    status=?
                WHERE appointment_id=?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());

            ps.setDate(3,
                    Date.valueOf(appointment.getAppointmentDate()));

            ps.setTime(4,
                    Time.valueOf(appointment.getAppointmentTime()));

            ps.setString(5, appointment.getReason());

            ps.setString(6, appointment.getStatus());

            ps.setInt(7, appointment.getAppointmentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteAppointment(int appointmentId) {

        String sql = """
                DELETE FROM appointments
                WHERE appointment_id=?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {

        String sql = """
                SELECT *
                FROM appointments
                WHERE appointment_id=?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        rs.getInt("appointment_id"));

                appointment.setPatientId(
                        rs.getInt("patient_id"));

                appointment.setDoctorId(
                        rs.getInt("doctor_id"));

                appointment.setAppointmentDate(
                        rs.getDate("appointment_date").toLocalDate());

                appointment.setAppointmentTime(
                        rs.getTime("appointment_time").toLocalTime());

                appointment.setReason(
                        rs.getString("reason"));

                appointment.setStatus(
                        rs.getString("status"));

                appointment.setCreatedAt(
                        rs.getTimestamp("created_at"));

                appointment.setUpdatedAt(
                        rs.getTimestamp("updated_at"));

                return appointment;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = """
                SELECT *
                FROM appointments
                ORDER BY appointment_date,
                         appointment_time
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        rs.getInt("appointment_id"));

                appointment.setPatientId(
                        rs.getInt("patient_id"));

                appointment.setDoctorId(
                        rs.getInt("doctor_id"));

                appointment.setAppointmentDate(
                        rs.getDate("appointment_date").toLocalDate());

                appointment.setAppointmentTime(
                        rs.getTime("appointment_time").toLocalTime());

                appointment.setReason(
                        rs.getString("reason"));

                appointment.setStatus(
                        rs.getString("status"));

                appointment.setCreatedAt(
                        rs.getTimestamp("created_at"));

                appointment.setUpdatedAt(
                        rs.getTimestamp("updated_at"));

                appointments.add(appointment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }
}