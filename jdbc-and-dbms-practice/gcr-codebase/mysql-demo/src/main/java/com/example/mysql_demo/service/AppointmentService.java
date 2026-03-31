package com.example.mysql_demo.service;

import java.util.Scanner;
import com.example.mysql_demo.dao.AppointmentDAO;
import com.example.mysql_demo.model.Appointment;

public class AppointmentService {

    Scanner sc = new Scanner(System.in);
    AppointmentDAO dao = new AppointmentDAO();

    public void book() throws Exception {

        System.out.println("Patient id:");
        int pid = sc.nextInt();

        System.out.println("Doctor id:");
        int did = sc.nextInt();

        sc.nextLine();

        System.out.println("Doctor name:");
        String dname = sc.nextLine();

        System.out.println("Date yyyy-mm-dd:");
        String date = sc.nextLine();

        System.out.println("Time hh:mm:ss:");
        String time = sc.nextLine();

        Appointment ap = new Appointment(pid,did,dname,date,time);

        dao.bookAppointment(ap);
    }

    public void availability() throws Exception {

        System.out.println("Doctor id:");
        int did = sc.nextInt();
        sc.nextLine();

        System.out.println("Date:");
        String date = sc.nextLine();

        dao.checkAvailability(did,date);
    }

    public void cancel() throws Exception {

        System.out.println("Appointment id:");
        int id = sc.nextInt();

        dao.cancelAppointment(id);
    }

    public void reschedule() throws Exception {

        System.out.println("Appointment id:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("New date:");
        String date = sc.nextLine();

        System.out.println("New time:");
        String time = sc.nextLine();

        dao.reschedule(id,date,time);
    }

    public void schedule() throws Exception {

        System.out.println("Date:");
        String date = sc.next();

        dao.viewSchedule(date);
    }
}
