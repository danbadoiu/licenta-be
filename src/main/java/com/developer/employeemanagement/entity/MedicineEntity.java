package com.developer.employeemanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_medicine")
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long id;

    @Column(name = "id_receiver")
    private Long idReceiver;


    @Column(name = "name")
    private String name;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "description")
    private String description;


}
