package com.app.fundoo.controller;

import com.app.fundoo.dto.AuthResponse;
import com.app.fundoo.dto.LoginRequest;
import com.app.fundoo.dto.RegisterRequest;
import com.app.fundoo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        String token = userService.register(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        String token = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}

