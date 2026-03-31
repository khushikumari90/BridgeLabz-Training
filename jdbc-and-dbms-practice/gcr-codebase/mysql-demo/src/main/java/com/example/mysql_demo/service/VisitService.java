package com.example.mysql_demo.service;

import java.util.*;

import com.example.mysql_demo.dao.VisitDAO;
import com.example.mysql_demo.dao.PrescriptionDAO;
import com.example.mysql_demo.model.Visit;
import com.example.mysql_demo.model.Prescription;

public class VisitService {

    Scanner sc = new Scanner(System.in);

    VisitDAO visitDAO = new VisitDAO();
    PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    // record visit
    public void recordVisit() throws Exception {

        System.out.println("Appointment id:");
        int aid = sc.nextInt();

        System.out.println("Patient id:");
        int pid = sc.nextInt();

        System.out.println("Doctor id:");
        int did = sc.nextInt();
        sc.nextLine();

        System.out.println("Visit date:");
        String date = sc.nextLine();

        System.out.println("Diagnosis:");
        String diag = sc.nextLine();

        System.out.println("Notes:");
        String notes = sc.nextLine();

        Visit visit = new Visit(aid,pid,did,date,diag,notes);

        int visitId = visitDAO.recordVisit(visit);

        System.out.println("Number of medicines:");
        int n = sc.nextInt();
        sc.nextLine();

        List<Prescription> list = new ArrayList<>();

        for(int i=0;i<n;i++){

            System.out.println("Medicine:");
            String med = sc.nextLine();

            System.out.println("Dosage:");
            String dose = sc.nextLine();

            System.out.println("Duration:");
            String dur = sc.nextLine();

            list.add(new Prescription(visitId,med,dose,dur));
        }

        prescriptionDAO.addPrescriptions(list);
    }

    public void history() throws Exception {

        System.out.println("Patient id:");
        int pid = sc.nextInt();

        visitDAO.medicalHistory(pid);
    }
}
