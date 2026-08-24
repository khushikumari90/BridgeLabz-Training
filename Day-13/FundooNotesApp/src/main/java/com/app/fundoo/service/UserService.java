package com.app.fundoo.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService{
    String register(String email, String password, String name);
    String login(String email, String password);
}
