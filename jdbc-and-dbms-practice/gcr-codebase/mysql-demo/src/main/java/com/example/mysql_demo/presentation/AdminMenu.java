package com.example.mysql_demo.presentation;

import java.util.Scanner;

import com.example.mysql_demo.service.AdminService;

public class AdminMenu {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        AdminService service = new AdminService();

        while(true) {

            System.out.println("1 Add Specialty");
            System.out.println("2 View Specialties");
            System.out.println("3 Delete Specialty");
            System.out.println("4 View Audit Logs");
            System.out.println("5 Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch(ch) {

            case 1:

                System.out.println("Enter specialty name:");
                String name=sc.nextLine();

                System.out.println("Enter description:");
                String desc=sc.nextLine();

                service.addSpecialty(name,desc);
                break;

            case 2:
                service.viewSpecialties();
                break;

            case 3:

                System.out.println("Enter specialty id:");
                int id=sc.nextInt();

                service.deleteSpecialty(id);
                break;

            case 4:
                service.viewAuditLogs();
                break;

            case 5:
                System.exit(0);
            }
        }
    }
}
