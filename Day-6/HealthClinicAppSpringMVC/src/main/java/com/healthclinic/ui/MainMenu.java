package com.healthclinic.ui;

import com.healthclinic.dto.*;
import com.healthclinic.exception.*;
import com.healthclinic.service.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientService patientService = new PatientService();
    private final DoctorService doctorService = new DoctorService();
    private final AppointmentService appointmentService = new AppointmentService();
    private final BillingService billingService = new BillingService();
    private final VisitHistoryService visitHistoryService = new VisitHistoryService();

    public void start() {
        while (true) {
            System.out.println("\n HEALTH CLINIC MANAGEMENT SYSTEM");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient By ID");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");

            System.out.println("___");

            System.out.println("6. Add Doctor");
            System.out.println("7. View Doctor By ID");
            System.out.println("8. View All Doctors");
            System.out.println("9. Update Doctor");
            System.out.println("10. Delete Doctor");

            System.out.println("___");

            System.out.println("11. Book Appointment");
            System.out.println("12. View Appointment By ID");
            System.out.println("13. View All Appointments");
            System.out.println("14. Update Appointment");
            System.out.println("15. Delete Appointment");

            System.out.println("___");

            System.out.println("16. Add Billing");
            System.out.println("17. View Billing By ID");
            System.out.println("18. View All Billing");
            System.out.println("19. Update Billing");
            System.out.println("20. Delete Billing");

            System.out.println("___");

            System.out.println("21. Add Visit History");
            System.out.println("22. View Visit History By ID");
            System.out.println("23. View All Visit History");
            System.out.println("24. Update Visit History");
            System.out.println("25. Delete Visit History");

            System.out.println("___");

            System.out.println("26. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> viewPatientById();
                    case 3 -> viewAllPatients();
                    case 4 -> updatePatient();
                    case 5 -> deletePatient();

                    case 6 -> addDoctor();
                    case 7 -> viewDoctorById();
                    case 8 -> viewAllDoctors();
                    case 9 -> updateDoctor();
                    case 10 -> deleteDoctor();

                    case 11 -> addAppointment();
                    case 12 -> viewAppointmentById();
                    case 13 -> viewAllAppointments();
                    case 14 -> updateAppointment();
                    case 15 -> deleteAppointment();

                    case 16 -> addBilling();
                    case 17 -> viewBillingById();
                    case 18 -> viewAllBilling();
                    case 19 -> updateBilling();
                    case 20 -> deleteBilling();

                    case 21 -> addVisitHistory();
                    case 22 -> viewVisitHistoryById();
                    case 23 -> viewAllVisitHistory();
                    case 24 -> updateVisitHistory();
                    case 25 -> deleteVisitHistory();

                    case 26 -> {
                        System.out.println("Thank You!");
                        return;
                    }
                    default -> System.out.println("Invalid Choice!");
                }
            } catch (ValidationException | ResourceNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }

    }

    //PATIENT
    private void addPatient() {
        Patient patient = new Patient();

        System.out.print("First Name : ");
        patient.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        patient.setLastName(scanner.nextLine());

        System.out.print("Gender : ");
        patient.setGender(scanner.nextLine());

        System.out.print("DOB (yyyy-mm-dd): ");
        patient.setDob(LocalDate.parse(scanner.nextLine()));

        System.out.print("Phone Number : ");
        patient.setPhoneNumber(scanner.nextLine());

        System.out.print("Email : ");
        patient.setEmail(scanner.nextLine());

        System.out.print("Address : ");
        patient.setAddress(scanner.nextLine());

        boolean added = patientService.addPatient(patient);

        System.out.println(added ? "Patient added successfully." : "Failed to add patient.");
    }

    private void viewPatientById() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient patient = patientService.getPatientById(id);
        System.out.println(patient);
    }

    private void viewAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        patients.forEach(System.out::println);
    }

    private void updatePatient() {
        Patient patient = new Patient();
        System.out.print("Patient ID: ");
        patient.setPatientId(Integer.parseInt(scanner.nextLine()));

        System.out.print("First Name : ");
        patient.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        patient.setLastName(scanner.nextLine());

        System.out.print("Gender : ");
        patient.setGender(scanner.nextLine());

        System.out.print("DOB (yyyy-mm-dd): ");
        patient.setDob(LocalDate.parse(scanner.nextLine()));

        System.out.print("Phone Number : ");
        patient.setPhoneNumber(scanner.nextLine());

        System.out.print("Email : ");
        patient.setEmail(scanner.nextLine());

        System.out.print("Address : ");
        patient.setAddress(scanner.nextLine());

        boolean updated = patientService.updatePatient(patient);

        System.out.println(updated ? "Patient updated successfully." : "Failed to update patient.");
    }

    private void deletePatient() {

        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = patientService.deletePatient(id);

        System.out.println(deleted ? "Patient deleted successfully." : "Failed to delete patient.");
    }

    //DOCTOR
    private void addDoctor() {

        Doctor doctor = new Doctor();

        System.out.print("First Name: ");
        doctor.setFirstName(scanner.nextLine());

        System.out.print("Last Name: ");
        doctor.setLastName(scanner.nextLine());

        System.out.print("Specialization: ");
        doctor.setSpecialization(scanner.nextLine());

        System.out.print("Phone Number: ");
        doctor.setPhoneNumber(scanner.nextLine());

        System.out.print("Email: ");
        doctor.setEmail(scanner.nextLine());

        System.out.print("Room Number: ");
        doctor.setRoomNumber(scanner.nextLine());

        System.out.print("Consultation Fee: ");
        doctor.setConsultationFee(new BigDecimal(scanner.nextLine()));

        System.out.print("Experience (Years): ");
        doctor.setExperienceYears(Integer.parseInt(scanner.nextLine()));

        boolean added = doctorService.addDoctor(doctor);

        System.out.println(added ?
                "Doctor Added Successfully." :
                "Failed.");
    }

    private void viewDoctorById() {
        System.out.print("Enter Doctor ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Doctor doctor = doctorService.getDoctorById(id);
        System.out.println(doctor);
    }

    private void viewAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        doctors.forEach(System.out::println);
    }
    private void updateDoctor() {

        Doctor doctor = new Doctor();

        System.out.print("Doctor ID: ");
        doctor.setDoctorId(Integer.parseInt(scanner.nextLine()));

        System.out.print("First Name: ");
        doctor.setFirstName(scanner.nextLine());

        System.out.print("Last Name: ");
        doctor.setLastName(scanner.nextLine());

        System.out.print("Specialization: ");
        doctor.setSpecialization(scanner.nextLine());

        System.out.print("Phone Number: ");
        doctor.setPhoneNumber(scanner.nextLine());

        System.out.print("Email: ");
        doctor.setEmail(scanner.nextLine());

        System.out.print("Room Number: ");
        doctor.setRoomNumber(scanner.nextLine());

        System.out.print("Consultation Fee: ");
        doctor.setConsultationFee(new BigDecimal(scanner.nextLine()));

        System.out.print("Experience: ");
        doctor.setExperienceYears(Integer.parseInt(scanner.nextLine()));

        boolean updated = doctorService.updateDoctor(doctor);

        System.out.println(updated ?
                "Doctor Updated Successfully." :
                "Failed.");
    }
    private void deleteDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = doctorService.deleteDoctor(id);

        System.out.println(deleted ? "Doctor deleted successfully."
                : "Failed to delete doctor.");
    }
    //APPOINTMENT

    private void addAppointment() {

        Appointment appointment = new Appointment();

        System.out.print("Patient ID: ");
        appointment.setPatientId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Doctor ID: ");
        appointment.setDoctorId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Appointment Date (yyyy-mm-dd): ");
        appointment.setAppointmentDate(LocalDate.parse(scanner.nextLine()));

        System.out.print("Appointment Time (HH:mm): ");
        appointment.setAppointmentTime(LocalTime.parse(scanner.nextLine()));

        System.out.print("Reason: ");
        appointment.setReason(scanner.nextLine());

        appointment.setStatus("Scheduled");

        boolean added =
                appointmentService.addAppointment(appointment);

        System.out.println(added ?
                "Appointment Added Successfully." :
                "Failed.");
    }

    private void viewAppointmentById() {
        System.out.print("Enter Appointment ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Appointment appointment = appointmentService.getAppointmentById(id);
        System.out.println(appointment);
    }

    private void viewAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        appointments.forEach(System.out::println);
    }

    private void updateAppointment() {

        Appointment appointment = new Appointment();

        System.out.print("Appointment ID: ");
        appointment.setAppointmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Patient ID: ");
        appointment.setPatientId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Doctor ID: ");
        appointment.setDoctorId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Appointment Date (yyyy-mm-dd): ");
        appointment.setAppointmentDate(LocalDate.parse(scanner.nextLine()));

        System.out.print("Appointment Time (HH:mm): ");
        appointment.setAppointmentTime(LocalTime.parse(scanner.nextLine()));

        System.out.print("Reason: ");
        appointment.setReason(scanner.nextLine());

        System.out.print("Status:(Scheduled/Updated/Cancelled) ");
        appointment.setStatus(scanner.nextLine());

        boolean updated =
                appointmentService.updateAppointment(appointment);

        System.out.println(updated ?
                "Updated Successfully." :
                "Failed.");
    }
    private void deleteAppointment() {

        System.out.print("Enter Appointment ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean deleted = appointmentService.deleteAppointment(id);
        System.out.println(deleted ? "Appointment deleted successfully." : "Failed to delete appointment.");
    }

    //BILLING

    private void addBilling() {

        Billing billing = new Billing();

        System.out.print("Appointment ID: ");
        billing.setAppointmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Total Amount: ");
        billing.setTotalAmount(new java.math.BigDecimal(scanner.nextLine()));

        System.out.print("Payment Status: ");
        billing.setPaymentStatus(scanner.nextLine());

        System.out.print("Billing Date (yyyy-mm-dd): ");
        billing.setBillingDate(LocalDate.parse(scanner.nextLine()));

        boolean added = billingService.addBilling(billing);

        System.out.println(added ? "Billing added successfully." : "Failed.");
    }

    private void viewBillingById() {

        System.out.print("Billing ID: ");

        System.out.println(
                billingService.getBillingById(
                        Integer.parseInt(scanner.nextLine())
                )
        );
    }

    private void viewAllBilling() {

        billingService.getAllBillings()
                .forEach(System.out::println);
    }

    private void updateBilling() {

        Billing billing = new Billing();

        System.out.print("Billing ID: ");
        billing.setBillingId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Appointment ID: ");
        billing.setAppointmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Amount: ");
        billing.setTotalAmount(new java.math.BigDecimal(scanner.nextLine()));

        System.out.print("Payment Status: ");
        billing.setPaymentStatus(scanner.nextLine());

        System.out.print("Billing Date (yyyy-mm-dd): ");
        billing.setBillingDate(LocalDate.parse(scanner.nextLine()));

        boolean updated = billingService.updateBilling(billing);

        System.out.println(updated ? "Updated Successfully." : "Failed.");
    }

    private void deleteBilling() {

        System.out.print("Billing ID: ");

        boolean deleted = billingService.deleteBilling(
                Integer.parseInt(scanner.nextLine()));

        System.out.println(deleted ? "Deleted Successfully." : "Failed.");
    }

    //VISIT HISTORY
    private void addVisitHistory() {

        VisitHistory visit = new VisitHistory();

        System.out.print("Appointment ID: ");
        visit.setAppointmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Diagnosis: ");
        visit.setDiagnosis(scanner.nextLine());

        System.out.print("Prescription: ");
        visit.setPrescription(scanner.nextLine());

        System.out.print("Visit Date (yyyy-mm-dd): ");
        visit.setVisitDate(LocalDate.parse(scanner.nextLine()));

        boolean added = visitHistoryService.addVisitHistory(visit);

        System.out.println(added ? "Visit History Added." : "Failed.");
    }

    private void viewVisitHistoryById() {

        System.out.print("Visit ID: ");

        System.out.println(
                visitHistoryService.getVisitHistoryById(
                        Integer.parseInt(scanner.nextLine())
                )
        );
    }

    private void viewAllVisitHistory() {

        visitHistoryService.getAllVisitHistory()
                .forEach(System.out::println);
    }

    private void updateVisitHistory() {

        VisitHistory visit = new VisitHistory();

        System.out.print("Visit ID: ");
        visit.setVisitId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Appointment ID: ");
        visit.setAppointmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Diagnosis: ");
        visit.setDiagnosis(scanner.nextLine());

        System.out.print("Prescription: ");
        visit.setPrescription(scanner.nextLine());

        System.out.print("Visit Date (yyyy-mm-dd): ");
        visit.setVisitDate(LocalDate.parse(scanner.nextLine()));

        boolean updated = visitHistoryService.updateVisitHistory(visit);

        System.out.println(updated ? "Updated Successfully." : "Failed.");
    }

    private void deleteVisitHistory() {

        System.out.print("Visit ID: ");

        boolean deleted = visitHistoryService.deleteVisitHistory(
                Integer.parseInt(scanner.nextLine()));

        System.out.println(deleted ? "Deleted Successfully." : "Failed.");
    }
}