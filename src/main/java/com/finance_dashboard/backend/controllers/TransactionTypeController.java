package com.finance_dashboard.backend.controllers;
import com.finance_dashboard.backend.models.*;
import com.finance_dashboard.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/financeDashboard/transactiontype")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactions();
    }
}
