package com.finance_dashboard.backend.services;
import com.finance_dashboard.backend.dto.reponses.*;
import com.finance_dashboard.backend.dto.requests.*;
import com.finance_dashboard.backend.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BudgetService {
    ResponseEntity<ApiResponseDto<?>> createBudget(BudgetRequest budgetRequest) throws UserNotFoundException, UserServiceLogicException;
    ResponseEntity<ApiResponseDto<?>> getBudgetByMonth(long userId, int month, long year) throws UserServiceLogicException;

}
