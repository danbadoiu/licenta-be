package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.entity.PatientRaportEntity;
import com.developer.employeemanagement.entity.PollEntity;
import com.developer.employeemanagement.entity.UserEntity;
import com.developer.employeemanagement.repository.PatientRaportRepository;
import com.developer.employeemanagement.repository.PollRepository;
import com.developer.employeemanagement.service.PatientRaportService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientRaportServiceImpl implements PatientRaportService {
    private final PatientRaportRepository patientRaportRepository;

    public PatientRaportServiceImpl(PatientRaportRepository patientRaportRepository) {
        this.patientRaportRepository = patientRaportRepository;
    }
    @Override
    public List<PatientRaportEntity> findAllPatientRaport() {
        return patientRaportRepository.findAll();
    }

    @Override
    public Optional<PatientRaportEntity> findById(Long id) {
        return patientRaportRepository.findById(id);
    }

    @Override
    public PatientRaportEntity updatePatientRaport(UserEntity userEntity) {
        return null;
    }

    @Override
    public void savePatientRaport(Long idUser, String raport) throws IOException {
        PatientRaportEntity patientRaportEntity = new PatientRaportEntity();
        patientRaportEntity.setIdUser(idUser);
        patientRaportEntity.setRaport(raport);
        patientRaportRepository.save(patientRaportEntity);
    }

    @Override
    public void updatePatientRaport(Long id, Long idUser, String raport) throws IOException {

    }



    @Override
    public void deletePatientRaport(Long id) {

    }
}
