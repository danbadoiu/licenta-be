package com.developer.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_patient_file")
public class PatientFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_file_id")
    private Long id;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "blood_type", length = 5)
    private String bloodType;

    @Column(name = "allergies", length = 255)
    private String allergies;

    @Column(name = "chronic_diseases", length = 255)
    private String chronicDiseases;

    @Column(name = "current_medications", length = 255)
    private String currentMedications;

    @Column(name = "emergency_contact", length = 100)
    private String emergencyContact;

    @Column(name = "last_visit_date")
    private String lastVisitDate;

    @Column(name = "date", nullable = false)
    private String date;



}
