package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.service.MarkerService;
import com.developer.employeemanagement.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marker")
@RequiredArgsConstructor
public class MarkerController {
    private final MarkerService markerService;

    @GetMapping
    public List<MarkerEntity> findAllMarker() {
        return markerService.findAllMarker();
    }

    @GetMapping("/{id}")
    public Optional<MarkerEntity> findMarkerById(@PathVariable("id") Long id) {
        return markerService.findById(id);
    }
}
