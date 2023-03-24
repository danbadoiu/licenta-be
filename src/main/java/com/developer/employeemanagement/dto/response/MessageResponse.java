package com.developer.employeemanagement.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String role;
    private String password;
    private String picture;



}
