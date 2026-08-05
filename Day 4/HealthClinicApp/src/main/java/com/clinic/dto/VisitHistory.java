package com.clinic.dto;

import java.sql.Timestamp;

public class VisitHistory {

    private int visitId;
    private int appointmentId;
    private String diagnosis;
    private String notes;
    private Timestamp visitDate;

    public VisitHistory() {
    }

    public VisitHistory(int appointmentId, String diagnosis, String notes) {
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public int getVisitId() { return visitId; }
    public void setVisitId(int visitId) { this.visitId = visitId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Timestamp getVisitDate() { return visitDate; }
    public void setVisitDate(Timestamp visitDate) { this.visitDate = visitDate; }

    @Override
    public String toString() {
        return "VisitHistory{id=" + visitId + ", appointmentId=" + appointmentId +
                ", diagnosis='" + diagnosis + "'}";
    }
}
