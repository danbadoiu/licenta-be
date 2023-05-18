package com.developer.employeemanagement.service.impl;


import com.developer.employeemanagement.entity.UserEntity;

import com.developer.employeemanagement.repository.UserRepository;
import com.developer.employeemanagement.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
    @Override
    public void saveUser(MultipartFile profilePicture, String username, String firstName, String lastName, String password
            , String role, String email, String domain) throws IOException {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
        user.setProfilePicture(profilePicture.getBytes());
        user.setDomain(domain);
        userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    Using Request and Response with save and update employee



}
