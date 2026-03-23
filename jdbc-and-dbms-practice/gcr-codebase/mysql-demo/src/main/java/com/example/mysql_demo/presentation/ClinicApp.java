package com.example.mysql_demo.presentation;

import java.time.LocalDate;
import java.util.Scanner;

import com.example.mysql_demo.model.Patient;
import com.example.mysql_demo.service.PatientService;
import com.example.mysql_demo.service.VisitService;
import com.example.mysql_demo.service.AppointmentService;
import com.example.mysql_demo.service.BillingService;

public class ClinicApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();
        VisitService visitService = new VisitService();
        BillingService billingService=new BillingService();

        while (true) {

            System.out.println("\n===== Health Clinic System =====");

            System.out.println("1 Register Patient");
            System.out.println("2 Update Patient");
            System.out.println("3 Search Patient");
            System.out.println("4 View Visit History");

            System.out.println("5 Book Appointment");
            System.out.println("6 Check Doctor Availability");
            System.out.println("7 Cancel Appointment");
            System.out.println("8 Reschedule Appointment");
            System.out.println("9 View Daily Schedule");
            System.out.println("10 Record Patient Visit");
            System.out.println("11 View Medical History");
            System.out.println("12 Generate Bill");
            System.out.println("13 Record Payment");
            System.out.println("14 View Outstanding Bills");
            System.out.println("15 Revenue Report");

            System.out.println("16 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter DOB (yyyy-mm-dd):");
                    LocalDate dob = LocalDate.parse(sc.nextLine());

                    System.out.println("Enter Phone:");
                    String phone = sc.nextLine();

                    System.out.println("Enter Email:");
                    String email = sc.nextLine();

                    System.out.println("Enter Address:");
                    String address = sc.nextLine();

                    System.out.println("Enter Blood Group:");
                    String blood = sc.nextLine();

                    Patient patient = new Patient(name, dob, phone, email, address, blood);

                    patientService.register(patient);
                    break;

                case 2:

                    System.out.println("Enter patient id:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("New Address:");
                    String add = sc.nextLine();

                    System.out.println("New Phone:");
                    String ph = sc.nextLine();

                    patientService.update(id, add, ph);
                    break;

                case 3:

                    System.out.println("Enter name / phone / id:");
                    String key = sc.nextLine();

                    patientService.search(key);
                    break;

                case 4:

                    System.out.println("Enter patient id:");
                    int pid = sc.nextInt();

                    patientService.visitHistory(pid);
                    break;

                // -------- UC3 --------

                case 5:
                    appointmentService.book();
                    break;

                case 6:
                    appointmentService.availability();
                    break;

                case 7:
                    appointmentService.cancel();
                    break;

                case 8:
                    appointmentService.reschedule();
                    break;

                case 9:
                    appointmentService.schedule();
                    break;
                case 10:
                    visitService.recordVisit();
                    break;

                case 11:
                    visitService.history();
                    break;
                case 12:
                    billingService.generateBill();
                    break;

                case 13:
                    billingService.recordPayment();
                    break;

                case 14:
                    billingService.outstanding();
                    break;

                case 15:
                    billingService.revenue();
                    break;

                case 16:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
