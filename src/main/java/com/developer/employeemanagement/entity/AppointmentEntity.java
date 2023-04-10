package com.developer.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "idDoctor")
    private Long idDoctor;

    @Column(name = "idMarker")
    private Long idMarker;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private LocalDateTime date;

}