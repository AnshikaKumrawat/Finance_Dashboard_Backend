package com.finance_dashboard.backend.repository;
import com.finance_dashboard.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Budget findByUserIdAndMonthAndYear(long userId, int month, long year);
}
