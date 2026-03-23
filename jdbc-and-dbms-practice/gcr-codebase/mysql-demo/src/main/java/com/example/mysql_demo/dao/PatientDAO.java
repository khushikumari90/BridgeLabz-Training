package com.example.mysql_demo.dao;
import  com.example.mysql_demo.model.Patient;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
public class PatientDAO
{
	public void registerPatient(Patient patient) throws Exception
	{
		Connection con=DBConnection.getConnection();
		String checkQuery="Select * from patients where phone=? or email=?";
		PreparedStatement checkstmt=con.prepareStatement(checkQuery);
		checkstmt.setString(1,patient.getPhone());
		checkstmt.setString(2,patient.getEmail());
		
		ResultSet rs=checkstmt.executeQuery();
		if(rs.next())
		{
			System.out.println("patient already exsts");
			return;
		}
		String insertQuery="INSERT INTO patients(name,dob,phone,email,address,blood_group) values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insertQuery);
		ps.setString(1,patient.getName());
		ps.setDate(2,Date.valueOf(patient.getDob()));
		ps.setString(3,patient.getPhone());
		ps.setString(4,patient.getEmail());
		ps.setString(5,patient.getAddress());
		ps.setString(6,patient.getBloodGroup());
		
		ps.executeUpdate();
		System.out.println("Patient registered successfully");
		con.close();
	}
	 public void updatePatient(int id,String address,String phone) throws Exception{

	        Connection con = DBConnection.getConnection();

	        String sql =
	        "UPDATE patients SET address=?, phone=? WHERE patient_id=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1,address);
	        ps.setString(2,phone);
	        ps.setInt(3,id);

	        int rows = ps.executeUpdate();

	        if(rows>0)
	            System.out.println("Patient Updated");
	        else
	            System.out.println("Patient not found");

	        con.close();
	    }
	
	public void searchPatient(String keyword) throws Exception
	{
		Connection con=DBConnection.getConnection();
		String query="Select * from patients where name like ? or phone=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,"%"+keyword+"%");
		ps.setString(2, keyword);
		ResultSet rs=ps.executeQuery()
;
		while(rs.next())
		{
			System.out.println("ID"+rs.getInt("patient_id"));
			System.out.println("name"+rs.getString("name"));
			System.out.println("phone"+rs.getString("phone"));
			System.out.println("-------------------------");
		}
		con.close();
	}
	  public void viewVisitHistory(int patientId) throws Exception{

	        Connection con = DBConnection.getConnection();

	        String sql =
	        "SELECT a.doctor_name,v.diagnosis,v.visit_date " +
	        "FROM appointments a JOIN visits v " +
	        "ON a.appointment_id=v.appointment_id " +
	        "WHERE a.patient_id=? " +
	        "ORDER BY v.visit_date";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1,patientId);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()){

	            System.out.println("Doctor: "+rs.getString("doctor_name"));
	            System.out.println("Diagnosis: "+rs.getString("diagnosis"));
	            System.out.println("Visit Date: "+rs.getDate("visit_date"));
	            System.out.println("---------------------");
	        }
	        con.close();
	  }
}

