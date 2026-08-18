package com.healthclinic.service;

import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.dao.DoctorDAOImpl;
import com.healthclinic.dto.Doctor;
import com.healthclinic.exception.ValidationException;

import java.util.List;

public class DoctorService {

    private final DoctorDAO doctorDAO = new DoctorDAOImpl();

    public boolean addDoctor(Doctor doctor) {

        if (doctor.getFirstName() == null || doctor.getFirstName().isBlank())
            throw new ValidationException("First name cannot be empty.");

        if (doctor.getLastName() == null || doctor.getLastName().isBlank())
            throw new ValidationException("Last name cannot be empty.");

        if (doctor.getPhoneNumber() == null ||
                !doctor.getPhoneNumber().matches("\\d{10}"))
            throw new ValidationException("Phone number must contain exactly 10 digits.");

        if (doctor.getEmail() == null ||
                !doctor.getEmail().contains("@"))
            throw new ValidationException("Invalid Email.");

        if (doctor.getConsultationFee().doubleValue() < 0)
            throw new ValidationException("Consultation fee cannot be negative.");

        return doctorDAO.addDoctor(doctor);
    }

    public boolean updateDoctor(Doctor doctor) {
        return doctorDAO.updateDoctor(doctor);
    }

    public boolean deleteDoctor(int doctorId) {
        return doctorDAO.deleteDoctor(doctorId);
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorDAO.getDoctorById(doctorId);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }
}