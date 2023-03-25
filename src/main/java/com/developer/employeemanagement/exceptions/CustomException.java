package com.developer.employeemanagement.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private final String errorMessage;
    private final String[] messageParams;

    public CustomException(String errorMessage, String... messageParams) {
        super(String.format(errorMessage, messageParams));
        this.errorMessage = errorMessage;
        this.messageParams = messageParams;
    }
}
