package com.payroll.app.service;

import com.payroll.app.entity.Employee;
import com.payroll.app.exception.EmployeeNotFoundException;
import com.payroll.app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> searchByName(String name){
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    @Override
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Employee not found with id: {}", id);
                    return new EmployeeNotFoundException(id);
                });
    }

    @Override
    public Employee createEmployee(Employee employee) {
        log.info("Creating employee: {}", employee.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        log.info("Updating employee with id: {}", id);

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Cannot update — employee not found with id: {}", id);
                    return new EmployeeNotFoundException(id);
                });

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id: {}", id);
        if (!employeeRepository.existsById(id)) {
            log.warn("Cannot delete — employee not found with id: {}", id);
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        log.info("Employee deleted with id: {}", id);
    }
}