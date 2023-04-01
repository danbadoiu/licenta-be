package com.developer.employeemanagement.service;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MarkerService {
    List<MarkerEntity> findAllMarker();
    Optional<MarkerEntity> findById(Long id);

}
