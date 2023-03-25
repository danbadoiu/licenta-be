package com.developer.employeemanagement.service;

import com.developer.employeemanagement.dto.request.PostRequest;
import com.developer.employeemanagement.dto.response.PostResponse;
import com.developer.employeemanagement.entity.PostEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostEntity> findAllPost();
    Optional<PostEntity> findById(Long id);
    PostEntity savePost(PostEntity postEntity);
    PostEntity updatePost(PostEntity postEntity);
    public void savePost(MultipartFile image, String message, LocalDateTime date, Long idUser, String domain) throws IOException;
    void deletePost(Long id);

    //    Using Request for Save and Update Employee
    PostResponse savePost(PostRequest postRequest);
    PostResponse updatePost(PostRequest postRequest, Long id);


}
