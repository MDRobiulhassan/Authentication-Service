package com.example.Authentication_Service.service;

import com.example.Authentication_Service.dto.LoginRequest;
import com.example.Authentication_Service.dto.LoginResponse;
import com.example.Authentication_Service.dto.SignupRequest;
import com.example.Authentication_Service.dto.SignupResponse;

public interface AuthenticationService {
    SignupResponse signup(SignupRequest request);
    LoginResponse login(LoginRequest request);
}
