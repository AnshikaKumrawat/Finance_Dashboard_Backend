package com.finance_dashboard.backend.exceptions;

public class TransactionTypeNotFoundException extends Exception{

    public TransactionTypeNotFoundException(String message) {
        super(message);
    }
}
