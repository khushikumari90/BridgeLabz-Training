package com.example.mysql_demo.dao;

import java.sql.*;
import java.util.List;
import com.example.mysql_demo.model.Prescription;

public class PrescriptionDAO {

    public void addPrescriptions(List<Prescription> list) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql =
        "INSERT INTO prescriptions(visit_id,medicine_name,dosage,duration) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        for(Prescription p : list){

            ps.setInt(1,p.getVisitId());
            ps.setString(2,p.getMedicineName());
            ps.setString(3,p.getDosage());
            ps.setString(4,p.getDuration());

            ps.addBatch();
        }

        ps.executeBatch();

        System.out.println("Prescriptions added");
    }
}
