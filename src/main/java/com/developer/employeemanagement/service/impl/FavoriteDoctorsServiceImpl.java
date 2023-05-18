package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.entity.AppointmentEntity;
import com.developer.employeemanagement.entity.FavoriteDoctorsEntity;
import com.developer.employeemanagement.entity.MedicineEntity;
import com.developer.employeemanagement.repository.FavoriteDoctorsRepository;
import com.developer.employeemanagement.repository.MarkerRepository;
import com.developer.employeemanagement.service.FavoriteDoctorsService;
import com.developer.employeemanagement.service.MarkerService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteDoctorsServiceImpl implements FavoriteDoctorsService {
    private final FavoriteDoctorsRepository favoriteDoctorsRepository;

    public FavoriteDoctorsServiceImpl(FavoriteDoctorsRepository favoriteDoctorsRepository) {
        this.favoriteDoctorsRepository = favoriteDoctorsRepository;
    }

    @Override
    public List<FavoriteDoctorsEntity> findAllFavoriteDoctors() {
        return favoriteDoctorsRepository.findAll();
    }

    @Override
    public Optional<FavoriteDoctorsEntity> findById(Long id) {
        return favoriteDoctorsRepository.findById(id);
    }

    @Override
    public FavoriteDoctorsEntity saveFavoriteDoctors(FavoriteDoctorsEntity favoriteDoctorsEntity) {
        return favoriteDoctorsRepository.save(favoriteDoctorsEntity);
    }

    @Override
    public void updateFavoriteDoctors(Long id, Long idPatient, String doctors) throws IOException {
        Optional<FavoriteDoctorsEntity> optionalFavoriteDoctorsEntity = favoriteDoctorsRepository.findById(id);
        if (optionalFavoriteDoctorsEntity.isPresent()) {
            FavoriteDoctorsEntity favoriteDoctorsEntity = optionalFavoriteDoctorsEntity.get();
            favoriteDoctorsEntity.setDoctors(doctors);
            favoriteDoctorsEntity.setIdPatient(idPatient);
            favoriteDoctorsEntity.setId(id);
            favoriteDoctorsRepository.save(favoriteDoctorsEntity);
        } else {
            throw new IllegalArgumentException("Appointment with id " + id + " not found");
        }
    }


    @Override
    public void saveFavoriteDoctors(Long idPatient, String doctors) throws IOException {
        FavoriteDoctorsEntity favoriteDoctorsEntity = new FavoriteDoctorsEntity();
        favoriteDoctorsEntity.setIdPatient(idPatient);
        favoriteDoctorsEntity.setDoctors(doctors);
        favoriteDoctorsRepository.save(favoriteDoctorsEntity);

    }

    @Override
    public void deleteFavoriteDoctors(Long id) {
        favoriteDoctorsRepository.deleteById(id);
    }
}
