package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.repository.MedicineRepository;
import com.developer.employeemanagement.repository.MessageRepository;
import com.developer.employeemanagement.service.MedicineService;
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
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;
    private final MedicineRepository medicineRepository;

    @GetMapping
    public List<MedicineEntity> findAllMedicine() {
        return medicineService.findAllMedicine();
    }

    @GetMapping("/{id}")
    public Optional<MedicineEntity> findMedicineById(@PathVariable("id") Long id) {
        return medicineService.findById(id);
    }

    @PostMapping
//    public MessageEntity saveMessage(@RequestBody MessageEntity messageEntity) {
//        return messageService.saveMessage(messageEntity);
//    }
    public void saveMedicine(
            @RequestBody(required = false) MultipartFile image, String name, String description, Long idReceiver
    ) throws IOException, ParseException {


        this.medicineService.saveMedicine(image, name, description, idReceiver);
    }
    @PutMapping
    public MedicineEntity updateMedicine(@RequestBody MedicineEntity userEntity) {
        return medicineService.updateMedicine(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable("id") Long id) {
        medicineService.deleteMedicine(id);
    }

//    Using Request and Response with save and update employee





}
