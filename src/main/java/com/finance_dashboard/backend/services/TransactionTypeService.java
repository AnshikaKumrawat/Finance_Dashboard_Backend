package com.finance_dashboard.backend.services;
import com.finance_dashboard.backend.exceptions.*;
import com.finance_dashboard.backend.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionTypeService {
    List<TransactionType> getAllTransactions();

    boolean existsByTransactionTypeId(int transactionTypeId);

    TransactionType getTransactionById(int transactionTypeId) throws TransactionTypeNotFoundException;

}
