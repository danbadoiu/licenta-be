package com.developer.employeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "id_sender")
    private Long idSender;

    @Column(name = "id_receiver")
    private Long idReceiver;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Date date;


}
