package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkerRepository extends JpaRepository<MarkerEntity, Long> {
}
