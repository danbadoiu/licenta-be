package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.entity.PatientFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientFileRepository extends JpaRepository<PatientFileEntity, Long> {
    Optional<PatientFileEntity> findByIdUser(Long idUser);
}
