package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.UserEntity;
import com.developer.employeemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> findAllUser() {
        return userService.findAllUser();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Optional<UserEntity> findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
//    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
//        return userService.saveUser(userEntity);
//    }
    public void saveUser(MultipartFile profilePicture, String username, String firstName, String lastName, String password
    , String role, String email) throws IOException {
this.userService.saveUser(profilePicture, username, firstName, lastName, password, role, email);

    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public UserResponse saveUserResponse(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @PutMapping("/res/{id}")
    public UserResponse updateUserResponse(@RequestBody UserRequest userRequest, @PathVariable("id") Long id) {
        return userService.updateUser(userRequest, id);
    }

}
