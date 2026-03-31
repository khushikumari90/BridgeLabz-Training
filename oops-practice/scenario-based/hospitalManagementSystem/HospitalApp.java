package hospitalManagementSystem;

public class HospitalApp {

    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        Doctor d1 = new Doctor(1, "Dr. Sharma", "Cardiology");
        Patient p1 = new Patient(101, "Rahul");

        hospital.addDoctor(d1);
        hospital.addPatient(p1);

        p1.addMedicalRecord("Blood Test - Normal");
        p1.addMedicalRecord("ECG - Normal");

        try {
            hospital.bookAppointment(d1, p1, "20-Jan-2026");
        } catch (AppointmentNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        p1.viewMedicalHistory();
        System.out.println("Consultation Fee: ₹" + d1.calculateConsultationFee());

        hospital.cancelAppointment();
    }
}
