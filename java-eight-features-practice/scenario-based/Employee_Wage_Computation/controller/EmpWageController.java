package com.example.Employee_Wage_Computation.controller;

import com.example.Employee_Wage_Computation.model.CompanyEmpWage;
import com.example.Employee_Wage_Computation.repository.EmpWageRepositoryImpl;
import com.example.Employee_Wage_Computation.service.EmpWageServiceImpl;

public class EmpWageController {

    public void start() {
        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageRepositoryImpl repo = new EmpWageRepositoryImpl();
        EmpWageServiceImpl service = new EmpWageServiceImpl();

        CompanyEmpWage tcs = new CompanyEmpWage("TCS", 20, 20, 100);
        CompanyEmpWage infosys = new CompanyEmpWage("Infosys", 25, 22, 110);

        service.computeEmpWage(tcs);
        service.computeEmpWage(infosys);

        repo.addCompany(tcs);
        repo.addCompany(infosys);

        System.out.println("TCS Total Wage: " + repo.getTotalWageByCompany("TCS"));
        System.out.println("Infosys Total Wage: " + repo.getTotalWageByCompany("Infosys"));
    }
}
