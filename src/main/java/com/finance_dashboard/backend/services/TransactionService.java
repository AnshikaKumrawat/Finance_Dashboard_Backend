package com.finance_dashboard.backend.services;
import com.finance_dashboard.backend.dto.reponses.*;
import com.finance_dashboard.backend.dto.requests.*;
import com.finance_dashboard.backend.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {


    ResponseEntity<ApiResponseDto<?>> addTransaction(TransactionRequestDto transactionRequestDto)
            throws UserNotFoundException, CategoryNotFoundException, TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getTransactionById(Long TransactionId)
            throws TransactionNotFoundException;

    ResponseEntity<ApiResponseDto<?>> updateTransaction(Long transactionId, TransactionRequestDto transactionRequestDto)
            throws TransactionNotFoundException, UserNotFoundException, CategoryNotFoundException, TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> deleteTransaction(Long transactionId) throws TransactionNotFoundException, TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getAllTransactions(int pageNumber, int pageSize, String searchKey) throws TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getTransactionsByUser(String email, int pageNumber, int pageSize, String searchKey, String sortField, String sortDirec, String transactionType) throws UserNotFoundException, TransactionServiceLogicException;

}
