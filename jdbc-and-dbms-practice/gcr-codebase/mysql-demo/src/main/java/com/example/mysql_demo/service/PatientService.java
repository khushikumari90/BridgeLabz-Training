package com.example.mysql_demo.service;

import com.example.mysql_demo.dao.PatientDAO;

import com.example.mysql_demo.model.Patient;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class PatientService {

    private PatientDAO dao = new PatientDAO();

    public void register(Patient patient) throws Exception{
        dao.registerPatient(patient);
    }

    public void update(int id,String address,String phone) throws Exception{
        dao.updatePatient(id,address,phone);
    }

    public void search(String keyword) throws Exception{
        dao.searchPatient(keyword);
    }

    public void visitHistory(int id) throws Exception{
        dao.viewVisitHistory(id);
    }
}
