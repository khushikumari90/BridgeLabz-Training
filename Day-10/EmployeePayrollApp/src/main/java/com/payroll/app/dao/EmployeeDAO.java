package com.payroll.app.dao;

import com.payroll.app.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    Employee update(Long id, Employee employee);
    void deleteById(Long id);
    boolean existsById(Long id);
}