package com.demo.springconcepts.service;

import org.springframework.stereotype.Service;
import com.demo.springconcepts.repository.MyRepository;

@Service
public class MyService {

  private final MyRepository myRepository;

  public MyService(MyRepository myRepository) {
    this.myRepository = myRepository;
  }

  public String getMessage() {
    return myRepository.getData();
  }
}
