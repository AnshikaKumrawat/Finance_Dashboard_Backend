package com.finance_dashboard.backend.controllers;

import com.finance_dashboard.backend.dto.reponses.ApiResponseDto;
import com.finance_dashboard.backend.dto.requests.CategoryRequestDto;
import com.finance_dashboard.backend.exceptions.CategoryAlreadyExistsException;
import com.finance_dashboard.backend.exceptions.CategoryNotFoundException;
import com.finance_dashboard.backend.exceptions.CategoryServiceLogicException;
import com.finance_dashboard.backend.exceptions.TransactionTypeNotFoundException;
import com.finance_dashboard.backend.services.CategoryService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/financeDashboard/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> getAllCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> addNewCategory(
            @RequestBody @Valid CategoryRequestDto categoryRequestDto)
            throws CategoryServiceLogicException,
                   TransactionTypeNotFoundException,
                   CategoryAlreadyExistsException {

        return categoryService.addNewCategory(categoryRequestDto);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> updateCategory(
            @RequestParam("categoryId") int categoryId,
            @RequestBody @Valid CategoryRequestDto categoryRequestDto)
            throws CategoryServiceLogicException,
                   CategoryNotFoundException,
                   TransactionTypeNotFoundException {

        return categoryService.updateCategory(categoryId, categoryRequestDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> enableOrDisableCategory(
            @RequestParam("categoryId") int categoryId)
            throws CategoryServiceLogicException,
                   CategoryNotFoundException {

        return categoryService.enableOrDisableCategory(categoryId);
    }
}