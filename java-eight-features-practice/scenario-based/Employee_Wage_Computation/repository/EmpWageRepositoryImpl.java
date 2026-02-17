package com.example.Employee_Wage_Computation.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.Employee_Wage_Computation.model.CompanyEmpWage;

public class EmpWageRepositoryImpl implements EmpWageRepository {

    private List<CompanyEmpWage> companyList = new ArrayList<>();

    public void addCompany(CompanyEmpWage company) {
        companyList.add(company);
    }

    public int getTotalWageByCompany(String companyName) {
        for (CompanyEmpWage company : companyList) {
            if (company.companyName.equals(companyName)) {
                return company.totalWage;
            }
        }
        return 0;
    }

    public List<CompanyEmpWage> getCompanies() {
        return companyList;
    }
}
