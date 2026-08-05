package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

/**
 * Floor 4 — what the receptionist actually sees and types into.
 * This file never contains SQL. It only asks DAOs/Service to do things.
 */
public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    public void start() {
        boolean running = true;
        System.out.println("=========================================");
        System.out.println("   Welcome to HealthClinicApp");
        System.out.println("=========================================");

        while (running) {
            printMainMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> doctorMenu();
                case 3 -> specializationMenu();
                case 4 -> appointmentMenu();
                case 5 -> billingMenu();
                case 6 -> visitHistoryMenu();
                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("\n----------- MAIN MENU -----------");
        System.out.println("1. Patients");
        System.out.println("2. Doctors");
        System.out.println("3. Specializations");
        System.out.println("4. Appointments");
        System.out.println("5. Billing");
        System.out.println("6. Visit History");
        System.out.println("0. Exit");
    }

    // ============================================================
    // PATIENTS
    // ============================================================
    private void patientMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Patients ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient by ID");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("0. Back");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> viewPatientById();
                case 3 -> viewAllPatients();
                case 4 -> updatePatient();
                case 5 -> deletePatient();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void registerPatient() {
        System.out.print("First name: ");
        String first = scanner.nextLine();
        System.out.print("Last name: ");
        String last = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (patientDAO.getPatientByEmail(email) != null) {
            System.out.println("A patient with that email already exists.");
            return;
        }

        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        Date dob = readOptionalDate("Date of birth (YYYY-MM-DD, blank to skip): ");
        System.out.print("Address: ");
        String address = scanner.nextLine();

        Patient p = new Patient(first, last, email, phone, dob, address);
        int id = patientDAO.insertPatient(p);
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed.");
    }

    private void viewPatientById() {
        int id = readInt("Patient ID: ");
        Patient p = patientDAO.getPatientById(id);
        System.out.println(p != null ? p : "No patient found with ID " + id);
    }

    private void viewAllPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        patients.forEach(System.out::println);
    }

    private void updatePatient() {
        int id = readInt("Patient ID to update: ");
        Patient p = patientDAO.getPatientById(id);
        if (p == null) {
            System.out.println("No patient found with ID " + id);
            return;
        }
        System.out.println("Leave blank to keep current value.");

        System.out.print("First name [" + p.getFirstName() + "]: ");
        String first = scanner.nextLine();
        if (!first.isBlank()) p.setFirstName(first);

        System.out.print("Last name [" + p.getLastName() + "]: ");
        String last = scanner.nextLine();
        if (!last.isBlank()) p.setLastName(last);

        System.out.print("Email [" + p.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isBlank()) p.setEmail(email);

        System.out.print("Phone [" + p.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) p.setPhone(phone);

        System.out.print("Address [" + p.getAddress() + "]: ");
        String address = scanner.nextLine();
        if (!address.isBlank()) p.setAddress(address);

        boolean ok = patientDAO.updatePatient(p);
        System.out.println(ok ? "Patient updated." : "Update failed.");
    }

    private void deletePatient() {
        int id = readInt("Patient ID to delete: ");
        System.out.print("This will also delete their appointments, billing, and visit history. Confirm? (y/n): ");
        if (!scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Cancelled.");
            return;
        }
        boolean ok = patientDAO.deletePatient(id);
        System.out.println(ok ? "Patient deleted." : "Delete failed (does that ID exist?).");
    }

    // ============================================================
    // DOCTORS
    // ============================================================
    private void doctorMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Doctors ---");
            System.out.println("1. Register Doctor");
            System.out.println("2. View Doctor by ID");
            System.out.println("3. View All Doctors");
            System.out.println("4. View Doctors by Specialization");
            System.out.println("5. Update Doctor");
            System.out.println("6. Delete Doctor");
            System.out.println("0. Back");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> registerDoctor();
                case 2 -> viewDoctorById();
                case 3 -> viewAllDoctors();
                case 4 -> viewDoctorsBySpecialization();
                case 5 -> updateDoctor();
                case 6 -> deleteDoctor();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void registerDoctor() {
        System.out.print("First name: ");
        String first = scanner.nextLine();
        System.out.print("Last name: ");
        String last = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        viewAllSpecializations();
        Integer specId = readOptionalInt("Specialization ID (blank to skip): ");

        Doctor d = new Doctor(first, last, email, phone, specId);
        int id = doctorDAO.insertDoctor(d);
        System.out.println(id > 0 ? "Doctor registered with ID: " + id : "Registration failed.");
    }

    private void viewDoctorById() {
        int id = readInt("Doctor ID: ");
        Doctor d = doctorDAO.getDoctorById(id);
        System.out.println(d != null ? d : "No doctor found with ID " + id);
    }

    private void viewAllDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered yet.");
            return;
        }
        doctors.forEach(System.out::println);
    }

    private void viewDoctorsBySpecialization() {
        int specId = readInt("Specialization ID: ");
        List<Doctor> doctors = doctorDAO.getDoctorsBySpecialization(specId);
        if (doctors.isEmpty()) {
            System.out.println("No doctors found for that specialization.");
            return;
        }
        doctors.forEach(System.out::println);
    }

    private void updateDoctor() {
        int id = readInt("Doctor ID to update: ");
        Doctor d = doctorDAO.getDoctorById(id);
        if (d == null) {
            System.out.println("No doctor found with ID " + id);
            return;
        }
        System.out.println("Leave blank to keep current value.");

        System.out.print("First name [" + d.getFirstName() + "]: ");
        String first = scanner.nextLine();
        if (!first.isBlank()) d.setFirstName(first);

        System.out.print("Last name [" + d.getLastName() + "]: ");
        String last = scanner.nextLine();
        if (!last.isBlank()) d.setLastName(last);

        System.out.print("Email [" + d.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isBlank()) d.setEmail(email);

        System.out.print("Phone [" + d.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) d.setPhone(phone);

        System.out.print("Specialization ID [" + d.getSpecializationId() + "] (blank to keep): ");
        String specStr = scanner.nextLine();
        if (!specStr.isBlank()) d.setSpecializationId(Integer.parseInt(specStr.trim()));

        boolean ok = doctorDAO.updateDoctor(d);
        System.out.println(ok ? "Doctor updated." : "Update failed.");
    }

    private void deleteDoctor() {
        int id = readInt("Doctor ID to delete: ");
        boolean ok = doctorDAO.deleteDoctor(id);
        System.out.println(ok ? "Doctor deleted." : "Delete failed (does that ID exist, or do they have appointments?).");
    }

    // ============================================================
    // SPECIALIZATIONS
    // ============================================================
    private void specializationMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Specializations ---");
            System.out.println("1. Add Specialization");
            System.out.println("2. View All Specializations");
            System.out.println("3. Update Specialization");
            System.out.println("4. Delete Specialization");
            System.out.println("0. Back");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> addSpecialization();
                case 2 -> viewAllSpecializations();
                case 3 -> updateSpecialization();
                case 4 -> deleteSpecialization();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addSpecialization() {
        System.out.print("Specialization name: ");
        String name = scanner.nextLine();
        int id = specializationDAO.insertSpecialization(new Specialization(name));
        System.out.println(id > 0 ? "Added with ID: " + id : "Add failed (maybe it already exists).");
    }

    private void viewAllSpecializations() {
        List<Specialization> list = specializationDAO.getAllSpecializations();
        if (list.isEmpty()) {
            System.out.println("No specializations yet.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void updateSpecialization() {
        int id = readInt("Specialization ID to update: ");
        Specialization s = specializationDAO.getSpecializationById(id);
        if (s == null) {
            System.out.println("No specialization found with ID " + id);
            return;
        }
        System.out.print("New name [" + s.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isBlank()) s.setName(name);
        boolean ok = specializationDAO.updateSpecialization(s);
        System.out.println(ok ? "Updated." : "Update failed.");
    }

    private void deleteSpecialization() {
        int id = readInt("Specialization ID to delete: ");
        boolean ok = specializationDAO.deleteSpecialization(id);
        System.out.println(ok ? "Deleted." : "Delete failed (does that ID exist?).");
    }

    // ============================================================
    // APPOINTMENTS
    // ============================================================
    private void appointmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Appointments ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointment by ID");
            System.out.println("3. View All Appointments");
            System.out.println("4. View Appointments by Patient");
            System.out.println("5. View Appointments by Doctor");
            System.out.println("6. Complete Appointment (bills + logs visit)");
            System.out.println("7. Cancel Appointment");
            System.out.println("8. Reschedule Appointment");
            System.out.println("9. Delete Appointment");
            System.out.println("0. Back");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> bookAppointment();
                case 2 -> viewAppointmentById();
                case 3 -> viewAllAppointments();
                case 4 -> viewAppointmentsByPatient();
                case 5 -> viewAppointmentsByDoctor();
                case 6 -> completeAppointment();
                case 7 -> cancelAppointment();
                case 8 -> rescheduleAppointment();
                case 9 -> deleteAppointment();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void bookAppointment() {
        int patientId = readInt("Patient ID: ");
        if (patientDAO.getPatientById(patientId) == null) {
            System.out.println("No patient with that ID. Register them first.");
            return;
        }
        int doctorId = readInt("Doctor ID: ");
        if (doctorDAO.getDoctorById(doctorId) == null) {
            System.out.println("No doctor with that ID.");
            return;
        }
        Timestamp date = readDateTime("Appointment date/time (YYYY-MM-DD HH:MM): ");
        if (date == null) return;

        Appointment a = new Appointment(patientId, doctorId, date);
        int id = appointmentDAO.insertAppointment(a);
        System.out.println(id > 0 ? "Appointment booked with ID: " + id : "Booking failed.");
    }

    private void viewAppointmentById() {
        int id = readInt("Appointment ID: ");
        Appointment a = appointmentDAO.getAppointmentById(id);
        System.out.println(a != null ? a : "No appointment found with ID " + id);
    }

    private void viewAllAppointments() {
        List<Appointment> list = appointmentDAO.getAllAppointments();
        if (list.isEmpty()) {
            System.out.println("No appointments yet.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void viewAppointmentsByPatient() {
        int patientId = readInt("Patient ID: ");
        List<Appointment> list = appointmentDAO.getAppointmentsByPatient(patientId);
        if (list.isEmpty()) {
            System.out.println("No appointments found for that patient.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void viewAppointmentsByDoctor() {
        int doctorId = readInt("Doctor ID: ");
        List<Appointment> list = appointmentDAO.getAppointmentsByDoctor(doctorId);
        if (list.isEmpty()) {
            System.out.println("No appointments found for that doctor.");
            return;
        }
        list.forEach(System.out::println);
    }

    /**
     * The signature workflow: one receptionist action that safely triggers
     * three database writes via the Service layer's transaction.
     */
    private void completeAppointment() {
        int id = readInt("Appointment ID: ");
        Appointment appt = appointmentDAO.getAppointmentById(id);
        if (appt == null) {
            System.out.println("No appointment found with ID " + id);
            return;
        }
        if (!"Scheduled".equals(appt.getStatus())) {
            System.out.println("Only 'Scheduled' appointments can be completed. Current status: " + appt.getStatus());
            return;
        }

        System.out.print("Bill amount: ");
        BigDecimal amount;
        try {
            amount = new BigDecimal(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Aborting.");
            return;
        }
        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Notes (optional): ");
        String notes = scanner.nextLine();

        boolean success = appointmentService.completeAppointment(id, amount, diagnosis, notes);
        System.out.println(success ? "Appointment completed! Bill and visit record created."
                                    : "Something went wrong — nothing was saved.");
    }

    private void cancelAppointment() {
        int id = readInt("Appointment ID to cancel: ");
        boolean ok = appointmentService.cancelAppointment(id);
        System.out.println(ok ? "Appointment cancelled." : "Cancel failed (does that ID exist?).");
    }

    private void rescheduleAppointment() {
        int id = readInt("Appointment ID to reschedule: ");
        Appointment appt = appointmentDAO.getAppointmentById(id);
        if (appt == null) {
            System.out.println("No appointment found with ID " + id);
            return;
        }
        Timestamp newDate = readDateTime("New date/time (YYYY-MM-DD HH:MM): ");
        if (newDate == null) return;
        appt.setAppointmentDate(newDate);
        boolean ok = appointmentDAO.updateAppointment(appt);
        System.out.println(ok ? "Appointment rescheduled." : "Reschedule failed.");
    }

    private void deleteAppointment() {
        int id = readInt("Appointment ID to delete: ");
        System.out.print("This also deletes its billing and visit history. Confirm? (y/n): ");
        if (!scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Cancelled.");
            return;
        }
        boolean ok = appointmentDAO.deleteAppointment(id);
        System.out.println(ok ? "Appointment deleted." : "Delete failed.");
    }

    // ============================================================
    // BILLING
    // ============================================================
    private void billingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Billing ---");
            System.out.println("1. View Bill by ID");
            System.out.println("2. View Bill by Appointment");
            System.out.println("3. View All Bills");
            System.out.println("4. Mark Bill as Paid");
            System.out.println("5. Delete Bill");
            System.out.println("0. Back");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> viewBillingById();
                case 2 -> viewBillingByAppointment();
                case 3 -> viewAllBillings();
                case 4 -> markBillPaid();
                case 5 -> deleteBilling();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void viewBillingById() {
        int id = readInt("Billing ID: ");
        Billing b = billingDAO.getBillingById(id);
        System.out.println(b != null ? b : "No bill found with ID " + id);
    }

    private void viewBillingByAppointment() {
        int apptId = readInt("Appointment ID: ");
        Billing b = billingDAO.getBillingByAppointmentId(apptId);
        System.out.println(b != null ? b : "No bill found for that appointment.");
    }

    private void viewAllBillings() {
        List<Billing> list = billingDAO.getAllBillings();
        if (list.isEmpty()) {
            System.out.println("No bills yet.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void markBillPaid() {
        int id = readInt("Billing ID to mark paid: ");
        boolean ok = billingDAO.updatePaymentStatus(id, "Paid");
        System.out.println(ok ? "Marked as Paid." : "Update failed (does that ID exist?).");
    }

    private void deleteBilling() {
        int id = readInt("Billing ID to delete: ");
        boolean ok = billingDAO.deleteBilling(id);
        System.out.println(ok ? "Bill deleted." : "Delete failed.");
    }

    // ============================================================
    // VISIT HISTORY
    // ============================================================
    private void visitHistoryMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Visit History ---");
            System.out.println("1. View Visit by ID");
            System.out.println("2. View Visits by Appointment");
            System.out.println("3. View All Visits");
            System.out.println("4. Update Visit Notes");
            System.out.println("5. Delete Visit Record");
            System.out.println("0. Back");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> viewVisitById();
                case 2 -> viewVisitsByAppointment();
                case 3 -> viewAllVisits();
                case 4 -> updateVisit();
                case 5 -> deleteVisit();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void viewVisitById() {
        int id = readInt("Visit ID: ");
        VisitHistory v = visitHistoryDAO.getVisitHistoryById(id);
        System.out.println(v != null ? v : "No visit record found with ID " + id);
    }

    private void viewVisitsByAppointment() {
        int apptId = readInt("Appointment ID: ");
        List<VisitHistory> list = visitHistoryDAO.getVisitHistoryByAppointmentId(apptId);
        if (list.isEmpty()) {
            System.out.println("No visit records found for that appointment.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void viewAllVisits() {
        List<VisitHistory> list = visitHistoryDAO.getAllVisitHistory();
        if (list.isEmpty()) {
            System.out.println("No visit records yet.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void updateVisit() {
        int id = readInt("Visit ID to update: ");
        VisitHistory v = visitHistoryDAO.getVisitHistoryById(id);
        if (v == null) {
            System.out.println("No visit record found with ID " + id);
            return;
        }
        System.out.print("Diagnosis [" + v.getDiagnosis() + "]: ");
        String diag = scanner.nextLine();
        if (!diag.isBlank()) v.setDiagnosis(diag);
        System.out.print("Notes [" + v.getNotes() + "]: ");
        String notes = scanner.nextLine();
        if (!notes.isBlank()) v.setNotes(notes);
        boolean ok = visitHistoryDAO.updateVisitHistory(v);
        System.out.println(ok ? "Updated." : "Update failed.");
    }

    private void deleteVisit() {
        int id = readInt("Visit ID to delete: ");
        boolean ok = visitHistoryDAO.deleteVisitHistory(id);
        System.out.println(ok ? "Deleted." : "Delete failed.");
    }

    // ============================================================
    // Small input helpers — kept here since they're pure UI concerns,
    // not business logic. This is Step 7's "fail safely on bad input".
    // ============================================================
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private Integer readOptionalInt(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) return null;
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number, skipping.");
            return null;
        }
    }

    private Date readOptionalDate(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) return null;
        try {
            return Date.valueOf(line);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format, skipping (expected YYYY-MM-DD).");
            return null;
        }
    }

    private Timestamp readDateTime(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try {
            // Accept "YYYY-MM-DD HH:MM" and turn it into a full timestamp
            return Timestamp.valueOf(line + ":00");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid format. Expected YYYY-MM-DD HH:MM, e.g. 2026-08-10 14:30. Aborting.");
            return null;
        }
    }
}
