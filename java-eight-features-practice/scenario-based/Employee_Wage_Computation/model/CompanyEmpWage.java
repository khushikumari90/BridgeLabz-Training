package com.example.Employee_Wage_Computation.model;
import java.util.ArrayList;
import java.util.List;

public class CompanyEmpWage {

    public String companyName;
    public int wagePerHour;
    public int workingDays;
    public int maxHours;
    public int totalWage;

    public List<DailyWage> dailyWages = new ArrayList<>();

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
    }
}
