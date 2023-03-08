package com.developer.employeemanagement.dto.request;


import lombok.*;

import java.io.Serializable;
import java.util.Date;
@RequiredArgsConstructor

@AllArgsConstructor
@Getter
@Setter
public class MessageRequest implements Serializable {
    private long idSender;
    private long idReceiver;
    private String message;
    private Date date;



}
