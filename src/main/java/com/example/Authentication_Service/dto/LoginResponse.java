package com.example.Authentication_Service.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private Long userId;
    private String email;
    private String message;
}