package com.developer.employeemanagement.auth;

import com.developer.employeemanagement.auth.jwt.JwtUtils;
import com.developer.employeemanagement.dto.request.LoginRequest;
import com.developer.employeemanagement.entity.UserEntity;
import com.developer.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public AuthResponse login(LoginRequest loginRequest) {
        Optional<UserEntity> user = userRepository.findByUsername(loginRequest.getUsername());
        if (userRepository.findByUsername(loginRequest.getUsername()).isPresent()) {
            if (passwordEncoder.matches(loginRequest.getPassword(), userRepository.findByUsername(loginRequest.getUsername()).get().getPassword())) {
                return new AuthResponse(jwtUtils.generateJwtToken(userRepository.findByUsername(loginRequest.getUsername()).get()), userRepository.findByUsername(loginRequest.getUsername()).get(), null);
            }
        }
        AuthResponse authResponse = AuthResponse.builder().build();
        authResponse.setError("Invalid password or mail");
        return authResponse;
    }

    public AuthResponse signup(MultipartFile profilePicture, String username, String firstName, String lastName, String password
            , String role, String email, String domain) throws IOException {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setProfilePicture(profilePicture.getBytes());
        user.setDomain(domain);
        UserEntity savedUser = userRepository.save(user);
        return new AuthResponse(jwtUtils.generateJwtToken(savedUser), savedUser, null);


    }

}
