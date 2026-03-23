package com.example.mysql_demo.dao;

import java.sql.*;
import com.example.mysql_demo.model.PaymentTransaction;

public class PaymentDAO {

    public void recordPayment(PaymentTransaction p) throws Exception {

        Connection con = DBConnection.getConnection();

        con.setAutoCommit(false);

        try{

            String update =
            "UPDATE bills SET payment_status='PAID' WHERE bill_id=?";

            PreparedStatement ps1 = con.prepareStatement(update);
            ps1.setInt(1,p.getBillId());
            ps1.executeUpdate();


            String insert =
            "INSERT INTO payment_transactions(bill_id,payment_date,payment_mode,amount) VALUES(?,CURDATE(),?,?)";

            PreparedStatement ps2 = con.prepareStatement(insert);

            ps2.setInt(1,p.getBillId());
            ps2.setString(2,p.getPaymentMode());
            ps2.setDouble(3,p.getAmount());

            ps2.executeUpdate();

            con.commit();

            System.out.println("Payment recorded successfully");

        }
        catch(Exception e){

            con.rollback();
            System.out.println("Payment failed");
        }
    }
}
