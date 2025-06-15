package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.entity.PatientFileEntity;
import com.developer.employeemanagement.service.AppointmentService;
import com.developer.employeemanagement.service.PatientFileService;
import com.developer.employeemanagement.service.UserService;
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
    @GetMapping("/patient-file/{id}")
    public ResponseEntity<?> getPatientFileById(@PathVariable Long id) {
        Optional<PatientFileEntity> optionalFile = patientFileService.findById(id);

        if (optionalFile.isPresent()) {
            return ResponseEntity.ok(optionalFile.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Patient file with ID " + id + " not found");
        }
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

    @GetMapping("/{idDoctor}")
    public ResponseEntity<List<PatientFileEntity>> getPatientsByDoctor(
            @PathVariable("idDoctor") Long idDoctor
    )throws IOException {
        List<PatientFileEntity> patients = patientFileService.getPatientsByDoctor(idDoctor);

        if (patients.isEmpty()) {
            return ResponseEntity.status(404).body(null);  // No patients found
        }

        return ResponseEntity.ok(patients);
    }
}
