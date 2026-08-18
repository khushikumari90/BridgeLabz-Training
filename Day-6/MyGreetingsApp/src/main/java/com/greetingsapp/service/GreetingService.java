package com.greetingsapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greetingsapp.model.Greeting;
import com.greetingsapp.repository.GreetingRepository;

@Service
public class GreetingService {
  
  private final GreetingRepository greetingRepository;

  public GreetingService(GreetingRepository greetingRepository){
    this.greetingRepository = greetingRepository;
  }

  public Greeting createGreeting(Greeting greeting) {
    return greetingRepository.save(greeting);
}

  public List<Greeting> getAllGreetings(){
    return greetingRepository.findAll();
  }

  public Greeting getGreetingById(Long id) {
    return greetingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Greeting not found"));
}

  public Greeting updateGreeting(Long id, Greeting greeting) {

    Greeting existing = getGreetingById(id);
    existing.setMessage(greeting.getMessage());
    return greetingRepository.save(existing);
}

  public void deleteGreeting(Long id) {
    greetingRepository.deleteById(id);
  }

}
