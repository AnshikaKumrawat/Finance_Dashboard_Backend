package com.finance_dashboard.backend.exceptions;

public class CategoryAlreadyExistsException extends Exception{

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
