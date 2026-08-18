package com.healthclinic.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;
    private String email;
    private String roomNumber;
    private BigDecimal consultationFee;
    private int experienceYears;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName,
                  String specialization,
                  String phoneNumber,
                  String email,
                  String roomNumber,
                  BigDecimal consultationFee,
                  int experienceYears) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roomNumber = roomNumber;
        this.consultationFee = consultationFee;
        this.experienceYears = experienceYears;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        this.consultationFee = consultationFee;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
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
        return "\nDoctor ID : " + doctorId +
                "\nName : Dr. " + firstName + " " + lastName +
                "\nSpecialization : " + specialization +
                "\nPhone : " + phoneNumber +
                "\nEmail : " + email +
                "\nRoom : " + roomNumber +
                "\nConsultation Fee : " + consultationFee +
                "\nExperience : " + experienceYears + " years";
    }
}