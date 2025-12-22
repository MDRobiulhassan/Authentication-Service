package com.example.Authentication_Service.serviceimpl;

import com.example.Authentication_Service.dto.LoginRequest;
import com.example.Authentication_Service.dto.LoginResponse;
import com.example.Authentication_Service.dto.SignupRequest;
import com.example.Authentication_Service.dto.SignupResponse;
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
    public SignupResponse signup(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        SignupResponse signupResponse = new SignupResponse();
        signupResponse.setEmail(request.getEmail());
        signupResponse.setName(request.getName());
        signupResponse.setMessage("Signup Successful");
        return signupResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setEmail(user.getEmail());
        response.setMessage("Login successful");

        return response;
    }
}