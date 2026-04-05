package com.finance_dashboard.backend.handlers;

import com.finance_dashboard.backend.enums.*;
import com.finance_dashboard.backend.dto.reponses.*;
import com.finance_dashboard.backend.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<ApiResponseDto<String>> CategoryNotFoundExceptionHandler(CategoryNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ApiResponseDto<>(ApiResponseStatus.FAILED, HttpStatus.NOT_FOUND, exception.getMessage())
                );
    }

    @ExceptionHandler(value = CategoryServiceLogicException.class)
    public ResponseEntity<ApiResponseDto<String>> CategoryServiceLogicExceptionHandler(CategoryServiceLogicException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ApiResponseDto<>(ApiResponseStatus.FAILED, HttpStatus.BAD_REQUEST, exception.getMessage())
                );
    }


    @ExceptionHandler(value = CategoryAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDto<String>> categoryAlreadyExistsExceptionHandler(CategoryAlreadyExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        new ApiResponseDto<>(ApiResponseStatus.FAILED, HttpStatus.CONFLICT, exception.getMessage())
                );
    }

}
