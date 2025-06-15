package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.entity.PatientRaportEntity;
import com.developer.employeemanagement.entity.PollEntity;
import com.developer.employeemanagement.service.PatientRaportService;
import com.developer.employeemanagement.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient-raport")
@RequiredArgsConstructor
public class PatientRaportController {
    private final PatientRaportService patientRaportService;



    @GetMapping
    public List<PatientRaportEntity> findAllPatientRaport() {
        return patientRaportService.findAllPatientRaport();
    }

    @GetMapping("/{id}")
    public Optional<PatientRaportEntity> findPatientRaportById(@PathVariable("id") Long id) {
        return patientRaportService.findById(id);
    }

    @PostMapping
    public void savePatientRaport(
            @RequestParam("idUser") Long idUser,
            @RequestParam("raport") String raport
    ) throws IOException {

        this.patientRaportService.savePatientRaport(idUser,raport);
    }
    @PutMapping("/{id}")
    public void updatePatientRaport(
            @PathVariable("id") Long id,
            @RequestParam("idUser") Long idUser,
            @RequestParam("raport") String raport
    ) throws IOException, ParseException {


        this.patientRaportService.updatePatientRaport(id,idUser,raport);
    }


    @DeleteMapping("/{id}")
    public void deletePatientRaport(@PathVariable("id") Long id) {
        patientRaportService.deletePatientRaport(id);
    }
}
