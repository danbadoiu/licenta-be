package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.entity.AppointmentEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.repository.MedicineRepository;
import com.developer.employeemanagement.service.AppointmentService;
import com.developer.employeemanagement.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;


    @GetMapping
    public List<AppointmentEntity> findAllAppointment() {
        return appointmentService.findAllAppointment();
    }

    @GetMapping("/{id}")
    public Optional<AppointmentEntity> findAppointmentById(@PathVariable("id") Long id) {
        return appointmentService.findById(id);
    }

    @PostMapping
//    public MessageEntity saveMessage(@RequestBody MessageEntity messageEntity) {
//        return messageService.saveMessage(messageEntity);
//    }
    public void saveAppointment(
            Long idUser, Long idDoctor, Long idMarker, String date, String status
    ) throws IOException, ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        this.appointmentService.saveAppointment(idUser, idDoctor, idMarker, dateTime,status);
    }
    @PutMapping("/{id}")
    public void updateAppointment(
            @PathVariable("id") Long id, Long idUser, Long idDoctor, Long idMarker, String date, String status
    ) throws IOException, ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        this.appointmentService.updateAppointment(id,idUser, idDoctor, idMarker, dateTime,status);
    }
    @PutMapping
    public AppointmentEntity updateAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        return appointmentService.updateAppointment(appointmentEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
    }

//    Using Request and Response with save and update employee





}
