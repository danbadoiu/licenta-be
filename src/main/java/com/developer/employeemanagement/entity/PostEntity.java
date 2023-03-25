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
@Table(name = "mt_post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "message")
    private String message;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "domain")
    private String domain;

    @Column(name = "date")
    private LocalDateTime date;
}
