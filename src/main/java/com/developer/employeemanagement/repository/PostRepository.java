package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
