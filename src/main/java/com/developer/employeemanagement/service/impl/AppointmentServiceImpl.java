package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.entity.AppointmentEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.repository.AppointmentRepository;
import com.developer.employeemanagement.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentEntity> findAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<AppointmentEntity> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity) {
        return appointmentRepository.save(appointmentEntity);
    }

    @Override
    public AppointmentEntity updateAppointment(AppointmentEntity appointmentEntity) {
        return null;
    }

    @Override
    public void saveAppointment(Long idUser, Long idDoctor, Long idMarker, LocalDateTime date, String status) throws IOException {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setDate(date);
        appointmentEntity.setIdDoctor(idDoctor);
        appointmentEntity.setIdMarker(idMarker);
        appointmentEntity.setIdUser(idUser);
        appointmentEntity.setStatus(status);
        appointmentRepository.save(appointmentEntity);
    }
    @Override
    public void updateAppointment(Long id, Long idUser, Long idDoctor, Long idMarker, LocalDateTime date, String status) throws IOException {
        Optional<AppointmentEntity> optionalAppointmentEntity = appointmentRepository.findById(id);
        if (optionalAppointmentEntity.isPresent()) {
            AppointmentEntity appointmentEntity = optionalAppointmentEntity.get();
            appointmentEntity.setDate(date);
            appointmentEntity.setIdDoctor(idDoctor);
            appointmentEntity.setIdMarker(idMarker);
            appointmentEntity.setIdUser(idUser);
            appointmentEntity.setStatus(status);
            appointmentRepository.save(appointmentEntity);
        } else {
            throw new IllegalArgumentException("Appointment with id " + id + " not found");
        }
    }



    @Override
    public void deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
    }
}
