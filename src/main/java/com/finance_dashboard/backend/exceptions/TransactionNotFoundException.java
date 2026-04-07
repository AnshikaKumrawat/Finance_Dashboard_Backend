package com.finance_dashboard.backend.exceptions;

public class TransactionNotFoundException extends Exception{

    public TransactionNotFoundException(String message) {
        super(message);
    }
}
