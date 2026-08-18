package com.demo.springconcepts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springconcepts.service.MyService;


@Controller
public class MyController {
  private final MyService myService;

  public MyController(MyService myService) {
      this.myService = myService;
  }

  @GetMapping("/test")
  @ResponseBody
  public String test() {
      return myService.getMessage();
  }

  
  
}
