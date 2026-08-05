package com.clinic.dao;

import com.clinic.dto.Doctor;
import java.util.List;

public interface DoctorDAO {
    int insertDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsBySpecialization(int specializationId);
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(int id);
}
