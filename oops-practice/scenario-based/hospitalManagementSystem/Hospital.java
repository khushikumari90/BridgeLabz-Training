package hospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private Appointment appointment;

    // CRUD: Add Patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.name);
    }

    // CRUD: Delete Patient
    public void deletePatient(Patient patient) {
        patients.remove(patient);
        System.out.println("Patient removed: " + patient.name);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor.getName());
    }

    @Override
    public void bookAppointment(Doctor doctor, Patient patient, String date)
            throws AppointmentNotAvailableException {

        if (appointment != null) {
            throw new AppointmentNotAvailableException("Appointment slot already booked!");
        }
        appointment = new Appointment(doctor, patient, date);
        appointment.displayAppointment();
    }

    @Override
    public void cancelAppointment() {
        if (appointment != null) {
            System.out.println("Appointment cancelled.");
            appointment = null;
        }
    }
}
