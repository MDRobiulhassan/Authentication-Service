package com.example.Authentication_Service.dto;

import lombok.Data;

@Data
public class SignupResponse {
    private Long userId;
    private String email;
    private String name;
    private String message;
}
