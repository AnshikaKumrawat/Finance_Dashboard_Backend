package com.finance_dashboard.backend.exceptions;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
