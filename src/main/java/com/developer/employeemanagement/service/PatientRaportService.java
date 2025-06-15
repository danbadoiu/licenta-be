package com.developer.employeemanagement.service;

import com.developer.employeemanagement.entity.PatientRaportEntity;
import com.developer.employeemanagement.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PatientRaportService {
    List<PatientRaportEntity> findAllPatientRaport();
    Optional<PatientRaportEntity> findById(Long id);
    PatientRaportEntity updatePatientRaport(UserEntity userEntity);
    void savePatientRaport(Long idUser, String raport) throws IOException;
    void updatePatientRaport(Long id, Long idUser, String raport) throws IOException;
    void deletePatientRaport(Long id);
}
