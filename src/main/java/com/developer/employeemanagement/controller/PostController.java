package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.PostRequest;
import com.developer.employeemanagement.dto.response.PostResponse;
import com.developer.employeemanagement.entity.PostEntity;
import com.developer.employeemanagement.repository.PostRepository;
import com.developer.employeemanagement.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping
    public List<PostEntity> findAllPost() {
        return postService.findAllPost();
    }

    @GetMapping("/{id}")
    public Optional<PostEntity> findPostById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PostMapping
//    public PostEntity saveMPost(@RequestBody PostEntity postEntity) {
//        return postService.savePost(postEntity);
//    }
        public void saveMessage(
            MultipartFile image, String message, String date, Long idUser, String domain
    ) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        this.postService.savePost(image, message, dateTime, idUser, domain);
    }
    @PutMapping
    public PostEntity updatePost(@RequestBody PostEntity postEntity) {
        return postService.updatePost(postEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public PostResponse savePostResponse(@RequestBody PostRequest postRequest) {
        return postService.savePost(postRequest);
    }

    @PutMapping("/res/{id}")
    public PostResponse updatePostResponse(@RequestBody PostRequest postRequest, @PathVariable("id") Long id) {
        return postService.updatePost(postRequest, id);
    }



}
