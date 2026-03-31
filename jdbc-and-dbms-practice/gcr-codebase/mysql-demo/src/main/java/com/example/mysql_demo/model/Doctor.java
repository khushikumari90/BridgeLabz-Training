package com.example.mysql_demo.model;

public class Doctor {

    private String name;
    private String contact;
    private double consultationFee;
    private int specialtyId;

    public Doctor(String name, String contact, double consultationFee, int specialtyId) {
        this.name = name;
        this.contact = contact;
        this.consultationFee = consultationFee;
        this.specialtyId = specialtyId;
    }

    public String getName() { return name; }
    public String getContact() { return contact; }
    public double getConsultationFee() { return consultationFee; }
    public int getSpecialtyId() { return specialtyId; }
}
