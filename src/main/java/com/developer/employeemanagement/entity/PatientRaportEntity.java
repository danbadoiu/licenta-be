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
@Table(name = "mt_patient_raport")
public class PatientRaportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_raport_id")
    private Long id;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "raport")
    private String raport;
}
