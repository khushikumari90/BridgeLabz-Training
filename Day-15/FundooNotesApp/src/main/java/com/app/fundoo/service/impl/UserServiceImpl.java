package com.app.fundoo.service.impl;

import com.app.fundoo.entity.User;
import com.app.fundoo.repository.UserRepository;
import com.app.fundoo.security.JwtUtil;
import com.app.fundoo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String register(String email, String password, String name) {
        if(userRepository.findByEmail(email).isPresent()){
            throw new IllegalArgumentException("Email already registered");
        }
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password)); //password hashing
        user.setName(name);

        User saved = userRepository.save(user);

        return jwtUtil.generateToken(String.valueOf(saved.getUserId()),saved.getEmail());
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(
                ()-> new IllegalArgumentException("Invalid email or password")
        );

        if(!passwordEncoder.matches(password,user.getPasswordHash())){
            throw new IllegalArgumentException("Invalid email or password");
        }

        return jwtUtil.generateToken(String.valueOf(user.getUserId()), user.getEmail());
    }
}
