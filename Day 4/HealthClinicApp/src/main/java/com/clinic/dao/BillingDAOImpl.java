package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public int insertBilling(Billing billing) {
        try (Connection conn = HikariConnectionPool.getConnection()) {
            return insertBilling(conn, billing);
        } catch (SQLException e) {
            System.out.println("Insert billing failed: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Shares a connection handed in by the Service layer, so this insert can be
     * part of the same commit/rollback as the appointment status update and the
     * visit_history insert.
     */
    @Override
    public int insertBilling(Connection conn, Billing billing) throws SQLException {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, billing.getAppointmentId());
            pstmt.setBigDecimal(2, billing.getAmount());
            pstmt.setString(3, billing.getPaymentStatus() != null ? billing.getPaymentStatus() : "Pending");
            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public Billing getBillingById(int id) {
        String sql = "SELECT * FROM billing WHERE billing_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get billing failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Billing getBillingByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM billing WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Get billing by appointment failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Billing> getAllBillings() {
        String sql = "SELECT * FROM billing ORDER BY billing_id";
        List<Billing> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Get all billings failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updatePaymentStatus(int billingId, String paymentStatus) {
        String sql = "UPDATE billing SET payment_status = ? WHERE billing_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, paymentStatus);
            pstmt.setInt(2, billingId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update payment status failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBilling(int id) {
        String sql = "DELETE FROM billing WHERE billing_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete billing failed: " + e.getMessage());
            return false;
        }
    }

    private Billing mapRow(ResultSet rs) throws SQLException {
        Billing b = new Billing();
        b.setBillingId(rs.getInt("billing_id"));
        b.setAppointmentId(rs.getInt("appointment_id"));
        b.setAmount(rs.getBigDecimal("amount"));
        b.setPaymentStatus(rs.getString("payment_status"));
        b.setBillingDate(rs.getTimestamp("billing_date"));
        return b;
    }
}
