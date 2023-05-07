package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.entity.AppointmentEntity;
import com.developer.employeemanagement.entity.PollEntity;
import com.developer.employeemanagement.entity.PostEntity;
import com.developer.employeemanagement.repository.PollRepository;
import com.developer.employeemanagement.repository.PostRepository;
import com.developer.employeemanagement.service.PollService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PollServiceImpl implements PollService {
    private final PollRepository pollRepository;

    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }
    @Override
    public List<PollEntity> findAllPoll() {
        return pollRepository.findAll();
    }

    @Override
    public Optional<PollEntity> findById(Long id) {
        return pollRepository.findById(id);
    }

    @Override
    public PollEntity savePoll(PollEntity pollEntity) {
        return pollRepository.save(pollEntity);
    }

    @Override
    public void savePoll(Long idPost,String answer) throws IOException {
        PollEntity pollEntity = new PollEntity();
        pollEntity.setIdPost(idPost);
        pollEntity.setAnswer(answer);
        pollRepository.save(pollEntity);
    }

    @Override
    public void updatePoll(Long id,Long idPost,String answer) throws IOException {
        Optional<PollEntity> optionalPollEntity = pollRepository.findById(id);
        if (optionalPollEntity.isPresent()) {
            PollEntity pollEntity = optionalPollEntity.get();
            pollEntity.setIdPost(idPost);
            pollEntity.setAnswer(answer);
            pollRepository.save(pollEntity);
        } else {
            throw new IllegalArgumentException("Appointment with id " + id + " not found");
        }
    }
    @Override
    public void deletePoll(Long id) {
        pollRepository.deleteById(id);

    }
}
