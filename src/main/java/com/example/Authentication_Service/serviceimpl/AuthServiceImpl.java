package com.example.Authentication_Service.serviceimpl;

import com.example.Authentication_Service.dto.LoginRequest;
import com.example.Authentication_Service.dto.LoginResponse;
import com.example.Authentication_Service.dto.SignupRequest;
import com.example.Authentication_Service.entity.User;
import com.example.Authentication_Service.repository.UserRepository;
import com.example.Authentication_Service.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signup(SignupRequest request) {
        if (userRepository.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.email);
        user.setName(request.name);
        user.setPassword(request.password);

        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getPassword().equals(request.password)) {
            throw new RuntimeException("Invalid credentials");
        }

        LoginResponse response = new LoginResponse();
        response.userId = user.getId();
        response.email = user.getEmail();
        response.message = "Login successful";

        return response;
    }
}