package com.developer.employeemanagement.service.impl;


import com.developer.employeemanagement.entity.MedicineEntity;

import com.developer.employeemanagement.repository.MedicineRepository;
import com.developer.employeemanagement.service.MedicineService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
