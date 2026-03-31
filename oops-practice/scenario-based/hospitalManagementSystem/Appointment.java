package hospitalManagementSystem;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public void displayAppointment() {
        System.out.println("Appointment | Doctor: " + doctor.getName()
                + " | Patient: " + patient.name
                + " | Date: " + date);
    }
}
