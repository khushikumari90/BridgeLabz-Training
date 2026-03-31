package com.example.mysql_demo.model;

public class Visit {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String visitDate;
    private String diagnosis;
    private String notes;

    public Visit(int appointmentId,int patientId,int doctorId,
                 String visitDate,String diagnosis,String notes){

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public int getAppointmentId(){ return appointmentId; }
    public int getPatientId(){ return patientId; }
    public int getDoctorId(){ return doctorId; }
    public String getVisitDate(){ return visitDate; }
    public String getDiagnosis(){ return diagnosis; }
    public String getNotes(){ return notes; }
}
