package com.healthclinic.dao;

import com.healthclinic.dto.Doctor;

import java.util.List;

public interface DoctorDAO {

    boolean addDoctor(Doctor doctor);

    boolean updateDoctor(Doctor doctor);

    boolean deleteDoctor(int doctorId);

    Doctor getDoctorById(int doctorId);

    List<Doctor> getAllDoctors();
}