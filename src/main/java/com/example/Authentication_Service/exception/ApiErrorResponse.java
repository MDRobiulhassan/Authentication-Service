package com.example.Authentication_Service.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErrorResponse {

    @JsonFormat(pattern = "dd-MM-yyyy HH-mm-ss ")
    private LocalDateTime timestamp;

    private int status;
    private String message;

    public ApiErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponse(int status, String message) {
        this();
        this.status = status;
        this.message = message;
    }
}

