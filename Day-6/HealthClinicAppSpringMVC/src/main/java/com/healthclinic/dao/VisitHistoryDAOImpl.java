package com.healthclinic.dao;

import com.healthclinic.config.DatabaseConnection;
import com.healthclinic.dto.VisitHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public boolean addVisitHistory(VisitHistory visitHistory) {

        String sql = """
                INSERT INTO visit_history
                (appointment_id,
                diagnosis,
                prescription,
                visit_date)
                VALUES(?,?,?,?)
                """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){

            ps.setInt(1, visitHistory.getAppointmentId());
            ps.setString(2, visitHistory.getDiagnosis());
            ps.setString(3, visitHistory.getPrescription());
            ps.setDate(4, Date.valueOf(visitHistory.getVisitDate()));

            return ps.executeUpdate() > 0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateVisitHistory(VisitHistory visitHistory) {

        String sql = """
                UPDATE visit_history
                SET appointment_id=?,
                    diagnosis=?,
                    prescription=?,
                    visit_date=?
                WHERE visit_id=?
                """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){

            ps.setInt(1, visitHistory.getAppointmentId());
            ps.setString(2, visitHistory.getDiagnosis());
            ps.setString(3, visitHistory.getPrescription());
            ps.setDate(4, Date.valueOf(visitHistory.getVisitDate()));
            ps.setInt(5, visitHistory.getVisitId());

            return ps.executeUpdate() > 0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteVisitHistory(int visitId) {

        String sql = "DELETE FROM visit_history WHERE visit_id=?";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){

            ps.setInt(1, visitId);

            return ps.executeUpdate() > 0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public VisitHistory getVisitHistoryById(int visitId) {

        String sql = "SELECT * FROM visit_history WHERE visit_id=?";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){

            ps.setInt(1, visitId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                VisitHistory visitHistory = new VisitHistory();

                visitHistory.setVisitId(rs.getInt("visit_id"));
                visitHistory.setAppointmentId(rs.getInt("appointment_id"));
                visitHistory.setDiagnosis(rs.getString("diagnosis"));
                visitHistory.setPrescription(rs.getString("prescription"));
                visitHistory.setVisitDate(rs.getDate("visit_date").toLocalDate());
                visitHistory.setCreatedAt(rs.getTimestamp("created_at"));
                visitHistory.setUpdatedAt(rs.getTimestamp("updated_at"));

                return visitHistory;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VisitHistory> getAllVisitHistory() {

        List<VisitHistory> list = new ArrayList<>();

        String sql = "SELECT * FROM visit_history";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ){

            while(rs.next()){

                VisitHistory visitHistory = new VisitHistory();

                visitHistory.setVisitId(rs.getInt("visit_id"));
                visitHistory.setAppointmentId(rs.getInt("appointment_id"));
                visitHistory.setDiagnosis(rs.getString("diagnosis"));
                visitHistory.setPrescription(rs.getString("prescription"));
                visitHistory.setVisitDate(rs.getDate("visit_date").toLocalDate());
                visitHistory.setCreatedAt(rs.getTimestamp("created_at"));
                visitHistory.setUpdatedAt(rs.getTimestamp("updated_at"));

                list.add(visitHistory);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return list;
    }
}