package com.finance_dashboard.backend.repository;
import com.finance_dashboard.backend.enums.*;
import com.finance_dashboard.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
    Optional<TransactionType> findById(int id);
    TransactionType findByTransactionTypeName(ETransactionType transactionTypeName);
    boolean existsByTransactionTypeName(ETransactionType transactionTypeName);
}
