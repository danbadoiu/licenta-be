package com.developer.employeemanagement.dto.mapper;

import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.request.MessageRequest;
import com.developer.employeemanagement.dto.request.UserRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.dto.response.MessageResponse;
import com.developer.employeemanagement.dto.response.UserResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.entity.MessageEntity;
import com.developer.employeemanagement.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);
    MessageEntity fromRequestToEntity(MessageRequest messageRequest);
    MessageResponse fromEntityToResponse(MessageEntity messageEntity);
}
