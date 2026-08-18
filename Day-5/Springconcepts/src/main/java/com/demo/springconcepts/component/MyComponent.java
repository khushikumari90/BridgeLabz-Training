package com.demo.springconcepts.component;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
  public String message(){
    return "My Component is working!";
  }
}
