package com.clinic.dao;

import com.clinic.dto.VisitHistory;
import java.sql.Connection;
import java.util.List;

public interface VisitHistoryDAO {
    int insertVisitHistory(VisitHistory visitHistory);
    VisitHistory getVisitHistoryById(int id);
    List<VisitHistory> getVisitHistoryByAppointmentId(int appointmentId);
    List<VisitHistory> getAllVisitHistory();
    boolean updateVisitHistory(VisitHistory visitHistory);
    boolean deleteVisitHistory(int id);

    /** Used by the Service layer to share the same transaction/connection. */
    int insertVisitHistory(Connection conn, VisitHistory visitHistory) throws java.sql.SQLException;
}
