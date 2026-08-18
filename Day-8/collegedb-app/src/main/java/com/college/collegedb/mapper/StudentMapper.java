package com.college.collegedb.mapper;

import com.college.collegedb.dto.StudentDTO;
import com.college.collegedb.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDTO toDTO(Student student){
        return StudentDTO.builder()
                .studentId(student.getStudentId())
                .rollNumber(student.getRollNumber())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .gender(student.getGender())
                .email(student.getEmail())
                .address(student.getAddress())
                .city(student.getCity())
                .state(student.getState())
                .course(student.getCourse())
                .department(student.getDepartment())
                .admissionYear(student.getAdmissionYear())
                .build();
    }

    public Student toEntity(StudentDTO studentDTO){
        return Student.builder()
                .studentId(studentDTO.getStudentId())
                .rollNumber(studentDTO.getRollNumber())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .gender(studentDTO.getGender())
                .email(studentDTO.getEmail())
                .address(studentDTO.getAddress())
                .city(studentDTO.getCity())
                .state(studentDTO.getState())
                .course(studentDTO.getCourse())
                .department(studentDTO.getDepartment())
                .admissionYear(studentDTO.getAdmissionYear())
                .build();
    }

    public Student updateEntityFromDTO(StudentDTO studentDTO, Student existingStudent){
        existingStudent.setRollNumber(studentDTO.getRollNumber());
        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setLastName(studentDTO.getLastName());
        existingStudent.setGender(studentDTO.getGender());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setAddress(studentDTO.getAddress());
        existingStudent.setCity(studentDTO.getCity());
        existingStudent.setState(studentDTO.getState());
        existingStudent.setCourse(studentDTO.getCourse());
        existingStudent.setDepartment(studentDTO.getDepartment());
        existingStudent.setAdmissionYear(studentDTO.getAdmissionYear());

        return existingStudent;
    }
}