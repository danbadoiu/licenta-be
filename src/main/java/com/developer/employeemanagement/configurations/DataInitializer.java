package com.developer.employeemanagement.configurations;

import com.developer.employeemanagement.entity.MarkerEntity;
import com.developer.employeemanagement.repository.MarkerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MarkerRepository markerRepository;

    public DataInitializer(MarkerRepository markerRepository) {
        this.markerRepository = markerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificăm dacă datele există deja
        if (markerRepository.count() == 0) {
            markerRepository.save(new MarkerEntity( "23.58345", "46.7654", "Spitalul Clinic Județean de Urgență Cluj",
                    "1,2", "Cardiologie"));
            markerRepository.save(new MarkerEntity("23.5980", "46.7730", "Spitalul Clinic Municipal Cluj-Napoca",
                    "1,2", "Oncologie"));
            markerRepository.save(new MarkerEntity( "23.5820", "46.7685", "Spitalul de Pediatrie Cluj",
                    "1,2", "Pediatrie"));
            markerRepository.save(new MarkerEntity("23.5900", "46.7700", "Spitalul De Chirurgie Cluj",
                    "1,2", "Medicină Internă"));
        }
    }
}
