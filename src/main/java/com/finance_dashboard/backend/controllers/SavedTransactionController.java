package com.finance_dashboard.backend.controllers;

import com.finance_dashboard.backend.dto.reponses.*;
import com.finance_dashboard.backend.dto.requests.*;
import com.finance_dashboard.backend.exceptions.*;
import com.finance_dashboard.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/financeDashboard/saved")
public class SavedTransactionController {

    @Autowired
    private SavedTransactionService savedTransactionService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> createSavedTransaction(@RequestBody SavedTransactionRequestDto requestDto)
            throws UserServiceLogicException, UserNotFoundException{
        return savedTransactionService.createSavedTransaction(requestDto);
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> addSavedTransaction(@Param("id") long id)
            throws UserServiceLogicException, TransactionNotFoundException {
        return savedTransactionService.addSavedTransaction(id);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> editSavedTransaction(@Param("id") long id, @RequestBody SavedTransactionRequestDto requestDto)
            throws UserServiceLogicException, TransactionNotFoundException {
        return savedTransactionService.editSavedTransaction(id, requestDto);
    }

    @DeleteMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> deleteSavedTransaction(@Param("id") long id)
            throws UserServiceLogicException, TransactionNotFoundException {
        return savedTransactionService.deleteSavedTransaction(id);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> getAllTransactionsByUser(@Param("id") long id)
            throws UserServiceLogicException, UserNotFoundException {
        return savedTransactionService.getAllTransactionsByUser(id);
    }

    @GetMapping("/month")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> getAllTransactionsByUserAndMonth(@Param("id") long id)
            throws UserServiceLogicException, UserNotFoundException {
        return savedTransactionService.getAllTransactionsByUserAndMonth(id);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> getAllTransactionsById(@Param("id") long id)
            throws UserServiceLogicException, TransactionNotFoundException {
        return savedTransactionService.getSavedTransactionById(id);
    }

    @GetMapping("/skip")
    public ResponseEntity<ApiResponseDto<?>> skipSavedTransaction(@Param("id") long id)
            throws TransactionNotFoundException, UserServiceLogicException {
        return savedTransactionService.skipSavedTransaction(id);
    }
}
