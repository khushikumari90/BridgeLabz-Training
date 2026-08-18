package com.college.collegedb.service;

import com.college.collegedb.dto.FacultyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacultyService {
    List<FacultyDTO> getAllFaculty();
    FacultyDTO getFacultyById(Integer id);
    FacultyDTO createFaculty(FacultyDTO facultyDTO);
    void deleteFacultyById(Integer facultyId);
    FacultyDTO updateFaculty(FacultyDTO facultyDTO);
}