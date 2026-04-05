package com.finance_dashboard.backend.services;
import com.finance_dashboard.backend.dto.reponses.*;
import com.finance_dashboard.backend.dto.requests.*;
import com.finance_dashboard.backend.exceptions.*;
import com.finance_dashboard.backend.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    ResponseEntity<ApiResponseDto<?>> getCategories();

    boolean existsCategory(int id);

    Category getCategoryById(int id) throws CategoryNotFoundException;

    ResponseEntity<ApiResponseDto<?>> addNewCategory(CategoryRequestDto categoryRequestDto)
            throws TransactionTypeNotFoundException, CategoryServiceLogicException, CategoryAlreadyExistsException;

    ResponseEntity<ApiResponseDto<?>> updateCategory(int categoryId, CategoryRequestDto categoryRequestDto)
            throws CategoryNotFoundException, TransactionTypeNotFoundException, CategoryServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> enableOrDisableCategory(int categoryId) throws CategoryServiceLogicException, CategoryNotFoundException;
}
