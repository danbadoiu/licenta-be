package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.entity.FavoriteDoctorsEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.repository.MessageRepository;
import com.developer.employeemanagement.service.FavoriteDoctorsService;
import com.developer.employeemanagement.service.MessageService;
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
@RequestMapping("/favorite_doctors")
@RequiredArgsConstructor
public class FavoriteDoctorsController {

    private final FavoriteDoctorsService favoriteDoctorsService;

    @GetMapping
    public List<FavoriteDoctorsEntity> findAllFavoriteDoctors() {
        return favoriteDoctorsService.findAllFavoriteDoctors();
    }

    @GetMapping("/{id}")
    public Optional<FavoriteDoctorsEntity> findFavoriteDoctorsById(@PathVariable("id") Long id) {
        return favoriteDoctorsService.findById(id);
    }

    @PostMapping
//    public MessageEntity saveMessage(@RequestBody MessageEntity messageEntity) {
//        return messageService.saveMessage(messageEntity);
//    }
    public void saveMessage(
             Long idPatient, String doctors
    ) throws IOException, ParseException {


        this.favoriteDoctorsService.saveFavoriteDoctors(idPatient, doctors);
    }
    @PutMapping("/{id}")
    public void updateFavoriteDoctors(
            @PathVariable("id") Long id, Long idPatient,String doctors
    ) throws IOException, ParseException {


        this.favoriteDoctorsService.updateFavoriteDoctors(id,idPatient, doctors);
    }


    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long id) {
        favoriteDoctorsService.deleteFavoriteDoctors(id);
    }



}
