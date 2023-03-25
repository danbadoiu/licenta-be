package com.developer.employeemanagement.dto.request;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@RequiredArgsConstructor

@AllArgsConstructor
@Getter
@Setter
public class PostRequest implements Serializable {
    private long idUser;
    private String domain;
    private String message;
    private String image;
    private Date date;



}
