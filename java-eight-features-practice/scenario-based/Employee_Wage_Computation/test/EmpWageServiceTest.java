package com.example.Employee_Wage_Computation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.Employee_Wage_Computation.model.CompanyEmpWage;
import com.example.Employee_Wage_Computation.service.EmpWageServiceImpl;

public class EmpWageServiceTest {

    @Test
    public void testTotalWageIsCalculated() {
        CompanyEmpWage company = new CompanyEmpWage("Test", 20, 20, 100);
        EmpWageServiceImpl service = new EmpWageServiceImpl();
        service.computeEmpWage(company);
        assertTrue(company.totalWage > 0);
    }
}
