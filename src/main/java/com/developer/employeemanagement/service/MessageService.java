package com.developer.employeemanagement.service;

import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<MessageEntity> findAllMessage();
    Optional<MessageEntity> findById(Long id);
    MessageEntity saveMessage(MessageEntity messageEntity);
    MessageEntity updateMessage(MessageEntity messageEntity);
    public void saveMessage(MultipartFile picture, String message, LocalDateTime date, Long idReceiver, Long idSender) throws IOException;
    void deleteMessage(Long id);

    //    Using Request for Save and Update Employee
    MessageResponse saveMessage(MessageRequest messageRequest);
    MessageResponse updateMessage(MessageRequest messageRequest, Long id);


}
