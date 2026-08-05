package com.clinic.dao;

import com.clinic.dto.Billing;
import java.sql.Connection;
import java.util.List;

public interface BillingDAO {
    int insertBilling(Billing billing);
    Billing getBillingById(int id);
    Billing getBillingByAppointmentId(int appointmentId);
    List<Billing> getAllBillings();
    boolean updatePaymentStatus(int billingId, String paymentStatus);
    boolean deleteBilling(int id);

    /** Used by the Service layer to share the same transaction/connection. */
    int insertBilling(Connection conn, Billing billing) throws java.sql.SQLException;
}
