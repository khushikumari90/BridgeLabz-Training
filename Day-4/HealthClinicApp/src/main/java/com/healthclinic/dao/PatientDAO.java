package com.healthclinic.dao;

import com.healthclinic.dto.Patient;
import java.util.List;

public interface PatientDAO {
    boolean addPatient(Patient patient);
    Patient getPatientById(int patientId);
    List<Patient> getAllPatients();
    boolean updatePatient(Patient patient);
    boolean deletePatient(int patientId);
}
