package com.example.mysql_demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.mysql_demo.model.Doctor;

public class DoctorDAO {

    // UC-2.1 Add Doctor
    public void addDoctor(Doctor doctor) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO doctors(name,contact,consultation_fee,specialty_id) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, doctor.getName());
        ps.setString(2, doctor.getContact());
        ps.setDouble(3, doctor.getConsultationFee());
        ps.setInt(4, doctor.getSpecialtyId());

        ps.executeUpdate();

        System.out.println("Doctor Added Successfully");

        con.close();
    }

    // UC-2.2 Update Doctor Specialty
    public void updateDoctorSpecialty(int doctorId, int specialtyId) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE doctors SET specialty_id=? WHERE doctor_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, specialtyId);
        ps.setInt(2, doctorId);

        ps.executeUpdate();

        System.out.println("Doctor Specialty Updated");

        con.close();
    }

    // UC-2.3 View Doctors by Specialty
    public void viewDoctorsBySpecialty(String specialtyName) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
                "SELECT d.doctor_id,d.name,d.contact,d.consultation_fee,s.specialty_name " +
                "FROM doctors d JOIN specialties s " +
                "ON d.specialty_id=s.specialty_id " +
                "WHERE s.specialty_name=? AND d.is_active=true";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, specialtyName);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            System.out.println("Doctor ID: " + rs.getInt("doctor_id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Specialty: " + rs.getString("specialty_name"));
            System.out.println("Contact: " + rs.getString("contact"));
            System.out.println("Fee: " + rs.getDouble("consultation_fee"));
            System.out.println("----------------------");
        }

        con.close();
    }

    // UC-2.4 Deactivate Doctor
    public void deactivateDoctor(int doctorId) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
                "UPDATE doctors SET is_active=false " +
                "WHERE doctor_id=? " +
                "AND doctor_id NOT IN " +
                "(SELECT doctor_id FROM appointments WHERE appointment_date >= CURDATE())";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, doctorId);

        int rows = ps.executeUpdate();

        if(rows > 0)
            System.out.println("Doctor Deactivated");
        else
            System.out.println("Doctor has future appointments!");

        con.close();
    }
}
