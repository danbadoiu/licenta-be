package com.developer.employeemanagement.exceptions.handler;

import com.developer.employeemanagement.exceptions.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> handleCmtExceptions(HttpServletRequest request, CustomException ex) {
        log.debug("Bachelor exception thrown: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(generateResponse(request, ex));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> handleRuntimeExceptions(HttpServletRequest request, RuntimeException ex) {
        log.error("Internal error occurred: " + ex.toString() + ": ");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createGeneralServerErrorDetails(ex, request.getRequestURL().toString()));
    }

    private ErrorDetails generateResponse(HttpServletRequest request, CustomException ex) {
        request.removeAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
        request.setAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE, Collections.singleton(MediaType.APPLICATION_JSON));
        return new ErrorDetails(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), ex.getClass().getName(), request.getRequestURL().toString(), ex.getMessage());
    }

    private ErrorDetails createGeneralServerErrorDetails(RuntimeException ex, String requestUrl) {
        return new ErrorDetails(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getClass().getName(), requestUrl, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @Data
    @AllArgsConstructor
    private static class ErrorDetails {
        private String timestamp;
        private int status;
        private String error;
        private String exception;
        private String url;
        private String message;
    }
}