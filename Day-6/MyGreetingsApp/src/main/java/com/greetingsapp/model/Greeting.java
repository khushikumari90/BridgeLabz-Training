package com.greetingsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Greeting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Message cannot be empty")
  private String message;

  public Greeting(){
  }

  public Greeting(String message){
    this.message = message;
  }

  public long getId(){
    return id;
  }
  public String getMessage(){
    return message;
  }
  public void setMessage(String message){
    this.message = message;
  }
}
