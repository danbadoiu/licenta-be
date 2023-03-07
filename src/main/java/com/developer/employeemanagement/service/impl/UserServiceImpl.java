package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.dto.mapper.EmployeeMapper;
import com.developer.employeemanagement.dto.mapper.UserMapper;
import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.UserEntity;

import com.developer.employeemanagement.repository.UserRepository;
import com.developer.employeemanagement.service.EmployeeService;
import com.developer.employeemanagement.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
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
            , String role, String email) throws IOException {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
        user.setProfilePicture(profilePicture.getBytes());
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

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.MAPPER.fromRequestToEntity(userRequest);
        userRepository.save(userEntity);
        return UserMapper.MAPPER.fromEntityToResponse(userEntity);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id) {

        Optional<UserEntity> checkExistingUser = findById(id);
        if (! checkExistingUser.isPresent())
            throw new RuntimeException("User Id "+ id + " Not Found!");

        UserEntity userEntity = UserMapper.MAPPER.fromRequestToEntity(userRequest);
        userEntity.setId(id);
        userRepository.save(userEntity);
        return UserMapper.MAPPER.fromEntityToResponse(userEntity);
    }

}
