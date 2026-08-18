package com.college.collegedb.service;

import com.college.collegedb.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Integer id);
    StudentDTO createStudent(StudentDTO studentDTO);
    void deleteStudentById(Integer studentId);
    StudentDTO updateStudent(StudentDTO studentDTO);
}