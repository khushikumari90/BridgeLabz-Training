package com.payroll.app.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService {

    public String isRunning(){
        return "App bootstrapped & is running successfully!";
    }
}
