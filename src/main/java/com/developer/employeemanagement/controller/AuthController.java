package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.auth.AuthResponse;
import com.developer.employeemanagement.auth.AuthService;
import com.developer.employeemanagement.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/signup")
    public AuthResponse saveUser(
            MultipartFile profilePicture, String username, String firstName, String lastName, String password, String role, String email
    ) throws IOException {
        return this.authService.signup(profilePicture, username, firstName, lastName, password, role, email);
    }

    @PostMapping(value = "/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return this.authService.login(loginRequest);
    }
}
