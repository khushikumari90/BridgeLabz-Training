package com.clinic.service;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.*;
import com.clinic.dto.Billing;
import com.clinic.dto.VisitHistory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Floor 3 — coordinates multiple DAO writes into a single all-or-nothing
 * transaction. "Complete an appointment" is really three separate writes
 * (status update + billing insert + visit_history insert) that must succeed
 * or fail together, like one switch controlling three bulbs.
 */
public class AppointmentService {

    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();

    /**
     * Marks the appointment Completed, creates its bill, and logs the visit —
     * all three or none of them.
     */
    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis, String notes) {
        Connection conn = null;
        try {
            conn = HikariConnectionPool.getConnection();
            conn.setAutoCommit(false); // stop auto-saving after each statement

            // Write 1: mark appointment as completed
            boolean statusUpdated = appointmentDAO.updateStatus(conn, appointmentId, "Completed");
            if (!statusUpdated) {
                throw new SQLException("Appointment " + appointmentId + " does not exist.");
            }

            // Write 2: create the bill
            Billing billing = new Billing(appointmentId, amount, "Pending");
            int billingId = billingDAO.insertBilling(conn, billing);
            if (billingId == -1) {
                throw new SQLException("Failed to create billing record.");
            }

            // Write 3: record what happened during the visit
            VisitHistory visit = new VisitHistory(appointmentId, diagnosis, notes);
            int visitId = visitHistoryDAO.insertVisitHistory(conn, visit);
            if (visitId == -1) {
                throw new SQLException("Failed to create visit history record.");
            }

            conn.commit(); // all 3 worked -> save everything for real
            return true;

        } catch (SQLException e) {
            System.out.println("Something failed, undoing everything: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Rollback failed: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Closing connection failed: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Cancels a scheduled appointment. Single write, no transaction needed —
     * included here because it's still an "appointment lifecycle" action that
     * belongs conceptually with completeAppointment, not scattered in the UI.
     */
    public boolean cancelAppointment(int appointmentId) {
        try (Connection conn = HikariConnectionPool.getConnection()) {
            return appointmentDAO.updateStatus(conn, appointmentId, "Cancelled");
        } catch (SQLException e) {
            System.out.println("Cancel appointment failed: " + e.getMessage());
            return false;
        }
    }
}
