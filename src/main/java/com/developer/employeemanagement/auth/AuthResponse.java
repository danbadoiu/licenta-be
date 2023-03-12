package com.developer.employeemanagement.auth;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@Data
public class AuthResponse {
    private String token;
    private UserDetails userDetails;
    private String error;

}
