package com.developer.employeemanagement.service;

import com.developer.employeemanagement.entity.AppointmentEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface AppointmentService {
    List<AppointmentEntity> findAllAppointment();
    Optional<AppointmentEntity> findById(Long id);
    AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);
    AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity);
    public void saveAppointment(Long idUser, Long idDoctor, Long idMarker, LocalDateTime date) throws IOException;
    void deleteAppointment(Long id);




}