package com.developer.employeemanagement.service;


import com.developer.employeemanagement.entity.PatientFileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PatientFileService {

    List<PatientFileEntity> findAllPatientFiles();
    Optional<PatientFileEntity> findById(Long id);
    Optional<PatientFileEntity> findByIdUser(Long idUser);

    PatientFileEntity savePatientFile(PatientFileEntity patientFileEntity);
    PatientFileEntity updatePatientFile(PatientFileEntity patientFileEntity);
    void updatePatientFile(Long id,Long idUser, String fullName, String birthDate,
                           String gender, String bloodType, String allergies, String chronicDiseases,
                           String currentMedications, String emergencyContact, String date) throws IOException;

    void savePatientFile(Long idUser, String fullName, String birthDate,
                         String gender, String bloodType, String allergies, String chronicDiseases,
                         String currentMedications, String emergencyContact, String date) throws IOException;

    void deletePatientFile(Long id);

}

