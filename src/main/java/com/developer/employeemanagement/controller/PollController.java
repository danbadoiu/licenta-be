package com.developer.employeemanagement.controller;

import com.developer.employeemanagement.entity.PollEntity;
import com.developer.employeemanagement.entity.PostEntity;
import com.developer.employeemanagement.repository.PollRepository;
import com.developer.employeemanagement.repository.PostRepository;
import com.developer.employeemanagement.service.PollService;
import com.developer.employeemanagement.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @GetMapping
    public List<PollEntity> findAllPoll() {
        return pollService.findAllPoll();
    }

    @GetMapping("/{id}")
    public Optional<PollEntity> findPollById(@PathVariable("id") Long id) {
        return pollService.findById(id);
    }

    @PostMapping
//    public PollEntity savePoll(@RequestBody PollEntity pollEntity) {
//        return pollService.savePoll(pollEntity);
//    }
    public void savePoll(
            Long idPost,String answer
    ) throws IOException {

        this.pollService.savePoll(idPost,answer);
    }
    @PutMapping("/{id}")
    public void updatePoll(
            @PathVariable("id") Long id, Long idPost,String answer
    ) throws IOException, ParseException {


        this.pollService.updatePoll(id,idPost,answer);
    }


    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable("id") Long id) {
        pollService.deletePoll(id);
    }


}
