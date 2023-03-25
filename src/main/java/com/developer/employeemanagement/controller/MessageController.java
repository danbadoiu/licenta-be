package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.repository.MessageRepository;
import com.developer.employeemanagement.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final MessageRepository messageRepository;

    @GetMapping
    public List<MessageEntity> findAllMessage() {
        return messageService.findAllMessage();
    }

    @GetMapping("/{id}")
    public Optional<MessageEntity> findMessageById(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }

    @PostMapping
//    public MessageEntity saveMessage(@RequestBody MessageEntity messageEntity) {
//        return messageService.saveMessage(messageEntity);
//    }
    public void saveMessage(
            MultipartFile picture, String message, String date, Long idSender, Long idReceiver
    ) throws IOException, ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        this.messageService.saveMessage(picture, message, dateTime, idSender, idReceiver);
    }
    @PutMapping
    public MessageEntity updateMessage(@RequestBody MessageEntity userEntity) {
        return messageService.updateMessage(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long id) {
        messageService.deleteMessage(id);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public MessageResponse saveMessageResponse(@RequestBody MessageRequest messageRequest) {
        return messageService.saveMessage(messageRequest);
    }

    @PutMapping("/res/{id}")
    public MessageResponse updateMessageResponse(@RequestBody MessageRequest messageRequest, @PathVariable("id") Long id) {
        return messageService.updateMessage(messageRequest, id);
    }



}
