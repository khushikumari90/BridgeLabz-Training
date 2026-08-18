package com.greetingsapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import com.greetingsapp.entity.Greeting;
import com.greetingsapp.service.GreetingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

  private final GreetingService greetingService;

  public GreetingController(GreetingService greetingService){
    this.greetingService = greetingService;
  }

  @PostMapping
  public Greeting createGreeting(@Valid @RequestBody Greeting greeting){
    return greetingService.saveGreeting(greeting);
  }

  @GetMapping
  public List<Greeting> getAllGreeting(){
    return greetingService.getAllgreeting();
  }

  @GetMapping("/{id}")
  public Greeting getGreetingById(@PathVariable Long id) {
    return greetingService.getGreetingById(id);
  }

  @PutMapping("/{id}")
  public Greeting updateGreeting(@PathVariable Long id, @Valid @RequestBody Greeting greeting) {
    return greetingService.updateGreeting(id, greeting);
  }

  @DeleteMapping("/{id}")
  public String deleteGreeting(@PathVariable Long id) {
    greetingService.deleteGreeting(id);
    return "Greeting deleted successfully";
  }

  @GetMapping("/search")
  public List<Greeting> searchGreeting(@RequestParam String keyword) {
    return greetingService.searchGreetings(keyword);
  }
}
