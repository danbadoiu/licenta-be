package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.entity.PatientFileEntity;
import com.developer.employeemanagement.service.PatientFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient-file")
@RequiredArgsConstructor
public class PatientFileController {

    private final PatientFileService patientFileService;

    // Get all patient files
    @GetMapping
    public List<PatientFileEntity> findAllPatientFiles() {
        return patientFileService.findAllPatientFiles();
    }

    // Get a patient file by ID
    @GetMapping("/{id}")
    public Optional<PatientFileEntity> findPatientFileById(@PathVariable("id") Long id) {
        return patientFileService.findById(id);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<PatientFileEntity> findPatientFileByIdUser(@PathVariable("idUser") Long id) {
        Optional<PatientFileEntity> patientFile = patientFileService.findByIdUser(id);
        return patientFile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Save a patient file (medical report is now optional)
    @PostMapping("/upload")
    public void savePatientFile(
            @RequestParam("idUser") Long idUser,
            @RequestParam("fullName") String fullName,
            @RequestParam("birthDate") String birthDate,
            @RequestParam("gender") String gender,
            @RequestParam("bloodType") String bloodType,
            @RequestParam("allergies") String allergies,
            @RequestParam("chronicDiseases") String chronicDiseases,
            @RequestParam("currentMedications") String currentMedications,
            @RequestParam("emergencyContact") String emergencyContact,
            @RequestParam("date") String date

    ) throws IOException {
        patientFileService.savePatientFile(idUser, fullName, birthDate, gender, bloodType, allergies,
                chronicDiseases, currentMedications, emergencyContact, date);
    }

    // Update a patient file (medical report is also optional)
    @PutMapping("/{id}")
    public void updatePatientFile(
            @PathVariable("id") Long id,
            @RequestParam("idUser") Long idUser,
            @RequestParam("fullName") String fullName,
            @RequestParam("birthDate") String birthDate,
            @RequestParam("gender") String gender,
            @RequestParam("bloodType") String bloodType,
            @RequestParam("allergies") String allergies,
            @RequestParam("chronicDiseases") String chronicDiseases,
            @RequestParam("currentMedications") String currentMedications,
            @RequestParam("emergencyContact") String emergencyContact,
            @RequestParam("date") String date
    ) throws IOException, ParseException {
        patientFileService.updatePatientFile(id, idUser, fullName, birthDate, gender, bloodType, allergies,
                chronicDiseases, currentMedications, emergencyContact, date);
    }

    // Delete a patient file by ID
    @DeleteMapping("/{id}")
    public void deletePatientFile(@PathVariable("id") Long id) {
        patientFileService.deletePatientFile(id);
    }
}
