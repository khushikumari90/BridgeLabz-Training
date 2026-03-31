package com.example.mysql_demo.dao;

import java.sql.*;
import com.example.mysql_demo.dao.DBConnection;

public class AdminDAO {

    Connection con = DBConnection.getConnection();

    public void addSpecialty(String name, String desc) throws Exception {

        String sql="INSERT INTO specialties(specialty_name,description) VALUES(?,?)";

        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,desc);

        ps.executeUpdate();

        System.out.println("Specialty added");
    }

    public void viewSpecialties() throws Exception {

        String sql="SELECT * FROM specialties";

        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()) {

            System.out.println(rs.getInt("specialty_id")+" "
                    +rs.getString("specialty_name")+" "
                    +rs.getString("description"));
        }
    }

    public void deleteSpecialty(int id) throws Exception {

        String check="SELECT COUNT(*) FROM doctors WHERE specialty_id=?";

        PreparedStatement ps=con.prepareStatement(check);
        ps.setInt(1,id);

        ResultSet rs=ps.executeQuery();

        rs.next();

        if(rs.getInt(1)>0) {
            System.out.println("Cannot delete. Doctors exist with this specialty.");
            return;
        }

        String sql="DELETE FROM specialties WHERE specialty_id=?";

        PreparedStatement ps2=con.prepareStatement(sql);
        ps2.setInt(1,id);

        ps2.executeUpdate();

        System.out.println("Specialty deleted");
    }

    public void viewAuditLogs() throws Exception {

        String sql="SELECT * FROM audit_log";

        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()) {

            System.out.println(
                    rs.getInt("log_id")+" "
                    +rs.getString("table_name")+" "
                    +rs.getString("operation_type")+" "
                    +rs.getString("change_time")
            );
        }
    }
}
