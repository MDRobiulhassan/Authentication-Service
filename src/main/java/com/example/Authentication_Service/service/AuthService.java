package com.example.Authentication_Service.service;

import com.example.Authentication_Service.dto.LoginRequest;
import com.example.Authentication_Service.dto.LoginResponse;
import com.example.Authentication_Service.dto.SignupRequest;

public interface AuthService {
    void signup(SignupRequest request);
    LoginResponse login(LoginRequest request);
}
