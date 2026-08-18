package com.demo.springconcepts.bean;

import org.springframework.stereotype.Component;

@Component
public class Department {

    public String getDepartmentName() {
        return "Computer Science";
    }
}