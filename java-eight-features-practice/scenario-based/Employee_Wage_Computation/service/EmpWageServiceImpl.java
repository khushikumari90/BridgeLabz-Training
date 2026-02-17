package com.example.Employee_Wage_Computation.service;

import com.example.Employee_Wage_Computation.model.CompanyEmpWage;
import com.example.Employee_Wage_Computation.model.DailyWage;

public class EmpWageServiceImpl implements EmpWageService {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    public void computeEmpWage(CompanyEmpWage company) {

        int totalHours = 0;
        int day = 0;

        while (day < company.workingDays && totalHours < company.maxHours) {
            day++;
            int empHours = 0;
            int attendance = (int) (Math.random() * 3);

            switch (attendance) {
                case IS_FULL_TIME:
                    empHours = 8;
                    break;
                case IS_PART_TIME:
                    empHours = 4;
                    break;
                default:
                    empHours = 0;
            }

            totalHours += empHours;
            int dailyWage = empHours * company.wagePerHour;
            company.dailyWages.add(new DailyWage(day, dailyWage));
            company.totalWage += dailyWage;
        }
    }
}
