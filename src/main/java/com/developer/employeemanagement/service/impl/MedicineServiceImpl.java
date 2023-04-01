package com.developer.employeemanagement.service.impl;


import com.developer.employeemanagement.dto.mapper.EmployeeMapper;
import com.developer.employeemanagement.dto.mapper.MessageMapper;
import com.developer.employeemanagement.dto.mapper.UserMapper;
import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.MedicineRequest;
import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.MedicineResponse;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.entity.UserEntity;

import com.developer.employeemanagement.repository.MedicineRepository;
import com.developer.employeemanagement.repository.MessageRepository;
import com.developer.employeemanagement.repository.UserRepository;
import com.developer.employeemanagement.service.EmployeeService;
import com.developer.employeemanagement.service.MedicineService;
import com.developer.employeemanagement.service.MessageService;
import com.developer.employeemanagement.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public List<MedicineEntity> findAllMedicine() {
        return medicineRepository.findAll();
    }

    @Override
    public Optional<MedicineEntity> findById(Long id) {
        return medicineRepository.findById(id);
    }

    @Override
    public MedicineEntity saveMedicine(MedicineEntity medicineEntity) {
        return medicineRepository.save(medicineEntity);
    }

    @Override
    public void saveMedicine(MultipartFile image, String name, String description, Long idReceiver) throws IOException {
        MedicineEntity medicineEntity = new MedicineEntity();
        medicineEntity.setDescription(description);
        medicineEntity.setIdReceiver(idReceiver);
        medicineEntity.setName(name);
        if(!(image ==null)){
            medicineEntity.setImage(image.getBytes());
        }

        medicineRepository.save(medicineEntity);
    }

    @Override
    public MedicineEntity updateMedicine(MedicineEntity medicineEntity) {
        return medicineRepository.save(medicineEntity);
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
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
