package com.example.Employee_Wage_Computation.repository;

import com.example.Employee_Wage_Computation.model.CompanyEmpWage;

public interface EmpWageRepository {
    void addCompany(CompanyEmpWage company);
    int getTotalWageByCompany(String companyName);
}
