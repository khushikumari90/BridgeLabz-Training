package com.greetingsapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.greetingsapp.entity.Greeting;
import com.greetingsapp.repository.GreetingRepository;

@Service
public class GreetingService {
  
  private final GreetingRepository greetingRepository;

  public GreetingService(GreetingRepository greetingRepository){
    this.greetingRepository = greetingRepository;
  }

  public Greeting saveGreeting(Greeting greeting){
    return greetingRepository.save(greeting);
  }

  public List<Greeting> getAllgreeting(){
    return greetingRepository.findAll();
  }

  public Greeting getGreetingById(Long id) {
    return greetingRepository.findById(id).orElse(null);
  }

  public Greeting updateGreeting(Long id, Greeting newGreeting) {

    return greetingRepository.findById(id)
            .map(greeting -> {
                greeting.setMessage(newGreeting.getMessage());
                return greetingRepository.save(greeting);
            })
            .orElse(null);
  }

  public void deleteGreeting(Long id) {
    greetingRepository.deleteById(id);
  }

  public List<Greeting> searchGreetings(String keyword) {
    return greetingRepository.searchByMessage(keyword);
  }

}
