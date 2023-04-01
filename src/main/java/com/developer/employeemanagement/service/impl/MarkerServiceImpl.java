package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.repository.MarkerRepository;
import com.developer.employeemanagement.repository.MedicineRepository;
import com.developer.employeemanagement.service.MarkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkerServiceImpl implements MarkerService {
    private final MarkerRepository markerRepository;

    public MarkerServiceImpl(MarkerRepository markerRepository) {
        this.markerRepository = markerRepository;
    }

    @Override
    public List<MarkerEntity> findAllMarker() {
        return this.markerRepository.findAll();
    }

    @Override
    public Optional<MarkerEntity> findById(Long id) {
        return markerRepository.findById(id);
    }
}
