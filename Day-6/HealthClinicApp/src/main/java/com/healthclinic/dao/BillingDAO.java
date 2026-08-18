package com.healthclinic.dao;

import com.healthclinic.dto.Billing;

import java.util.List;

public interface BillingDAO {

    boolean addBilling(Billing billing);

    boolean updateBilling(Billing billing);

    boolean deleteBilling(int billingId);

    Billing getBillingById(int billingId);

    List<Billing> getAllBillings();
}