package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.AppointmentEntity;
import com.developer.employeemanagement.entity.MarkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
