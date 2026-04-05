package com.finance_dashboard.backend.services.impls;
import com.finance_dashboard.backend.services.*;
import com.finance_dashboard.backend.exceptions.*;
import com.finance_dashboard.backend.models.*;
import com.finance_dashboard.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionTypeServiceImpl implements TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public List<TransactionType> getAllTransactions() {
        return transactionTypeRepository.findAll();
    }

    @Override
    public boolean existsByTransactionTypeId(int transactionTypeId) {
        return transactionTypeRepository.existsById(transactionTypeId);
    }

    @Override
    public TransactionType getTransactionById(int transactionTypeId) throws TransactionTypeNotFoundException {
        return transactionTypeRepository.findById(transactionTypeId).orElseThrow(
                () -> new TransactionTypeNotFoundException("Transaction type not found with id " + transactionTypeId)
        );
    }


}
