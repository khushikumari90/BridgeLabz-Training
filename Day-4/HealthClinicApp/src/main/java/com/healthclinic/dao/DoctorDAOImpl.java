package com.healthclinic.dao;

import com.healthclinic.config.DatabaseConnection;
import com.healthclinic.dto.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public boolean addDoctor(Doctor doctor) {

        String sql = """
        INSERT INTO doctors
        (
        first_name,
        last_name,
        specialization,
        phone_number,
        email,
        room_number,
        consultation_fee,
        experience_years
        )
        VALUES(?,?,?,?,?,?,?,?)
        """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){

            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getSpecialization());
            ps.setString(4, doctor.getPhoneNumber());
            ps.setString(5, doctor.getEmail());
            ps.setString(6, doctor.getRoomNumber());
            ps.setBigDecimal(7, doctor.getConsultationFee());
            ps.setInt(8, doctor.getExperienceYears());

            return ps.executeUpdate()>0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {

        String sql = "SELECT * FROM doctors WHERE doctor_id=?";

        try(
                Connection connection=DatabaseConnection.getConnection();
                PreparedStatement ps=connection.prepareStatement(sql);
        ){

            ps.setInt(1,doctorId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Doctor doctor=new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
                doctor.setRoomNumber(rs.getString("room_number"));
                doctor.setConsultationFee(rs.getBigDecimal("consultation_fee"));
                doctor.setExperienceYears(rs.getInt("experience_years"));

                return doctor;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        String sql = """
                SELECT * FROM doctors
                """;

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs =  ps.executeQuery();

            while(rs.next()){
                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
                doctor.setRoomNumber(rs.getString("room_number"));
                doctor.setConsultationFee(rs.getBigDecimal("consultation_fee"));
                doctor.setExperienceYears(rs.getInt("experience_years"));

                doctors.add(doctor);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {

        String sql="""
            UPDATE doctors
            SET first_name=?,
                last_name=?,
                specialization=?,
                phone_number=?,
                email=?,
                room_number=?,
                consultation_fee=?,
                experience_years=?
            WHERE doctor_id=?
            """;

        try(
                Connection connection=DatabaseConnection.getConnection();
                PreparedStatement ps=connection.prepareStatement(sql);
        ){

            ps.setString(1,doctor.getFirstName());
            ps.setString(2,doctor.getLastName());
            ps.setString(3,doctor.getSpecialization());
            ps.setString(4,doctor.getPhoneNumber());
            ps.setString(5,doctor.getEmail());
            ps.setString(6,doctor.getRoomNumber());
            ps.setBigDecimal(7,doctor.getConsultationFee());
            ps.setInt(8,doctor.getExperienceYears());
            ps.setInt(9,doctor.getDoctorId());

            return ps.executeUpdate()>0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteDoctor(int doctorId) {

        String sql = """
            DELETE FROM doctors
            WHERE doctor_id = ?
            """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, doctorId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
