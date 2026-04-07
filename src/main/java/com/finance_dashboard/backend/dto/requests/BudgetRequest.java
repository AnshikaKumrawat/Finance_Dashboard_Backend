package com.finance_dashboard.backend.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BudgetRequest {
    long userId;
    double amount;
}
