package com.demo.springconcepts.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
  public String getData(){
    return "MyRepository is working!";
  }
}
