package com.college.collegedb.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Integer studentId;
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String address;
    private String city;
    private String state;
    private String course;
    private String department;
    private Integer admissionYear;
}