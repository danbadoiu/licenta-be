package com.developer.employeemanagement.service.impl;


import com.developer.employeemanagement.dto.request.PostRequest;
import com.developer.employeemanagement.dto.response.PostResponse;
import com.developer.employeemanagement.entity.PostEntity;
import com.developer.employeemanagement.repository.PostRepository;
import com.developer.employeemanagement.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostEntity> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostEntity savePost(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    @Override
    public void savePost(MultipartFile image, String message, LocalDateTime date, Long idUser, String domain) throws IOException {
        PostEntity postEntity = new PostEntity();
        postEntity.setMessage(message);
        postEntity.setDate(date);
        postEntity.setIdUser(idUser);
        postEntity.setDomain(domain);
        postEntity.setImage(image.getBytes());
        postRepository.save(postEntity);
    }

    @Override
    public PostEntity updatePost(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostResponse savePost(PostRequest postRequest) {
        return null;
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest, Long id) {
        return null;
    }

//    Using Request and Response with save and update employee

//    @Override
//    public MessageResponse saveMessage(UserRequest messageRequest) {
//        MessageEntity messageEntity = MessageMapper.MAPPER.fromRequestToEntity(messageRequest);
//        messageRepository.save(messageEntity);
//        return MessageMapper.MAPPER.fromEntityToResponse(messageEntity);
//    }

//    @Override
//    public MessageResponse updateMessage(MessageRequest messageRequest, Long id) {
//
//        Optional<MessageEntity> checkExistingMessage = findById(id);
//        if (! checkExistingMessage.isPresent())
//            throw new RuntimeException("Message Id "+ id + " Not Found!");
//
//        MessageEntity messageEntity = MessageMapper.MAPPER.fromRequestToEntity(messageRequest);
//        messageEntity.setId(id);
//        messageRepository.save(messageEntity);
//        return MessageMapper.MAPPER.fromEntityToResponse(messageEntity);
//    }

}
