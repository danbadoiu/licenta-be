package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
}

