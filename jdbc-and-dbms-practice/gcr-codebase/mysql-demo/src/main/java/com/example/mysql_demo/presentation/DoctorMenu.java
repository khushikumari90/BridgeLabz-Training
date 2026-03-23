package com.example.mysql_demo.presentation;

import com.example.mysql_demo.model.Doctor;
import com.example.mysql_demo.service.DoctorService;

import java.util.Scanner;

public class DoctorMenu {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while(true){

            System.out.println("1 Add Doctor");
            System.out.println("2 Update Doctor Specialty");
            System.out.println("3 View Doctors by Specialty");
            System.out.println("4 Deactivate Doctor");
            System.out.println("5 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.println("Enter name:");
                    String name = sc.nextLine();

                    System.out.println("Enter contact:");
                    String contact = sc.nextLine();

                    System.out.println("Enter consultation fee:");
                    double fee = sc.nextDouble();

                    System.out.println("Enter specialty id:");
                    int sp = sc.nextInt();

                    Doctor doctor = new Doctor(name,contact,fee,sp);

                    service.addDoctor(doctor);

                    break;

                case 2:

                    System.out.println("Enter doctor id:");
                    int docId = sc.nextInt();

                    System.out.println("Enter new specialty id:");
                    int spId = sc.nextInt();

                    service.updateSpecialty(docId,spId);

                    break;

                case 3:

                    sc.nextLine();
                    System.out.println("Enter specialty name:");
                    String s = sc.nextLine();

                    service.viewBySpecialty(s);

                    break;

                case 4:

                    System.out.println("Enter doctor id:");
                    int id = sc.nextInt();

                    service.deactivate(id);

                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
