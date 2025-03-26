package com.developer.employeemanagement.service.impl;


import com.developer.employeemanagement.entity.PatientFileEntity;
import com.developer.employeemanagement.entity.PollEntity;
import com.developer.employeemanagement.repository.PatientFileRepository;
import com.developer.employeemanagement.service.PatientFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientFileServiceImpl implements PatientFileService {

    private final PatientFileRepository patientFileRepository;

    public PatientFileServiceImpl(PatientFileRepository patientFileRepository) {
        this.patientFileRepository = patientFileRepository;
    }

    @Override
    public List<PatientFileEntity> findAllPatientFiles() {
        return patientFileRepository.findAll();
    }

    @Override
    public Optional<PatientFileEntity> findById(Long id) {
        return patientFileRepository.findById(id);
    }
    @Override
    public Optional<PatientFileEntity> findByIdUser(Long id) {
        return patientFileRepository.findByIdUser(id);  // Use the repository method
    }

    @Override
    public PatientFileEntity savePatientFile(PatientFileEntity patientFileEntity) {
        return patientFileRepository.save(patientFileEntity);
    }

    @Override
    public void savePatientFile(Long idUser, String fullName, String birthDate,
                                String gender, String bloodType, String allergies,
                                String chronicDiseases, String currentMedications,
                                String emergencyContact, String date) throws IOException {

        PatientFileEntity patientFile = new PatientFileEntity();
        patientFile.setIdUser(idUser);
        patientFile.setFullName(fullName);
        patientFile.setBirthDate(birthDate);
        patientFile.setGender(gender);
        patientFile.setBloodType(bloodType);
        patientFile.setAllergies(allergies);
        patientFile.setChronicDiseases(chronicDiseases);
        patientFile.setCurrentMedications(currentMedications);
        patientFile.setEmergencyContact(emergencyContact);
        patientFile.setDate(date);




        patientFileRepository.save(patientFile);
    }

    @Override
    public PatientFileEntity updatePatientFile(PatientFileEntity patientFileEntity) {
        return patientFileRepository.save(patientFileEntity);
    }
    @Override
    public void updatePatientFile(Long id,Long idUser, String fullName, String birthDate,
                                  String gender, String bloodType, String allergies,
                                  String chronicDiseases, String currentMedications,
                                  String emergencyContact, String date) throws IOException {
        Optional<PatientFileEntity> existingPatientOpt = patientFileRepository.findById(id);



        PatientFileEntity existingPatient = existingPatientOpt.get();
        existingPatient.setFullName(fullName);
        existingPatient.setBirthDate(birthDate);
        existingPatient.setGender(gender);
        existingPatient.setBloodType(bloodType);
        existingPatient.setAllergies(allergies);
        existingPatient.setChronicDiseases(chronicDiseases);
        existingPatient.setCurrentMedications(currentMedications);
        existingPatient.setEmergencyContact(emergencyContact);
        existingPatient.setDate(date);

     patientFileRepository.save(existingPatient);

    }

    @Override
    public void deletePatientFile(Long id) {
        patientFileRepository.deleteById(id);
    }



}
