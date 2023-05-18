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
@Table(name = "mt_favorite_doctors")
public class FavoriteDoctorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_doctors_id")
    private Long id;


    @Column(name = "id_patient")
    private Long idPatient;

    @Column(name= "doctors")
    private String doctors;


}
