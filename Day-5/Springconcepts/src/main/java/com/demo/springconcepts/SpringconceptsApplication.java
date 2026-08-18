package com.demo.springconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.springconcepts.bean.Employee;

@SpringBootApplication
public class SpringconceptsApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringconceptsApplication.class, args);

        Employee employee = context.getBean(Employee.class);

        employee.displayEmployee();
    }
}
