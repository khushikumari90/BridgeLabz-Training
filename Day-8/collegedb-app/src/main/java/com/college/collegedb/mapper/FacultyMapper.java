package com.college.collegedb.mapper;

import com.college.collegedb.dto.FacultyDTO;
import com.college.collegedb.entity.Faculty;
import org.springframework.stereotype.Component;
@Component
public class FacultyMapper {

    //Think of DTO files as only the Response and Request JSON data and you'll understand
    public FacultyDTO toDTO(Faculty faculty){
        return FacultyDTO.builder()
                .facultyId(faculty.getFacultyId())
                .firstName(faculty.getFirstName())
                .lastName(faculty.getLastName())
                .gender(faculty.getGender())
                .email(faculty.getEmail())
                .address(faculty.getAddress())
                .city(faculty.getCity())
                .state(faculty.getState())
                .department(faculty.getDepartment())
                .designation(faculty.getDesignation())
                .joiningYear(faculty.getJoiningYear())
                .salary(faculty.getSalary())
                .build();
    }

    public Faculty toEntity(FacultyDTO facultyDTO){
        return Faculty.builder()
                .facultyId(facultyDTO.getFacultyId())
                .firstName(facultyDTO.getFirstName())
                .lastName(facultyDTO.getLastName())
                .gender(facultyDTO.getGender())
                .email(facultyDTO.getEmail())
                .address(facultyDTO.getAddress())
                .city(facultyDTO.getCity())
                .state(facultyDTO.getState())
                .department(facultyDTO.getDepartment())
                .designation(facultyDTO.getDesignation())
                .joiningYear(facultyDTO.getJoiningYear())
                .salary(facultyDTO.getSalary())
                .build();
    }

    public Faculty updateEntityFromDTO(FacultyDTO facultyDTO, Faculty existingFaculty){
        existingFaculty.setFirstName(facultyDTO.getFirstName());
        existingFaculty.setLastName(facultyDTO.getLastName());
        existingFaculty.setEmail(facultyDTO.getEmail());
        existingFaculty.setGender(facultyDTO.getGender());
        existingFaculty.setAddress(facultyDTO.getAddress());
        existingFaculty.setCity(facultyDTO.getCity());
        existingFaculty.setState(facultyDTO.getState());
        existingFaculty.setDepartment(facultyDTO.getDepartment());
        existingFaculty.setDesignation(facultyDTO.getDesignation());
        existingFaculty.setJoiningYear(facultyDTO.getJoiningYear());
        existingFaculty.setSalary(facultyDTO.getSalary());

        return existingFaculty;
    }
}
