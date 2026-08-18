package com.healthclinic.dto;

import java.time.LocalDate;
import java.sql.Timestamp;

public class VisitHistory {

    private int visitId;
    private int appointmentId;
    private String diagnosis;
    private String prescription;
    private LocalDate visitDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public VisitHistory() {
    }

    public VisitHistory(int appointmentId,
                        String diagnosis,
                        String prescription,
                        LocalDate visitDate) {

        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.visitDate = visitDate;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
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

        return "\nVisit ID : " + visitId +
                "\nAppointment ID : " + appointmentId +
                "\nDiagnosis : " + diagnosis +
                "\nPrescription : " + prescription +
                "\nVisit Date : " + visitDate;
    }
}