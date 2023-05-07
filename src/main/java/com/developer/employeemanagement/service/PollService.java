package com.developer.employeemanagement.service;

import com.developer.employeemanagement.dto.request.PostRequest;
import com.developer.employeemanagement.dto.response.PostResponse;
import com.developer.employeemanagement.entity.PollEntity;
import com.developer.employeemanagement.entity.PostEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PollService {
    List<PollEntity> findAllPoll();
    Optional<PollEntity> findById(Long id);
    PollEntity savePoll(PollEntity pollEntity);
    public void savePoll(Long idPost, String answer) throws IOException;
    public void updatePoll(Long id, Long idPost,String answer) throws IOException;

//    PollEntity updatePoll(PollEntity pollEntity);
    void deletePoll(Long id);




}
