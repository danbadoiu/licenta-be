package com.developer.employeemanagement.service;


import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<MedicineEntity> findAllMedicine();
    Optional<MedicineEntity> findById(Long id);
    MedicineEntity saveMedicine(MedicineEntity medicineEntity);
    MedicineEntity updateMedicine(MedicineEntity medicineEntity);
    public void saveMedicine(MultipartFile image, String name, String description, Long idReceiver) throws IOException;
    void deleteMedicine(Long id);




}