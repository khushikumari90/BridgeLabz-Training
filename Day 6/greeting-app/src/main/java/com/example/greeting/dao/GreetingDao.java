package com.example.greeting.dao;

import com.example.greeting.model.Greeting;

import java.util.List;

public interface GreetingDao {

    void addGreeting(Greeting greeting);

    List<Greeting> getAllGreetings();

    Greeting getGreetingById(int id);

    void updateGreeting(Greeting greeting);

    void deleteGreeting(int id);
}
