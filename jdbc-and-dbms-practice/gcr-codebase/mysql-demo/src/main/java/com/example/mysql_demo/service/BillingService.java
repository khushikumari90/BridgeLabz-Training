package com.example.mysql_demo.service;

import java.util.Scanner;

import com.example.mysql_demo.dao.BillingDAO;
import com.example.mysql_demo.dao.PaymentDAO;
import com.example.mysql_demo.model.Bill;
import com.example.mysql_demo.model.PaymentTransaction;

public class BillingService {

    Scanner sc = new Scanner(System.in);

    BillingDAO billingDAO = new BillingDAO();
    PaymentDAO paymentDAO = new PaymentDAO();

    // UC-5.1
    public void generateBill() throws Exception {

        System.out.println("Enter visit id:");
        int vid = sc.nextInt();

        System.out.println("Consultation fee:");
        double fee = sc.nextDouble();

        System.out.println("Additional charges:");
        double add = sc.nextDouble();

        Bill bill = new Bill(vid,fee,add);

        billingDAO.generateBill(bill);
    }


    // UC-5.2
    public void recordPayment() throws Exception {

        System.out.println("Enter bill id:");
        int bid = sc.nextInt();
        sc.nextLine();

        System.out.println("Payment mode:");
        String mode = sc.nextLine();

        System.out.println("Amount:");
        double amt = sc.nextDouble();

        PaymentTransaction p =
        new PaymentTransaction(bid,mode,amt);

        paymentDAO.recordPayment(p);
    }


    // UC-5.3
    public void outstanding() throws Exception {

        billingDAO.outstandingBills();
    }


    // UC-5.4
    public void revenue() throws Exception {

        sc.nextLine();

        System.out.println("Start date (yyyy-mm-dd):");
        String start = sc.nextLine();

        System.out.println("End date (yyyy-mm-dd):");
        String end = sc.nextLine();

        billingDAO.revenueReport(start,end);
    }
}
