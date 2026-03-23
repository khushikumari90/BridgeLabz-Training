package com.example.mysql_demo.model;

public class Appointment {

    private int patientId;
    private int doctorId;
    private String doctorName;
    private String date;
    private String time;

    public Appointment(int patientId,int doctorId,String doctorName,String date,String time){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public int getPatientId(){ return patientId; }
    public int getDoctorId(){ return doctorId; }
    public String getDoctorName(){ return doctorName; }
    public String getDate(){ return date; }
    public String getTime(){ return time; }
}
