package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.entity.PatientFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientFileRepository extends JpaRepository<PatientFileEntity, Long> {
    Optional<PatientFileEntity> findByIdUser(Long idUser);
    @Query(value = "SELECT pfe.* FROM mt_patient_file pfe " +
            "JOIN mt_appointment ae ON ae.id_user = pfe.id_user " +
            "WHERE ae.id_doctor = :idDoctor AND TRIM(pfe.blood_type) = 'B-'", nativeQuery = true)
    List<PatientFileEntity> findPatientsByDoctor(Long idDoctor);
}
