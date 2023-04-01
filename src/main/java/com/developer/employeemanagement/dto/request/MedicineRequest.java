package com.developer.employeemanagement.dto.request;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@RequiredArgsConstructor

@AllArgsConstructor
@Getter
@Setter
public class MedicineRequest implements Serializable {
    private long idReceiver;
    private String name;
    private String picture;
    private String description;



}
