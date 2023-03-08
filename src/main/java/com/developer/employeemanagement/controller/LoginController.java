//package com.developer.employeemanagement.controller;
//
//import com.developer.employeemanagement.dto.request.UserRequest;
//import com.developer.employeemanagement.dto.response.LoginResponse;
//import com.developer.employeemanagement.entity.UserDetails;
//import com.developer.employeemanagement.entity.UserEntity;
//import com.developer.employeemanagement.repository.UserRepository;
//import io.jsonwebtoken.Jwts;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.Date;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/login")
//public class LoginController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody UserRequest loginRequest) {
//        UserEntity user = userRepository.findByUsername(loginRequest.getUsername());
//
//        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        String accessToken = generateAccessToken(user);
//        String refreshToken = generateRefreshToken(user);
//        long expiresIn = 3600;
////        String role = user.getRole().toString();
//        String role = "";
//
//        LoginResponse loginResponse = new LoginResponse(accessToken, refreshToken, expiresIn,
//                new UserDetails(user.getId(), user.getUsername(), role));
//
//        return ResponseEntity.ok(loginResponse);
//    }
//
//    private String generateAccessToken(UserEntity user) {
//        String secretKey = "mySecretKey"; // replace with your own secret key
//        long expiresIn = 3600; // token expiry time in seconds
//
//
//        String accessToken = Jwts.builder()
//                .setSubject(user.getUsername()) // set the subject of the token to the username
//                .setExpiration(new Date(System.currentTimeMillis() + expiresIn * 1000)) // set the expiry time
////                .signWith(SignatureAlgorithm.HS512, secretKey) // sign the token with the secret key
//                .compact();
//
//        return accessToken;
//    }
//
//    private String generateRefreshToken(UserEntity user) {
//        // TODO: Implement refresh token generation logic
//        return null;
//    }
//}
