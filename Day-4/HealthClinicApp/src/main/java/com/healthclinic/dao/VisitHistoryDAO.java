package com.healthclinic.dao;

import com.healthclinic.dto.VisitHistory;

import java.util.List;

public interface VisitHistoryDAO {

    boolean addVisitHistory(VisitHistory visitHistory);

    boolean updateVisitHistory(VisitHistory visitHistory);

    boolean deleteVisitHistory(int visitId);

    VisitHistory getVisitHistoryById(int visitId);

    List<VisitHistory> getAllVisitHistory();
}