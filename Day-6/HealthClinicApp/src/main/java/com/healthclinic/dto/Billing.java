package com.healthclinic.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.Timestamp;

public class Billing {

    private int billingId;
    private int appointmentId;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private LocalDate billingDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Billing() {
    }

    public Billing(int appointmentId,
                   BigDecimal totalAmount,
                   String paymentStatus,
                   LocalDate billingDate) {

        this.appointmentId = appointmentId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.billingDate = billingDate;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {

        return "\nBilling ID : " + billingId +
                "\nAppointment ID : " + appointmentId +
                "\nAmount : " + totalAmount +
                "\nPayment Status : " + paymentStatus +
                "\nBilling Date : " + billingDate;
    }
}