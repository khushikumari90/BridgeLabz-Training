package com.college.collegedb.service.impl;

import com.college.collegedb.dto.StudentDTO;
import com.college.collegedb.entity.Student;
import com.college.collegedb.exception.ResourceNotFoundException;
import com.college.collegedb.mapper.StudentMapper;
import com.college.collegedb.repository.StudentRepository;
import com.college.collegedb.service.FacultyService;
import com.college.collegedb.service.StudentService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final FacultyService facultyService; //StudentService need facultyService
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper,
                              @Lazy FacultyService facultyService){
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.facultyService = facultyService;
    }

    @Override
    public StudentDTO getStudentById(Integer id){
        Student getStudentEntity = studentRepository.getReferenceById(Long.valueOf(id));
        return studentMapper.toDTO(getStudentEntity);
    }

    @Override
    public List<StudentDTO> getAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO){
        Student entity = studentMapper.toEntity(studentDTO);
        return studentMapper.toDTO(studentRepository.save(entity));
    }

    @Override
    public void deleteStudentById(Integer id){
        if(id==null){
            throw new ResourceNotFoundException(id);
        }
        studentRepository.deleteById(Long.valueOf(id));
        return;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO){
        Student existingStudentEntity = studentRepository.findById(Long.valueOf(studentDTO.getStudentId()))
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Student updatedStudentEntity = studentMapper.updateEntityFromDTO(studentDTO, existingStudentEntity);
        Student savedStudentEntity = studentRepository.save(updatedStudentEntity);
        return studentMapper.toDTO(savedStudentEntity);
    }
}