package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.PatientRaportEntity;
import com.developer.employeemanagement.entity.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRaportRepository extends JpaRepository<PatientRaportEntity, Long> {
}
