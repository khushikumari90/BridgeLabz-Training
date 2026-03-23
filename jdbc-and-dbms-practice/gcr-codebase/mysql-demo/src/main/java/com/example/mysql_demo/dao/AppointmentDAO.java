package com.example.mysql_demo.dao;

import java.sql.*;
import com.example.mysql_demo.model.Appointment;

public class AppointmentDAO {

    // UC-3.1 Book Appointment
    public void bookAppointment(Appointment ap) throws Exception {

        Connection con = DBConnection.getConnection();

        String check =
        "SELECT COUNT(*) FROM appointments " +
        "WHERE doctor_id=? AND appointment_date=? AND appointment_time=? AND status='SCHEDULED'";

        PreparedStatement ps1 = con.prepareStatement(check);
        ps1.setInt(1, ap.getDoctorId());
        ps1.setDate(2, Date.valueOf(ap.getDate()));
        ps1.setTime(3, Time.valueOf(ap.getTime()));

        ResultSet rs = ps1.executeQuery();
        rs.next();

        if(rs.getInt(1) > 0){
            System.out.println("Doctor not available at this slot");
            return;
        }

        String insert =
        "INSERT INTO appointments(patient_id,doctor_id,doctor_name,appointment_date,appointment_time,status) VALUES(?,?,?,?,?,?)";

        PreparedStatement ps2 = con.prepareStatement(insert);

        ps2.setInt(1, ap.getPatientId());
        ps2.setInt(2, ap.getDoctorId());
        ps2.setString(3, ap.getDoctorName());
        ps2.setDate(4, Date.valueOf(ap.getDate()));
        ps2.setTime(5, Time.valueOf(ap.getTime()));
        ps2.setString(6,"SCHEDULED");

        ps2.executeUpdate();

        System.out.println("Appointment booked");
    }

    // UC-3.2 Check Doctor Availability
    public void checkAvailability(int doctorId,String date) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT appointment_time, COUNT(*) AS bookings " +
        "FROM appointments WHERE doctor_id=? AND appointment_date=? " +
        "GROUP BY appointment_time";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, doctorId);
        ps.setDate(2, Date.valueOf(date));

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            System.out.println(
            rs.getTime("appointment_time")+" -> "+rs.getInt("bookings")+" bookings");
        }
    }

    // UC-3.3 Cancel Appointment
    public void cancelAppointment(int id) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {

            String update =
            "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";

            PreparedStatement ps = con.prepareStatement(update);
            ps.setInt(1,id);
            ps.executeUpdate();

            String audit =
            "INSERT INTO appointment_audit(appointment_id,action) VALUES(?,?)";

            PreparedStatement ps2 = con.prepareStatement(audit);
            ps2.setInt(1,id);
            ps2.setString(2,"CANCELLED");
            ps2.executeUpdate();

            con.commit();
            System.out.println("Appointment cancelled");

        } catch(Exception e){

            con.rollback();
            System.out.println("Cancellation failed");
        }
    }

    // UC-3.4 Reschedule Appointment
    public void reschedule(int id,String date,String time) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "UPDATE appointments SET appointment_date=?,appointment_time=? WHERE appointment_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDate(1,Date.valueOf(date));
        ps.setTime(2,Time.valueOf(time));
        ps.setInt(3,id);

        ps.executeUpdate();

        System.out.println("Appointment rescheduled");
    }

    // UC-3.5 View Daily Schedule
    public void viewSchedule(String date) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT a.appointment_id,p.name,a.doctor_name,a.appointment_time " +
        "FROM appointments a " +
        "JOIN patients p ON a.patient_id=p.patient_id " +
        "WHERE a.appointment_date=? AND a.status='SCHEDULED' " +
        "ORDER BY a.appointment_time";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1,Date.valueOf(date));

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            System.out.println(
            rs.getInt("appointment_id")+" | "+
            rs.getString("name")+" | "+
            rs.getString("doctor_name")+" | "+
            rs.getTime("appointment_time"));
        }
    }
}
