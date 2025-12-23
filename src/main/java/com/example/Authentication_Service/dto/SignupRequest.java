package com.example.Authentication_Service.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
}