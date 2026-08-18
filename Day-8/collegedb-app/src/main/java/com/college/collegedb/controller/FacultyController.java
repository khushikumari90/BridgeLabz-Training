package com.college.collegedb.controller;

import com.college.collegedb.dto.FacultyDTO;
import com.college.collegedb.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }
    @GetMapping
    public List<FacultyDTO> getAllFaculty(){
        return facultyService.getAllFaculty();
    }

    @GetMapping("/{id}")
    public FacultyDTO getFacultyById(@PathVariable Integer id){
        return facultyService.getFacultyById(id);
    }

    @PostMapping
    public FacultyDTO createFaculty(@RequestBody FacultyDTO facultyDTO){
        return facultyService.createFaculty(facultyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFacultyById(@PathVariable Integer id){
        facultyService.deleteFacultyById(id);
    }

    @PutMapping
    public FacultyDTO updateFaculty(@RequestBody FacultyDTO facultyDTO){
        return facultyService.updateFaculty(facultyDTO);
    }
}
