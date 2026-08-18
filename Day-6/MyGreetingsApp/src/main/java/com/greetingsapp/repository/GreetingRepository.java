package com.greetingsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greetingsapp.model.Greeting;

import java.util.List;

public interface GreetingRepository extends JpaRepository<Greeting, Long>{
  @Query("SELECT g FROM Greeting g WHERE g.message LIKE %:keyword%")
  List<Greeting> searchByMessage(String keyword);
}
