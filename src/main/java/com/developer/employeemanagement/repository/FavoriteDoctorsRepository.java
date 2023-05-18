package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.FavoriteDoctorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDoctorsRepository extends JpaRepository<FavoriteDoctorsEntity, Long> {
}
