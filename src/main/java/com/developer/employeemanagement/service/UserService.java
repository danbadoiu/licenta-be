package com.developer.employeemanagement.service;

import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    Optional<UserEntity> findById(Long id);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    void saveUser(MultipartFile profilePicture, String username, String firstName, String lastName, String password
            , String role, String email, String domain) throws IOException;
    void deleteUser(Long id);

    //    Using Request for Save and Update Employee
    UserResponse saveUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest, Long id);


}
