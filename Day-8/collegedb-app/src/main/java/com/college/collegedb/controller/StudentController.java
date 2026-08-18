package com.college.collegedb.controller;

import com.college.collegedb.dto.StudentDTO;
import com.college.collegedb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }

    @PutMapping
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }
}