package com.example.mysql_demo.service;

import com.example.mysql_demo.dao.DoctorDAO;
import com.example.mysql_demo.model.Doctor;

public class DoctorService {

    private DoctorDAO dao = new DoctorDAO();

    public void addDoctor(Doctor doctor) throws Exception {
        dao.addDoctor(doctor);
    }

    public void updateSpecialty(int doctorId,int specialtyId) throws Exception {
        dao.updateDoctorSpecialty(doctorId,specialtyId);
    }

    public void viewBySpecialty(String name) throws Exception {
        dao.viewDoctorsBySpecialty(name);
    }

    public void deactivate(int doctorId) throws Exception {
        dao.deactivateDoctor(doctorId);
    }
}
