package com.healthclinic.dao;

import com.healthclinic.config.DatabaseConnection;
import com.healthclinic.dto.Billing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public boolean addBilling(Billing billing) {

        String sql = """
                INSERT INTO billing
                (appointment_id,
                total_amount,
                payment_status,
                billing_date)
                VALUES(?,?,?,?)
                """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){

            ps.setInt(1,billing.getAppointmentId());

            ps.setBigDecimal(2,billing.getTotalAmount());

            ps.setString(3,billing.getPaymentStatus());

            ps.setDate(4,Date.valueOf(billing.getBillingDate()));

            return ps.executeUpdate()>0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateBilling(Billing billing) {

        String sql="""
                UPDATE billing
                SET appointment_id=?,
                total_amount=?,
                payment_status=?,
                billing_date=?
                WHERE billing_id=?
                """;

        try(
                Connection connection=DatabaseConnection.getConnection();
                PreparedStatement ps=connection.prepareStatement(sql);
        ){

            ps.setInt(1,billing.getAppointmentId());
            ps.setBigDecimal(2,billing.getTotalAmount());
            ps.setString(3,billing.getPaymentStatus());
            ps.setDate(4,Date.valueOf(billing.getBillingDate()));
            ps.setInt(5,billing.getBillingId());

            return ps.executeUpdate()>0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteBilling(int billingId) {

        String sql="DELETE FROM billing WHERE billing_id=?";

        try(
                Connection connection=DatabaseConnection.getConnection();
                PreparedStatement ps=connection.prepareStatement(sql);
        ){

            ps.setInt(1,billingId);

            return ps.executeUpdate()>0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Billing getBillingById(int billingId) {

        String sql="SELECT * FROM billing WHERE billing_id=?";

        try(
                Connection connection=DatabaseConnection.getConnection();
                PreparedStatement ps=connection.prepareStatement(sql);
        ){

            ps.setInt(1,billingId);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Billing billing=new Billing();

                billing.setBillingId(rs.getInt("billing_id"));
                billing.setAppointmentId(rs.getInt("appointment_id"));
                billing.setTotalAmount(rs.getBigDecimal("total_amount"));
                billing.setPaymentStatus(rs.getString("payment_status"));
                billing.setBillingDate(rs.getDate("billing_date").toLocalDate());
                billing.setCreatedAt(rs.getTimestamp("created_at"));
                billing.setUpdatedAt(rs.getTimestamp("updated_at"));

                return billing;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Billing> getAllBillings() {

        List<Billing> billings=new ArrayList<>();

        String sql="SELECT * FROM billing";

        try(
                Connection connection=DatabaseConnection.getConnection();
                PreparedStatement ps=connection.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
        ){

            while(rs.next()){

                Billing billing=new Billing();

                billing.setBillingId(rs.getInt("billing_id"));
                billing.setAppointmentId(rs.getInt("appointment_id"));
                billing.setTotalAmount(rs.getBigDecimal("total_amount"));
                billing.setPaymentStatus(rs.getString("payment_status"));
                billing.setBillingDate(rs.getDate("billing_date").toLocalDate());
                billing.setCreatedAt(rs.getTimestamp("created_at"));
                billing.setUpdatedAt(rs.getTimestamp("updated_at"));

                billings.add(billing);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return billings;
    }
}