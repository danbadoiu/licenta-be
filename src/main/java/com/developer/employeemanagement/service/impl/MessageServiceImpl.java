package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.entity.MessageEntity;

import com.developer.employeemanagement.repository.MessageRepository;
import com.developer.employeemanagement.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
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

    @Override
    public void saveMessage(MultipartFile picture, String message, LocalDateTime date, Long idReceiver, Long idSender) throws IOException {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(message);
        messageEntity.setDate(date);
        messageEntity.setIdReceiver(idReceiver);
        messageEntity.setIdSender(idSender);
        if(!(picture ==null)){
            messageEntity.setPicture(picture.getBytes());
        }

        messageRepository.save(messageEntity);
    }

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
