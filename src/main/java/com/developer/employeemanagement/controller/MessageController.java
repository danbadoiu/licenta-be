package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.entity.UserEntity;
import com.developer.employeemanagement.service.MessageService;
import com.developer.employeemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<MessageEntity> findAllMessage() {
        return messageService.findAllMessage();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Optional<MessageEntity> findMessageById(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public MessageEntity saveMessage(@RequestBody MessageEntity messageEntity) {
        return messageService.saveMessage(messageEntity);
    }
//    public void saveMessage(
//            MultipartFile profilePicture, String username, String firstName, String lastName, String password, String role, String email
//    ) throws IOException {
//        this.messageService.saveMessage(profilePicture, username, firstName, lastName, password, role, email);
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public MessageEntity updateMessage(@RequestBody MessageEntity userEntity) {
        return messageService.updateMessage(userEntity);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long id) {
        messageService.deleteMessage(id);
    }

//    Using Request and Response with save and update employee

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/res")
    public MessageResponse saveMessageResponse(@RequestBody MessageRequest messageRequest) {
        return messageService.saveMessage(messageRequest);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/res/{id}")
    public MessageResponse updateMessageResponse(@RequestBody MessageRequest messageRequest, @PathVariable("id") Long id) {
        return messageService.updateMessage(messageRequest, id);
    }

}
