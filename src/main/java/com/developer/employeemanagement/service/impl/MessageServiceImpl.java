package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.dto.mapper.EmployeeMapper;
import com.developer.employeemanagement.dto.mapper.MessageMapper;
import com.developer.employeemanagement.dto.mapper.UserMapper;
import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.entity.UserEntity;

import com.developer.employeemanagement.repository.MessageRepository;
import com.developer.employeemanagement.repository.UserRepository;
import com.developer.employeemanagement.service.EmployeeService;
import com.developer.employeemanagement.service.MessageService;
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
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageEntity> findAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<MessageEntity> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public MessageEntity saveMessage(MessageEntity messageEntity) {
        return messageRepository.save(messageEntity);
    }
//    @Override
//    public void saveMessage(MultipartFile profilePicture, String username, String firstName, String lastName, String password
//            , String role, String email) throws IOException {
////        UserEntity user = new UserEntity();
////        user.setEmail(email);
////        user.setUsername(username);
////        user.setFirstName(firstName);
////        user.setLastName(lastName);
////        user.setPassword(password);
////        user.setRole(role);
////        user.setProfilePicture(profilePicture.getBytes());
//        messageRepository.save(user);
//    }

    @Override
    public MessageEntity updateMessage(MessageEntity messageEntity) {
        return messageRepository.save(messageEntity);
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public MessageResponse saveMessage(MessageRequest messageRequest) {
        return null;
    }

    @Override
    public MessageResponse updateMessage(MessageRequest messageRequest, Long id) {
        return null;
    }

//    Using Request and Response with save and update employee

//    @Override
//    public MessageResponse saveMessage(UserRequest messageRequest) {
//        MessageEntity messageEntity = MessageMapper.MAPPER.fromRequestToEntity(messageRequest);
//        messageRepository.save(messageEntity);
//        return MessageMapper.MAPPER.fromEntityToResponse(messageEntity);
//    }

//    @Override
//    public MessageResponse updateMessage(MessageRequest messageRequest, Long id) {
//
//        Optional<MessageEntity> checkExistingMessage = findById(id);
//        if (! checkExistingMessage.isPresent())
//            throw new RuntimeException("Message Id "+ id + " Not Found!");
//
//        MessageEntity messageEntity = MessageMapper.MAPPER.fromRequestToEntity(messageRequest);
//        messageEntity.setId(id);
//        messageRepository.save(messageEntity);
//        return MessageMapper.MAPPER.fromEntityToResponse(messageEntity);
//    }

}
