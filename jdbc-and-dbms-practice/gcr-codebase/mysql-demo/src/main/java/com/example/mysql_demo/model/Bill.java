
package com.example.mysql_demo.model;

public class Bill {

    private int visitId;
    private double consultationFee;
    private double additionalCharges;

    public Bill(int visitId,double consultationFee,double additionalCharges){
        this.visitId = visitId;
        this.consultationFee = consultationFee;
        this.additionalCharges = additionalCharges;
    }

    public int getVisitId(){
        return visitId;
    }

    public double getConsultationFee(){
        return consultationFee;
    }

    public double getAdditionalCharges(){
        return additionalCharges;
    }

}
