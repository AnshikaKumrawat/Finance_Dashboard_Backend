package com.finance_dashboard.backend.dataSeeders;

import com.finance_dashboard.backend.enums.*;
import com.finance_dashboard.backend.models.*;
import com.finance_dashboard.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class TransactionTypeDataSeeder {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @EventListener
    @Transactional
    public void LoadTransactionTypes(ContextRefreshedEvent event) {

        List<ETransactionType> transactionTypes = Arrays.stream(ETransactionType.values()).toList();

        for(ETransactionType eTransactionType: transactionTypes) {
            if (!transactionTypeRepository.existsByTransactionTypeName(eTransactionType)) {
                transactionTypeRepository.save(new TransactionType(eTransactionType));
            }
        }

    }
}
