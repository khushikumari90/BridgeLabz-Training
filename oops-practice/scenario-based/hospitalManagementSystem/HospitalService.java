package hospitalManagementSystem;

public interface HospitalService {
    void bookAppointment(Doctor doctor, Patient patient, String date)
            throws AppointmentNotAvailableException;

    void cancelAppointment();
}
