package com.developer.employeemanagement.service;

import com.developer.employeemanagement.entity.FavoriteDoctorsEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FavoriteDoctorsService {
    List<FavoriteDoctorsEntity> findAllFavoriteDoctors();
    Optional<FavoriteDoctorsEntity> findById(Long id);
    FavoriteDoctorsEntity saveFavoriteDoctors(FavoriteDoctorsEntity favoriteDoctorsEntity);
    public void saveFavoriteDoctors(Long idPatient, String doctors) throws IOException;
    void deleteFavoriteDoctors(Long id);
    public void updateFavoriteDoctors(Long id, Long idPatient, String doctors) throws IOException;

}
