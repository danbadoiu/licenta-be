package com.developer.employeemanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_marker")
public class MarkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marker_id")
    private Long id;

    @Column(name = "longitude")
    private String longitude;


    @Column(name = "latitude")
    private String latitude;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "name")
    private String name;

    @Column(name= "doctors")
    private String doctors;


}
