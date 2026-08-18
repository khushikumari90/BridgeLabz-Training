package com.payroll.app.service;

import com.payroll.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> searchByName(String name);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}