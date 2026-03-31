package com.example.mysql_demo.dao;

import java.sql.*;
import com.example.mysql_demo.model.Visit;

public class VisitDAO {

    // UC-4.1 Record Patient Visit
    public int recordVisit(Visit visit) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        int visitId = 0;

        try {

            String sql =
            "INSERT INTO visits(appointment_id,patient_id,doctor_id,visit_date,diagnosis,notes) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, visit.getAppointmentId());
            ps.setInt(2, visit.getPatientId());
            ps.setInt(3, visit.getDoctorId());
            ps.setDate(4, Date.valueOf(visit.getVisitDate()));
            ps.setString(5, visit.getDiagnosis());
            ps.setString(6, visit.getNotes());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                visitId = rs.getInt(1);

            // update appointment status
            String update =
            "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";

            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setInt(1, visit.getAppointmentId());
            ps2.executeUpdate();

            con.commit();

            System.out.println("Visit recorded successfully");

        } catch(Exception e) {

            con.rollback();
            System.out.println("Visit recording failed");
        }

        return visitId;
    }

    // UC-4.2 View Medical History
    public void medicalHistory(int patientId) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT v.visit_date,v.diagnosis,p.medicine_name,p.dosage,p.duration " +
        "FROM visits v " +
        "LEFT JOIN prescriptions p ON v.visit_id=p.visit_id " +
        "WHERE v.patient_id=? ORDER BY v.visit_date DESC";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,patientId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            System.out.println(
            rs.getDate("visit_date")+" | "+
            rs.getString("diagnosis")+" | "+
            rs.getString("medicine_name")+" | "+
            rs.getString("dosage")+" | "+
            rs.getString("duration"));
        }
    }
}
