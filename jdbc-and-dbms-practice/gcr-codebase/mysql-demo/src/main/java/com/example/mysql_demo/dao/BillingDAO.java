package com.example.mysql_demo.dao;

import java.sql.*;
import com.example.mysql_demo.model.Bill;

public class BillingDAO {

    // UC-5.1 Generate Bill
    public void generateBill(Bill bill) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "INSERT INTO bills(visit_id,consultation_fee,additional_charges,total_amount,bill_date) VALUES(?,?,?,?,CURDATE())";

        PreparedStatement ps = con.prepareStatement(sql);

        double total = bill.getConsultationFee() + bill.getAdditionalCharges();

        ps.setInt(1, bill.getVisitId());
        ps.setDouble(2, bill.getConsultationFee());
        ps.setDouble(3, bill.getAdditionalCharges());
        ps.setDouble(4, total);

        ps.executeUpdate();

        System.out.println("Bill generated successfully");
    }


    // UC-5.3 View Outstanding Bills
    public void outstandingBills() throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT p.name,COUNT(b.bill_id) AS total_bills,SUM(b.total_amount) AS pending_amount " +
        "FROM bills b " +
        "JOIN visits v ON b.visit_id=v.visit_id " +
        "JOIN patients p ON v.patient_id=p.patient_id " +
        "WHERE b.payment_status='UNPAID' " +
        "GROUP BY p.name";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            System.out.println(
            rs.getString("name")+" | "+
            rs.getInt("total_bills")+" bills | "+
            rs.getDouble("pending_amount")+" pending");
        }
    }


    // UC-5.4 Revenue Report
    public void revenueReport(String start,String end) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT d.name,SUM(b.total_amount) AS revenue " +
        "FROM bills b " +
        "JOIN visits v ON b.visit_id=v.visit_id " +
        "JOIN doctors d ON v.doctor_id=d.doctor_id " +
        "WHERE b.bill_date BETWEEN ? AND ? " +
        "GROUP BY d.name";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1,start);
        ps.setString(2,end);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            System.out.println(
            rs.getString("name")+" | Revenue: "+rs.getDouble("revenue"));
        }
    }
}
