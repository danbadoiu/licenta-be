package com.developer.employeemanagement.dto.response;

import com.developer.employeemanagement.entity.UserDetails;

public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private long expiresIn;

    public LoginResponse(String accessToken, String refreshToken, long expiresIn, UserDetails userDetails) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.userDetails = userDetails;
    }

    private UserDetails userDetails;
}
