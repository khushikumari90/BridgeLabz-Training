package com.demo.springconcepts.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

  private static final Logger logger = LoggerFactory.getLogger(Employee.class);

  @Autowired
  private Department department;

  public void displayEmployee() {
    
    logger.info("Employee method started");

    System.out.println("Employee belongs to: "+ department.getDepartmentName());
    
    logger.info("Employee method completed");
  }
}
