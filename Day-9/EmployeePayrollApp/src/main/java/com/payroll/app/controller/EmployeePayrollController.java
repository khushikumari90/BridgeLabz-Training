package com.payroll.app.controller;

import com.payroll.app.EmployeePayrollAppApplication;
import com.payroll.app.service.EmployeePayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class EmployeePayrollController {
    private final EmployeePayrollService employeePayrollService;

    @GetMapping
    public String isRunning(){
        return employeePayrollService.isRunning();
    }
}
